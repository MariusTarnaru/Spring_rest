package sda.spring.rest.controller.dto;

import javax.validation.constraints.Size;

public class UserStatus {

    @Size(max = 50, message = "Status cannot be longer than 50 characters")
    private String status;

    public String getStatus() {
        return status;
    }

    public UserStatus setStatus(String status) {
        this.status = status;
        return this;
    }
}
