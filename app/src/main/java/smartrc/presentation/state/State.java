package smartrc.presentation.state;

public interface State {
    public abstract void handle(int cmd);
    public abstract void init();
}
