package smartrc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

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

    @Autowired
    Environment env;
    
    @Bean
    public int propsRoomNo(){
        return Integer.valueOf(env.getProperty("roomNo"));
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        // Spring Boot 未使用のため必要
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
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
