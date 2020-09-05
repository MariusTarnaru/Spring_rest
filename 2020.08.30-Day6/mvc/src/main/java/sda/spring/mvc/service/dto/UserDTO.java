package sda.spring.mvc.service.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO {

    private long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String country;

    public long getId() {
        return id;
    }

    public UserDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserDTO setCountry(String country) {
        this.country = country;
        return this;
    }
}
