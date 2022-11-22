package com.bcafinance.rhspringboot.repository;


import com.bcafinance.rhspringboot.model.DimCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCDimCustomerRepository implements  DimCustomerRepository{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(DimCustomer dc) {
        return jdbcTemplate.update("INSERT INTO DimCustomer (CustomerAlternateKey,FirstName,MiddleName,LastName,EmailAddress,BirthDate) VALUES(?,?,?,?,?,?)",
                new Object[] {dc.getCustomeralternatekey(),
                dc.getFirstname(),
                dc.getMiddlename(),
                dc.getLastname(),
                dc.getEmailaddress(),
                dc.getBirthdate()});
    }

    @Override
    public int update(DimCustomer dc) {
        return jdbcTemplate.update("UPDATE DimCustomer SET CustomerAlternateKey=?,FirstName=?,MiddleName=?,LastName=?,EmailAddress=?,BirthDate=? WHERE CustomerKey=?",
                new Object[] { dc.getCustomeralternatekey(),
                        dc.getFirstname(),
                        dc.getMiddlename(),
                        dc.getLastname(),
                        dc.getEmailaddress(),
                        dc.getBirthdate(),
                        dc.getCustomerkey()});
    }

    @Override
    public DimCustomer findById(long id) {
        try{
            DimCustomer dimCustomer = jdbcTemplate.queryForObject("SELECT CustomerKey,FirstName,MiddleName,LastName,BirthDate,EmailAddress FROM DimCustomer WHERE CustomerKey=?",
                    BeanPropertyRowMapper.newInstance(DimCustomer.class), id);

            return dimCustomer;
        } catch (
                Exception e) {
            return null;
        }
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM DimCustomer WHERE CustomerKey=?", id);
    }

    @Override
    public List<DimCustomer> findAll() {
        return jdbcTemplate.query("SELECT * from DimCustomer", BeanPropertyRowMapper.newInstance(DimCustomer.class));
    }

    @Override
    public List<DimCustomer> findByName(String name) {
        return jdbcTemplate.query("SELECT * from DimCustomer WHERE FirstName+MiddleName+LastName LIKE CONCAT('%',?,'%')",
                BeanPropertyRowMapper.newInstance(DimCustomer.class), name);
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
