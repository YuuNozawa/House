package smartrc;

import smartrc.presentation.state.AppContext;
import smartrc.presentation.state.HomeState;

public class App {
    public static void main(String[] args) {
        AppContext ctx = new AppContext();
        HomeState.getInstance().init();
        ctx.interact();
    }
}
