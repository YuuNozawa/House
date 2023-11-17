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

    @Autowired
    private final int propsRoomNo;

    public LightController(LightService lightService, int propsRoomNo) {
        this.lightService = lightService;
        this.propsRoomNo = propsRoomNo;
    }

    @Override
    public void display() {
        try {
            System.out.println(propsRoomNo);
            LightModel model = lightService.getLight(propsRoomNo);
            View view = new LightView(model);
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
