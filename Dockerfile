FROM wombatsecurity/java8:8u192

# Maintainer
MAINTAINER "Matt Briden"

RUN mkdir /app
ADD target/spring-webflux-api-*.jar ./api.jar
ADD docker-config/run.sh /app/run.sh
RUN chmod +x /app/run.sh
EXPOSE 8080

ENTRYPOINT ["/app/run.sh"]
