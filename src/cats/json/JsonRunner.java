/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.json;

import cats.tools.IterationCallable;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gvpm
 */
public class JsonRunner {

    public static void main(String[] args) {
        JsonInterface runner1;
        JsonInterface runner2;

        if (args.length != 0) {
            System.out.println(args[0]);
            runner1 = new JsonInterface(args[0]);
            runner1.call();

        } else {
            String jsonAll1 = "{\"simulationParameters\":{\"speedLimit\":25,\"probP\":30,\"simulationTime\":15000,\"discardTime\":10000,\"statisticTime\":121,\"initialDensity\":0.01,\"deltaDensity\":0.01,\"finalDensity\":0.9,\"cellsInX\":10000,\"cellsInY\":1,\"cellSize\":1.5,\"defaultCarSize\":7.5,\"model\":\"nasch\",\"logName\":\"naschp30\",\"pictureLog\":\"0\",\"acidLog\":1,\"velLog\":\"0\"},\"profiles\":[{\"fdpProviderString\":\"uniform\",\"name\":\"NaschBasic\",\"size\":5,\"velMax\":25,\"ahead\":0,\"safeDistance\":0,\"velIncrement\":5,\"percentageOccurrence\":0.5,\"alphaAcc\":8,\"betaAcc\":4,\"alphaAnt\":8,\"betaAnt\":4},{\"fdpProviderString\":\"uniform\",\"name\":\"NaschBasic2\",\"size\":5,\"velMax\":25,\"ahead\":0,\"safeDistance\":0,\"velIncrement\":5,\"percentageOccurrence\":0.5,\"alphaAcc\":8,\"betaAcc\":4,\"alphaAnt\":8,\"betaAnt\":4}]}";
            //String jsonAll2 = "{\"simulationParameters\":{\"speedLimit\":25,\"probP\":30,\"simulationTime\":15000,\"discardTime\":10000,\"statisticTime\":121,\"initialDensity\":0.01,\"deltaDensity\":0.01,\"finalDensity\":0.9,\"cellsInX\":10000,\"cellsInY\":1,\"cellSize\":1.5,\"defaultCarSize\":7.5,\"model\":\"nasch\",\"logName\":\"2-naschp30\",\"pictureLog\":\"0\",\"acidLog\":1,\"velLog\":\"0\"},\"profiles\":[{\"fdpProviderString\":\"uniform\",\"name\":\"NaschBasic\",\"size\":5,\"velMax\":25,\"ahead\":0,\"safeDistance\":0,\"velIncrement\":5,\"percentageOccurrence\":0.5,\"alphaAcc\":8,\"betaAcc\":4,\"alphaAnt\":8,\"betaAnt\":4},{\"fdpProviderString\":\"uniform\",\"name\":\"NaschBasic2\",\"size\":5,\"velMax\":25,\"ahead\":0,\"safeDistance\":0,\"velIncrement\":5,\"percentageOccurrence\":0.5,\"alphaAcc\":8,\"betaAcc\":4,\"alphaAnt\":8,\"betaAnt\":4}]}";

            runner1 = new JsonInterface(jsonAll1);
            int resp;
            resp = runner1.call();
//            runner2 = new JsonInterface(jsonAll2);
//
//            ArrayList<Future<Integer>> tasks = new ArrayList<>();
//
//            ExecutorService es = Executors.newFixedThreadPool(2);
//
//            Future<Integer> task1 = es.submit(runner1);
//            tasks.add(task1);
//            Future<Integer> task2 = es.submit(runner2);
//            tasks.add(task1);
//
//            for (int i = 0; i < tasks.size(); i++) {
//                try {
//                    Integer result = tasks.get(i).get();
//                    System.out.println("End");
//                } catch (InterruptedException | ExecutionException e) {
//                    System.out.println(e);
//                }
//
//            }
//            es.shutdown();
        }
    }
}
