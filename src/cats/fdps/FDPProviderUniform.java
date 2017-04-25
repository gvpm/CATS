package cats.fdps;

import java.util.Random;

/**
 * Implements the Uniform FDP Provider
 *
 * @author gvpm
 */
public class FDPProviderUniform extends FDPProvider {

    @Override
    public boolean provide(int a) {
        Random rand = new Random();
        int p = rand.nextInt(100);

        return p < a;
    }

    @Override
    public String toString() {
        return "Uniform";
    }

}
