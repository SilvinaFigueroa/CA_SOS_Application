package gRPC_CA;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Server_service1 {
    public static void main(String[] args) throws IOException, InterruptedException { // IOException for server start and awaitTermination
        System.out.println("Grpc Server setup");

        Server server = ServerBuilder.forPort(50051)
                .build();

        server.start();
        System.out.println("Server running");

        // Shut down the server if the application close it.
        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            System.out.println("Shut down request");
            server.shutdown();
            System.out.println("Server Stopped");
        }   ));

        server.awaitTermination();


    }

}


