package smartrc.presentation.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.LightModel;
import smartrc.service.LightService;
import smartrc.view.View;
import smartrc.view.light.LightView;

@Component
public class LightController implements Controller {
    @Autowired
    private LightService lightService;

    @Autowired
    @Qualifier("LightView")
    private View view;

    @Autowired
    private int propsRoomNo;

    @Override
    public void display() {
        try {
            LightModel model = lightService.getLight(propsRoomNo);
            view.setModel(model);
            view.show();
        } catch(IOException e) {
            System.out.println("エラーが出ている");
        }
    }

    public void save() {
        try {
            lightService.insert(propsRoomNo);
            display();
        } catch(IOException e) {
            System.out.println("エラーが出ている");
        }
    }
}
