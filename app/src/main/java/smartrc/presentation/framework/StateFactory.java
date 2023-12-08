package smartrc.presentation.framework;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import smartrc.presentation.framework.state.IState;

@Component
public class StateFactory {
    @Autowired
    private ApplicationContext applicationContext;

    public Optional<IState> createState(Class<? extends IState> clazz) {
        return Optional.of(applicationContext.getBean(clazz));
    }

    // public Optional<IState> createState(String type) {
    //     if ( HomeState.class.getName().equals(type) ) {
    //         return Optional.of(applicationContext.getBean(HomeState.class));
    //     } else if ( "light".equals(type) ) {
    //         return Optional.of(applicationContext.getBean(LightState.class));
    //     } else if ( "leave".equals(type) ) {
    //         return Optional.of(applicationContext.getBean(LeaveState.class));
    //     } else if ( "error".equals(type) ) {
    //         return Optional.of(applicationContext.getBean(ErrorState.class));
    //     }
    //     return Optional.empty();
    // }
}
