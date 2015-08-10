package com.lilleswing.lifetracker.server.db.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks_users")
public class TaskUser {
    @Id
    @GeneratedValue
    private long id;

    @JoinColumn(name="task_id")
    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = Task.class, fetch = FetchType.LAZY)
    private Task task;

    @JoinColumn(name="app_user_id")
    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = AppUser.class, fetch = FetchType.LAZY)
    private AppUser appUser;

    public TaskUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
