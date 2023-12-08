package smartrc.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.LightModel;
import smartrc.service.LightService;
import smartrc.view.IView;

@Component
public class LightController {
    @Autowired
    private LightService lightService;

    @Autowired
    @Qualifier("LightView")
    private IView view;

    public void display() throws Exception {
        // if(true) { throw new Exception("エラーの動作確認");}
        LightModel model = lightService.getLight();
        view.setModel(model);
        view.show();
    }

    public void save() throws Exception {
        lightService.update();
        display();
    }
}
