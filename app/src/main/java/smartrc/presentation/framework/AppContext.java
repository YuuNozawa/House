package smartrc.presentation.framework;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class AppContext {
    private static final int ERR_CD = 999;

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
            changeState( currentState.next(ERR_CD) );
            tryDisplay();
        }
    }

    private void tryHandle(int cmd) {
        try {
            currentState.handle(cmd);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            changeState( currentState.next(ERR_CD) );
            tryDisplay();
        }
    }

    public void interact() {
        Scanner sc = new Scanner(System.in);
        int cmd = 0;
        while( !(currentState instanceof LeaveState) ) {
            cmd = sc.nextInt();
            if(currentState.next(cmd) != null) {
                changeState( currentState.next(cmd) );
                tryDisplay();
            } else {
                // Mapはキー(Command)が存在しない場合nullを返す
                tryHandle(cmd);
            }
        }
        sc.close();
    }
}
