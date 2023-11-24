package smartrc.presentation.framework;

public interface IState {
    public abstract void handle(int cmd) throws Exception;
    public abstract void display() throws Exception;
    public abstract IState next(int cmd);
}
