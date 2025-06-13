package com.example;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task() {}

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "todo";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters và setters
    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s [%s]", id, description, status);
    }
}