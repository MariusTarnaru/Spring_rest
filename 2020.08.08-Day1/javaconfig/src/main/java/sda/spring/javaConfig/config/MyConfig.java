package sda.spring.javaConfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sda.spring.javaConfig.beans.MyBean;
import sda.spring.javaConfig.beans.MyNewBean;

@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean(){
        MyBean myBean = new MyBean();
        myBean.setName("Valeriu");
        return myBean;
    }

    @Bean
    public MyNewBean myNewBean(){
        MyNewBean myNewBean = new MyNewBean();
        myNewBean.setName("SDA");
        return myNewBean;
    }
}
