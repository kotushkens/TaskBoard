package com.tasks.taskboard.dto.response;

import com.tasks.taskboard.dto.request.UserRequestDto;

import java.util.Date;

public class UserResponseDto {
    private String message;
    Long id;
    private String name;
    private String surname;
    private String contacts;

    public UserResponseDto() {
    }

    public UserResponseDto(Long id, String name, String surname,
                           String contacts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.contacts = contacts;
    }

    public UserResponseDto(UserRequestDto request){
        this.id = request.getId();
        this.name = request.getName();
        this.surname = request.getSurname();
        this.contacts = request.getContacts();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

}
