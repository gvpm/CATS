package cats.tools;

import cats.core.Core;

/**
 * Responsible to provide the calculated data from the core, to be logged.
 * Calculates things such as flow, average velocity.
 *
 */
public class MainDataExtractor {

    Core core;
    float flowSum;
    float avgVelSum;
    float sumAccumulator;

    public MainDataExtractor(Core core) {
        this.core = core;
        flowSum = 0;
        avgVelSum = 0;
        sumAccumulator = 0;
    }

    public void restartSumCounters() {
        flowSum = 0;
        avgVelSum = 0;
        sumAccumulator = 0;

    }

    public float[] getResults() {
        float[] results = new float[2];

        results[0] = flowSum / sumAccumulator;
        results[1] = avgVelSum / sumAccumulator;

        restartSumCounters();
        return results;

    }

    public void measure(float density) {
        flowSum += getFlow(density);
        avgVelSum += getAvgVel();
        sumAccumulator++;

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
