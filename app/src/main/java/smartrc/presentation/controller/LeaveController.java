package smartrc.presentation.controller;

import smartrc.view.LeaveView;
import smartrc.view.View;

public class LeaveController implements Controller{
    public void display() {
        View view = new LeaveView();
        view.show();
    }
}
