/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.tools;

/**
 *
 * @author gvpm
 */
public class Timer {

    long startTime;
    long elapsedTime;
    long secondsTotal;
    long minutes;
    long secondsRest;

    public Timer() {

        startTime = 0;
        elapsedTime = 0;
        secondsTotal = 0;
        minutes = 0;
        secondsRest = 0;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        elapsedTime = System.currentTimeMillis() - startTime;
        secondsTotal = elapsedTime / 1000;
        minutes = secondsTotal / 60;
        secondsRest = secondsTotal % 60;

    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return secondsRest;
    }

}
