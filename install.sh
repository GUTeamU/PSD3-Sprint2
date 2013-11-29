#!/bin/bash

ROOT_DIR=$(pwd)
BOOTSTRAP_FILE=$ROOT_DIR/bootstrap.sh
JDK_DIR=/usr/lib/jvm/java-1.7.0-openjdk.x86_64
 
MAVEN_VERSION=3.1.1
MAVEN_DIR=apache-maven-$MAVEN_VERSION
MAVEN_TAR=$MAVEN_DIR-bin.tar.gz
MAVEN_URL=http://mirror.catn.com/pub/apache/maven/maven-3/$MAVEN_VERSION/binaries/$MAVEN_TAR

SPRING_VERSION=0.5.0.M6
SPRING_DIR=spring-$SPRING_VERSION
SPRING_TAR=spring-boot-cli-$SPRING_VERSION-bin.tar.gz
SPRING_URL=http://repo.spring.io/milestone/org/springframework/boot/spring-boot-cli/$SPRING_VERSION/$SPRING_TAR

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

echo "### Installing Spring Boot"
rm -rf $SPRING_TAR*
wget $SPRING_URL
tar xfz $SPRING_TAR

echo "## Updating bootstrap.sh"
echo "" >> $BOOTSTRAP_FILE
echo "# Spring Boot" >> $BOOTSTRAP_FILE
echo "export SPRING_HOME=$ROOT_DIR/$SPRING_DIR" >> $BOOTSTRAP_FILE
echo "export PATH=\$PATH:\$SPRING_HOME/bin" >> $BOOTSTRAP_FILE

