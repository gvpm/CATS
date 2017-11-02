/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.log.handlers;

import cats.core.Core;
import cats.dataModels.SimulationParameters;
import cats.file.loggers.VelLogger;
import cats.tools.MainDataExtractor;

/**
 *
 * @author gvpm
 */
public class VelLogHandler {

    public static VelLogger Create(SimulationParameters parameters, float roundD) {
        String roundDString = "" + roundD;
        String fileName = parameters.getLogName() + "-velLog-d" + roundD;

        //Creates a picture log for that density
        if (parameters.getPictureLog().contains(roundDString)) {
            return new VelLogger(fileName, roundD);
        }
        return null;
    }

    public static void CalculateAndLog(SimulationParameters parameters, VelLogger velLogger, float roundD, int currentTime, int discardTime, Core core, MainDataExtractor mainDataExtractor) {
        String roundDString = "" + roundD;
        if ((currentTime > discardTime)) {
            if (parameters.getVelLog().contains(roundDString)) {
                float velToLog = parameters.getCellSize() * (float) 3.6 * core.getVehicleFromId(1).getVelocity();
                float roundVelToLog = (float) (Math.round(velToLog * 10.0) / 10.0);
                float velToLog2 = parameters.getCellSize() * (float) 3.6 * core.getVehicleFromId(2).getVelocity();
                float roundVelToLog2 = (float) (Math.round(velToLog2 * 10.0) / 10.0);
                float velToLog3 = parameters.getCellSize() * (float) 3.6 * core.getVehicleFromId(3).getVelocity();
                float roundVelToLog3 = (float) (Math.round(velToLog3 * 10.0) / 10.0);
                velLogger.logALine(currentTime, roundVelToLog, roundVelToLog2, roundVelToLog3, mainDataExtractor.getAvgVel());
            }
        }
    }

    public static void Close(SimulationParameters parameters, VelLogger velLogger, float roundD) {
        String roundDString = "" + roundD;
        if (parameters.getVelLog().contains(roundDString)) {
            velLogger.closeLogger();

        }
    }

}
