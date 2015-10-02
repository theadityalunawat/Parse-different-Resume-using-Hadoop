#!/bin/sh

rm -rf $2
javac -cp lib/*:src ./src/PdfInputDriver.java -d bin/
javac -cp lib/*:src ./src/PdfRecordReader.java -d bin/
javac -cp lib/*:src ./src/PdfInputFormat.java -d bin/
javac -cp lib/*:src ./src/WordCountMapper.java.java -d bin/
javac -cp lib/*:src ./src/WordCountReducer.java -d bin/
java -cp ./lib/*:./bin PdfInputDriver $1 $2

