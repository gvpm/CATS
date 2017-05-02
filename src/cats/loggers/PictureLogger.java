package cats.loggers;

import cats.tools.TXTtoImage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Responsible to create the data log file and log into it.
 *
 * @author gvpm
 */
public class PictureLogger {

    String fileName;
    float density;
    FileWriter arq = null;
    PrintWriter gravarArq;

    public PictureLogger(String fileName, float density) {
        this.fileName = fileName;

        try {
            arq = new FileWriter(fileName + ".txt");

        } catch (IOException ex) {

        }
        gravarArq = new PrintWriter(arq);

    }

    public void logALine(int[] grid) {
        for (int i = 0; i < grid.length; i++) {
            int j = grid[i];
            if (j == -1) {
                gravarArq.print(0);
            } else {
                gravarArq.print(1);
            }

        }
        gravarArq.println();
        //gravarArq.println(flow + " " + density + " " + avgVel);
        gravarArq.flush();

    }

    public void closeLogger() {
        gravarArq.close();

    }
    
    public void convertToImage(){
        TXTtoImage converter = new TXTtoImage(fileName);
        converter.convert();
        
    }

    public float getDensity() {
        return density;
    }

}
