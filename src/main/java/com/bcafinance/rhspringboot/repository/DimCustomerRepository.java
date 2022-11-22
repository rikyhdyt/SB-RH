package com.bcafinance.rhspringboot.repository;

import com.bcafinance.rhspringboot.model.DimCustomer;

import java.util.List;

public interface DimCustomerRepository {

    int save(DimCustomer dc);
    int update(DimCustomer dc);
    DimCustomer findById(long id);

    /*
        Delete maksud nya adalah mengupdate kolom flag status dirubah menjadi 0
     */
    int deleteById(long id);
    List<DimCustomer> findAll();

    List<DimCustomer> findByName(String name);
    int deleteAll();
}
