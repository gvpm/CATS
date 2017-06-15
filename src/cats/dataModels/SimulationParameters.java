package cats.dataModels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Responsible to store all the simulation parameters. It will be given to Core
 * class, and here all the simulation parameters will be stored.
 *
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class SimulationParameters {

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
    String pictureLog;
    String velLog;
    int acidLog;

    public SimulationParameters(int speedLimit, float probP, int simulationTime, int discardTime, int statisticTime, float initialDensity, float deltaDendity, float finalDensity, int cellsInX, int cellsInY, float cellSize, float defaultCarSize, String model, String logName, String pictureLog, int acidLog, String velLog) {
        this.speedLimit = speedLimit;
        this.probP = probP;
        this.simulationTime = simulationTime;
        this.discardTime = discardTime;
        this.statisticTime = statisticTime;
        this.initialDensity = initialDensity;
        this.deltaDensity = deltaDendity;
        this.finalDensity = finalDensity;
        this.cellsInX = cellsInX;
        this.cellsInY = cellsInY;
        this.cellSize = cellSize;
        this.defaultCarSize = defaultCarSize;
        this.model = model;
        this.logName = logName;
        this.pictureLog = pictureLog;
        this.acidLog = acidLog;
        this.velLog = velLog;
    }

    @JsonCreator
    public SimulationParameters() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public float getProbP() {
        return probP;
    }

    public void setProbP(float probP) {
        this.probP = probP;
    }

    public int getSimulationTime() {
        return simulationTime;
    }

    public void setSimulationTime(int simulationTime) {
        this.simulationTime = simulationTime;
    }

    public int getDiscardTime() {
        return discardTime;
    }

    public void setDiscardTime(int discardTime) {
        this.discardTime = discardTime;
    }

    public int getStatisticTime() {
        return statisticTime;
    }

    public void setStatisticTime(int statisticTime) {
        this.statisticTime = statisticTime;
    }

    public float getInitialDensity() {
        return initialDensity;
    }

    public void setInitialDensity(float initialDensity) {
        this.initialDensity = initialDensity;
    }

    public float getDeltaDensity() {
        return deltaDensity;
    }

    public void setDeltaDensity(float deltaDensity) {
        this.deltaDensity = deltaDensity;
    }

    public float getFinalDensity() {
        return finalDensity;
    }

    public void setFinalDensity(float finalDensity) {
        this.finalDensity = finalDensity;
    }

    public int getCellsInX() {
        return cellsInX;
    }

    public void setCellsInX(int cellsInX) {
        this.cellsInX = cellsInX;
    }

    public int getCellsInY() {
        return cellsInY;
    }

    public void setCellsInY(int cellsInY) {
        this.cellsInY = cellsInY;
    }

    public float getCellSize() {
        return cellSize;
    }

    public void setCellSize(float cellSize) {
        this.cellSize = cellSize;
    }

    public float getDefaultCarSize() {
        return defaultCarSize;
    }

    public void setDefaultCarSize(float defaultCarSize) {
        this.defaultCarSize = defaultCarSize;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getPictureLog() {
        return pictureLog;
    }

    public void setPictureLog(String pictureLog) {
        this.pictureLog = pictureLog;
    }

    public int getAcidLog() {
        return acidLog;
    }

    public void setAcidLog(int acidLog) {
        this.acidLog = acidLog;
    }

    public String getVelLog() {
        return velLog;
    }

    public void setVelLog(String velLog) {
        this.velLog = velLog;
    }

}
