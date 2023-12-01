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
    private AppFrame appFrame;
    private LeavePanel leavePanel;

    @Autowired
    public LeaveView(AppFrame appFrame, LeavePanel leavePanel) {
        this.appFrame = appFrame;
        this.leavePanel = leavePanel;
    }

    public void show() {
        leavePanel.render();
        appFrame.next(leavePanel);
    }
    
    public void setModel(Model model) {
        // no-op
    }
}
