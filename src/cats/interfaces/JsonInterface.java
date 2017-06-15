package cats.interfaces;

import cats.core.Core;
import cats.core.Profile;
import cats.core.SimulationParameters;
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

    public void run(String Jparameters, String Jprofile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Core core;
        SimulationParameters parameters;
        Profile profile;

        try {

            // Convert JSON string to Object
            parameters = mapper.readValue(Jparameters, SimulationParameters.class);
            profile = mapper.readValue(Jprofile, Profile.class);

            core = new Core();
            core.setParameters(parameters);
            //profile.mount();
            core.addProfile(profile);

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
