package smartrc.presentation.state;

import smartrc.presentation.controller.LeaveController;

public class LeaveState implements State {
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
