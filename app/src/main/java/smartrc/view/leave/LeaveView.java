package smartrc.view.leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.Model;
import smartrc.view.AppFrame;
import smartrc.view.IView;

@Component
@Qualifier("LeaveView")
public class LeaveView implements IView {
    @Autowired
    private AppFrame appFrame;
    public void show() {
        LeavePanel leavePanel = new LeavePanel();
        appFrame.next(leavePanel);
    }
    
    public void setModel(Model model) {
        // no-op
    }
}
