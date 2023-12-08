package smartrc.presentation.framework.state;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.HomeController;
import smartrc.presentation.framework.Command;
import smartrc.presentation.framework.IAction;
import smartrc.presentation.framework.LeaveState;
import smartrc.presentation.framework.StateFactory;

@Component
public class HomeState implements IState {
    private HomeController homeController;
    private StateFactory stateFactory;
    private Map< Command, IAction> cmdMap;

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
        cmdMap.put(new Command(999), () -> stateFactory.createState(ErrorState.class));

        this.cmdMap = cmdMap;
        System.out.println("constructor end");
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
        return cmdMap.get(cmd).execute();
    }
}
