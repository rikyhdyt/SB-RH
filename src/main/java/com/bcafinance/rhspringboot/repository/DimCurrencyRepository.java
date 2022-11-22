package com.bcafinance.rhspringboot.repository;

import com.bcafinance.rhspringboot.model.DimCurrency;

import java.util.List;

//public interface DimCurrencyRepository {
public interface DimCurrencyRepository {

    int save(DimCurrency dcr);
    int update(DimCurrency dcr);
    DimCurrency findById(long id);
    int deleteById(long id);
    List<DimCurrency> findAll();
    List<DimCurrency> findByName(String name);
    int deleteAll();

}
