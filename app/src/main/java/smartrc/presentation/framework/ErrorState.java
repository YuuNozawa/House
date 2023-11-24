package smartrc.presentation.framework;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.presentation.controller.ErrorController;

@Component
public class ErrorState implements IState {
    @Autowired
    private ErrorController errorController;

    @Autowired
    @Qualifier("errorCmdMap")
    private Map<Integer, IState> cmdMap;

    @Override
    public void handle(int cmd) {
        // no-op
    }

    @Override
    public void display() {
        errorController.display();
        System.out.println("エラー発生！");
    }

    @Override
    public String toString() {
        return "状態：エラー";
    }

    @Override
    public IState next(int cmd) {
        return cmdMap.get(cmd);
    }
}
