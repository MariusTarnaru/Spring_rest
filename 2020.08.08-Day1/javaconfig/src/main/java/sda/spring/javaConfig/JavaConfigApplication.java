package sda.spring.javaConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sda.spring.javaConfig.beans.MyBean;
import sda.spring.javaConfig.beans.MyNewBean;
import sda.spring.javaConfig.beans.PrototypeBean;
import sda.spring.javaConfig.beans.SingletonBean;
import sda.spring.javaConfig.config.MyConfig;

public class JavaConfigApplication {

    public static void main2(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(MyConfig.class);
        context.refresh();

        MyBean myBean = (MyBean) context.getBean("myBean");
//		MyBean myNewBean = (MyNewBean) context.getBean("myNewBean");

        myBean.sayHello();
        myBean.setName("SDA");
        myBean.sayHello();
//		myNewBean.sayHello();

        MyBean anotherBean = (MyBean) context.getBean("myBean");
        anotherBean.sayHello();


    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConfig.class);

        PrototypeBean firstPrototype = context.getBean(PrototypeBean.class);

        PrototypeBean secondPrototype = context.getBean(PrototypeBean.class);

        firstPrototype.setMessage("Hello");
        System.out.println(firstPrototype.getMessage());

        System.out.println(secondPrototype.getMessage());

        secondPrototype.setMessage("Buna ziua");
        System.out.println(secondPrototype.getMessage());
    }

}
