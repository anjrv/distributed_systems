#!/bin/sh
if ./protoc --plugin=protoc-gen-grpc-java=protoc-gen --proto_path=src/main/proto --java_out=src/main/generated --grpc-java_out=src/main/generated src/main/proto/CounterService.proto; then
  javac -cp "jars/*" -d classes/ -sourcepath src/main/java/:src/main/generated/ src/main/generated/com/v10/grpc/*.java src/main/java/com/v10/grpc/client/*.java src/main/java/com/v10/grpc/server/*.java
fi
