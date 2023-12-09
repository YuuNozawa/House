package smartrc.presentation.framework.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.HomeController;
import smartrc.presentation.framework.Command;
import smartrc.presentation.framework.IAction;

@Component
public class HomeState implements IState {
    @SuppressWarnings("unused")
    private final StateFactory stateFactory;
    private final HomeController homeController;
    private final Map< Command, IAction> cmdMap;

    @Autowired
    public HomeState(HomeController homeController, StateFactory stateFactory) {
        this.homeController = homeController;
        this.stateFactory = stateFactory;
        
        Map< Command, IAction> cmdMap = new HashMap<>();
        cmdMap.put(new Command(0), () -> {
            homeController.changeLanguage();
            return Optional.empty();
        } );
        cmdMap.put(new Command(1), () -> stateFactory.createState(LightState.class));
        cmdMap.put(new Command(9), () -> stateFactory.createState(LeaveState.class));

        this.cmdMap = cmdMap;
    }

    @Override
    public void display() {
        homeController.display();
    }

    @Override
    public String toString() {
        return "状態：ホーム";
    }

    @Override
    public Optional<IState> next(Command cmd) throws Exception {
        if(cmdMap.containsKey(cmd)) return cmdMap.get(cmd).execute();
        return Optional.empty();
    }
}
