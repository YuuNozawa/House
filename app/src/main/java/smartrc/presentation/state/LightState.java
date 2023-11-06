package smartrc.presentation.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.LightController;

@Component
public class LightState implements State {
    @Autowired
    private LightController lightController;

    public LightState(LightController lightController) {
        this.lightController = lightController;
    }

    @Override
    public void handle(int cmd) {
        if(cmd == 1) {
            lightController.save();
        }
    }

    @Override
    public void init() {
        lightController.display();
    }

    @Override
    public String toString() {
        return "状態：メインライト";
    }
}
