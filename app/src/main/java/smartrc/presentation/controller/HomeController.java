package smartrc.presentation.controller;

import smartrc.view.HomeView;
import smartrc.view.View;

public class HomeController implements Controller {
    @Override
    public void display() {
        View view = new HomeView();
        view.show();
    }
}
