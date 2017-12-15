package cats.file.loggers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Responsible to create the data log file and log into it.
 *
 * @author gvpm
 */
public class AcidLogger {

    String fileName;
    FileWriter arq = null;
    PrintWriter gravarArq;

    public AcidLogger(String fileName) {
        this.fileName = fileName;

        try {

            arq = new FileWriter(fileName + ".txt");

        } catch (IOException ex) {

        }
        gravarArq = new PrintWriter(arq);

    }

    public void logALine(float density, int acid1, int acid2, int acid3, int nOfCars, int timeConsidered,
            int dangerousSituations, String acidProbability, float probP, String normalizedAcidProbability,
            String acid1Probability, String acid2Probability, String acid3Probability,
            String acid1_vf2Probability, String acid1_vf3Probability, String acid1_vf4Probability,
            String acid1_vf5Probability, String acid1_vf6Probability, String acid4Probability,
            String acid5Probability) {
        gravarArq.println((int) density + " " + acid1 + " " + acid2 + " " + acid3
                + " " + nOfCars + " " + timeConsidered + " " + timeConsidered + " " + dangerousSituations
                + " " + acidProbability + " " + probP + " " + normalizedAcidProbability + " "
                + acid1Probability + " " + acid2Probability + " " + acid3Probability + " "
                + acid1_vf2Probability + " " + acid1_vf3Probability + " " + acid1_vf4Probability + " "
                + acid1_vf5Probability + " " + acid1_vf6Probability + " " + acid4Probability + " " + acid5Probability);
        gravarArq.flush();

    }
        public void logALineFiltered(
            float density, 
            int nOfCars, 
            int timeConsidered,
            String acid1_vFront1Probability,
            String acid1_vFront2Probability, 
            String acid1_vFront3Probability, 
            String acid1_vFront4Probability,
            String acid1_vFront5Probability,  
            String acid1_vBackFront5Probability,
            String acid1_deceleration1CellProbability,
            String acid1_deceleration2CellProbability,
            String acid1_deceleration3CellProbability,
            String acid1_deceleration4CellProbability,
            String acid1_deceleration5CellProbability,
            String acid1_deceleration6CellProbability,
            String acid2Probability
            )
        {
        gravarArq.println(
                (int) density + " " +
                nOfCars + " " + 
                timeConsidered + " " + 
                acid1_vFront1Probability + " " + 
                acid1_vFront2Probability + " " + 
                acid1_vFront4Probability + " " + 
                acid1_vFront3Probability + " " + 
                acid1_vFront5Probability + " " + 
                acid1_vBackFront5Probability + " " + 
                acid1_deceleration1CellProbability + " " + 
                acid1_deceleration2CellProbability + " " + 
                acid1_deceleration3CellProbability + " " + 
                acid1_deceleration4CellProbability + " " + 
                acid1_deceleration5CellProbability + " " + 
                acid1_deceleration6CellProbability + " " +  
                acid2Probability
        );
        gravarArq.flush();

    }

    public void closeLogger() {
        gravarArq.close();

    }

}
