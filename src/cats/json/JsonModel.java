/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.json;

import cats.dataModels.Profile;
import cats.dataModels.SimulationParameters;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author gvpm
 */
public class JsonModel {

    @JsonProperty("simulationParameters")
    SimulationParameters simulationParameters;
    @JsonProperty("profiles")
    List<Profile> profiles;

    @JsonCreator
    public JsonModel() {
    }

    public SimulationParameters getSimulationParameters() {
        return simulationParameters;
    }

    public void setSimulationParameters(SimulationParameters simulationParameters) {
        this.simulationParameters = simulationParameters;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

}
