package com.bcafinance.rhspringboot.model;

public class DimCustomer {

    private long customerkey;
    private String firstname;
    private String middlename;
    private String lastname;
    private String birthdate;
    private String emailaddress;
    private String customeralternatekey;

    public DimCustomer() {
    }

    public DimCustomer(long customerkey, String firstname, String middlename, String lastname, String birthdate, String emailaddress, String customeralternatekey) {
        this.customerkey = customerkey;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.emailaddress = emailaddress;
        this.customeralternatekey = customeralternatekey;
    }

    public DimCustomer(String firstname, String middlename, String lastname, String birthdate, String emailaddress, String customeralternatekey) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.emailaddress = emailaddress;
        this.customeralternatekey = customeralternatekey;
    }

    public long getCustomerkey() {
        return customerkey;
    }

    public void setCustomerkey(long customerkey) {
        this.customerkey = customerkey;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getCustomeralternatekey() {
        return customeralternatekey;
    }

    public void setCustomeralternatekey(String customeralternatekey) {
        this.customeralternatekey = customeralternatekey;
    }
}