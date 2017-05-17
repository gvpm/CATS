
import cats.fdps.FDPProviderBeta;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gvpm
 */
public class BetaTester {

    public static void main(String[] args) {

        String fileName;
        FileWriter arq = null;
        PrintWriter gravarArq;

        fileName = "BetaTest1-40";

        try {
            arq = new FileWriter(fileName + ".txt");

        } catch (IOException ex) {

        }
        gravarArq = new PrintWriter(arq);

        FDPProviderBeta b = new FDPProviderBeta();
        double j = 0.000;
        double increment = 0.001;
        //for (int i = 0; i < 100; i++) {
        //    float j = (float) i / 100;
        while (j < 1.000) {
            double beta = b.getBeta(1, 40, j);
            float roundB = (float) (Math.round(beta * 100.0) / 100.0);

            gravarArq.println(j + " " + roundB);
            gravarArq.flush();
            j += increment;

        }

        //}
        gravarArq.close();

    }

}
