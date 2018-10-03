FROM maven as builder

WORKDIR /work
ADD . /work
RUN mvn clean install meecrowave:bundle
RUN mkdir /dist
WORKDIR /dist
RUN unzip /work/target/rest-api-meecrowave-distribution.zip

FROM openjdk:8

WORKDIR /server
COPY --from=builder /dist/rest-api-distribution/ /server/
RUN find /server
CMD [ "sh", "/server/bin/meecrowave.sh", "run"]

EXPOSE 8080