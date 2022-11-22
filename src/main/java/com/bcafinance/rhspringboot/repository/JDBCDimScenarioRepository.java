package com.bcafinance.rhspringboot.repository;

import com.bcafinance.rhspringboot.model.DimScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JDBCDimScenarioRepository implements  DimScenarioRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(DimScenario ds) {
        return jdbcTemplate.update("INSERT INTO DimScenario (ScenarioName) VALUES(?)",
                new Object[] {ds.getScenarioname()});
    }

    @Override
    public int update(DimScenario ds) {
        return jdbcTemplate.update("UPDATE DimScenario SET ScenarioName=? WHERE ScenarioKey=?",
                new Object[] { ds.getScenarioname(),ds.getScenarioKey()});
    }

    @Override
    public DimScenario findById(long id) {
        try{
            DimScenario dimScenario = jdbcTemplate.queryForObject("SELECT * FROM DimScenario WHERE ScenarioKey=?",
                    BeanPropertyRowMapper.newInstance(DimScenario.class), id);

            return dimScenario;
        } catch (
        Exception e) {
            return null;
        }
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM DimScenario WHERE ScenarioKey=?", id);
    }

    @Override
    public List<DimScenario> findAll() {
        return jdbcTemplate.query("SELECT * from DimScenario", BeanPropertyRowMapper.newInstance(DimScenario.class));
    }

    @Override
    public List<DimScenario> findByScenarioName(String scenarioName) {
        return jdbcTemplate.query("SELECT * from DimScenario WHERE ScenarioName=?",
                BeanPropertyRowMapper.newInstance(DimScenario.class), scenarioName);
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE from DimScenario");
    }
}