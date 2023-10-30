package com.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Objects;

@Entity
@Getter @Setter
@EqualsAndHashCode
public class Administrators {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AdminID", nullable = false)
    private int adminId;
    @Basic
    @Column(name = "FirstName", nullable = true, length = 50)
    private String firstName;
    @Basic
    @Column(name = "LastName", nullable = true, length = 50)
    private String lastName;
    @Basic
    @Column(name = "Email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "Password", nullable = true, length = 255)
    private String password;
    @JsonManagedReference(value = "adminLog")
    @OneToMany(mappedBy = "administratorsByAdminId")
    private Collection<AdminLogs> adminLogsByAdminId;


}
