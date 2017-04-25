package cats.models;

import cats.core.Vehicle;

/**
 * Abstract model class, all models should implement this. It contains the
 * min/max calculation normally used in models.
 *
 * @author gvpm
 */
public abstract class Model {

    public Model() {
    }

    public int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }

    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }

    }

    public abstract void apply(Vehicle vehicle);

    @Override
    public abstract String toString();

}
