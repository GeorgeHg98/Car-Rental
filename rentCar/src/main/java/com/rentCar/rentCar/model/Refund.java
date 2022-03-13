package com.rentCar.rentCar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "refund")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "refund_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "date_of_return")
    private Date dateOfReturn;
    @OneToOne
    private Reservation reservation;
    @Column(name = "surcharge")
    private double surcharge;
    @Column(name = "comments")
    private String comments;

    public Refund(Employee employee, Date dateOfReturn, Reservation reservation, double surcharge, String comments) {
        this.employee = employee;
        this.dateOfReturn = dateOfReturn;
        this.reservation = reservation;
        this.surcharge = surcharge;
        this.comments = comments;
    }

    public Refund() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "id=" + id +
                ", employee=" + employee +
                ", dateOfReturn=" + dateOfReturn +
                ", reservation=" + reservation +
                ", surcharge=" + surcharge +
                ", comments='" + comments + '\'' +
                '}';
    }
}
