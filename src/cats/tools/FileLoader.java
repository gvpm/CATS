package cats.tools;

import cats.core.Core;
import cats.core.SimulationParameters;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * It loads the initial config from a .txt file
 *
 * @author gvpm
 */
public class FileLoader {

    Core core;
    String fileToLoad;
    SimulationParameters parameters;

    //SIMULATION PARAMETERS           
    int speedLimit;
    float probP;
    int simulationTime;
    int discardTime;
    int statisticTime;
    float initialDensity;
    float deltaDensity;
    float finalDensity;
    int cellsInX;
    int cellsInY;
    float cellSize;
    float defaultCarSize;
    String model;
    String logName;
    int pictureLog;

//Profile Parameters
    String fdpProvider = "";
    String name = "";
    int size = 0;
    int velMax = 0;
    int ahead = 0;
    int safeDistance = 0;
    int velIncrement = 0;
    double percentageOccurrence = 0;
    float alphaAcc = 0;
    float betaAcc = 0;
    float alphaAnt = 0;
    float betaAnt = 0;

    public FileLoader(String fileToLoad) {
        this.fileToLoad = fileToLoad;
        core = new Core();
        parameters = new SimulationParameters();
    }

    public void load() throws IOException {

        FileReader f;
        try {
            f = new FileReader(fileToLoad);

            BufferedReader b;
            b = new BufferedReader(f);
            boolean eof = false;

            while (!eof) {
                String line = b.readLine();
                if (line == null) {//Case where line is empty, end of file
                    eof = true;
                } else if (line.startsWith("SPEEDLIMIT")) {
                    String[] sv = line.split(":");
                    speedLimit = Integer.parseInt(sv[1]);
                    parameters.setSpeedLimit(speedLimit);

                } else if (line.startsWith("PROBP")) {
                    String[] sv = line.split(":");
                    probP = Float.parseFloat(sv[1]);
                    parameters.setProbP(probP);

                } else if (line.startsWith("SIMULATIONTIME")) {
                    String[] sv = line.split(":");
                    simulationTime = Integer.parseInt(sv[1]);
                    parameters.setSimulationTime(simulationTime);

                } else if (line.startsWith("DISCARDTIME")) {
                    String[] sv = line.split(":");
                    discardTime = Integer.parseInt(sv[1]);
                    parameters.setDiscardTime(discardTime);

                } else if (line.startsWith("STATISTICTIME")) {
                    String[] sv = line.split(":");
                    statisticTime = Integer.parseInt(sv[1]);
                    parameters.setStatisticTime(statisticTime);

                } else if (line.startsWith("INITIALDENSITY")) {
                    String[] sv = line.split(":");
                    initialDensity = Float.parseFloat(sv[1]);
                    parameters.setInitialDensity(initialDensity);

                } else if (line.startsWith("DELTADENSITY")) {
                    String[] sv = line.split(":");
                    deltaDensity = Float.parseFloat(sv[1]);
                    parameters.setDeltaDensity(deltaDensity);

                } else if (line.startsWith("FINALDENSITY")) {
                    String[] sv = line.split(":");
                    finalDensity = Float.parseFloat(sv[1]);
                    parameters.setFinalDensity(finalDensity);

                } else if (line.startsWith("CELLSINX")) {
                    String[] sv = line.split(":");
                    cellsInX = Integer.parseInt(sv[1]);
                    parameters.setCellsInX(cellsInX);

                } else if (line.startsWith("CELLSINY")) {
                    String[] sv = line.split(":");
                    cellsInY = Integer.parseInt(sv[1]);
                    parameters.setCellsInY(cellsInY);

                } else if (line.startsWith("CELLSIZE")) {
                    String[] sv = line.split(":");
                    cellSize = Float.parseFloat(sv[1]);
                    parameters.setCellSize(cellSize);

                } else if (line.startsWith("DEFAULTCARSIZE")) {
                    String[] sv = line.split(":");
                    defaultCarSize = Float.parseFloat(sv[1]);
                    parameters.setDefaultCarSize(defaultCarSize);

                } else if (line.startsWith("MODEL")) {
                    String[] sv = line.split(":");
                    model = sv[1];
                    parameters.setModel(model);

                } else if (line.startsWith("LOGNAME")) {
                    String[] sv = line.split(":");
                    logName = sv[1];
                    parameters.setLogName(logName);

                } else if (line.startsWith("PICTURELOG")) {
                    String[] sv = line.split(":");
                    pictureLog = Integer.parseInt(sv[1]);
                    parameters.setPictureLog(pictureLog);

                } else if (line.startsWith("ENDOFPARAMETERS")) {
                    core.setParameters(parameters);

                } else if (line.startsWith("FDPPROVIDER")) {
                    String[] sv = line.split(":");
                    fdpProvider = sv[1];

                } else if (line.startsWith("NAME")) {
                    String[] sv = line.split(":");
                    name = sv[1];

                } else if (line.startsWith("SIZE")) {
                    String[] sv = line.split(":");
                    size = Integer.parseInt(sv[1]);

                } else if (line.startsWith("VELMAX")) {
                    String[] sv = line.split(":");
                    velMax = Integer.parseInt(sv[1]);

                } else if (line.startsWith("AHEAD")) {
                    String[] sv = line.split(":");
                    ahead = Integer.parseInt(sv[1]);

                } else if (line.startsWith("SAFEDISTANCE")) {
                    String[] sv = line.split(":");
                    safeDistance = Integer.parseInt(sv[1]);

                } else if (line.startsWith("VELINCREMENT")) {
                    String[] sv = line.split(":");
                    velIncrement = Integer.parseInt(sv[1]);

                } else if (line.startsWith("PERCENTAGEOCCURRENCE")) {
                    String[] sv = line.split(":");
                    percentageOccurrence = Double.parseDouble(sv[1]);

                } else if (line.startsWith("ALPHAACC")) {
                    String[] sv = line.split(":");
                    alphaAcc = Float.parseFloat(sv[1]);

                } else if (line.startsWith("BETAACC")) {
                    String[] sv = line.split(":");
                    betaAcc = Float.parseFloat(sv[1]);

                } else if (line.startsWith("ALPHAANT")) {
                    String[] sv = line.split(":");
                    alphaAnt = Float.parseFloat(sv[1]);

                } else if (line.startsWith("BETAANT")) {
                    String[] sv = line.split(":");
                    betaAnt = Float.parseFloat(sv[1]);

                } else if (line.startsWith("ENDOFPROFILE")) {
                    core.createProfile(fdpProvider, name, size, velMax, ahead, safeDistance, velIncrement, percentageOccurrence, alphaAcc, betaAcc, alphaAnt, betaAnt);
                    resetProfileParameters();
                }

            }
            b.close();

        } catch (FileNotFoundException ex) {

        }

    }

    public Core getCore() {

        return core;
    }

    public void resetProfileParameters() {
        fdpProvider = "";
        name = "";
        size = 0;
        velMax = 0;
        ahead = 0;
        safeDistance = 0;
        velIncrement = 0;
        percentageOccurrence = 0;
        alphaAcc = 0;
        betaAcc = 0;
        alphaAnt = 0;
        betaAnt = 0;

    }

}
