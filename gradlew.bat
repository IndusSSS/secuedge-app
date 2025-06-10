@echo off
setlocal
set DIR=%~dp0\gradle\wrapper
set JAR=%DIR%\gradle-wrapper.jar
set PROPERTIES=%DIR%\gradle-wrapper.properties
"%JAVA_HOME%\bin\java" -jar "%JAR%" %*
