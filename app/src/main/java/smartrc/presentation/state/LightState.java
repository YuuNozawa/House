package smartrc.presentation.state;

import smartrc.presentation.controller.LightController;

public class LightState implements State {
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
