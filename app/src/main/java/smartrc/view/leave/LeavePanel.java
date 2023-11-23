package smartrc.view.leave;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeavePanel extends JPanel {
    public LeavePanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lbl = new JLabel("take care.");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(lbl);
        this.add(Box.createVerticalGlue());
    }
}
