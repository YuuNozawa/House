package smartrc.presentation.framework;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import smartrc.presentation.framework.state.ErrorState;
import smartrc.presentation.framework.state.HomeState;
import smartrc.presentation.framework.state.IState;
import smartrc.presentation.framework.state.LeaveState;
import smartrc.presentation.framework.state.StateFactory;

@Component
public class AppContext {
    private IState currentState;
    private StateFactory stateFactory;

    @Autowired
    public AppContext(HomeState homeState, StateFactory stateFactory) {
        this.stateFactory = stateFactory;
        changeState(homeState);
        tryDisplay();
    }

    private void changeState(IState state) {
        currentState = state;
    }

    private void tryDisplay() {
        try {
            System.out.println(currentState);
            currentState.display();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            changeState( stateFactory.createState(ErrorState.class).get() );
            tryDisplay();
        }
    }

    // Commandに紐づくActionを実行し、次の状態がある場合は状態を変更
    private void tryNext(Command cmd) {
        try {
            currentState.next(cmd).ifPresent(state -> { 
                changeState(state);
                tryDisplay();
            });
        } catch(Exception e) {
            System.out.println(e.getMessage());
            changeState( stateFactory.createState(ErrorState.class).get() );
            tryDisplay();
        }
    }

    public void interact() {
        Scanner sc = new Scanner(System.in);
        while( !(currentState instanceof LeaveState) ) {
            tryNext( new Command(sc.nextInt()) );
        }
        sc.close();
    }
}
