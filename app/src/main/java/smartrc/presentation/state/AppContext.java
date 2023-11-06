package smartrc.presentation.state;

import java.util.Scanner;

public class AppContext {
    private State currentState;
    private State homeState;
    private State lightState;
    private State leaveState;

    public AppContext(HomeState homeState, LightState lightState, LeaveState leaveState) {
        this.homeState = homeState;
        this.lightState = lightState;
        this.leaveState = leaveState;

        currentState = homeState;
        currentState.init();
    }

    private void changeState(State state) {
        currentState = state;
        currentState.init();
    }

    public void interact() {
        Scanner sc = new Scanner(System.in);
        int cmd = 0;
        State beforeState = null;

        while( !(currentState instanceof LeaveState) ) {
            cmd = sc.nextInt();
            beforeState = currentState;

            if( currentState instanceof HomeState ) {
                if(cmd == 1) {
                    changeState(lightState);
                } else if(cmd == 9) {
                    changeState(leaveState);
                }
            } else if( currentState instanceof LightState ) {
                if(cmd == 9) {
                    changeState(homeState);
                }
            }

            // 状態の変更が発生しない場合は状態の処理
            if(beforeState == currentState) {
                currentState.handle(cmd);
            }
            
        }
        sc.close();
    }
}
