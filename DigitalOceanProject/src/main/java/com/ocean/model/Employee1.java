package com.ocean.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="Employee", uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Employee1 {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="NAME", length=20, nullable=true)
    private String name;

    @Column(name="ROLE", length=20, nullable=true)
    private String role;

    @Column(name="insert_time", nullable=true)
    private Date insertTime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Date getInsertTime() {
        return insertTime;
    }
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}