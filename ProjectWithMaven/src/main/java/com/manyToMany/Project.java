package com.manyToMany;

import javax.persistence.*;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int pId;

    @Column(name = "project_name")
    private String pName;

    @ManyToMany(mappedBy = "projectList")
    private List<Employee> empList;

    public Project() {
    }

    public Project(int pId, String pName, List<Employee> empList) {
        this.pId = pId;
        this.pName = pName;
        this.empList = empList;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }
}
