package com.bcafinance.rhspringboot.model;


public class DimScenario {

    private long scenarioKey;
    private String scenarioname;

    public DimScenario() {
    }

    public DimScenario(long scenarioKey, String scenarioname) {
        this.scenarioKey = scenarioKey;
        this.scenarioname = scenarioname;
    }

    public DimScenario(String scenarioname) {
        this.scenarioname = scenarioname;
    }

    public long getScenarioKey() {
        return scenarioKey;
    }

    public void setScenarioKey(long scenarioKey) {
        this.scenarioKey = scenarioKey;
    }

    public String getScenarioname() {
        return scenarioname;
    }

    public void setScenarioname(String scenarioname) {
        this.scenarioname = scenarioname;
    }

}