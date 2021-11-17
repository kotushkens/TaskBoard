package com.tasks.taskboard.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Schema(description = "Сущность пользователя")
@Entity
public class UserEntity {
    @Id
    @GenericGenerator(name = "generator", strategy = "auto")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "contacts")
    private String contacts;
    @Column(name = "role")
    private String role;

    public UserEntity() {
    }

    public UserEntity(Long id, String name, String surname, String contacts, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.contacts = contacts;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
