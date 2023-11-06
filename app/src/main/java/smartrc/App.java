package smartrc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;

import smartrc.presentation.state.AppContext;

@ComponentScan
public class App {
    public static void main(String[] args) {
        // DIコンテナなし（手動依存解決）
        // HomeController homeController = new HomeController();
        // HomeState homeState = new HomeState(homeController);

        // LightService lightService = new LightService();
        // LightController lightController = new LightController(lightService);
        // LightState lightState = new LightState(lightController);
        
        // LeaveController leaveController = new LeaveController();
        // LeaveState leaveState = new LeaveState(leaveController);

        
        // AppContext ctx = new AppContext(homeState, lightState, leaveState);
        try(
            GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        ) {
            AppContext ctx = applicationContext.getBean(AppContext.class);
            ctx.interact();
        }
    }
}
