package gRPC_CA.Server;

import com.proto.CA_Service_1.InformationGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class Server2imp_2 extends InformationGrpc.InformationImplBase {

    private static final Logger logger = Logger.getLogger(Server2imp_2.class.getName());

    public static void main(String[] args) {

        Server2imp_2 server2imp2 = new Server2imp_2();

        int port = 50054;
        String service_type = "_biStreaming._tcp.local.";
        String service_name = "GrpcServer_2.1";

        // register the service instantiating the class service registration
        ServerRegistration registration = new ServerRegistration();
        registration.run(port, service_type, service_name);

        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(server2imp2)
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


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        logger.info("Server started, listening on " + port);


    }

}



