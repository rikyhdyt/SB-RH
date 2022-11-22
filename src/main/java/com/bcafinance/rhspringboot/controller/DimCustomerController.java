package com.bcafinance.rhspringboot.controller;

import com.bcafinance.rhspringboot.model.DimCustomer;
import com.bcafinance.rhspringboot.repository.DimCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DimCustomerController {

    @Autowired
    DimCustomerRepository dimCustomerRepository;

    @GetMapping("/dimcustomers/{id}")
    public ResponseEntity<DimCustomer> getDimCustomerById(@PathVariable("id") long id) {
        DimCustomer dimCustomer = dimCustomerRepository.findById(id);

        if (dimCustomer != null) {
            return new ResponseEntity<>(dimCustomer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/dimcustomers/{name}")
//    public ResponseEntity<DimCustomer> getDimCustomerById(@PathVariable("id") long id) {


    @PostMapping("/dimcustomers")
    public ResponseEntity<String> createDimCustomer(@RequestBody DimCustomer dimCustomer) {
        try {
//            public DimCustomer(String firstname, String middlename,
//                    String lastname, String birthdate, String emailaddress, String customeralternatekey) {
            dimCustomerRepository.save(new DimCustomer(dimCustomer.getFirstname(),
                    dimCustomer.getMiddlename(),
                    dimCustomer.getLastname(),
                    dimCustomer.getBirthdate(),
                    dimCustomer.getEmailaddress(),
                    dimCustomer.getCustomeralternatekey()));
            return new ResponseEntity<>("Data berhasil dibuat.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/dimcustomers/{id}")
    public ResponseEntity<String> updateDimCustomer(@PathVariable("id") long id, @RequestBody DimCustomer dimCustomer) {
        DimCustomer _dimCustomer = dimCustomerRepository.findById(id);

        if (_dimCustomer != null) {
            _dimCustomer.setCustomerkey(id);
            _dimCustomer.setEmailaddress(dimCustomer.getEmailaddress());
            _dimCustomer.setCustomeralternatekey(dimCustomer.getCustomeralternatekey());
            _dimCustomer.setFirstname(dimCustomer.getFirstname());
            _dimCustomer.setMiddlename(dimCustomer.getMiddlename());
            _dimCustomer.setLastname(dimCustomer.getLastname());
            _dimCustomer.setBirthdate(dimCustomer.getBirthdate());

            dimCustomerRepository.update(_dimCustomer);
            return new ResponseEntity<>("Data Berhasil diperbaharui.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tidak dapat menemukan data dengan id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dimcustomers/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        try {
            int result = dimCustomerRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Data dengan id " + id +" Tidak ada !!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Data dengan id "+id+" Berhasil di hapus", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data .", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dimcustomers/6832BLE")
    public ResponseEntity<String> deleteAll() {
        try {
            int numRows = dimCustomerRepository.deleteAll();
            return new ResponseEntity<>("Berhasil Menghapus  " + numRows + " Data .", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/dimcustomers/datas/{name}")
    public ResponseEntity<List<DimCustomer>> findByCustomerName(@PathVariable("name") String name) {
        try {
            List<DimCustomer> lsDimCustomer = dimCustomerRepository.findByName(name);

            if (lsDimCustomer.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lsDimCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
