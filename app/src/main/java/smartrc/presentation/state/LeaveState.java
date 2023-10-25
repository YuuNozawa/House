package smartrc.presentation.state;

import smartrc.presentation.controller.LeaveController;

public class LeaveState implements State {
    private static LeaveState singleton = new LeaveState();

    public static LeaveState getInstance() {
        return singleton;
    }

    @Override
    public void doCommand(Context context, int cmd) {
        // no-op
    }

    @Override
    public void init() {
        LeaveController controller = new LeaveController();
        controller.start();
    }
}
