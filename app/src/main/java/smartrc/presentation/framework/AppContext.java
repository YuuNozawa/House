package smartrc.presentation.framework;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import smartrc.presentation.framework.state.HomeState;
import smartrc.presentation.framework.state.IState;

@Component
public class AppContext {
    private IState currentState;

    public AppContext(HomeState homeState) {
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
            // changeState( currentState.next(ECommand.ERROR.getCommand()) );
            // tryDisplay();
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
            // changeState( currentState.next(ECommand.ERROR.getCommand()) );
            // tryDisplay();
        }
    }

    public void interact() {
        Scanner sc = new Scanner(System.in);
        
        while( !(currentState instanceof LeaveState) ) {
            Command cmd = new Command(sc.nextInt());
            tryNext(cmd);
            // if(currentState.next(cmd) != null) {
            //     changeState( currentState.next(cmd) );
            //     tryDisplay();
            // } else {
            //     // Mapはキー(Command)が存在しない場合nullを返す
            //     tryNext(cmd);
            // }
        }
        sc.close();
    }
}
