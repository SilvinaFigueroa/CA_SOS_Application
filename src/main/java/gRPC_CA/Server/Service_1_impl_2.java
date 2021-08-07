package gRPC_CA.Server;

import com.proto.CA_Service_1.*;
import io.grpc.stub.StreamObserver;

import javax.swing.*;

public class Service_1_impl_2 extends HelpMessageServiceGrpc.HelpMessageServiceImplBase {

    @Override
    public StreamObserver<UserDataRequest> userData(StreamObserver<UserDataResponse> responseObserver) {
        // creating the StreamObserver
        StreamObserver<UserDataRequest> streamObserverRequest = new StreamObserver<UserDataRequest>() {


            @Override
            public void onNext(UserDataRequest value) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        }

        return super.userData(responseObserver);

        //prepare the value to be set back


        responseObserver.onNext(helpResponse);


        responseObserver.onCompleted();


    }


}

