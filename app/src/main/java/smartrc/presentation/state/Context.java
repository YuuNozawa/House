package smartrc.presentation.state;

public interface Context {
    public abstract void changeState(State state);
    public abstract void interact();
}
