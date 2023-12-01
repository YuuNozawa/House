package smartrc.view.leave;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.service.MessageService;

@Component
public class LeavePanel extends JPanel {
    private final MessageService ms;
    private final JLabel lbl1 = new JLabel();

    @Autowired
    public LeavePanel(MessageService ms) {
        this.ms = ms;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        lbl1.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(lbl1);
        this.add(Box.createVerticalGlue());
    }

    public void render() {
        lbl1.setText(ms.getMessage("leave.label.1", null));
    }
}
