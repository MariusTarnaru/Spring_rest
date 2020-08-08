package sda.spring.javaConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sda.spring.javaConfig.beans.MyBean;
import sda.spring.javaConfig.beans.MyNewBean;
import sda.spring.javaConfig.config.MyConfig;

public class JavaConfigApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(MyConfig.class);
		context.refresh();

		MyBean myBean = (MyBean) context.getBean("myBean");
		MyBean myNewBean = (MyNewBean) context.getBean("myNewBean");

		myBean.sayHello();
		myNewBean.sayHello();


	}

}
