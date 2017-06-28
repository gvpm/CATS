package cats.json;

import cats.core.Core;
import cats.dataModels.Profile;
import cats.dataModels.SimulationParameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author gvpm
 */
public class JsonInterface implements Callable<Integer> {

    String jsonAll;

    public JsonInterface(String jsonAll) {
        this.jsonAll = jsonAll;
    }

    @Override
    public Integer call() {
        ObjectMapper mapper = new ObjectMapper();
        Core core;
        SimulationParameters parameters;
        Profile profile;
        JsonModel jsonModel;

        try {

            // Convert JSON string to Object
            jsonModel = mapper.readValue(jsonAll, JsonModel.class);

            core = new Core();

            core.setParameters(jsonModel.getSimulationParameters());

            for (int i = 0; i < jsonModel.getProfiles().size(); i++) {
                core.addProfile(jsonModel.getProfiles().get(i));

            }

            core.init();
            long startTime = System.currentTimeMillis();
            core.simulateAllDensities();
            long elapsedTime = System.currentTimeMillis() - startTime;
            long secondsTotal = elapsedTime / 1000;
            long minutes = secondsTotal / 60;
            long secondsRest = secondsTotal % 60;
            System.out.println("Total Simulation Time: " + minutes + " minutes and " + secondsRest + " seconds.");


        } catch (JsonGenerationException e) {
            System.out.println(e);

        } catch (JsonMappingException | ExecutionException | InterruptedException e) {
            System.out.println(e);

        } catch (IOException e) {
            System.out.println(e);
        }

        return 1;
    }

}
