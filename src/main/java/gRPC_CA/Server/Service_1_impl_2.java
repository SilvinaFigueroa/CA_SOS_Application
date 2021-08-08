package gRPC_CA.Server;

import com.proto.CA_Service_1.HelpMessageServiceGrpc;
import com.proto.CA_Service_1.UserDataRequest;
import com.proto.CA_Service_1.UserDataResponse;
import io.grpc.stub.StreamObserver;

public class Service_1_impl_2 extends HelpMessageServiceGrpc.HelpMessageServiceImplBase {



    @Override
    public StreamObserver<UserDataRequest> userData (StreamObserver<UserDataResponse> responseObserver) {
        // creating the StreamObserver -
        StreamObserver<UserDataRequest> requestStreamObserver = new StreamObserver<UserDataRequest>() {

            String situationResponse = "";

            @Override

            //The client sent a message
            public void onNext(UserDataRequest value) {
                situationResponse = "Situation informed :" + String.valueOf(UserDataRequest.getDefaultInstance().getEmergencySit())+ "\n" +
                        String.valueOf(UserDataRequest.getDefaultInstance().getTextSituation());
            }

            @Override
            // Error handling
            public void onError(Throwable t) {

            }

            @Override
            // Client finished sending messages
            // Return response (responseObserver)

//            MedicalAssistance  =0;
//            CarAccident =1;
//            DomesticViolence = 2;
//            Other = 3;

            public void onCompleted() {
                responseObserver.onNext(UserDataResponse.newBuilder().
                        setSituationResponse(situationResponse)
                        .build());

                responseObserver.onCompleted();

            }

        };

        return requestStreamObserver;
    }
}




