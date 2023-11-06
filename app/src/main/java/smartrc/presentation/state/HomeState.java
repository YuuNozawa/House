package smartrc.presentation.state;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.HomeController;

@Component
public class HomeState implements State {
    @Autowired
    private HomeController homeController;

    public HomeState(HomeController homeController) {
        this.homeController = homeController;
    }
    @Override
    public void handle(int cmd) {
        // no-op
    }

    @Override
    public void init() {
        homeController.display();
    }

    @Override
    public String toString() {
        return "状態：ホーム";
    }
}
