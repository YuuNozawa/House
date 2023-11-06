package smartrc;

import smartrc.presentation.controller.HomeController;
import smartrc.presentation.controller.LeaveController;
import smartrc.presentation.controller.LightController;
import smartrc.presentation.state.AppContext;
import smartrc.presentation.state.HomeState;
import smartrc.presentation.state.LeaveState;
import smartrc.presentation.state.LightState;
import smartrc.service.LightService;

public class App {
    public static void main(String[] args) {
        // DIコンテナなし（手動依存解決）
        HomeController homeController = new HomeController();
        HomeState homeState = new HomeState(homeController);

        LightService lightService = new LightService();
        LightController lightController = new LightController(lightService);
        LightState lightState = new LightState(lightController);
        
        LeaveController leaveController = new LeaveController();
        LeaveState leaveState = new LeaveState(leaveController);

        
        AppContext ctx = new AppContext(homeState, lightState, leaveState);
        ctx.interact();
    }
}
