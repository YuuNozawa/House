package smartrc.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.view.View;

@Component
public class HomeController implements Controller {
    
    @Autowired
    @Qualifier("HomeView")
    private View view;
    
    @Override
    public void display() {
        view.show();
    }
}
