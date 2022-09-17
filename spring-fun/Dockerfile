FROM ubuntu

RUN apt update && apt install -y curl zip unzip default-jdk
RUN java -version

RUN mkdir /opt/tomcat/
WORKDIR /opt/tomcat
RUN curl -O https://dlcdn.apache.org/tomcat/tomcat-10/v10.0.23/bin/apache-tomcat-10.0.23.tar.gz
RUN tar xvfz apache*.tar.gz
RUN mv apache-tomcat-10.0.23/* /opt/tomcat/.


WORKDIR /opt/tomcat/webapps

EXPOSE 8080

CMD ["/opt/tomcat/bin/catalina.sh", "run"]