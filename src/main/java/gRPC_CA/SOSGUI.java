package gRPC_CA;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public SOSGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(SOSPanel);
        this.pack();

        JPanel SOSPanel;
        JButton helpMeButton = null;
        JComboBox locationOptions = null;
        JComboBox typeServices = null;
        JCheckBox areYouHurtSituation = null;
        JCheckBox areYouAloneSituation = null;
        JButton closeAppButton = null;
        JButton situationCall = null;
        JButton typeServiceCall = null;
        JButton locationCall = null;
        JPanel LeftPanelMargin = null;
        JPanel RightPanelMargin = null;
        JCheckBox noneOfAboveSituation = null;


    }



    public static void main(String[] args) {
        JFrame frame = new SOSGUI();
        frame.setVisible(true);


    }


    public JButton getHelpMeButton() {
        return helpMeButton;
    }

    public void setHelpMeButton(JButton helpMeButton) {
        this.helpMeButton = helpMeButton;
    }

    public JComboBox getLocationOptions() {
        return locationOptions;
    }

    public void setLocationOptions(JComboBox locationOptions) {
        this.locationOptions = locationOptions;
    }

    public JComboBox getTypeServices() {
        return typeServices;
    }

    public void setTypeServices(JComboBox typeServices) {
        this.typeServices = typeServices;
    }

    public JCheckBox getAreYouHurtSituation() {
        return areYouHurtSituation;
    }

    public void setAreYouHurtSituation(JCheckBox areYouHurtSituation) {
        this.areYouHurtSituation = areYouHurtSituation;
    }

    public JCheckBox getAreYouAloneSituation() {
        return areYouAloneSituation;
    }

    public void setAreYouAloneSituation(JCheckBox areYouAloneSituation) {
        this.areYouAloneSituation = areYouAloneSituation;
    }

    public JButton getCloseAppButton() {
        return closeAppButton;
    }

    public void setCloseAppButton(JButton closeAppButton) {
        this.closeAppButton = closeAppButton;
    }

    public JButton getSituationCall() {
        return situationCall;
    }

    public void setSituationCall(JButton situationCall) {
        this.situationCall = situationCall;
    }

    public JButton getTypeServiceCall() {
        return typeServiceCall;
    }

    public void setTypeServiceCall(JButton typeServiceCall) {
        this.typeServiceCall = typeServiceCall;
    }

    public JButton getLocationCall() {
        return locationCall;
    }

    public void setLocationCall(JButton locationCall) {
        this.locationCall = locationCall;
    }

    public JPanel getLeftPanelMargin() {
        return LeftPanelMargin;
    }

    public void setLeftPanelMargin(JPanel leftPanelMargin) {
        LeftPanelMargin = leftPanelMargin;
    }

    public JPanel getRightPanelMargin() {
        return RightPanelMargin;
    }

    public void setRightPanelMargin(JPanel rightPanelMargin) {
        RightPanelMargin = rightPanelMargin;
    }

    public JCheckBox getNoneOfAboveSituation() {
        return noneOfAboveSituation;
    }

    public void setNoneOfAboveSituation(JCheckBox noneOfAboveSituation) {
        this.noneOfAboveSituation = noneOfAboveSituation;
    }

}
