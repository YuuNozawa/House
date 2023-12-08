package smartrc.presentation.framework.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.ErrorController;
import smartrc.presentation.framework.Command;
import smartrc.presentation.framework.IAction;
import smartrc.presentation.framework.StateFactory;

@Component
public class ErrorState implements IState {
    private ErrorController errorController;
    private StateFactory stateFactory;
    private Map<Command, IAction> cmdMap;

    @Autowired
    public ErrorState(ErrorController errorController, StateFactory stateFactory) {
        this.errorController = errorController;
        this.stateFactory = stateFactory;

        Map<Command, IAction> cmdMap = new HashMap<>();
        cmdMap.put(new Command(0), () -> stateFactory.createState(HomeState.class));
        this.cmdMap = cmdMap;
    }

    @Override
    public void display() {
        errorController.display();
        System.out.println("エラー発生！");
    }

    @Override
    public String toString() {
        return "状態：エラー";
    }

    @Override
    public Optional<IState> next(Command cmd) throws Exception {
        return cmdMap.get(cmd).execute();
    }
}
