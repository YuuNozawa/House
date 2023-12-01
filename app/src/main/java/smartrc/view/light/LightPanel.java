package smartrc.view.light;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.model.LightModel;
import smartrc.service.MessageService;

@Component
public class LightPanel extends JPanel {
    private final MessageService ms;
    private final JLabel lbl1 = new JLabel();
    private final JLabel lbl2 = new JLabel();
    private final JLabel lbl3 = new JLabel();

    @Autowired
    public LightPanel(MessageService ms) {
        this.ms = ms;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        lbl1.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        lbl2.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        lbl3.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

        this.add(Box.createVerticalGlue());
        this.add(lbl1);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(lbl2);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(lbl3);
        this.add(Box.createVerticalGlue());
    }

    public void render(LightModel model) {
        lbl1.setText(ms.getMessage("light.label.1", new Object[]{model.getIsOn() ? "on " : "off"}));
        lbl2.setText(ms.getMessage("light.label.2", null));
        lbl3.setText(ms.getMessage("light.label.3", null));
    }
}
