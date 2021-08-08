package gRPC_CA.Server;

import com.proto.CA_Service_1.InformationGrpc;
import com.proto.CA_Service_1.OptionRequest;
import com.proto.CA_Service_1.OptionResponse;
import io.grpc.stub.StreamObserver;

public class Service_2_impl_2 extends InformationGrpc.InformationImplBase{
    public static void main(String[] args) {
    }

    @Override
    public StreamObserver<OptionRequest> option (StreamObserver<OptionResponse> responseObserver) {
       StreamObserver<OptionRequest> requestObserver = new StreamObserver<OptionRequest>() {

           @Override
           public void onNext(OptionRequest value) {
               String userOption = value.getServiceOption();
               String typeOption = value.getTypeOption();

               OptionResponse optionResponse = OptionResponse.newBuilder().setServiceResponse(userOption).build();

               responseObserver.onNext(optionResponse);

               OptionResponse typeResponse = OptionResponse.newBuilder().setServiceResponse(typeOption).build();

               responseObserver.onNext(typeResponse);
           }

           @Override
           public void onError(Throwable t) {

           }

           @Override
           public void onCompleted() {
               responseObserver.onCompleted();

           }
       };

        return requestObserver;
    }
}
