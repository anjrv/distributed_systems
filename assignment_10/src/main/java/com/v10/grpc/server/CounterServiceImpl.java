package com.v10.grpc.server;

import com.v10.grpc.Empty;
import com.v10.grpc.CounterCountResponse;
import com.v10.grpc.CounterPrintResponse;
import com.v10.grpc.CounterServiceGrpc.CounterServiceImplBase;

import io.grpc.stub.StreamObserver;

public class CounterServiceImpl extends CounterServiceImplBase {
    private int count = 0;

    @Override
    public void incrementCounter(Empty req, StreamObserver<Empty> res) {
        System.out.println("Increment on count " + this.count++);
        Empty e = Empty.newBuilder().build();
        res.onNext(e);
        res.onCompleted();
    }

    @Override
    public void getCount(Empty req, StreamObserver<CounterCountResponse> res) {
        System.out.println("Get on count " + this.count);
        CounterCountResponse c = CounterCountResponse.newBuilder().setCount(this.count).build();
        res.onNext(c);
        res.onCompleted();
    }

    @Override
    public void printCount(Empty req, StreamObserver<CounterPrintResponse> res) {
        String response = "The current counter value is " + this.count;
        System.out.println(response);
        CounterPrintResponse c = CounterPrintResponse.newBuilder().setResponse(response).build();
        res.onNext(c);
        res.onCompleted();
    }
}
