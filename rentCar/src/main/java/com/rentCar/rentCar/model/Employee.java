package com.rentCar.rentCar.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public Employee(String firstName, String name, String position, Branch branch) {
        this.firstName = firstName;
        this.name = name;
        this.position = position;
        this.branch = branch;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", branch=" + branch +
                '}';
    }
}