#!/bin/bash

ROOT_DIR=$(pwd)
BOOTSTRAP_FILE=$ROOT_DIR/bootstrap.sh
if [ -n "$JAVA_HOME" ]; then
    JDK_DIR=$JAVA_HOME;
else
    JDK_DIR=/usr/lib/jvm/java-1.7.0-openjdk.x86_64;
fi
 
MAVEN_VERSION=3.1.1
MAVEN_DIR=apache-maven-$MAVEN_VERSION
MAVEN_TAR=$MAVEN_DIR-bin.tar.gz
MAVEN_URL=http://apache.mirrors.timporter.net/maven/maven-3/$MAVEN_VERSION/binaries/$MAVEN_TAR

echo "### Installing Maven"
rm -rf $MAVEN_TAR*
wget $MAVEN_URL
tar xfz $MAVEN_TAR

echo "## Creating bootstrap.sh"
echo "# Maven" > $BOOTSTRAP_FILE
echo "export M2_HOME=$ROOT_DIR/$MAVEN_DIR" >> $BOOTSTRAP_FILE
echo "export M2=\$M2_HOME/bin" >> $BOOTSTRAP_FILE
echo "export PATH=\$M2:\$PATH" >> $BOOTSTRAP_FILE
echo "export JAVA_HOME=$JDK_DIR" >> $BOOTSTRAP_FILE
echo "export PATH=\$JAVA_HOME/bin:\$PATH" >> $BOOTSTRAP_FILE
