package com.rentCar.rentCar.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "date_of_rental")
    private Date dateOfRental;
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    @Column(name = "comments")
    private String comments;

    public Loan(Employee employee, Date dateOfRental, Reservation reservation, String comments) {
        this.employee = employee;
        this.dateOfRental = dateOfRental;
        this.reservation = reservation;
        this.comments = comments;
    }

    public Loan() {

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

    public Date getDateOfRental() {
        return dateOfRental;
    }

    public void setDateOfRental(Date dateOfRental) {
        this.dateOfRental = dateOfRental;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", employee=" + employee +
                ", dateOfRental=" + dateOfRental +
                ", reservation=" + reservation +
                ", comments='" + comments + '\'' +
                '}';
    }
}
