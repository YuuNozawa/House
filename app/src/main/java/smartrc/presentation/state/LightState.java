package smartrc.presentation.state;

import smartrc.presentation.controller.LightController;

public class LightState implements State {
    private static LightState singleton = new LightState();

    public static LightState getInstance() {
        return singleton;
    }

    @Override
    public void doCommand(Context context, int cmd) {
        if(cmd == 1){
            save();
        } else if(cmd == 9) {
            context.changeState(HomeState.getInstance());
        } else {
            context.changeState(LeaveState.getInstance());
        }
    }

    @Override
    public void init() {
        LightController controller = new LightController();
        controller.start();
    }

    private void save() {
        LightController controller = new LightController();
        controller.save();
    }
}
