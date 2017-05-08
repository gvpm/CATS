package cats.models;

import cats.core.Grid;
import cats.core.Vehicle;

/**
 * Implements the TUFF Model
 *
 * @author gvpm
 */
public class ModelTUFF extends Model {

    @Override
    public void apply(Vehicle vehicle) {
        Grid grid = vehicle.getGrid();

        int distanceToFront;
        int distanceFromFrontToFront;

        int newVel;
        int acceleration = vehicle.getAcceleration();
        int vMax = vehicle.getVelMax();
        int currentVel = vehicle.getVelocity();
        int ahead = vehicle.getProfile().getAhead();
        int safeDist = vehicle.getProfile().getSafeDistance();

        Vehicle vehicleAtFront;
        Vehicle vehicleAtFrontOfFront;

        int[] distanceAndId;

        //calculate space between the vehicle and the one to the front
        distanceAndId = vehicle.getDistanceToFrontAndId();
        distanceToFront = distanceAndId[0];
        vehicle.setDistanceToFront(distanceToFront);
        vehicleAtFront = vehicle.getCore().getVehicleFromId(distanceAndId[1]);

        //calculate space between the vehicle ate front and the one in front of it        
        distanceAndId = vehicleAtFront.getDistanceToFrontAndId();
        distanceFromFrontToFront = distanceAndId[0];
        vehicleAtFrontOfFront = vehicleAtFront.getCore().getVehicleFromId(distanceAndId[1]);

        float alphaAcc = vehicle.getBetaFunctionAcc();
        float roundAlphaAcc = (float) (Math.round(alphaAcc * 100.0) / 100.0);
        float alphaAnt = vehicle.getBetaFunctionAnt();
        float roundAlphaAnt = (float) (Math.round(alphaAnt * 100.0) / 100.0);
        //Calculate new vel, addind acceleratio to vel

        newVel = min(currentVel + (int) (acceleration * (1 - roundAlphaAcc)), vMax);
        //System.out.println((int)(acceleration*(1-roundA)));

        //Caps the new vel bases on the distance to the vehicle on the front
        newVel = min(newVel, distanceToFront);

        //sets the vehicle new vel
        vehicle.setNewVelocity(newVel);

        //gets the new x position based on the current plus  adding new vel
        int newXPosition = grid.getNewXPostition(vehicle.getGridXPosition(), newVel);

        vehicle.setNewGridXPosition(newXPosition);
    }

    @Override
    public String toString() {
        return "TUff";
    }

}
