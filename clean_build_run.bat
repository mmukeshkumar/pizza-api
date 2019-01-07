@ECHO OFF
set JAVA_HOME=C:\dev\java_installs\jdk-8u191
Set PATH=%JAVA_HOME%\bin;%PATH%
set JAVA_OPTS=-Xms3g -Xmx3g

gradlew clean build && java -jar build/libs/pizza-api-0.0.1-SNAPSHOT.jar