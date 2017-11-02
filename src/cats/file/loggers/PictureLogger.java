package cats.file.loggers;

import cats.tools.TxtToImage;
import java.io.File;
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
            switch (j) {
                case -1:
                    gravarArq.print(0);
                    break;
                case 2:
                    gravarArq.print(2);
                    break;
                default:
                    gravarArq.print(1);
                    break;
            }

        }
        gravarArq.println();
        //gravarArq.println(flow + " " + density + " " + avgVel);
        gravarArq.flush();

    }

    public void closeLogger() {
        gravarArq.close();
        System.out.println("\nArquivo " + fileName + ".txt Criado.");

    }

    public void deleteLog() {
        File file = new File(fileName + ".txt");
        if (file.delete()) {
            System.out.println("Arquivo " + fileName + ".txt Deletado.");
        }

    }

    public void convertToImage() {
        System.out.println("Criando " + fileName + ".png ...");
        TxtToImage converter = new TxtToImage(fileName);
        converter.convert();

    }

    public float getDensity() {
        return density;
    }

}
