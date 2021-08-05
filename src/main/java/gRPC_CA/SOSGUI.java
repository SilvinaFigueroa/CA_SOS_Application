package gRPC_CA;

import javax.swing.*;

public class SOSGUI extends JFrame {
    private JPanel SOSPanel;
    private JButton helpMeButton;
    private JComboBox locationOptions;
    private JComboBox typeServices;
    private JCheckBox areYouHurtSituation;
    private JCheckBox areYouAloneSituation;
    private JButton closeAppButton;
    private JButton situationCall;
    private JButton typeServiceCall;
    private JButton locationCall;
    private JPanel LeftPanelMargin;
    private JPanel RightPanelMargin;
    private JCheckBox noneOfAboveSituation;

    // Constructor
    public SOSGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(SOSPanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new SOSGUI("SOSapp");
        frame.setVisible(true);

    }

}
