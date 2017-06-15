package cats.models;

import cats.core.Grid;
import cats.dataModels.Vehicle;

/**
 * Implements the Nasch Model using the BETA Function.
 *
 * @author gvpm
 */
public class ModelNaschWithBeta extends Model {

    @Override
    public void apply(Vehicle vehicle) {

        Grid grid = vehicle.getGrid();
        int distanceToFront;
        int newVel;
        int acceleration = vehicle.getAcceleration();
        int vMax = vehicle.getVelMax();
        int currentVel = vehicle.getVelocity();

        //This will be applied to every car in each step of the simulation.
        //Here the space between the current car and the car in front of it is calculated.
        int[] distanceAndId;
        distanceAndId = vehicle.getDistanceToFrontAndId();
        distanceToFront = distanceAndId[0];
        vehicle.setDistanceToFront(distanceToFront);
        vehicle.setFrontId(distanceAndId[1]);
        //Here the alpha is calculated, is a number between 0 and 1, it is given by the beta function.
        float alpha = vehicle.getBetaFunctionAcc();
        //The rounded version of the alpha is calculated.
        float roundA = (float) (Math.round(alpha * 100.0) / 100.0);
        //The acceleration is calculated based on the alpha
        //The acceleration set in the cars profile is multiplied by a number between 0 and 1.

        int calculatedAcceletarion = (int) Math.floor((acceleration + 1) * (1 - roundA));
        //int calculatedAcceletarion = (int) Math.floor((acceleration + 1) * (1 - 0));
        calculatedAcceletarion = min(acceleration, calculatedAcceletarion);
        //New Velocity is calculated.
        //This new value is added to the current velocity of the car.
        //There is a cap so that this new value will not be higher than the maximum velocity of the road.
        newVel = min((currentVel + calculatedAcceletarion), vMax);
        //Caps the new velocity based on the distance to the vehicle on the front
        newVel = min(newVel, distanceToFront);
        //Uses the Uniform FDP to decide if its going to use the calculated acceletarion or not.
        //Subtracts the acceletation with a probP chance of happening. probP is defined in the config file.
        if (vehicle.getCore().provideGeneralFDPUniform()) {
            newVel = max(newVel - calculatedAcceletarion, 0);
        }

        //Sets the vehicle new velocity.
        vehicle.setNewVelocity(newVel);

        int newXPosition = grid.getNewXPostition(vehicle.getGridXPosition(), newVel);

        vehicle.setNewGridXPosition(newXPosition);

    }

    @Override
    public String toString() {
        return "NaschWithBeta";
    }

}
