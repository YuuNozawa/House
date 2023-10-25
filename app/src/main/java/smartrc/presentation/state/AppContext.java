package smartrc.presentation.state;

import java.util.Scanner;

public class AppContext implements Context {
    private State state = HomeState.getInstance();

    public void changeState(State state) {
        this.state = state;
    }

    public void interact() {
        Scanner sc = new Scanner(System.in);
        while(state != LeaveState.getInstance()) {
            int cmd = sc.nextInt();
            state.doCommand(this, cmd);
            state.init();
        }
        sc.close();
    }
}
