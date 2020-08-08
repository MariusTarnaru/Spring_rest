package sda.spring.javaConfig.beans;

public class MyNewBean extends MyBean{

    @Override
    public void sayHello() {
        System.out.println("Hello " + this.getName() +
                " this is the new implementation of MyBean. Better. Faster. Stronger");
    }
}
