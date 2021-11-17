package com.tasks.taskboard.entities;


import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "projects")
@Schema(description = "Сущность проекта")
@Entity
public class ProjectEntity {
    @Id
    @GenericGenerator(name = "generator", strategy = "auto")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "is_paid")
    private boolean isPaid;
    @Column(name = "latest_release")
    private String latestRelease;

    public ProjectEntity() {
    }

    public ProjectEntity(Long id, String name, boolean isPaid, String latestRelease) {
        this.id = id;
        this.name = name;
        this.isPaid = isPaid;
        this.latestRelease = latestRelease;
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

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getLatestRelease() {
        return latestRelease;
    }

    public void setLatestRelease(String latestRelease) {
        this.latestRelease = latestRelease;
    }


}
