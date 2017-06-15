/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.json;

import cats.json.JsonInterface;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gvpm
 */
public class JsonRunner {

    public static void main(String[] args) {
        JsonInterface runner = new JsonInterface();

        try {
            
            if(args.length!=0){
                System.out.println(args[0]);  
                System.out.println(args[1]);
            //runner.run(args[0], args[1]);
                
            }else{
            //String Jparameters = "{\"speedLimit\":25,\"probP\":30,\"simulationTime\":15000,\"discardTime\":10000,\"statisticTime\":121,\"initialDensity\":0.01,\"deltaDensity\":0.01,\"finalDensity\":0.9,\"cellsInX\":10000,\"cellsInY\":1,\"cellSize\":1.5,\"defaultCarSize\":7.5,\"model\":\"nasch\",\"logName\":\"naschp30\",\"pictureLog\":\"0\",\"acidLog\":1,\"velLog\":\"0\"}";
            //String Jprofile = "{\"fdpProviderString\":\"uniform\",\"name\":\"NaschBasic\",\"size\":5,\"velMax\":25,\"ahead\":0,\"safeDistance\":0,\"velIncrement\":5,\"percentageOccurrence\":1,\"alphaAcc\":8,\"betaAcc\":4,\"alphaAnt\":8,\"betaAnt\":4}";
            //runner.run(Jparameters, Jprofile);
            //String jsonAll = "{\"simulationParameters\":{\"speedLimit\":25,\"probP\":30,\"simulationTime\":15000,\"discardTime\":10000,\"statisticTime\":121,\"initialDensity\":0.01,\"deltaDensity\":0.01,\"finalDensity\":0.9,\"cellsInX\":10000,\"cellsInY\":1,\"cellSize\":1.5,\"defaultCarSize\":7.5,\"model\":\"nasch\",\"logName\":\"naschp30\",\"pictureLog\":\"0\",\"acidLog\":1,\"velLog\":\"0\"},\"profile\":{\"fdpProviderString\":\"uniform\",\"name\":\"NaschBasic\",\"size\":5,\"velMax\":25,\"ahead\":0,\"safeDistance\":0,\"velIncrement\":5,\"percentageOccurrence\":1,\"alphaAcc\":8,\"betaAcc\":4,\"alphaAnt\":8,\"betaAnt\":4}}";
            String jsonAll = "{\"simulationParameters\":{\"speedLimit\":25,\"probP\":30,\"simulationTime\":15000,\"discardTime\":10000,\"statisticTime\":121,\"initialDensity\":0.01,\"deltaDensity\":0.01,\"finalDensity\":0.9,\"cellsInX\":10000,\"cellsInY\":1,\"cellSize\":1.5,\"defaultCarSize\":7.5,\"model\":\"nasch\",\"logName\":\"naschp30\",\"pictureLog\":\"0\",\"acidLog\":1,\"velLog\":\"0\"},\"profiles\":[{\"fdpProviderString\":\"uniform\",\"name\":\"NaschBasic\",\"size\":5,\"velMax\":25,\"ahead\":0,\"safeDistance\":0,\"velIncrement\":5,\"percentageOccurrence\":0.5,\"alphaAcc\":8,\"betaAcc\":4,\"alphaAnt\":8,\"betaAnt\":4},{\"fdpProviderString\":\"uniform\",\"name\":\"NaschBasic2\",\"size\":5,\"velMax\":25,\"ahead\":0,\"safeDistance\":0,\"velIncrement\":5,\"percentageOccurrence\":0.5,\"alphaAcc\":8,\"betaAcc\":4,\"alphaAnt\":8,\"betaAnt\":4}]}";
            runner.run(jsonAll);
            }
        } catch (ExecutionException | InterruptedException ex) {
            Logger.getLogger(JsonRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
