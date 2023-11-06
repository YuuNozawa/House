package smartrc.presentation.controller;

import org.springframework.stereotype.Component;

import smartrc.view.LeaveView;
import smartrc.view.View;

@Component
public class LeaveController implements Controller{
    public void display() {
        View view = new LeaveView();
        view.show();
    }
}
