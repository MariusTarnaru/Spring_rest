package sda.spring.javaConfig.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import sda.spring.javaConfig.beans.MyBean;
import sda.spring.javaConfig.beans.MyNewBean;
import sda.spring.javaConfig.beans.PrototypeBean;
import sda.spring.javaConfig.beans.SingletonBean;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        return myBean;
    }

    @Bean
    public MyNewBean myNewBean() {
        MyNewBean myNewBean = new MyNewBean();
        myNewBean.setName("SDA");
        return myNewBean;
    }

    @Bean
    SingletonBean singletonBean() {
        SingletonBean singletonBean = new SingletonBean();
        return singletonBean;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }
}
