package smartrc.view.light;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.LightModel;
import smartrc.model.Model;
import smartrc.view.AppFrame;
import smartrc.view.IView;

@Component
@Qualifier("LightView")
public class LightView implements IView {
    @Autowired
    private AppFrame appFrame;

    private LightModel model;

    public void show() {
        LightPanel lightPanel = new LightPanel(model);
        appFrame.next(lightPanel);
    }

    public void setModel(Model model) {
        if(model instanceof LightModel) {
            this.model = (LightModel)model;
        }
    }
}
