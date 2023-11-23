package smartrc.view.home;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel {
    public HomePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lbl = new JLabel("1: Main Light");
        JLabel lbl2 = new JLabel("9: Leave");

        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(lbl);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(lbl2);
        this.add(Box.createVerticalGlue());
    }
}
