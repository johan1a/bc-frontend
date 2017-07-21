FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/bc.frontend.jar /bc.frontend/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/bc.frontend/app.jar"]
