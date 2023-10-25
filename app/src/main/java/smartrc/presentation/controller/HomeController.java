package smartrc.presentation.controller;

import smartrc.view.HomeView;
import smartrc.view.View;

public class HomeController {
    public void start() {
        View view = new HomeView();
        view.show();
    }
}
