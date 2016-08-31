set JAVA_HOME=c:\PROGRA~1\Java\jdk1.8.0_102
set SAMPLE_HOME={path to sample program home dir}

set CLASS_PATH=%SAMPLE_HOME%\conf
set CLASS_PATH=%SAMPLE_HOME%\bin\ad-api-sample-IM-API-V5.4.jar;%SAMPLE_HOME%;%SAMPLE_HOME%\src\main\resources

cd %SAMPLE_HOME%
%JAVA_HOME%\bin\java -classpath %CLASS_PATH% %1
