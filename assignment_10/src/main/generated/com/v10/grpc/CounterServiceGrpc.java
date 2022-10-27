package com.v10.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.47.0)",
    comments = "Source: CounterService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CounterServiceGrpc {

  private CounterServiceGrpc() {}

  public static final String SERVICE_NAME = "com.v10.grpc.CounterService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.v10.grpc.Empty,
      com.v10.grpc.Empty> getIncrementCounterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "incrementCounter",
      requestType = com.v10.grpc.Empty.class,
      responseType = com.v10.grpc.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.v10.grpc.Empty,
      com.v10.grpc.Empty> getIncrementCounterMethod() {
    io.grpc.MethodDescriptor<com.v10.grpc.Empty, com.v10.grpc.Empty> getIncrementCounterMethod;
    if ((getIncrementCounterMethod = CounterServiceGrpc.getIncrementCounterMethod) == null) {
      synchronized (CounterServiceGrpc.class) {
        if ((getIncrementCounterMethod = CounterServiceGrpc.getIncrementCounterMethod) == null) {
          CounterServiceGrpc.getIncrementCounterMethod = getIncrementCounterMethod =
              io.grpc.MethodDescriptor.<com.v10.grpc.Empty, com.v10.grpc.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "incrementCounter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.v10.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.v10.grpc.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CounterServiceMethodDescriptorSupplier("incrementCounter"))
              .build();
        }
      }
    }
    return getIncrementCounterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.v10.grpc.Empty,
      com.v10.grpc.CounterCountResponse> getGetCountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCount",
      requestType = com.v10.grpc.Empty.class,
      responseType = com.v10.grpc.CounterCountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.v10.grpc.Empty,
      com.v10.grpc.CounterCountResponse> getGetCountMethod() {
    io.grpc.MethodDescriptor<com.v10.grpc.Empty, com.v10.grpc.CounterCountResponse> getGetCountMethod;
    if ((getGetCountMethod = CounterServiceGrpc.getGetCountMethod) == null) {
      synchronized (CounterServiceGrpc.class) {
        if ((getGetCountMethod = CounterServiceGrpc.getGetCountMethod) == null) {
          CounterServiceGrpc.getGetCountMethod = getGetCountMethod =
              io.grpc.MethodDescriptor.<com.v10.grpc.Empty, com.v10.grpc.CounterCountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.v10.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.v10.grpc.CounterCountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CounterServiceMethodDescriptorSupplier("getCount"))
              .build();
        }
      }
    }
    return getGetCountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.v10.grpc.Empty,
      com.v10.grpc.CounterPrintResponse> getPrintCountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "printCount",
      requestType = com.v10.grpc.Empty.class,
      responseType = com.v10.grpc.CounterPrintResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.v10.grpc.Empty,
      com.v10.grpc.CounterPrintResponse> getPrintCountMethod() {
    io.grpc.MethodDescriptor<com.v10.grpc.Empty, com.v10.grpc.CounterPrintResponse> getPrintCountMethod;
    if ((getPrintCountMethod = CounterServiceGrpc.getPrintCountMethod) == null) {
      synchronized (CounterServiceGrpc.class) {
        if ((getPrintCountMethod = CounterServiceGrpc.getPrintCountMethod) == null) {
          CounterServiceGrpc.getPrintCountMethod = getPrintCountMethod =
              io.grpc.MethodDescriptor.<com.v10.grpc.Empty, com.v10.grpc.CounterPrintResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "printCount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.v10.grpc.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.v10.grpc.CounterPrintResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CounterServiceMethodDescriptorSupplier("printCount"))
              .build();
        }
      }
    }
    return getPrintCountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CounterServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CounterServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CounterServiceStub>() {
        @java.lang.Override
        public CounterServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CounterServiceStub(channel, callOptions);
        }
      };
    return CounterServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CounterServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CounterServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CounterServiceBlockingStub>() {
        @java.lang.Override
        public CounterServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CounterServiceBlockingStub(channel, callOptions);
        }
      };
    return CounterServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CounterServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CounterServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CounterServiceFutureStub>() {
        @java.lang.Override
        public CounterServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CounterServiceFutureStub(channel, callOptions);
        }
      };
    return CounterServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CounterServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void incrementCounter(com.v10.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.v10.grpc.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIncrementCounterMethod(), responseObserver);
    }

    /**
     */
    public void getCount(com.v10.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.v10.grpc.CounterCountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCountMethod(), responseObserver);
    }

    /**
     */
    public void printCount(com.v10.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.v10.grpc.CounterPrintResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrintCountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getIncrementCounterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.v10.grpc.Empty,
                com.v10.grpc.Empty>(
                  this, METHODID_INCREMENT_COUNTER)))
          .addMethod(
            getGetCountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.v10.grpc.Empty,
                com.v10.grpc.CounterCountResponse>(
                  this, METHODID_GET_COUNT)))
          .addMethod(
            getPrintCountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.v10.grpc.Empty,
                com.v10.grpc.CounterPrintResponse>(
                  this, METHODID_PRINT_COUNT)))
          .build();
    }
  }

  /**
   */
  public static final class CounterServiceStub extends io.grpc.stub.AbstractAsyncStub<CounterServiceStub> {
    private CounterServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CounterServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CounterServiceStub(channel, callOptions);
    }

    /**
     */
    public void incrementCounter(com.v10.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.v10.grpc.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIncrementCounterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCount(com.v10.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.v10.grpc.CounterCountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void printCount(com.v10.grpc.Empty request,
        io.grpc.stub.StreamObserver<com.v10.grpc.CounterPrintResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPrintCountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CounterServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CounterServiceBlockingStub> {
    private CounterServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CounterServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CounterServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.v10.grpc.Empty incrementCounter(com.v10.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIncrementCounterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.v10.grpc.CounterCountResponse getCount(com.v10.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.v10.grpc.CounterPrintResponse printCount(com.v10.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPrintCountMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CounterServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CounterServiceFutureStub> {
    private CounterServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CounterServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CounterServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.v10.grpc.Empty> incrementCounter(
        com.v10.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIncrementCounterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.v10.grpc.CounterCountResponse> getCount(
        com.v10.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.v10.grpc.CounterPrintResponse> printCount(
        com.v10.grpc.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPrintCountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INCREMENT_COUNTER = 0;
  private static final int METHODID_GET_COUNT = 1;
  private static final int METHODID_PRINT_COUNT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CounterServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CounterServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INCREMENT_COUNTER:
          serviceImpl.incrementCounter((com.v10.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<com.v10.grpc.Empty>) responseObserver);
          break;
        case METHODID_GET_COUNT:
          serviceImpl.getCount((com.v10.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<com.v10.grpc.CounterCountResponse>) responseObserver);
          break;
        case METHODID_PRINT_COUNT:
          serviceImpl.printCount((com.v10.grpc.Empty) request,
              (io.grpc.stub.StreamObserver<com.v10.grpc.CounterPrintResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CounterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CounterServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.v10.grpc.CounterServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CounterService");
    }
  }

  private static final class CounterServiceFileDescriptorSupplier
      extends CounterServiceBaseDescriptorSupplier {
    CounterServiceFileDescriptorSupplier() {}
  }

  private static final class CounterServiceMethodDescriptorSupplier
      extends CounterServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CounterServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CounterServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CounterServiceFileDescriptorSupplier())
              .addMethod(getIncrementCounterMethod())
              .addMethod(getGetCountMethod())
              .addMethod(getPrintCountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
