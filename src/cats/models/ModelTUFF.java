package cats.models;

import cats.core.Grid;
import cats.dataModels.Vehicle;

/**
 * Implements the TUFF Model
 *
 * @author gvpm
 */
public class ModelTUFF extends Model {

    int distanceToFront;
    int distanceFromFrontToFront;
    int velMax;
    int currentVel;
    int profileHParameter;
    int profileSafeDistance;
    Vehicle vehicle;
    Vehicle vehicleAtFront;
    Vehicle vehicleAtFrontOfFront;
    int vehicleMaxAcceleration;
    int vehicleAtFrontMaxAcceleration;
    int vehicleAtFrontCurrentVel;
    int vehicleAtFrontVelMax;
    int calculatedAcceletarionAcc;
    int calculatedAcceletarionAnt;
    int calculatedSafeDistance;
    int predictedDistanceToFront;
    float roundAlphaAcc;
    float roundAlphaAnt;
    
    boolean print = false;
    

    @Override
    public void apply(Vehicle vehicle) {
        this.vehicle = vehicle;
        Grid grid = vehicle.getGrid();

        int newVel;

        calculateAllParameters(vehicle);

        //Calculates the safe distance based on the vehicles parameters and the car at front
        
        calculatedSafeDistance = getSafeDistance();
        
        //Based on the safe distance calculated and the predicted acceleration to the car at front
        
        predictedDistanceToFront = getPredictedDistanceToFront();
        
        //Current car desired new vel
        newVel = min(currentVel + calculatedAcceletarionAcc, velMax);
        //System.out.println((int)(acceleration*(1-roundA)));

        //Caps the new vel bases on the distance to the vehicle on the front
        //System.out.println("\n"+newVel +" "+ predictedDistanceToFront);
        newVel = min(newVel, predictedDistanceToFront);
        
        if(print)
        System.out.print(" NV "+newVel+"\n");

        //sets the vehicle new vel
        vehicle.setNewVelocity(newVel);

        //gets the new x position based on the current plus  adding new vel
        int newXPosition = grid.getNewXPostition(vehicle.getGridXPosition(), newVel);

        vehicle.setNewGridXPosition(newXPosition);
    }

    public int getSafeDistance() {

        int velocityDelta = (currentVel + velMax) - vehicleAtFrontCurrentVel;
        
        if(print)
        System.out.println(vehicle.getId() +" to "+vehicleAtFront.getId());
        
        int safeDistance = 0;

        if (velocityDelta > 0) {
            
            if(print)
            System.out.print("True ");
            
            int littleDeltaD = Math.abs(distanceFromFrontToFront - distanceToFront);

            if (littleDeltaD <= calculatedAcceletarionAnt) {
                safeDistance = calculatedAcceletarionAnt;
                
                if(print)
                System.out.print(" LD: " + littleDeltaD+ " PreSD: " + safeDistance );
            }

            int timeToFront = distanceToFront / velocityDelta;
            //VERIFICAR SE ESSA MULTIPLICAÇÂO ABAIXO ESTA CORRETA
            //VERIFICAR SE ESSA MULTIPLICAÇÂO ABAIXO ESTA CORRETA
            //VERIFICAR SE ESSA MULTIPLICAÇÂO ABAIXO ESTA CORRETA
            //VERIFICAR SE ESSA MULTIPLICAÇÂO ABAIXO ESTA CORRETA
            
            int headWay =  max((int)(profileHParameter * roundAlphaAcc),2);
            
            if (timeToFront <= headWay) {
                safeDistance += max((int) (profileSafeDistance * roundAlphaAcc),6);
                
                if(print)
                System.out.print(" TH: " + timeToFront+ " HDW "+headWay+ " PreSD: " + safeDistance );
            }

        }
        
        

        return safeDistance;
    }

    public int getPredictedDistanceToFront() {

        int predictedDistance = distanceToFront;
        int vehicleAtFrontPredictedNewVel = min(vehicleAtFrontCurrentVel + calculatedAcceletarionAnt, distanceFromFrontToFront);

        predictedDistance += max((vehicleAtFrontPredictedNewVel - calculatedSafeDistance), 0);
        
        if(print)
        System.out.print(" Distance: "+distanceToFront + " Pred: "+predictedDistance + " EndSD: "+ calculatedSafeDistance);
        
        return predictedDistance;
    }

    public void calculateAllParameters(Vehicle vehicle) {
        velMax = vehicle.getVelMax();
        currentVel = vehicle.getVelocity();
        profileHParameter = vehicle.getProfile().getAhead();
        profileSafeDistance = vehicle.getProfile().getSafeDistance();
        vehicleMaxAcceleration = vehicle.getAcceleration();

        float alphaAcc = vehicle.getBetaFunctionAcc();
        roundAlphaAcc = (float) (Math.round(alphaAcc * 100.0) / 100.0);

        //Calculates the accelaration based on the Acceleration Alpha and Beta values
        calculatedAcceletarionAcc = (int) Math.floor((vehicleMaxAcceleration + 1) * (1 - roundAlphaAcc));
        calculatedAcceletarionAcc = min(vehicleMaxAcceleration, calculatedAcceletarionAcc);

        int[] distanceAndIdToFront;

        //calculate space between the vehicle and the one to the front
        distanceAndIdToFront = vehicle.getDistanceToFrontAndId();
        distanceToFront = distanceAndIdToFront[0];
        vehicle.setDistanceToFront(distanceToFront);
        vehicle.setFrontId(distanceAndIdToFront[1]);     

        
        vehicleAtFront = vehicle.getCore().getVehicleFromId(distanceAndIdToFront[1]);

        int[] distanceAndIdFromFrontToFront;

        //calculate space between the vehicle ate front and the one in front of it        
        distanceAndIdFromFrontToFront = vehicleAtFront.getDistanceToFrontAndId();
        distanceFromFrontToFront = distanceAndIdFromFrontToFront[0];
        vehicleAtFrontOfFront = vehicleAtFront.getCore().getVehicleFromId(distanceAndIdFromFrontToFront[1]);
        
        
    
        vehicleAtFrontMaxAcceleration = vehicleAtFront.getAcceleration();
        vehicleAtFrontCurrentVel = vehicleAtFront.getVelocity();
        vehicleAtFrontVelMax = vehicleAtFront.getVelMax();


        float alphaAnt = vehicle.getBetaFunctionAnt();
        roundAlphaAnt = (float) (Math.round(alphaAnt * 100.0) / 100.0);
        //Calculate new vel, addind acceleratio to vel

        //Calculates the accelaration based on the Antecipation Alpha and Beta values
        calculatedAcceletarionAnt = (int) Math.floor((vehicleAtFrontMaxAcceleration + 1) * (1 - roundAlphaAnt));
        calculatedAcceletarionAnt = min(vehicleAtFrontMaxAcceleration, calculatedAcceletarionAnt);
         
    }

    @Override
    public String toString() {
        return "TUff";
    }

}
