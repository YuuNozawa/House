package smartrc.presentation.framework;

import java.util.Optional;

import smartrc.presentation.framework.state.IState;

@FunctionalInterface
public interface IAction {
    Optional<IState> execute() throws Exception;
}
