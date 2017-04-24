package cats.core;

import java.util.ArrayList;

/**
 * Responsible to store all the grid information. Stored where the cars are, its
 * ids and provide information such as next and previous car. Also responsible
 * to update the cars in the grid in each iteration.
 *
 * @author gvpm
 */
public class Grid {

    int[] grid;

    public Grid(int size) {
        grid = new int[size];

    }

    //puts 0 in all positions of the grid
    public void init() {
        for (int i = 0; i < grid.length; i++) {
            grid[i] = -1;
        }

    }

    public int getFromPosition(int i) {
        return grid[i];
    }

    public int getNextXPosition(int i) {
        if (i == grid.length - 1) {
            return 0;
        } else {
            return i + 1;
        }
    }

    public int getPreviousXPosition(int i) {
        if (i == 0) {
            return grid.length - 1;
        } else {
            return i - 1;
        }
    }

    public void clear() {

        init();
    }

    /**
     * Clears the grid information and fills it again respecting the vehicles
     * size. For each grid cell it puts the id of the vehicle that is there. -1
     * for empty cells. Throws exception if it founds conflict.
     *
     * @param vehicles List of vehicles to update.
     */
    public void updateVehiclesOnGrid(ArrayList<Vehicle> vehicles) {
        clear();
        for (int i = vehicles.size() - 1; i >= 0; i--) {
            Vehicle v = vehicles.get(i);
            int position = v.getNewGridXPosition();

            for (int j = 0; j < v.getSize(); j++) {

                if (getFromPosition(position) != -1) {
                    throw new UnsupportedOperationException("Conflict between car " + getFromPosition(position) + " and " + v.getId());

                } else {
                    grid[position] = v.getId();
                    position = getPreviousXPosition(position);
                    //case of conflict
                }

            }

        }

    }

    /**
     * Places vehicles on the grid at the beginning, all together in the end.
     *
     * @param vehicles
     */
    public void placeVehiclesOnGrid(ArrayList<Vehicle> vehicles) {

        int xPosition = grid.length - 1;

        for (int i = vehicles.size() - 1; i >= 0; i--) {
            Vehicle v = vehicles.get(i);
            v.setGridXPosition(xPosition);
            for (int j = 0; j < v.getProfile().getSize(); j++) {
                grid[xPosition] = v.getId();
                xPosition--;

            }

        }

    }

    public int[] getGrid() {
        return grid;
    }

    /**
     * Function that will return the new X position, adding vel cells to
     * position x.
     *
     * @param x current position
     * @param vel new velocity
     * @return returns new position
     */
    public int getNewXPostition(int x, int vel) {

        int newXPosition = x;
        for (int i = 0; i < vel; i++) {

            newXPosition = getNextXPosition(newXPosition);

        }

        return newXPosition;

    }

    public void printGrid() {
        System.out.println("Grid");
        for (int i = grid.length - 1; i >= 0; i--) {

            System.out.print(grid[i] + " ");

        }
        System.out.println("");

    }

}
