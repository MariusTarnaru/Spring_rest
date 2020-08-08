package sda.spring.xmlConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sda.spring.xmlConfig.beans.MyBean;

public class XmlConfigApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyBean myBean = (MyBean) context.getBean("myBean");

        myBean.sayHello();

        myBean.setName("SDA");

        myBean.sayHello();
    }

}
