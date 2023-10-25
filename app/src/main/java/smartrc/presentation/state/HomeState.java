package smartrc.presentation.state;

import smartrc.presentation.controller.HomeController;

public class HomeState implements State {
    private static HomeState singleton = new HomeState();

    public static HomeState getInstance() {
        return singleton;
    }

    @Override
    public void doCommand(Context context, int cmd) {
        if(cmd == 1){
            context.changeState(LightState.getInstance());
        } else {
            context.changeState(LeaveState.getInstance());
        }
    }

    @Override
    public void init() {
        HomeController controller = new HomeController();
        controller.start();
    }
}
