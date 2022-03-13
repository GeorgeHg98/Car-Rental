package com.rentCar.rentCar.model;


import javax.persistence.*;

@Entity
@Table(name = "rental")

public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rental_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "internet_domain")
    private String internetDomain;
    @Column(name = "contact_address")
    private String contactAddress;
    @Column(name = "owner")
    private String owner;
    @Column(name = "logo_type")
    private String logoType;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public Rental(String name, String internetDomain, String contactAddress, String owner, String logoType, Branch branch) {
        this.name = name;
        this.internetDomain = internetDomain;
        this.contactAddress = contactAddress;
        this.owner = owner;
        this.logoType = logoType;
        this.branch = branch;
    }

    public Rental() {

    }

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

    public String getInternetDomain() {
        return internetDomain;
    }

    public void setInternetDomain(String internetDomain) {
        this.internetDomain = internetDomain;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLogoType() {
        return logoType;
    }

    public void setLogoType(String logoType) {
        this.logoType = logoType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", internetDomain='" + internetDomain + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", owner='" + owner + '\'' +
                ", logoType='" + logoType + '\'' +
                ", branch=" + branch +
                '}';
    }
}