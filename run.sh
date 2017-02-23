#!/usr/bin/env bash
sh mvnw clean install -DskipTests=true
java -DserverPort=8999 -DisDomainNode=true -DclientPort=9999 -jar target/MessageGame-0.0.1-SNAPSHOT.jar &
sleep 2
java -DserverPort=9999 -DisDomainNode=false -DclientPort=8999 -jar target/MessageGame-0.0.1-SNAPSHOT.jar