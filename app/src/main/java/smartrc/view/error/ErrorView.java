package smartrc.view.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.Model;
import smartrc.view.AppFrame;
import smartrc.view.IView;

@Component
@Qualifier("ErrorView")
public class ErrorView implements IView {
    @Autowired
    private AppFrame appFrame;

    public void show() {
        // TODO: エラー時にエラーと出すだけで部屋の操作全般できなくなるのは普通にやばい
        ErrorPanel errorPanel = new ErrorPanel();
        appFrame.next(errorPanel);
    }
    
    public void setModel(Model model) {
        //no-op
    }
}
