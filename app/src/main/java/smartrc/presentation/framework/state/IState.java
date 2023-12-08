package smartrc.presentation.framework.state;

import java.util.Optional;

import smartrc.presentation.framework.Command;

public interface IState {
    public abstract void display() throws Exception;
    public abstract Optional<IState> next(Command cmd) throws Exception;
}
