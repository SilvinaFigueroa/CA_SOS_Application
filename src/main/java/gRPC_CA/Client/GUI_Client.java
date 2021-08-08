package gRPC_CA.Client;

import com.proto.CA_Service_1.HelpMessageRequest;
import com.proto.CA_Service_1.HelpMessageResponse;
import com.proto.CA_Service_1.HelpMessageServiceGrpc;
import com.proto.CA_Service_1.UserDataRequest;
import com.proto.CA_Service_1.UserDataResponse;
import gRPC_CA.Server.Service_1_impl_1;
import gRPC_CA.Server.Service_1_impl_2;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class GUI_Client implements ActionListener {

    private JTextField entry1, reply1;
    private JTextField entry2, reply2;
    private JTextField entry3, reply3;
    private JTextField entry4, reply4;

    public static void main(String[] args) {

        GUI_Client gui_client = new GUI_Client();

        gui_client.build();
    }

    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry1 = new JTextField("", 10);
        panel.add(entry1);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 1");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply1 = new JTextField("", 10);
        reply1.setEditable(false);
        panel.add(reply1);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService2JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JComboBox comboOperation = new JComboBox();
        comboOperation.setModel(new DefaultComboBoxModel(new String[]{"Medical Assistance", "Car Accident", "Domestic Violence", "Other"}));
        panel.add(comboOperation);

        int situation = comboOperation.getSelectedIndex();
        UserDataRequest.EmergencySituation operation = UserDataRequest.EmergencySituation.forNumber(situation);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 2");
        button.addActionListener(this);
        panel.add(button);
        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry2 = new JTextField("", 10);
        panel.add(entry2);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply2 = new JTextField("", 10);
        reply2.setEditable(false);
        panel.add(reply2);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService3JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry3 = new JTextField("", 10);
        panel.add(entry3);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 3");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply3 = new JTextField("", 10);
        reply3.setEditable(false);
        panel.add(reply3);

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService4JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Enter value");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        entry4 = new JTextField("", 10);
        panel.add(entry4);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JButton button = new JButton("Invoke Service 4");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        reply4 = new JTextField("", 10);
        reply4.setEditable(false);
        panel.add(reply4);

        panel.setLayout(boxlayout);

        return panel;

    }

    private void build() {

        JFrame frame = new JFrame("Service Controller Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Set the BoxLayout to be X_AXIS: from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));

        panel.add(getService1JPanel());
        panel.add(getService2JPanel());
        panel.add(getService3JPanel());
        panel.add(getService4JPanel());

        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String label = button.getActionCommand();

        //>> SERVICE 1 IMPLEMENTATION 1 UNARY
        if (label.equals("Invoke Service 1")) {
            System.out.println("service 1 to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                    .usePlaintext() // plaint text for security
                    .build();
            System.out.println("Channel build");

            // Creating the stub: BlockingStub for async - FutureStub for sync
            HelpMessageServiceGrpc.HelpMessageServiceBlockingStub service1Client = HelpMessageServiceGrpc.newBlockingStub(channel);

            // creating the protocol buffer messages


            HelpMessageRequest helpRequest = HelpMessageRequest.newBuilder()
                    .setHelpRequest("Help me!")
                    .build();

            HelpMessageResponse response = service1Client.helpMessage(helpRequest);
            JOptionPane.showMessageDialog(null, "Help Requested");

          //>> SERVICE 1 IMPLEMENTATION 2  SERVER STREAMING

        } else if (label.equals("Invoke Service 2")) {
            System.out.println("service 2 to be invoked ...");

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                    .usePlaintext() // plaint text for security
                    .build();
            System.out.println("Channel build");

            //Latch create for the responseObserver
            CountDownLatch latch = new CountDownLatch(1);

            // Creating the stub -
            HelpMessageServiceGrpc.HelpMessageServiceStub serviceClientStream = HelpMessageServiceGrpc.newStub(channel);

            //Creating an instance of StreamObserver to send the response with serviceClientStream
            StreamObserver<UserDataRequest> requestStreamObserver = serviceClientStream.userData(new StreamObserver<UserDataResponse>() {

                @Override
                // Response to the server - On Next will be called only once
                public void onNext(UserDataResponse value) {

                    System.out.println("Response from the server receive");
                    System.out.println(value.getSituationResponse());

                    JFrame frame;
                    frame = new JFrame();
                    // As a response, we pass the value set on the server when we build "OnCompleted"
                    JOptionPane.showMessageDialog(frame, value.getSituationResponse());

                }

                @Override
                //Error handling
                public void onError(Throwable t) {

                }

                @Override
                // The server is done sending data
                public void onCompleted() {
                    System.out.println("Server has sent the message");
                    // when server is done sending data, it decrease the latch by onw
                    latch.countDown();
                }
            });

            // Messages send to the response observer
            //Streaming message number 1

            requestStreamObserver.onNext(UserDataRequest.newBuilder()
                    .setEmergencySit(UserDataRequest.getDefaultInstance().getEmergencySit())
                    .build());
            System.out.println("Message 1");
            //Streaming message number 2

            requestStreamObserver.onNext(UserDataRequest.newBuilder()
                    .setTextSituation(UserDataRequest.getDefaultInstance().getTextSituation())
                    .build());
            System.out.println("Message 2");

            // sent to the server that the client is done sending messages.
           requestStreamObserver.onCompleted();

           //When the latch reaches 0 will complete. This will happens when server sent the messages (On Completed)
            try {
                latch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

//            /*
//             *
//             *
//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
//            Service2Grpc.Service2BlockingStub blockingStub = Service2Grpc.newBlockingStub(channel);
//
//            //preparing message to send
//            ds.service2.RequestMessage request = ds.service2.RequestMessage.newBuilder().setText(entry2.getText()).build();
//
//            //retreving reply from service
//            ds.service2.ResponseMessage response = blockingStub.service2Do(request);
//
//            reply2.setText( String.valueOf( response.getLength()) );
//
//        }else if (label.equals("Invoke Service 3")) {
//            System.out.println("service 3 to be invoked ...");
//
//
//            /*
//             *
//             */
//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
//            Service3Grpc.Service3BlockingStub blockingStub = Service3Grpc.newBlockingStub(channel);
//
//            //preparing message to send
//            ds.service3.RequestMessage request = ds.service3.RequestMessage.newBuilder().setText(entry3.getText()).build();
//
//            //retreving reply from service
//            ds.service3.ResponseMessage response = blockingStub.service3Do(request);
//
//            reply3.setText( String.valueOf( response.getLength()) );
//
//        }else if (label.equals("Invoke Service 4")) {
//            System.out.println("service 4 to be invoked ...");
//
//
//            /*
//             *
//             */
//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build();
//            Service4Grpc.Service4BlockingStub blockingStub = Service4Grpc.newBlockingStub(channel);
//
//            //preparing message to send
//            ds.service4.RequestMessage request = ds.service4.RequestMessage.newBuilder().setText(entry4.getText()).build();
//
//            //retreving reply from service
//            ds.service4.ResponseMessage response = blockingStub.service4Do(request);
//
//            reply4.setText( String.valueOf( response.getLength()) );
//
//        }else{
//

        }
    }
}