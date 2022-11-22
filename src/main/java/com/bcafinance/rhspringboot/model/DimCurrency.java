package com.bcafinance.rhspringboot.model;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 22/11/2022
@Last Modified 22/11/2022 13:10
Version 1.0
*/

public class DimCurrency {

    private long currencykey;

    private String currencyalternatekey;

    private String currencyname;

    public DimCurrency(String currencyalternatekey){
        this.currencykey= currencykey;
        this.currencyalternatekey=currencyalternatekey;
        this.currencyname=currencyname;
    }

    public DimCurrency (String currencyalternatekey, String currencyname){
        this.currencyalternatekey=currencyalternatekey;
        this.currencyname=currencyname;
    }

    public long getCurrencykey () {
        return currencykey;
    }

    public void setCurrencykey(long currencykey){
        this.currencykey=currencykey;
    }

    public String getCurrencyalternatekey(){
        return currencyalternatekey;
    }

    public void setCurrencyalternatekey(String currencyalternatekey){
        this.currencyalternatekey=currencyalternatekey;
    }

    public String getCurrencyname(){
        return currencyname;
    }

    public void setCurrencyname(String currencyname){
        this.currencyname=currencyname;
    }

    public DimCurrency() {

    }

}
