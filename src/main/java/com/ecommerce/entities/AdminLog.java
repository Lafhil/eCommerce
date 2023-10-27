package com.ecommerce.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "AdminLogs")
public class AdminLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LogID", nullable = false)
    private Integer id;

    @Column(name = "\"Action\"")
    private String action;

    @Column(name = "LogTime")
    private Instant logTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Instant getLogTime() {
        return logTime;
    }

    public void setLogTime(Instant logTime) {
        this.logTime = logTime;
    }

}