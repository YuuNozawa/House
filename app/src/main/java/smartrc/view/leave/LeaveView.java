package smartrc.view.leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.Model;
import smartrc.view.AppFrame;
import smartrc.view.View;
import smartrc.view.home.HomePanel;

@Component
@Qualifier("LeaveView")
public class LeaveView implements View {
    @Autowired
    private AppFrame appFrame;
    public void show() {
        LeavePanel leavePanel = new LeavePanel();
        appFrame.next(leavePanel);
        
        // System.out.println("+------------------+");
        // System.out.println("|                  |");
        // System.out.println("|    take care.    |");
        // System.out.println("|                  |");
        // System.out.println("+------------------+");
    }
    
    public void setModel(Model model) {
        // no-op
    }
}
