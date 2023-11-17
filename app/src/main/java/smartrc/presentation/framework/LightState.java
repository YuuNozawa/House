package smartrc.presentation.framework;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.LightController;

@Component
public class LightState implements State {
    @Autowired
    private LightController lightController;

    @Autowired
    @Qualifier("lightCmdMap")
    private Map<Integer, State> cmdMap;

    @Override
    public void handle(int cmd) {
        if(cmd == 1) {
            lightController.save();
        }
    }

    @Override
    public void display() {
        lightController.display();
    }

    @Override
    public String toString() {
        return "状態：メインライト";
    }

    @Override
    public State next(int cmd) {
        return cmdMap.get(cmd);
    }
}
