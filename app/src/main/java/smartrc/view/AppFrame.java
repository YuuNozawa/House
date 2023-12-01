package smartrc.view;

import java.beans.ConstructorProperties;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;


@Component
public class AppFrame extends JFrame {
    @SuppressWarnings("unused")
    private final int propsRoomNo;

    @ConstructorProperties({"propsRoomNo"})
    public AppFrame(int propsRoomNo) {
        this.propsRoomNo = propsRoomNo;
        this.setTitle("Room " + String.valueOf(propsRoomNo));
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }
    public void removePanel() {
        for(java.awt.Component comp : this.getContentPane().getComponents()) {
            if(comp instanceof JPanel) {
                this.getContentPane().remove(comp);
                break;
            }
        }
    }
    public void next(java.awt.Component component) {
        this.removePanel();
        this.getContentPane().add(component);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
}
