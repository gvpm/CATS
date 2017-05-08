package cats.models;

import cats.core.Grid;
import cats.core.Vehicle;

/**
 * Implements the Nasch Model
 *
 * @author gvpm
 */
public class ModelNasch extends Model {

    @Override
    public void apply(Vehicle vehicle) {

        Grid grid = vehicle.getGrid();
        int distanceToFront;
        int newVel;
        int acceleration = vehicle.getAcceleration();
        int vMax = vehicle.getVelMax();
        int currentVel = vehicle.getVelocity();

        //calculate space between vehicles
        distanceToFront = vehicle.getDistanceToFrontAndId()[0];
        vehicle.setDistanceToFront(distanceToFront);

        //Calculate new vel, addind acceleratio to vel
        newVel = min(currentVel + acceleration, vMax);

        //Caps the new vel bases on the distance to the vehicle on the front
        newVel = min(newVel, distanceToFront);

        //Gets the alpha to decide if its going to use acceletarion or not
        if (vehicle.getProfile().getFdpProvider().provide((int) vehicle.getCore().getParameters().getProbP())) {
            newVel = max(newVel - acceleration, 0);

        }

        //sets the vehicle new vel
        vehicle.setNewVelocity(newVel);

        //gets the new x position based on the current plus  adding new vel
        int newXPosition = grid.getNewXPostition(vehicle.getGridXPosition(), newVel);

        vehicle.setNewGridXPosition(newXPosition);

    }

    @Override
    public String toString() {
        return "Nasch";
    }

}
