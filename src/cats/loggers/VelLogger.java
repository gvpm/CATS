package cats.loggers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Responsible to create the data log file and log into it.
 *
 * @author gvpm
 */
public class VelLogger {

    String fileName;
    float density;
    FileWriter arq = null;
    PrintWriter gravarArq;

    public VelLogger(String fileName, float density) {
        this.fileName = fileName;
        this.density = density;

        try {
            arq = new FileWriter(fileName + ".txt");

        } catch (IOException ex) {

        }
        gravarArq = new PrintWriter(arq);

    }

    public void logALine(int time, int vel) {

        gravarArq.println(density + " " + time + " " + vel);
        gravarArq.flush();

    }

    public void closeLogger() {
        gravarArq.close();

    }

}
