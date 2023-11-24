package smartrc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import smartrc.presentation.framework.ErrorState;
import smartrc.presentation.framework.HomeState;
import smartrc.presentation.framework.IState;
import smartrc.presentation.framework.LeaveState;
import smartrc.presentation.framework.LightState;

@Configuration
@PropertySource(value={"classpath:application.properties"})
public class AppConfig {
    @Autowired
    ApplicationContext applicationContext;

    @Value("${roomNo}")
    private int propsRoomNo;
    
    @Bean
    public int propsRoomNo(){
        return propsRoomNo;
    }

    @Bean
    @Qualifier("homeCmdMap")
    public Map<Integer, IState> map1() {
        Map<Integer, IState> map = new HashMap<>();
        map.put(1, applicationContext.getBean(LightState.class));
        map.put(9, applicationContext.getBean(LeaveState.class));
        map.put(999, applicationContext.getBean(ErrorState.class));
        return map;
    }

    @Bean
    @Qualifier("lightCmdMap")
    public Map<Integer, IState> map2() {
        Map<Integer, IState> map = new HashMap<>();
        map.put(9, applicationContext.getBean(HomeState.class));
        map.put(999, applicationContext.getBean(ErrorState.class));
        return map;
    }

    @Bean
    @Qualifier("errorCmdMap")
    public Map<Integer, IState> map3() {
        Map<Integer, IState> map = new HashMap<>();
        map.put(0, applicationContext.getBean(HomeState.class));
        return map;
    }

    // @Bean
    // public HomeController homeController() {
    //     return new HomeController(applicationContext.getBean(HomeView.class));
    // }
}
