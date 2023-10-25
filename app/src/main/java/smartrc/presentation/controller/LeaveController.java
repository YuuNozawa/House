package smartrc.presentation.controller;

import smartrc.view.LeaveView;
import smartrc.view.View;

public class LeaveController {
    public void start() {
        View view = new LeaveView();
        view.show();
    }
}
