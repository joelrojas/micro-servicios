FROM openjdk:11.0.16-slim
COPY target/ms-account-0.0.1.jar ms-account-0.0.1.jar
RUN mkdir -p /opt/arqui_software/logs
VOLUME /opt/arqui_software/logs

ENV SERVER_PORT 9871
ENV EUREKA_URI "http://ms-discovery:8761/eureka"
ENV HOSTNAME "ms-account"


ENTRYPOINT ["java","-jar","/ms-account-0.0.1.jar"]



