package smartrc.presentation.framework;

public interface State {
    public abstract void handle(int cmd);
    public abstract void display();
    public abstract State next(int cmd);
}
