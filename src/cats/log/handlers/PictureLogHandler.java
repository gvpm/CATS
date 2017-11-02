/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.log.handlers;

import cats.core.Grid;
import cats.dataModels.SimulationParameters;
import cats.file.loggers.PictureLogger;

/**
 *
 * @author gvpm
 */
public class PictureLogHandler {
    

    public static PictureLogger Create(SimulationParameters parameters, float roundD) {
        String roundDString = "" + roundD;
        String fileName = parameters.getLogName() + "-d" + roundD;

        //Creates a picture log for that density
        if (parameters.getPictureLog().contains(roundDString)) {
            return new PictureLogger(fileName, roundD);
        }
        return null;
    }

    public static void Log(SimulationParameters parameters, Grid grid, PictureLogger picLogger, float roundD) {
        String roundDString = "" + roundD;

        if (parameters.getPictureLog().contains(roundDString)) {
            picLogger.logALine(grid.getGrid());
        }

    }

    public static void Close(SimulationParameters parameters, PictureLogger picLogger, float roundD) {
        String roundDString = "" + roundD;
        if (parameters.getPictureLog().contains(roundDString)) {
            picLogger.closeLogger();
            
            //picLogger.convertToImage();
            //Deletes the big file
            //picLogger.deleteLog();

        }
    }

}
