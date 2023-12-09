package smartrc.presentation.framework.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.LeaveController;
import smartrc.presentation.framework.Command;

@Component
public class LeaveState implements IState {
    private final LeaveController leaveController;

    @Autowired
    public LeaveState(LeaveController leaveController) {
        this.leaveController = leaveController;
    }

    @Override
    public void display() {
        leaveController.display();
    }

    @Override
    public String toString() {
        return "状態：退出";
    }

    @Override
    public Optional<IState> next(Command cmd) {
        return Optional.empty();
    }
}
