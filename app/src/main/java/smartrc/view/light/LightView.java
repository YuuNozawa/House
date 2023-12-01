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
    private AppFrame appFrame;
    private LightPanel lightPanel;
    private LightModel model;

    @Autowired
    public LightView(AppFrame appFrame, LightPanel lightPanel) {
        this.appFrame = appFrame;
        this.lightPanel = lightPanel;
    }

    public void show() {
        lightPanel.render(model);
        appFrame.next(lightPanel);
    }

    public void setModel(Model model) {
        if(model instanceof LightModel) {
            this.model = (LightModel)model;
        }
    }
}
