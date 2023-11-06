package smartrc.presentation.controller;

import org.springframework.stereotype.Component;

import smartrc.view.HomeView;
import smartrc.view.View;

@Component
public class HomeController implements Controller {
    @Override
    public void display() {
        View view = new HomeView();
        view.show();
    }
}
