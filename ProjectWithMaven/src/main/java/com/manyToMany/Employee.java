package com.manyToMany;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Employee {
    @Id
    private int eId;
    private String eName;

    @ManyToMany
    private List<Project> projectList;

    public Employee() {
    }

    public Employee(int eId, String eName, List<Project> projectList) {
        this.eId = eId;
        this.eName = eName;
        this.projectList = projectList;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
