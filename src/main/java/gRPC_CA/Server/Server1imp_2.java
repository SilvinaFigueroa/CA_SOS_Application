package gRPC_CA.Server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Server1imp_2 {
    public static void main(String[] args) throws IOException, InterruptedException { // IOException for server start and awaitTermination
        System.out.println("Grpc Server setup");

        //Build the server
        Server server = ServerBuilder.forPort(50055)
                //adding the server implementation
                .addService(new Service_1_impl_2())
                .build();

        //Start the server
        server.start();
        System.out.println("Server running");

        // Shut down the server if the application close it.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shut down request");
            server.shutdown();
            System.out.println("Server Stopped");
        }));

        server.awaitTermination();


    }

}


