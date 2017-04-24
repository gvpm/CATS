package cats.core;

/**
 * Abstract FDP Provider class, all FDP Providers should implement this.
 *
 */
public abstract class FDPProvider {

    public boolean provide(int a) {
        return false;
    }

    public float provide(int a, int b) {
        return 1;

    }

    @Override
    public abstract String toString();

}
