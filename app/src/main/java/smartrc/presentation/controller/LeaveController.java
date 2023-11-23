package smartrc.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.view.View;

@Component
public class LeaveController implements Controller{
    
    @Autowired
    @Qualifier("LeaveView")
    private View view;

    public void display() {
        view.show();
    }
}
