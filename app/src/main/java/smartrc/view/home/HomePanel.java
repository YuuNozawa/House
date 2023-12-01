package smartrc.view.home;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.service.MessageService;

@Component
public class HomePanel extends JPanel {
    private final MessageService ms;
    private final JLabel lbl1 = new JLabel();
    private final JLabel lbl2 = new JLabel();
    private final JLabel lbl3 = new JLabel();

    @Autowired
    public HomePanel(MessageService ms) {
        this.ms = ms;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        lbl1.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        lbl2.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        lbl3.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(lbl1);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(lbl2);
        this.add(Box.createRigidArea(new Dimension(0, 15)));
        this.add(lbl3);
        this.add(Box.createVerticalGlue());
    }

    public void render() {
        lbl1.setText(ms.getMessage("home.label.1", null));
        lbl2.setText(ms.getMessage("home.label.2", null));
        lbl3.setText(ms.getMessage("home.label.3", null));
    }
}
