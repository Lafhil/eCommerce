package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class AdminLogs {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "LogID", nullable = false)
    private int logId;

    @Basic
    @Column(name = "Action", nullable = true, length = 255)
    private String action;
    @Basic
    @Column(name = "LogTime", nullable = true)
    private Date logTime;
    @ManyToOne
    @JsonBackReference(value = "adminLog")
    @JoinColumn(name = "AdminID", referencedColumnName = "AdminID")
    private Administrators administratorsByAdminId;


}
