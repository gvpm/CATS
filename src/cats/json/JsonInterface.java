package cats.json;

import cats.core.Core;
import cats.dataModels.Profile;
import cats.dataModels.SimulationParameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author gvpm
 */
public class JsonInterface {

    public void run(String jsonAll) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Core core;
        SimulationParameters parameters;
        Profile profile;
        JsonModel jsonModel;

        try {

            // Convert JSON string to Object
            //parameters = mapper.readValue(jsonAll, SimulationParameters.class);
            //profile = mapper.readValue(jsonAll, Profile.class);
            jsonModel = mapper.readValue(jsonAll, JsonModel.class);

            core = new Core();
            //core.setParameters(parameters);
            core.setParameters(jsonModel.getSimulationParameters());
            //core.addProfile(profile);
            for (int i = 0; i < jsonModel.getProfiles().size(); i++) {
                core.addProfile(jsonModel.getProfiles().get(i));
                
            }
            //core.addProfile(jsonModel.getProfile());

            core.init();
            core.simulateAllDensities();

        } catch (JsonGenerationException e) {
            System.out.println(e);

        } catch (JsonMappingException e) {
            System.out.println(e);

        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
