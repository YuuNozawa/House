package smartrc.view.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import smartrc.model.Model;
import smartrc.view.AppFrame;
import smartrc.view.View;

@Component
@Qualifier("HomeView")
public class HomeView implements View {
    @Autowired
    private AppFrame appFrame;

    public void show() {
        HomePanel homePanel = new HomePanel();
        appFrame.next(homePanel);

        // System.out.println("+------------------+");
        // System.out.println("| 1: Main Light    |");
        // System.out.println("| 9: Leave         |");
        // System.out.println("|                  |");
        // System.out.println("+------------------+");
    }
    
    public void setModel(Model model) {
        // no-op
    }
}
