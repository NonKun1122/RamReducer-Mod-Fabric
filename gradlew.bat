@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@echo off

set CLASSPATH=%~dp0gradle\wrapper\gradle-wrapper.jar

if "%JAVA_HOME%" == "" goto findJava
set JAVA_EXE="%JAVA_HOME%\bin\java.exe"
goto checkJava

:findJava
for %%i in ("%PATH:;=" "%") do (
    if exist "%%i\java.exe" (
        set JAVA_EXE="%%i\java.exe"
        goto checkJava
    )
)

:checkJava
if not exist %JAVA_EXE% (
    echo.
    echo ERROR: JAVA_HOME is not set and no 'java.exe' command could be found in your PATH.
    echo.
    echo Please set the JAVA_HOME variable in your environment to match the
    echo location of your Java installation.
    echo.
    exit /b 1
)

%JAVA_EXE% %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
