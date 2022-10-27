**In project root:**

Ensure `protoc` and, `protoc-gen` and `setup.sh` are executable.
```
chmod +x protoc
chmod +x protoc-gen
chmod +x setup.sh
```

Run setup to generate protobuf code and compile. ( Also inspect the shell script for funky stuff )

*NOTE: Not windows safe*
```
./setup.sh
```

*Server and Client communicate over hard coded port 3002*

Start server 
```
java -cp "classes:jars/*" com.v10.grpc.server.GrpcServer
```

Start client
```
java -cp "classes:jars/*" com.v10.grpc.client.GrpcClient
```
