package com.example.test.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.util.HtmlUtils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * XSS防护配置<br/>
 *
 */
@Configuration
public class XssConfig {
    /**
     * XSS防护<br/>
     *
     * @param builder
     * @return
     */
    @Bean
    @Primary
    public ObjectMapper xssObjectMapper(Jackson2ObjectMapperBuilder builder) {
        // 解析器
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        // 注册xss解析器
        SimpleModule xssModule = new SimpleModule("XssStringJsonSerializer");
        xssModule.addSerializer(new XssStringJsonSerializer());
        objectMapper.registerModule(xssModule);
        // 返回
        return objectMapper;
    }
}


class XssStringJsonSerializer extends JsonSerializer<String> {

    @Override
    public Class<String> handledType() {
        return String.class;
    }

    @SuppressWarnings("unused")
    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        if (value != null) {
            String encodedValue = HtmlUtils.htmlEscape(value);
            jsonGenerator.writeString(value);
        }
    }
}
