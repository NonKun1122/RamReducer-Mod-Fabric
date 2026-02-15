#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`"/$link"
    fi
done
APP_HOME=`dirname "$PRG"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass any JVM options to this script.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

# OS specific support (must be 'true' or 'false').
cygwin=false
darwin=false
linux=false
sunos=false
case "`uname`" in
    CYGWIN*)
        cygwin=true
        ;;
    Darwin*)
        darwin=true
        ;;
    Linux*)
        linux=true
        ;;
    SunOS*)
        sunos=true
        ;;
esac

# For Cygwin, ensure paths are in UNIX format before anything is touched.
if $cygwin ; then
    [ -n "$APP_HOME" ] &&
        APP_HOME=`cygpath --unix "$APP_HOME"`
    [ -n "$JAVA_HOME" ] &&
        JAVA_HOME=`cygpath --unix "$JAVA_HOME"`
fi

# Attempt to locate JAVA_HOME if not already set.
if [ -z "$JAVA_HOME" ] ; then
    if $darwin ; then
        if [ -x '/usr/libexec/java_home' ] ; then
            JAVA_HOME=`/usr/libexec/java_home`
        elif [ -d "/System/Library/Frameworks/JavaVM.framework/Versions/CurrentJDK/Home" ]; then
            JAVA_HOME="/System/Library/Frameworks/JavaVM.framework/Versions/CurrentJDK/Home"
        fi
    else
        javaExecutable="`which javac`"
        if [ -n "$javaExecutable" ] && [ ! "`expr "$javaExecutable" : ".*bin/javac"`" = "0" ] ; then
            JAVA_HOME=`dirname "$javaExecutable"`/..
        fi
    fi
fi
if [ -z "$JAVA_HOME" ] ; then
    die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi

# Set JAVA_EXE
JAVA_EXE="$JAVA_HOME/bin/java"

# Check for JAVA_EXE
if [ ! -x "$JAVA_EXE" ] ; then
    die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi

# Set CLASSPATH
GRADLE_WRAPPER_JAR="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"

# Check for wrapper jar
if [ ! -f "$GRADLE_WRAPPER_JAR" ] ; then
    die "ERROR: The gradle wrapper jar is not available: $GRADLE_WRAPPER_JAR"
fi

# Split up the JVM_OPTS And GRADLE_OPTS values into an array, following the shell quoting and substitution rules
function splitJvmOpts() {
    JVM_OPTS=()
    for opt in $1; do
        JVM_OPTS+=("$opt")
    done
}

# Escape application args
save () {
    for i do
        printf %s\\n "$i" | sed "s/'/'\\\\''/g;1s/^/'/;\\$s/\$/' /"
    done
    echo ""
}
APP_ARGS_ESCAPED=`save "$@"`

# Collect all arguments for the java command, following the shell quoting and substitution rules
function collectAllArgs() {
    splitJvmOpts "$DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS"
    ALL_JVM_OPTS=(${JVM_OPTS[@]})
    ALL_JVM_OPTS+=("-Dorg.gradle.appname=$APP_BASE_NAME")
    CLASSPATH=$GRADLE_WRAPPER_JAR
}

# Execute Gradle
collectAllArgs

exec "$JAVA_EXE" "${ALL_JVM_OPTS[@]}" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
