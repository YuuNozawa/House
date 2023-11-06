package smartrc.presentation.state;

import smartrc.presentation.controller.HomeController;

public class HomeState implements State {
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
