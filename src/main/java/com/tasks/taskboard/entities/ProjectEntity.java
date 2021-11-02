package com.tasks.taskboard.entities;


import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Schema(description = "Сущность проекта")
@Entity
public class ProjectEntity {
    @Id
    @GenericGenerator(name = "generator", strategy = "auto")
    @GeneratedValue
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Integer id;
    @Column (nullable = false)
    private String name;
    @Column
    private String isPaid;
    @Column
    private String latestRelease;

    public ProjectEntity() {
    }

    public ProjectEntity(Integer id, String name, String isPaid, String latestRelease) {
        this.id = id;
        this.name = name;
        this.isPaid = isPaid;
        this.latestRelease = latestRelease;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public String getLatestRelease() {
        return latestRelease;
    }

    public void setLatestRelease(String latestRelease) {
        this.latestRelease = latestRelease;
    }



}
