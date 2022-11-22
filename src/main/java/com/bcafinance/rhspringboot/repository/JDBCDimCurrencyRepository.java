package com.bcafinance.rhspringboot.repository;

import com.bcafinance.rhspringboot.model.DimCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 22/11/2022
@Last Modified 22/11/2022 13:47
Version 1.0
*/
@Repository
public class JDBCDimCurrencyRepository implements DimCurrencyRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(DimCurrency dcr) {
        return jdbcTemplate.update("Insert into DimCurrency (CurrencyAlternateKey, CurrencyName) VALUES(?,?)",
                new Object[]{dcr.getCurrencyalternatekey(),
                dcr.getCurrencyname()
                });
    }

    @Override
    public int update(DimCurrency dcr) {
        return jdbcTemplate.update("UPDATE DimCurrency SET CurrencyAlternateKey=?, CurrencyName=? WHERE Currencykey=?",
                new Object[]{dcr.getCurrencyalternatekey(),
                dcr.getCurrencyname(),
                dcr.getCurrencykey()});
    }

    @Override
    public DimCurrency findById(long id) {
        try {
            DimCurrency dimCurrency= jdbcTemplate.queryForObject("select * from DimCurrency where CurrencyKey=?",
                    BeanPropertyRowMapper.newInstance(DimCurrency.class),id);

            return dimCurrency;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("delete from DimCurrency where CurrencyKey=?",id);
    }

    @Override
    public List<DimCurrency> findAll() {
        return jdbcTemplate.query("select * from DimCurrency",
                BeanPropertyRowMapper.newInstance(DimCurrency.class));
    }

    @Override
    public List<DimCurrency> findByName(String name) {
        return jdbcTemplate.query("select * from DimCurrency where CurrencyName LIKE CONCAT ('%',?,'%')",
                BeanPropertyRowMapper.newInstance(DimCurrency.class), name);
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("delete from DimCurrency");
    }
}
