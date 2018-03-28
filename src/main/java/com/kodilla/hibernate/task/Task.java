package com.kodilla.hibernate.task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "TASKS")
public final class Task {
        private int id;
        private String decription;
        private Date created;
        private int duration;

    public Task(String decription, int duration) {
        this.decription = decription;
        this.duration = duration;
        this.created = new Date();
    }

    public Task() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDecription() {
        return decription;
    }

    @NotNull
    public Date getCreated() {
        return created;
    }

    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDecription(String decription) {
        this.decription = decription;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }
}
