package smartrc.presentation.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.LeaveController;

@Component
public class LeaveState implements State {
    @Autowired
    private LeaveController leaveController;

    public LeaveState(LeaveController leaveController) {
        this.leaveController = leaveController;
    }

    @Override
    public void handle(int cmd) {
        // no-op
    }

    @Override
    public void init() {
        leaveController.display();
    }

    @Override
    public String toString() {
        return "状態：退出";
    }
}
