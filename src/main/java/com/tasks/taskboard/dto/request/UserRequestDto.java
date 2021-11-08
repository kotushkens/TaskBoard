package com.tasks.taskboard.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

public class UserRequestDto {
    private Long id;
    private String name;
    private String surname;
    private String contacts;
    private String password;
    private String repeatPassword;


    public UserRequestDto(){
    }

    public UserRequestDto(Long id, String name, String surname,
                          String contacts, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.contacts = contacts;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
