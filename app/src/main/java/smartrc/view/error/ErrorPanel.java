package smartrc.view.error;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorPanel extends JPanel {
    public ErrorPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lbl = new JLabel("SYSTEM ERROR");
        JLabel lbl2 = new JLabel("Apologies for the inconvenience.");
        JLabel lbl3 = new JLabel("An Error occured during the operation.");
        JLabel lbl4 = new JLabel("Press 0 to return to the home screen.");
        lbl.setForeground(Color.RED);
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl3.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl4.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(lbl);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(lbl2);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(lbl3);
        this.add(Box.createRigidArea(new Dimension(0, 3)));
        this.add(lbl4);
        this.add(Box.createVerticalGlue());
    }
}
