package com.bcafinance.rhspringboot.controller;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author Kyoto a.k.a Riky Hidayat
Java Developer
Created on 22/11/2022
@Last Modified 22/11/2022 13:30
Version 1.0
*/

import com.bcafinance.rhspringboot.model.DimCurrency;
import com.bcafinance.rhspringboot.repository.DimCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DimCurrencyController {

    @Autowired
    DimCurrencyRepository dimCurrencyRepository;

    @GetMapping("/dimcurrencys/{id}")
    public ResponseEntity<DimCurrency>getCurrencyKeyById(@PathVariable("id")long id){
        DimCurrency dimCurrency = dimCurrencyRepository.findById(id);

        if (dimCurrency != null){
            return new ResponseEntity<>(dimCurrency, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dimcurrencys")
    public ResponseEntity<String> createDimCurrency(@RequestBody DimCurrency dimCurrency){
        try {
            dimCurrencyRepository.save(new DimCurrency(
                    dimCurrency.getCurrencyalternatekey(),
                    dimCurrency.getCurrencyname()));
            return new ResponseEntity<>("Data berhasil dibuat.", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/dimcurrencys/{id}")
    public ResponseEntity<String> updateDimCurrency(@PathVariable("id") long id, @RequestBody DimCurrency dimCurrency) {
        DimCurrency _dimCurrency = dimCurrencyRepository.findById(id);

        if (_dimCurrency != null) {
            _dimCurrency.setCurrencykey(id);
            _dimCurrency.setCurrencyname(dimCurrency.getCurrencyname());
            _dimCurrency.setCurrencyalternatekey(dimCurrency.getCurrencyalternatekey());

            dimCurrencyRepository.update(_dimCurrency);
            return new ResponseEntity<>("Data Berhasil diperbaharui.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tidak dapat menemukan data dengan id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dimcurrencys/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        try {
            int result = dimCurrencyRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Data dengan id " + id +" Tidak ada !!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Data dengan id "+id+" Berhasil di hapus", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data .", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dimcurrencys/deleteall")
    public ResponseEntity<String> deleteAll() {
        try {
            int numRows = dimCurrencyRepository.deleteAll();
            return new ResponseEntity<>("Berhasil Menghapus  " + numRows + " Data .", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dimcurrencys/datas/{name}")
    public ResponseEntity<List<DimCurrency>> findByCurrencyName(@PathVariable("name") String name) {
        try {
            List<DimCurrency> lsDimCurrency = dimCurrencyRepository.findByName(name);

            if (lsDimCurrency.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lsDimCurrency, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
