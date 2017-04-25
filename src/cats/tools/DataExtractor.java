package cats.tools;

import cats.core.Core;

/**
 * Responsible to provide the calculated data from the core, to be logged.
 * Calculates things such as flow, average velocity.
 *
 */
public class DataExtractor {

    Core core;

    public DataExtractor(Core core) {
        this.core = core;
    }

    public float getFlow(float density) {

        return density * getAvgVel();
    }

    public float getAvgVel() {
        int numOfVehicles = core.getVehicles().size();
        float sum = 0;
        for (int i = 0; i < numOfVehicles; i++) {
            float velInKMH;
            velInKMH = (core.getVehicles().get(i).getVelocity()) * core.getParameters().getCellSize() * (float) 3.6;
            sum += velInKMH;

        }

        return sum / numOfVehicles;
    }

}
