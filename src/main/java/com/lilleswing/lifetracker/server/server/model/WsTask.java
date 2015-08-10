package com.lilleswing.lifetracker.server.server.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class WsTask {
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("completed")
    private boolean completed;

    @JsonProperty("difficulty")
    private long difficulty;

    public WsTask() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(final boolean completed) {
        this.completed = completed;
    }

    public long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(final long difficulty) {
        this.difficulty = difficulty;
    }
}
