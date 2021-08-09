package gRPC_CA.Client;

import com.proto.CA_Service_1.*;
import gRPC_CA.Server.Server1imp_1;
import gRPC_CA.Server.ServerDiscovery;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public class GUI_Client implements ActionListener {

    private String situation;
    private String areYouAlone = "";
    private String location = "";
    private String option = "";
    private String information = "";


    public static void main(String[] args) {

        GUI_Client gui_client = new GUI_Client();

        gui_client.build();
    }

    private JPanel getService1JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JLabel label = new JLabel("Press for Help");
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));


        JButton button = new JButton("Get Help!");
        button.addActionListener(this);
        panel.add(button);

        panel.setLayout(boxlayout);


        return panel;

    }


    private JPanel getService2JPanel() {

        JPanel panel = new JPanel();


        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

        JComboBox comboSituation = new JComboBox();
        panel.add(comboSituation);
        comboSituation.setModel(new DefaultComboBoxModel(new String []{"Select a situation", "Car Accident","Medical Assistance", "Domestic Violence", "Other"}));

        comboSituation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                situation = String.valueOf(comboSituation.getSelectedItem());
            }
        });

        panel.add(Box.createRigidArea(new Dimension(20, 0)));


        JComboBox comboYesNo = new JComboBox();
        panel.add(comboYesNo);
        comboYesNo.setModel(new DefaultComboBoxModel(new String []{"Are you alone?","Yes", "No"}));

        comboYesNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areYouAlone = String.valueOf(comboYesNo.getSelectedItem());
            }
        });

        panel.setLayout(boxlayout);

        panel.add(Box.createRigidArea(new Dimension(20, 0)));

        JButton button = new JButton("Service 2");
        button.addActionListener(this);
        panel.add(button);

        return panel;

    }

    private JPanel getService3JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);


        JComboBox comboLocation = new JComboBox();
        panel.add(comboLocation);
        comboLocation.setModel(new DefaultComboBoxModel(new String []{"Select your Location","Dublin", "Galway","Cork"}));

        comboLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                location = String.valueOf(comboLocation.getSelectedItem());
            }
        });


        panel.add(Box.createRigidArea(new Dimension(40, 0)));

        JButton button = new JButton("Service 3");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(15, 0)));

        panel.setLayout(boxlayout);

        return panel;

    }

    private JPanel getService4JPanel() {

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);


        JComboBox comboOption = new JComboBox();
        panel.add(comboOption);
        comboOption.setModel(new DefaultComboBoxModel(new String []{"Types of services",
                "Non-life-threatening emergencies",
                "Calling an ambulance",
                "Emotional support helpline"}));

        comboOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                option = String.valueOf(comboOption.getSelectedItem());
            }
        });

        panel.add(Box.createRigidArea(new Dimension(10, 0)));

        JComboBox comboInformation = new JComboBox();
        panel.add(comboInformation);
        comboInformation.setModel(new DefaultComboBoxModel(new String []{"Type of Information",
                "Phone Number",
                "E-mails",
                "Website"}));

        comboInformation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                information = String.valueOf(comboInformation.getSelectedItem());
            }
        });

        panel.add(Box.createRigidArea(new Dimension(20, 0)));

        JButton button = new JButton("Service 4");
        button.addActionListener(this);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));

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
        if (label.equals("Get Help!")) {


             Logger logger = Logger.getLogger(GUI_Client.class.getName());

                ServiceInfo serviceInfo;
                String service_type = "_unary._tcp.local.";
                //Now retrieve the service info - all we are supplying is the service type
                serviceInfo = ServerDiscovery.run(service_type);
                //Use the serviceInfo to retrieve the port
                int port = serviceInfo.getPort();
                System.out.println(port);
                String host = "localhost";
                // Port 50051


            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
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

          //>> SERVICE 1 IMPLEMENTATION 2  CLIENT STREAMING

        } else if (label.equals("Service 2")) {

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055)
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
                    System.out.println(situation);

                    JFrame frame;
                    frame = new JFrame();
                    // As a response, we pass the value set on the server when we build "OnCompleted"
                    JOptionPane.showMessageDialog(frame,value.getSituationResponse());

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

            System.out.println("Situation " + situation);
            requestStreamObserver.onNext(UserDataRequest.newBuilder()
                    .setEmergencySituation(situation)
                    .build());
            System.out.println("Message 1");
            //Streaming message number 2

            requestStreamObserver.onNext(UserDataRequest.newBuilder()
                    .setTextSituation(areYouAlone)
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

            //>> SERVICE 2 IMPLEMENTATION 1  SERVER STREAMING

        }else if (label.equals("Service 3")) {

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                    .usePlaintext() // plaint text for security
                    .build();
            System.out.println("Channel build");

            InformationGrpc.InformationBlockingStub infoClient = InformationGrpc.newBlockingStub(channel);

            infoClient.userLocation(UserLocationRequest.newBuilder()
                .setUserLocation(location)
                    .build())
                    .forEachRemaining(userLocationResponse -> {

                        JFrame frame;
                        frame = new JFrame();

                        JOptionPane.showMessageDialog(frame,userLocationResponse.getLocation());

                    });


            //>> SERVICE 2 IMPLEMENTATION 2  BIDIRECTIONAL STREAMING

        }else if (label.equals("Service 4")) {

            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50054)
                    .usePlaintext() // plaint text for security
                    .build();
            System.out.println("Channel build");

            InformationGrpc.InformationStub bidiStreamClient = InformationGrpc.newStub(channel);

            CountDownLatch latch = new CountDownLatch(1);

            StreamObserver<OptionRequest> requestObs = bidiStreamClient.option(new StreamObserver<OptionResponse>() {

                @Override
                public void onNext(OptionResponse value) {
                    System.out.println("Response from the server receive");
                    System.out.println(value.getServiceResponse());
                    System.out.println(option);

                    JFrame frame;
                    frame = new JFrame();
                    // As a response, we pass the value set on the server when we build "OnCompleted"
                    JOptionPane.showMessageDialog(frame,value.getServiceResponse());

                }


                @Override
                public void onError(Throwable t) {
                    latch.countDown();

                }

                @Override
                public void onCompleted() {
                    System.out.println("Server done");
                    latch.countDown();
                }
            });

            requestObs.onNext(OptionRequest.newBuilder()
                    .setServiceOption(option)
                    .build());

            requestObs.onNext(OptionRequest.newBuilder()
                    .setTypeOption(information)
                    .build());

            requestObs.onCompleted();
            try {
                latch.await(3l,TimeUnit.SECONDS);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }else{


        }
    }
}