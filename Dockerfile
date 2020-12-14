# 指定基础镜像，本地没有会从dockerHub pull下来
FROM java:8
#作者
MAINTAINER zyl
#指向了一个/tmp的目录，由于Spring Boot使用内置的Tomcat容器，Tomcat默认使用/tmp作为工作目录。效果就是在主机#的#/var/lib/docker目录下创建了一个临时文件，并连接到容器的/tmp。
VOLUME /d/docker:/data
# 镜像要暴露的端口，如要使用端口（tomcat启动用的8080），在执行docker run命令时使用-p生效
EXPOSE 8080 8081
# 把可执行jar包复制到基础镜像的根目录下
ADD test-0.0.1-SNAPSHOT.jar  /data/test-0.0.1-SNAPSHOT.jar

#RUN表示在新创建的镜像中执行一些命令，然后把执行的结果提交到当前镜像。这里使用touch命令来改变文件的修改时间，#Docker创建的#所有容器文件默认状态都是“未修改”。这对于简单应用来说不需要，不过对于一些静态内容（比如：#index.html）的文件就需要一个“修改#时间”。
#RUN sh -c 'touch /app.jar'
RUN bash -c 'touch /.jar'
# 在镜像运行为容器后执行的命令
ENTRYPOINT ["java","-jar","/data/test-0.0.1-SNAPSHOT.jar"]

