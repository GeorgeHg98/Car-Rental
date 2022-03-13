package com.rentCar.rentCar.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private int id;
    @Column(name = "date_of_booking")
    private Date dateOfBooking;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne
    private Car car;
    @Column(name = "date_from")
    private Date dateFrom;
    @Column(name = "date_to")
    private Date dateTo;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    @Column(name = "return_department")
    private String returnDepartment;
    @Column(name = "amount")
    private double amount;

    public Reservation(Date dateOfBooking, Customer customer, Car car, Date dateFrom, Date dateTo, Branch branch, String returnDepartment, double amount) {
        this.dateOfBooking = dateOfBooking;
        this.customer = customer;
        this.car = car;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.branch = branch;
        this.returnDepartment = returnDepartment;
        this.amount = amount;
    }

    public Reservation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(Date dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getReturnDepartment() {
        return returnDepartment;
    }

    public void setReturnDepartment(String returnDepartment) {
        this.returnDepartment = returnDepartment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateOfBooking=" + dateOfBooking +
                ", customer=" + customer +
                ", car=" + car +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", branch=" + branch +
                ", returnDepartment='" + returnDepartment + '\'' +
                ", amount=" + amount +
                '}';
    }
}
