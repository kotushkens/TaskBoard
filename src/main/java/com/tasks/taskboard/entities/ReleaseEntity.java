package com.tasks.taskboard.entities;

import com.tasks.taskboard.dto.request.ReleaseRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Schema(description = "Сущность релиза")
@Entity
public class ReleaseEntity {
    @Id
    @GenericGenerator(name="generator", strategy = "auto")
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Column
    private String version;
    @Column
    private Date start;
    @Column
    private Date end;

    public ReleaseEntity(){
    }

    public ReleaseEntity(ReleaseRequestDto release){
        this.id = release.getId();
        this.version = release.getVersion();
        this.start = release.getStart();
        this.end = release.getEnd();
    }

    public ReleaseEntity(Long id, String version, Date start, Date end) {
        this.id = id;
        this.version = version;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
