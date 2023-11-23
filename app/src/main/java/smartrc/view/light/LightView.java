package smartrc.view.light;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.LightModel;
import smartrc.model.Model;
import smartrc.view.AppFrame;
import smartrc.view.View;

@Component
@Qualifier("LightView")
public class LightView implements View {
    @Autowired
    private AppFrame appFrame;

    private LightModel model;

    public void show() {
        LightPanel lightPanel = new LightPanel(model);
        appFrame.next(lightPanel);

        // String str = model.getIsOn() ? "on " : "off";
        // System.out.println("+------------------+");
        // System.out.println("| Main Light: " + str + "  |");
        // System.out.println("| 1: on/off        |");
        // System.out.println("| 9: back          |");
        // System.out.println("+------------------+");
    }

    public void setModel(Model model) {
        if(model instanceof LightModel) {
            this.model = (LightModel)model;
        }
    }
}
