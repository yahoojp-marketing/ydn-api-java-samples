set JAVA_HOME={path to java home dir.}
set SAMPLE_HOME={path to sample program home dir}

set CLASS_PATH=%SAMPLE_HOME%\conf
set CLASS_PATH=%SAMPLE_HOME%\bin\sample.jar;%CLASS_PATH%

cd %SAMPLE_HOME%
%JAVA_HOME%\bin\java -classpath %CLASS_PATH% %1
