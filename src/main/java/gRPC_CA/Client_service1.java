package gRPC_CA;


import com.proto.CA_Service_1.HelpMessage;
import com.proto.CA_Service_1.HelpMessageServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client_service1 {
    public static void main(String[] args) {
        System.out.println("Grpc client set up");

        // Building the channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext() // plaint text for security
                .build();
        System.out.println("Channel build");

        // BlockingStub for asynch - FutureStub for synch

        HelpMessageServiceGrpc.HelpMessageServiceBlockingStub client = HelpMessageServiceGrpc.newBlockingStub(channel);

        // RPC Method 1


        System.out.println("Channel shutdowm");
        channel.shutdown();





    }


}
