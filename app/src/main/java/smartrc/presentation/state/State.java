package smartrc.presentation.state;

public interface State {
    public abstract void doCommand(Context context, int cmd);
    public abstract void init();
}
