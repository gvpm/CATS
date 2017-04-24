package cats.core;

/**
 * Responsible to instantiate a FDP Provider according to a given number or
 * string.
 *
 * @author gvpm
 */
public class FDPProviderFactory {

    public FDPProvider fabricate(int n) {

        switch (n) {

            case 1:
                return new FDPProviderUniform();

            case 2:
                return new FDPProviderBeta();
            default:
                throw new UnsupportedOperationException("FDPProvider not supported"); //To change body of generated methods, choose Tools | Templates.

        }

    }

    public FDPProvider fabricate(String s) {

        switch (s) {

            case "uniform":
                return new FDPProviderUniform();

            case "beta":
                return new FDPProviderBeta();
            default:
                throw new UnsupportedOperationException("FDPProvider not supported"); //To change body of generated methods, choose Tools | Templates.

        }

    }

}
