/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.log.handlers;

import cats.dataModels.SimulationParameters;
import cats.dataModels.Vehicle;
import cats.file.loggers.AcidLogger;
import cats.tools.AcidCounter;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author gvpm
 */
public class AcidLogHandler {

    public static void Measure(SimulationParameters parameters, int currentTime, int discardTime, AcidCounter acidCounter) {
        if (parameters.getAcidLog() == 1) {
//after each iteration I update the acidCounter counters
            if ((currentTime > discardTime)) {
                acidCounter.measure();
            }
        }

    }

    public static void Reset(SimulationParameters parameters, AcidCounter acidCounter) {
        if (parameters.getAcidLog() == 1) {
            acidCounter.reset();

        }

    }

    public static void CalculateAndLog(SimulationParameters parameters, AcidCounter acid, AcidLogger acidLogger, ArrayList<Vehicle> vehicles, int simulationTime, int discardTime, float roundD) {
        if (parameters.getAcidLog() == 1) {

            DecimalFormat df = new DecimalFormat("#0.000000");
//When the density is created I will log a line in the acidlog
            int[] acidMeasures = acid.getMeasures();
            //Do more math and put more infor in this line
            int timeConsidered = simulationTime - discardTime;
            int dangerousSituations = (acidMeasures[0] + acidMeasures[1]) - acidMeasures[2];

            double acidProbability = ((double) dangerousSituations / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcidProbability = df.format(acidProbability);

            double acid1Probability = ((double) acidMeasures[0] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid1Probability = df.format(acid1Probability);

            double acid2Probability = ((double) acidMeasures[1] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid2Probability = df.format(acid2Probability);

            double acid3Probability = ((double) acidMeasures[2] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid3Probability = df.format(acid3Probability);

            double acid1_vf2Probability = ((double) acidMeasures[3] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid1_vf2Probability = df.format(acid1_vf2Probability);

            double acid1_vf3Probability = ((double) acidMeasures[4] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid1_vf3Probability = df.format(acid1_vf3Probability);

            double acid1_vf4Probability = ((double) acidMeasures[5] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid1_vf4Probability = df.format(acid1_vf4Probability);

            double acid1_vf5Probability = ((double) acidMeasures[6] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid1_vf5Probability = df.format(acid1_vf5Probability);

            double acid1_vf6Probability = ((double) acidMeasures[7] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid1_vf6Probability = df.format(acid1_vf6Probability);

            double acid4Probability = ((double) acidMeasures[8] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid4Probability = df.format(acid4Probability);

            double acid5Probability = ((double) acidMeasures[9] / (double) vehicles.size()) / (double) timeConsidered;
            String roundAcid5Probability = df.format(acid5Probability);

            double normalizedAcidProbability = acidProbability / ((double) parameters.getProbP() / (double) 100);
            String roundNormalizedAcidProbability = df.format(normalizedAcidProbability);

            acidLogger.logALine(roundD * 100, acidMeasures[0], acidMeasures[1], acidMeasures[2], vehicles.size(),
                    timeConsidered, dangerousSituations, roundAcidProbability, parameters.getProbP(),
                    roundNormalizedAcidProbability, roundAcid1Probability, roundAcid2Probability, roundAcid3Probability,
                    roundAcid1_vf2Probability, roundAcid1_vf3Probability, roundAcid1_vf4Probability, roundAcid1_vf5Probability,
                    roundAcid1_vf6Probability, roundAcid4Probability, roundAcid5Probability);
        }
    }

}
