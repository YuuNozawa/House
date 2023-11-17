package smartrc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;

import smartrc.presentation.framework.AppContext;

@ComponentScan
public class App {
    public static void main(String[] args) {
        try(
            GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        ) {
            AppContext ctx = applicationContext.getBean(AppContext.class);
            ctx.interact();
        }
    }
}
