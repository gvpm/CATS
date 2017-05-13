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
    int acid3Counter;
    ArrayList<Vehicle> vehicles;

    public AcidCounter(Core core) {
        this.core = core;
    }

    public void reset() {
        this.acid1Counter = 0;
        this.acid2Counter = 0;
        this.acid3Counter = 0;

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

            boolean acid1 = acid1(vehicle, vehicleAtFront);
            boolean acid2 = acid2(vehicle, vehicleAtFront);
            //2 vehicles now at hand, do the logic here
            if (acid1) {
                acid1Counter++;
            }
            if (acid2) {
                acid2Counter++;
            }
            if (acid1 && acid2) {
                acid3Counter++;
            }
        }

    }

    public boolean acid1(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;
        boolean condition1 = (tal * vehicleOldVel) > oldDistance;
        boolean condition2 = vehicleAtFrontOldVel > 0;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid2(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;
        int vd = 10;
        boolean condition1 = (tal * vehicleOldVel) > (oldDistance + vehicleAtFrontVel);
        boolean condition2 = (vehicleAtFrontOldVel - vehicleAtFrontVel) >= vd;

        return condition1 && condition2;
    }

    public int[] getMeasures() {
        int[] measures = new int[3];
        measures[0] = acid1Counter;
        measures[1] = acid2Counter;
        measures[2] = acid3Counter;
        reset();
        return measures;
    }

}
