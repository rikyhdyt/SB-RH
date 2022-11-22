package com.bcafinance.rhspringboot.repository;

import com.bcafinance.rhspringboot.model.DimScenario;

import java.util.List;

//public interface DimScenarioRepository {
public interface DimScenarioRepository {

    int save(DimScenario ds);
    int update(DimScenario ds);
    DimScenario findById(long id);
    int deleteById(long id);
    List<DimScenario> findAll();
    List<DimScenario> findByScenarioName(String scenarioName);
    int deleteAll();

}
