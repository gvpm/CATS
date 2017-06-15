package cats.dataModels;

import cats.core.Core;
import cats.core.Grid;
import cats.dataModels.Profile;

/**
 * Responsible to store the vehicles information. The vehicle know what core it
 * is in, what grid and what profile it has.
 *
 * @author gvpm
 */
public class Vehicle {

    Grid grid;
    Core core;
    Profile profile;
    int id;
    int gridXPosition;
    int gridYPosition;
    int oldGridXPosition;
    int oldGridYPosition;
    int newGridXPosition;
    int newGridYPosition;
    int velocity;
    int newVelocity;
    int oldVelocity;
    int distanceToFront;
    int oldDistanceToFront;
    int frontId;
    int oldFrontId;

    Vehicle frontNeighbour;
    Vehicle backNeighbour;

    public Vehicle(Grid grid, Core core, Profile profile, int id) {
        this.grid = grid;
        this.core = core;
        this.profile = profile;
        this.id = id;
        this.velocity = 0;
    }

    public Vehicle(Grid grid, Core core) {
        this.grid = grid;
        this.core = core;
        this.velocity = 0;

    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGridXPosition() {
        return gridXPosition;
    }

    public void setGridXPosition(int gridXPosition) {
        this.gridXPosition = gridXPosition;
    }

    public int getGridYPosition() {
        return gridYPosition;
    }

    public void setGridYPosition(int gridYPosition) {
        this.gridYPosition = gridYPosition;
    }

    public int getOldGridXPosition() {
        return oldGridXPosition;
    }

    public void setOldGridXPosition(int oldGridXPosition) {
        this.oldGridXPosition = oldGridXPosition;
    }

    public int getOldGridYPosition() {
        return oldGridYPosition;
    }

    public void setOldGridYPosition(int oldGridYPosition) {
        this.oldGridYPosition = oldGridYPosition;
    }

    public int getNewGridXPosition() {
        return newGridXPosition;
    }

    public void setNewGridXPosition(int newGridXPosition) {
        this.newGridXPosition = newGridXPosition;
    }

    public int getNewGridYPosition() {
        return newGridYPosition;
    }

    public void setNewGridYPosition(int newGridYPosition) {
        this.newGridYPosition = newGridYPosition;
    }

    @Override
    public String toString() {
        return "" + getId();

    }

    public Vehicle getFrontNeighbour() {
        return frontNeighbour;
    }

    public void setFrontNeighbour(Vehicle frontNeighbour) {
        this.frontNeighbour = frontNeighbour;
    }

    public Vehicle getBackNeighbour() {
        return backNeighbour;
    }

    public void setBackNeighbour(Vehicle backNeighbour) {
        this.backNeighbour = backNeighbour;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getNewVelocity() {
        return newVelocity;
    }

    public void setNewVelocity(int newVelocity) {
        this.newVelocity = newVelocity;
    }

    public int getOldVelocity() {
        return oldVelocity;
    }

    public void setOldVelocity(int oldVelocity) {
        this.oldVelocity = oldVelocity;
    }

    public int getAcceleration() {
        return getProfile().getVelIncrement();

    }

    public int getSize() {
        return getProfile().getSize();

    }

    //gives the distance to the car at front and the id
    public int[] getDistanceToFrontAndId() {
        int pointer = grid.getNextXPosition(this.getGridXPosition());

        int distance = 0;
        //looks at front, cell by cell until it finds something in front
        while (grid.getFromPosition(pointer) == -1) {
            pointer = grid.getNextXPosition(pointer);
            distance++;
        }
        int[] r = new int[2];
        r[0] = distance;
        //car that is in that position
        r[1] = grid.getFromPosition(pointer);
        return r;
    }

    public int getVelMax() {
        return profile.getVelMax();

    }

    //after grid is updated, vehicle updates itself to next step
    public void updateInfo() {
//        if(getId()==4 && newGridXPosition!=gridXPosition){
//            System.out.print(" "+ gridXPosition);
//        }

        oldGridXPosition = gridXPosition;
        oldGridYPosition = gridYPosition;
        gridXPosition = newGridXPosition;
        gridYPosition = newGridYPosition;
        oldVelocity = velocity;
        velocity = newVelocity;
        oldDistanceToFront = distanceToFront;
        oldFrontId = frontId;

    }

    public float getBetaFunctionAcc() {
        float a = getProfile().getAlphaAcc();
        float b = getProfile().getBetaAcc();

        return getProfile().getFdpProvider().provide((int) a, (int) b);

    }

    public float getBetaFunctionAnt() {
        float a = getProfile().getAlphaAnt();
        float b = getProfile().getBetaAnt();

        return getProfile().getFdpProvider().provide((int) a, (int) b);

    }

    public int getDistanceToFront() {
        return distanceToFront;
    }

    public void setDistanceToFront(int distanceToFront) {
        this.distanceToFront = distanceToFront;
    }

    public int getOldDistanceToFront() {
        return oldDistanceToFront;
    }

    public void setOldDistanceToFront(int oldDistanceToFront) {
        this.oldDistanceToFront = oldDistanceToFront;
    }

    public int getFrontId() {
        return frontId;
    }

    public void setFrontId(int frontId) {
        this.frontId = frontId;
    }

    public int getOldFrontId() {
        return oldFrontId;
    }

    public void setOldFrontId(int oldFrontId) {
        this.oldFrontId = oldFrontId;
    }

}
