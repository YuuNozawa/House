package smartrc.view.light;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import smartrc.model.LightModel;

public class LightPanel extends JPanel {
    public LightPanel(LightModel model) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lbl = new JLabel("Main Light: " + (model.getIsOn() ? "on " : "off"));
        JLabel lbl2 = new JLabel("1: on/off");
        JLabel lbl3 = new JLabel("9: back");

        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl3.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(lbl);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(lbl2);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(lbl3);
        this.add(Box.createVerticalGlue());
    }
}
