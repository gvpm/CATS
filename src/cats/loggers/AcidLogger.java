package cats.loggers;

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

    public void logALine(float density, int acid1, int acid2, int acid3, int nOfCars, int timeConsidered, int dangerousSituations, double acidProbability, float probP, double normalizedAcidProbability, double acid1Probability, double acid2Probability, double acid3Probability) {
        gravarArq.println((int) density + " " + acid1 + " " + acid2 + " " + acid3 + " " + nOfCars + " " + timeConsidered + " " + timeConsidered + " " + dangerousSituations + " " + acidProbability + " " + probP + " " + normalizedAcidProbability + " " + acid1Probability + " " + acid2Probability + " " + acid3Probability);
        gravarArq.flush();

    }

    public void closeLogger() {
        gravarArq.close();

    }

}
