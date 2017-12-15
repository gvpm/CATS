package cats.tools;

import cats.core.Core;
import cats.dataModels.Vehicle;
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
    int acid1_vf2Counter;
    int acid1_vf3Counter;
    int acid1_vf4Counter;
    int acid1_vf5Counter;
    int acid1_vf6Counter;
    int acid4Counter;
    int acid5Counter;

    //to filtered
    int acid1_vbf5Counter;
    int acid1_deceleration1CellCounter;
    int acid1_deceleration2CellCounter;
    int acid1_deceleration3CellCounter;
    int acid1_deceleration4CellCounter;
    int acid1_deceleration5CellCounter;
    int acid1_deceleration6CellCounter;

    ArrayList<Vehicle> vehicles;

    public AcidCounter(Core core) {
        this.core = core;
    }

    public void reset() {
        this.acid1Counter = 0;
        this.acid2Counter = 0;
        this.acid3Counter = 0;
        this.acid1_vf2Counter = 0;
        this.acid1_vf3Counter = 0;
        this.acid1_vf4Counter = 0;
        this.acid1_vf5Counter = 0;
        this.acid1_vf6Counter = 0;
        this.acid4Counter = 0;
        this.acid5Counter = 0;

        this.acid1_vbf5Counter = 0;
        this.acid1_deceleration1CellCounter = 0;
        this.acid1_deceleration2CellCounter = 0;
        this.acid1_deceleration3CellCounter = 0;
        this.acid1_deceleration4CellCounter = 0;
        this.acid1_deceleration5CellCounter = 0;
        this.acid1_deceleration6CellCounter = 0;

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
            boolean acid1_vf2 = acid1_vf2(vehicle, vehicleAtFront);
            boolean acid1_vf3 = acid1_vf3(vehicle, vehicleAtFront);
            boolean acid1_vf4 = acid1_vf4(vehicle, vehicleAtFront);
            boolean acid1_vf5 = acid1_vf5(vehicle, vehicleAtFront);

            boolean acid1_vbf5 = acid1_vbf5(vehicle, vehicleAtFront);

            boolean acid1_deceleration1Cell = acid1_deceleration1Cell(vehicle, vehicleAtFront);
            boolean acid1_deceleration2Cell = acid1_deceleration2Cell(vehicle, vehicleAtFront);
            boolean acid1_deceleration3Cell = acid1_deceleration3Cell(vehicle, vehicleAtFront);
            boolean acid1_deceleration4Cell = acid1_deceleration4Cell(vehicle, vehicleAtFront);
            boolean acid1_deceleration5Cell = acid1_deceleration5Cell(vehicle, vehicleAtFront);
            boolean acid1_deceleration6Cell = acid1_deceleration6Cell(vehicle, vehicleAtFront);

            boolean acid2 = acid2(vehicle, vehicleAtFront);

            boolean acid1_vf6 = acid1_vf6(vehicle, vehicleAtFront);
            boolean acid4 = acid4(vehicle, vehicleAtFront);
            boolean acid5 = acid5(vehicle, vehicleAtFront);

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
            if (acid1_vf2) {
                acid1_vf2Counter++;
            }
            if (acid1_vf3) {
                acid1_vf3Counter++;
            }
            if (acid1_vf4) {
                acid1_vf4Counter++;
            }
            if (acid1_vf5) {
                acid1_vf5Counter++;
            }
            if (acid1_vf6) {
                acid1_vf6Counter++;
            }
            if (acid4) {
                acid4Counter++;
            }
            if (acid5) {
                acid5Counter++;
            }
            if (acid1_vbf5) {
                acid1_vbf5Counter++;
            }
            if (acid1_deceleration1Cell) {
                acid1_deceleration1CellCounter++;
            }
            if (acid1_deceleration2Cell) {
                acid1_deceleration2CellCounter++;
            }
            if (acid1_deceleration3Cell) {
                acid1_deceleration3CellCounter++;
            }
            if (acid1_deceleration4Cell) {
                acid1_deceleration4CellCounter++;
            }
            if (acid1_deceleration5Cell) {
                acid1_deceleration5CellCounter++;
            }
            if (acid1_deceleration6Cell) {
                acid1_deceleration6CellCounter++;
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

    public boolean acid1_vf2(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;
        boolean condition1 = (tal * vehicleOldVel) > oldDistance;
        boolean condition2 = vehicleAtFrontOldVel >= 2;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_vf3(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;
        boolean condition1 = (tal * vehicleOldVel) > oldDistance;
        boolean condition2 = vehicleAtFrontOldVel >= 3;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_vf4(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;
        boolean condition1 = (tal * vehicleOldVel) > oldDistance;
        boolean condition2 = vehicleAtFrontOldVel >= 4;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_vf5(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;
        boolean condition1 = (tal * vehicleOldVel) > oldDistance;
        boolean condition2 = vehicleAtFrontOldVel >= 5;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_vbf5(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;
        boolean condition1 = (tal * vehicleOldVel) > oldDistance;
        boolean condition2 = vehicleAtFrontOldVel >= 5;
        boolean condition3 = vehicleAtFrontVel == 0;
        boolean condition4 = vehicleOldVel >= 5;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_deceleration1Cell(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;

        //Deceleration
        boolean condition1 = (tal * vehicleOldVel) - oldDistance >= 1;

        boolean condition2 = vehicleAtFrontOldVel > 0;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_deceleration2Cell(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;

        //Deceleration
        boolean condition1 = (tal * vehicleOldVel) - oldDistance >= 2;

        boolean condition2 = vehicleAtFrontOldVel > 0;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_deceleration3Cell(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;

        //Deceleration
        boolean condition1 = (tal * vehicleOldVel) - oldDistance >= 3;

        boolean condition2 = vehicleAtFrontOldVel > 0;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_deceleration4Cell(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;

        //Deceleration
        boolean condition1 = (tal * vehicleOldVel) - oldDistance >= 4;

        boolean condition2 = vehicleAtFrontOldVel > 0;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_deceleration5Cell(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;

        //Deceleration
        boolean condition1 = (tal * vehicleOldVel) - oldDistance >= 5;

        boolean condition2 = vehicleAtFrontOldVel > 0;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid1_deceleration6Cell(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;

        //Deceleration
        boolean condition1 = (tal * vehicleOldVel) - oldDistance >= 6;

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

    public boolean acid1_vf6(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleAtFrontOldVel = vehicleAtFront.getOldVelocity();
        int vehicleAtFrontVel = vehicleAtFront.getVelocity();
        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 1;
        boolean condition1 = (tal * vehicleOldVel) > oldDistance;
        boolean condition2 = vehicleAtFrontOldVel >= 6;
        boolean condition3 = vehicleAtFrontVel == 0;

        return condition1 && condition2 && condition3;
    }

    public boolean acid4(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();

        int oldDistance = vehicle.getOldDistanceToFront();
        int tal = 2; //2 seconds
        boolean condition1 = (tal * vehicleOldVel) > oldDistance;

        return condition1;
    }

    public boolean acid5(Vehicle vehicle, Vehicle vehicleAtFront) {
        int vehicleOldVel = vehicle.getOldVelocity();
        int vehicleVel = vehicle.getVelocity();

        int oldDistance = vehicle.getOldDistanceToFront();

        boolean condition1 = (vehicleOldVel + vehicleVel) > oldDistance;

        return condition1;
    }

    public int[] getMeasures() {
        int[] measures = new int[10];
        measures[0] = acid1Counter;
        measures[1] = acid2Counter;
        measures[2] = acid3Counter;

        measures[3] = acid1_vf2Counter;
        measures[4] = acid1_vf3Counter;
        measures[5] = acid1_vf4Counter;
        measures[6] = acid1_vf5Counter;
        measures[7] = acid1_vf6Counter;
        measures[8] = acid4Counter;
        measures[9] = acid5Counter;

        reset();
        return measures;
    }

    public int[] getMeasuresFiltered() {
        
        
        int[] measures = new int[13];
        measures[0] = acid1Counter;
        measures[1] = acid1_vf2Counter;
        measures[2] = acid1_vf3Counter;
        measures[3] = acid1_vf4Counter;
        measures[4] = acid1_vf5Counter;
        measures[5] = acid1_vbf5Counter;
        measures[6] = acid1_deceleration1CellCounter;
        measures[7] = acid1_deceleration2CellCounter;
        measures[8] = acid1_deceleration3CellCounter;
        measures[9] = acid1_deceleration4CellCounter;
        measures[10] = acid1_deceleration5CellCounter;
        measures[11] = acid1_deceleration6CellCounter;
        measures[12] = acid2Counter;

        reset();
        return measures;
    }

}
