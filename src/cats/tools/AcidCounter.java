/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cats.tools;

import cats.core.Core;
import cats.core.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author gvpm
 */
public class AcidCounter {

    Core core;
    int acid1Counter;
    int acid2Counter;
    ArrayList<Vehicle> vehicles;

    public AcidCounter(Core core) {
        this.core = core;
    }

    public void reset() {
        this.acid1Counter = 0;
        this.acid2Counter = 0;
    }

    //Accident measure logic here
    public void measure() {
        vehicles = core.getVehicles();
        Vehicle vehicle;
        Vehicle vehicleAtFront;
        for (int i = 0; i < vehicles.size(); i++) {
            vehicle = vehicles.get(i);
            int vehicleAtFrontId = vehicle.getOldFrontId();
            vehicleAtFront = core.getVehicleFromId(vehicleAtFrontId);
            //2 vehicles now at hand, do the logic here
            acid1Counter++;
            acid2Counter++;

        }

    }

    public int[] getMeasures() {
        int[] measures = new int[2];
        measures[0] = acid1Counter;
        measures[1] = acid2Counter;
        reset();
        return measures;
    }

}
