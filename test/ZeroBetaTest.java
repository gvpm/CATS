
import cats.core.Vehicle;
import cats.fdps.FDPProviderBeta;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gvpm
 */
public class ZeroBetaTest {

    public static void main(String[] args) {

        String fileName;
        FileWriter arq = null;
        PrintWriter gravarArq;
        List<Float> list = new ArrayList<>();
//        fileName = "MeadiaTeste1-40";
//        
//        try {
//            arq = new FileWriter(fileName + ".txt");
//
//        } catch (IOException ex) {
//
//        }
//        gravarArq = new PrintWriter(arq);

        FDPProviderBeta b = new FDPProviderBeta();
        double j = 1;
        double increment = 1;
        int alpha = 1;
        int beta = 1;
        double fdeX;
        double roundFDEX;

        do {

            beta++;
            fdeX = b.getBeta(alpha, beta, 0.16);
            roundFDEX = (double) (Math.round(fdeX * 1000.0) / 1000.0);
            System.out.println("Beta " + beta + " f(0.16)= " + roundFDEX);

        } while (roundFDEX > 0);

        System.out.println(beta);

        //for (int i = 0; i < 100; i++) {
        //    float j = (float) i / 100;
//        while (j < 15000) {
//            double beta = b.provide(1, 40);
//            float roundB = (float) (Math.round(beta * 100.0) / 100.0);
//            //System.out.println(roundB);
//            list.add(roundB);
//            gravarArq.println(roundB);
//            gravarArq.flush();
//            j += increment;
//
//        }
//
//        //}
//        gravarArq.close();
//        double sum = 0;
//        for (int i = 0; i < list.size(); i++) {
//            sum += list.get(i);
//            
//        }
//        double average = sum/list.size();
//        System.out.println(average);
//        System.out.println(b.getBeta(1, 40, average));
    }

}
