package smartrc.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.service.MessageService;
import smartrc.view.IView;

@Component
public class HomeController {
    
    @Autowired
    @Qualifier("HomeView")
    private IView view;

    @Autowired
    MessageService ms;
    
    public void display() {
        view.show();
    }

    public void changeLanguage() {
        ms.setMessage();
    }
}
