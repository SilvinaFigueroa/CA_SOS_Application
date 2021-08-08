package gRPC_CA.Server;

import com.proto.CA_Service_1.InformationGrpc;
import com.proto.CA_Service_1.UserLocationRequest;
import com.proto.CA_Service_1.UserLocationResponse;
import io.grpc.stub.StreamObserver;

public class Service_2_impl_1 extends InformationGrpc.InformationImplBase {
    public static void main(String[] args) {

    }

    @Override
    public void userLocation(UserLocationRequest request, StreamObserver<UserLocationResponse> responseObserver) {


        String[] emergencyCentre = new String[]{"Hospital 684484648", "Garda 145686486", "Firefighter 454874785684"};

        String userLocation = request.getUserLocation();

        try {

            for (int i = 0; i <= 3; i++) {
                String UserResponse = userLocation + "\n" + emergencyCentre[i];

                UserLocationResponse response = UserLocationResponse.newBuilder()
                        .setLocation(UserResponse)
                        .build();

                responseObserver.onNext(response);
                Thread.sleep(1000l);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();

        }
    }
}
