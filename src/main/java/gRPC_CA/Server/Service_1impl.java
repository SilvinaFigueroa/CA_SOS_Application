package gRPC_CA.Server;

import com.proto.CA_Service_1.HelpMessageRequest;
import com.proto.CA_Service_1.HelpMessageResponse;
import com.proto.CA_Service_1.HelpMessageServiceGrpc;
import gRPC_CA.SOSGUI;
import io.grpc.stub.StreamObserver;

public class Service_1impl extends HelpMessageServiceGrpc.HelpMessageServiceImplBase {

    @Override
    public void helpMessage(HelpMessageRequest request, StreamObserver<HelpMessageResponse> responseObserver) {

        SOSGUI guiapp = new SOSGUI();

        HelpMessageResponse helpResponse = HelpMessageResponse.newBuilder()
                .setHelpButtonResponse(request.getHelpButtonRequest() + "").build();


    }
}
