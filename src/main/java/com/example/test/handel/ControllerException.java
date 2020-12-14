package com.example.test.handel;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ControllerException {
    private final Logger logger = (Logger) LoggerFactory.getLogger(ControllerException.class);
    /**     
     * *
     * * @param request    
     * * @param @return
     * */
    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request URL : {} , Exception : {}", request.getRequestURL(), e);
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;        
        }
        ModelAndView mav = new ModelAndView();       
        mav.addObject("url", request.getRequestURL());       
        mav.addObject("exception", e);       
        mav.setViewName("error/error");
        return mav;    
    }
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedException.class)
    public String handleException(UnauthorizedException e) {
        logger.debug(e.getMessage());
        return "403";
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorizationException.class)
    public String handleException2(AuthorizationException e) {
        logger.debug(e.getMessage());
        return "403";
    }
}

