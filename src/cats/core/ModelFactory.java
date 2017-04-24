package cats.core;

/**
 * Responsible to instantiate a model according to a given number or string.
 *
 * @author gvpm
 */
public class ModelFactory {

    public Model fabricate(int n) {

        switch (n) {

            case 1:
                return new ModelNasch();

            case 2:
                return new ModelTUFF();
            case 3:
                return new ModelNaschWithBeta();
            default:
                throw new UnsupportedOperationException("Model not supported"); //To change body of generated methods, choose Tools | Templates.

        }

    }

    public Model fabricate(String s) {

        switch (s) {

            case "nasch":
                return new ModelNasch();
            case "naschWithBeta":
                return new ModelNaschWithBeta();

            case "tuff":
                return new ModelTUFF();
            default:
                throw new UnsupportedOperationException("Model not supported"); //To change body of generated methods, choose Tools | Templates.

        }

    }

}
