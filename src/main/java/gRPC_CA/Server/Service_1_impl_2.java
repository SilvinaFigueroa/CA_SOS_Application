package gRPC_CA.Server;

import com.proto.CA_Service_1.HelpMessageServiceGrpc;
import com.proto.CA_Service_1.UserDataRequest;
import com.proto.CA_Service_1.UserDataResponse;
import io.grpc.stub.StreamObserver;

public class Service_1_impl_2 extends HelpMessageServiceGrpc.HelpMessageServiceImplBase {
    public static void main(String[] args) {

    }


    @Override
    public StreamObserver<UserDataRequest> userData (StreamObserver<UserDataResponse> responseObserver) {
        // creating the StreamObserver -
        StreamObserver<UserDataRequest> requestStreamObserver = new StreamObserver<UserDataRequest>() {

            String userResponse = "";
            String serverResponse = "";

            @Override

            //The client sent a message
            public void onNext(UserDataRequest value) {

                userResponse = value.getEmergencySituation();

                if (userResponse.equalsIgnoreCase("Medical Assistance")) {
                    serverResponse = "You are not alone, then, " + value.getTextSituation() + "\n" +
                            "Medical Assistance Phone Number  12345678";
                }
                    else{

                    }
                }


            @Override
            // Error handling
            public void onError(Throwable t) {

            }

            @Override
            // Client finished sending messages
            // Return response (responseObserver)

            public void onCompleted() {
                responseObserver.onNext(UserDataResponse.newBuilder().
                        setSituationResponse(serverResponse)
                        .build());
                System.out.println(userResponse);
                System.out.println(serverResponse);

                responseObserver.onCompleted();

            }

        };

        return requestStreamObserver;
    }
}




