package com.v10.grpc.client;

import com.v10.grpc.Empty;
import com.v10.grpc.CounterCountResponse;
import com.v10.grpc.CounterPrintResponse;
import com.v10.grpc.CounterServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 3002)
                .usePlaintext()
                .build();

        CounterServiceGrpc.CounterServiceBlockingStub stub = CounterServiceGrpc.newBlockingStub(channel);

        CounterPrintResponse res1 = stub.printCount(Empty.newBuilder()
                .build());

        System.out.println(res1);

        System.out.println("Incrementing...");
        stub.incrementCounter(Empty.newBuilder()
                .build());

        System.out.println("Incrementing...");
        stub.incrementCounter(Empty.newBuilder()
                .build());

        CounterPrintResponse res2 = stub.printCount(Empty.newBuilder().build());
        System.out.println(res2);

        channel.shutdown();
    }
}
