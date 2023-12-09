package smartrc.presentation.framework.state;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StateFactory {
    @Autowired
    private ApplicationContext applicationContext;

    public Optional<IState> createState(Class<? extends IState> clazz) {
        return Optional.of(applicationContext.getBean(clazz));
    }
}
