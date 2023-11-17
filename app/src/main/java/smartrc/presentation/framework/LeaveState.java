package smartrc.presentation.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.LeaveController;

@Component
public class LeaveState implements State {
    @Autowired
    private LeaveController leaveController;

    @Override
    public void handle(int cmd) {
        // no-op
    }

    @Override
    public void display() {
        leaveController.display();
    }

    @Override
    public String toString() {
        return "状態：退出";
    }

    @Override
    public State next(int cmd) {
        return null;
    }
}
