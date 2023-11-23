package smartrc.presentation.framework;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class AppContext {
    private State currentState;

    public AppContext(HomeState homeState) {
        currentState = homeState;
        currentState.display();
    }

    private void changeState(State state) {
        currentState = state;
        currentState.display();
    }

    public void interact() {
        Scanner sc = new Scanner(System.in);
        
        int cmd = 0;
        State beforeState = null;
        while( !(currentState instanceof LeaveState) ) {
            cmd = sc.nextInt();
            beforeState = currentState;

            // Mapはキーが存在しない場合nullを返す
            if(currentState.next(cmd) != null) {
                changeState( currentState.next(cmd) );
            }

            // 状態の変更が発生しない場合は状態の処理
            if(beforeState == currentState) {
                currentState.handle(cmd);
            }
            
        }
        System.out.println("退出済み");
        sc.close();
    }
}
