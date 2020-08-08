package sda.spring.xmlConfig.beans;

public class MyBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String firstName, String lastName){
        this.name = firstName + " " + lastName;
    }

    public void sayHello(){
        System.out.println("Hello " + name);
    }
}
