package smartrc.presentation.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.model.LightModel;
import smartrc.service.LightService;
import smartrc.view.LightView;
import smartrc.view.View;

@Component
public class LightController implements Controller {
    @Autowired
    private LightService lightService;

    public LightController(LightService lightService) {
        this.lightService = lightService;
    }

    @Override
    public void display() {
        try {
            LightModel model = lightService.getLight(828);
            View view = new LightView(model);
            view.show();
        } catch(IOException e) {
            System.out.println("エラーが出ている");
        }
    }

    public void save() {
        try {
            lightService.insert(828);
            display();
        } catch(IOException e) {
            System.out.println("エラーが出ている");
        }
    }
}
