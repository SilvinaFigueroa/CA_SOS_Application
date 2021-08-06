package gRPC_CA.Client;


import com.proto.CA_Service_1.HelpMessageServiceGrpc;
import gRPC_CA.SOSGUI;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;



public class Client_service1{

    static SOSGUI guiapp = new SOSGUI();

    public static void main(String[] args) {
        System.out.println("Grpc client set up");

        // Building the channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext() // plaint text for security
                .build();
        System.out.println("Channel build");

        // BlockingStub for asynch - FutureStub for synch

        HelpMessageServiceGrpc.HelpMessageServiceBlockingStub service1Client = HelpMessageServiceGrpc.newBlockingStub(channel);


        //HelpMessage helpMessage = HelpMessage.newBuilder()



       // service1Client.helpMessage

        // RPC Method 1


        System.out.println("Channel shutdowm");
        channel.shutdown();


    }


}
