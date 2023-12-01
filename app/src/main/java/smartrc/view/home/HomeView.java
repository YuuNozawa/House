package smartrc.view.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.Model;
import smartrc.view.AppFrame;
import smartrc.view.IView;

@Component
@Qualifier("HomeView")
public class HomeView implements IView {
    private AppFrame appFrame;
    private HomePanel homePanel;

    @Autowired
    public HomeView(AppFrame appFrame, HomePanel homePanel) {
        this.appFrame = appFrame;
        this.homePanel = homePanel;
    }

    public void show() {
        homePanel.render();
        appFrame.next(homePanel);
    }
    
    public void setModel(Model model) {
        // no-op
    }
}
