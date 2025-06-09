#!/usr/bin/env sh

##############################################################################
## Gradle wrapper script
##############################################################################

default_jvm_opts=""

app_name="Gradle"

if [ -n "$JAVA_HOME" ] ; then
    JAVA_HOME="${JAVA_HOME%/}"
    JAVA_CMD="$JAVA_HOME/bin/java"
else
    JAVA_CMD="java"
fi

WRAPPER_DIR=$(dirname "$0")/gradle/wrapper
JAR="$WRAPPER_DIR/gradle-wrapper.jar"
PROPERTIES="$WRAPPER_DIR/gradle-wrapper.properties"

exec "$JAVA_CMD" $JAVA_OPTS $DEFAULT_JVM_OPTS -jar "$JAR" "$@"
