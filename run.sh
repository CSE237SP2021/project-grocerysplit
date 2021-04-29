#!/bin/bash

javac src/main/*.java
java -cp src main.Menu $1
