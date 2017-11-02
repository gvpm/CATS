package cats.file.loggers;

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

    public void logALine(int time, float vel1, float vel2, float vel3, float avgVel) {

        gravarArq.println(density + " " + time + " " + (int) vel1 + " " + (int) vel2 + " " + (int) vel3 + " " + (int) avgVel);
        gravarArq.flush();

    }

    public void closeLogger() {
        gravarArq.close();

    }

}
