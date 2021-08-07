package gRPC_CA.Server;

import com.proto.CA_Service_1.HelpMessageRequest;
import com.proto.CA_Service_1.HelpMessageResponse;
import com.proto.CA_Service_1.HelpMessageServiceGrpc;
import io.grpc.stub.StreamObserver;

import javax.swing.*;

public class Service_1_impl_1 extends HelpMessageServiceGrpc.HelpMessageServiceImplBase {

    @Override
    public void helpMessage(HelpMessageRequest request, StreamObserver<HelpMessageResponse> responseObserver) {

        //prepare the value to be set back
        String helpRequest = request.getHelpRequest();
        HelpMessageResponse helpResponse = HelpMessageResponse.newBuilder()
                .setHelpResponse(JOptionPane.showInputDialog("Please,follow the instructions"))
                .build();

        responseObserver.onNext(helpResponse);
        responseObserver.onCompleted();
    }
}