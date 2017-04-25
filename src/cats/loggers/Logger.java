package cats.loggers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Responsible to create the data log file and log into it.
 *
 * @author gvpm
 */
public class Logger {

    String fileName;
    FileWriter arq = null;
    PrintWriter gravarArq;

    public Logger(String fileName) {
        this.fileName = fileName;

        try {
            arq = new FileWriter(fileName + ".txt");

        } catch (IOException ex) {

        }
        gravarArq = new PrintWriter(arq);

    }

    public void logALine(float flow, float density, float avgVel) {
        gravarArq.println(flow + " " + density + " " + avgVel);
        gravarArq.flush();

    }

    public void closeLogger() {
        gravarArq.close();

    }

}
