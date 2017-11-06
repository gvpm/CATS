/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gvpm
 */
public class CircularCar {

    int middle;
    int radius;
    int distanceToFront;
    int index;

    public CircularCar(int middle, int radius, int index) {
        this.middle = middle;
        this.radius = radius;
        this.index = index;

    }

    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDistanceToFront() {
        return distanceToFront;
    }

    public void setDistanceToFront(int distanceToFront) {
        this.distanceToFront = distanceToFront;
    }

}
