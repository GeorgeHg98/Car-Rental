package com.rentCar.rentCar.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "branch_id")
    private int id;
    @Column(name = "address")
    private String address;
    @OneToMany
    @JoinColumn(name = "employee_id")
    private Set<Employee> employees;
    @OneToMany
    private Set<Car> cars;

    public Branch(String address, Set<Employee> employees, Set<Car> cars) {
        this.address = address;
        this.employees = employees;
        this.cars = cars;
    }

    public Branch() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", employees=" + employees +
                ", cars=" + cars +
                '}';
    }
}