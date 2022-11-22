package com.bcafinance.rhspringboot.controller;

import com.bcafinance.rhspringboot.model.DimScenario;
import com.bcafinance.rhspringboot.repository.DimScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DimScenarioController {



    @Autowired
    DimScenarioRepository dimScenarioRepository;


    @GetMapping("/dimscenarios/{id}")
    public ResponseEntity<DimScenario> getDimScenarioById(@PathVariable("id") long id) {
        DimScenario dimScenario = dimScenarioRepository.findById(id);

        if (dimScenario != null) {
            return new ResponseEntity<>(dimScenario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dimscenarios")
    public ResponseEntity<String> createDimScenario(@RequestBody DimScenario dimScenario) {
        try {
            dimScenarioRepository.save(new DimScenario(dimScenario.getScenarioname()));
            return new ResponseEntity<>("Data berhasil dibuat.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/dimscenarios/{id}")
    public ResponseEntity<String> updateDimScenario(@PathVariable("id") long id, @RequestBody DimScenario dimScenario) {
        DimScenario _dimScneario = dimScenarioRepository.findById(id);

        if (_dimScneario != null) {
            _dimScneario.setScenarioKey(id);
            _dimScneario.setScenarioname(dimScenario.getScenarioname());

            dimScenarioRepository.update(_dimScneario);
            return new ResponseEntity<>("Data Berhasil diperbaharui.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tidak dapat menemukan data dengan id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dimscenarios/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        try {
            int result = dimScenarioRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Data dengan id " + id +" Tidak ada !!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Data dengan id "+id+" Berhasil di hapus", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data .", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dimscenarios/6832BLE")
    public ResponseEntity<String> deleteAll() {
        try {
            int numRows = dimScenarioRepository.deleteAll();
            return new ResponseEntity<>("Berhasil Menghapus  " + numRows + " Data .", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/dimscenarios/datas/{scenarioname}")
    public ResponseEntity<List<DimScenario>> findByScenarioName(@PathVariable("scenarioname") String scenarioName) {
        try {
            List<DimScenario> lsDimScenarios = dimScenarioRepository.findByScenarioName(scenarioName);

            if (lsDimScenarios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lsDimScenarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
