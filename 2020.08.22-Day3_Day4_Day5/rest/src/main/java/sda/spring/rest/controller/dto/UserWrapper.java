package sda.spring.rest.controller.dto;

import sda.spring.rest.model.User;

public class UserWrapper {

    private User user;
    private String uri;

    public User getUser() {
        return user;
    }

    public UserWrapper setUser(User user) {
        this.user = user;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public UserWrapper setUri(String uri) {
        this.uri = uri;
        return this;
    }
}
