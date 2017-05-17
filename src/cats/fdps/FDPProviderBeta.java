package cats.fdps;

/**
 * Implements the BETA FDP Provider
 *
 * @author gvpm
 */
public class FDPProviderBeta extends FDPProvider {

    @Override
    public float provide(int a, int b) {
        double y;
        float x;
        do {
            x = (float) Math.random();

            y = Math.random() * getBeta(a, b, getModa(a, b));

        } while (y > getBeta(a, b, x));

        return x;
    }

    //used for debug
    public float provideWithPrints(int a, int b) {
        double y;
        float x;
        do {
            x = (float) Math.random();

            y = Math.random() * getBeta(a, b, (float) getModa(a, b));
            System.out.println("x: " + x);
            System.out.println("f(x): " + getBeta(a, b, x));
            System.out.println("y: " + y);
            System.out.println("\n");

        } while (y > getBeta(a, b, x));
        System.out.println("Sorteio Escolhido");
        System.out.println("\n");
        System.out.println("x: " + x);
        System.out.println("f(x): " + getBeta(a, b, x));
        System.out.println("y: " + y);

        return x;
    }

    public static double fatorial(double num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * fatorial(num - 1);
        }
    }

    public double getBeta(double a, double b, double x) {

        double firstParcel = getFirstParcel(a, b);
        double secondParcel = getSecondParcel(a, b, x);

        return firstParcel * secondParcel;
    }

    public double getFirstParcel(double a, double b) {

        return fatorial((a + b)-1) / (fatorial(a-1) * fatorial(b-1));
    }

    public double getSecondParcel(double a, double b, double x) {
        double firstPart;
        double secondPart;
        firstPart = Math.pow(x, (a - 1));
        secondPart = Math.pow((1 - x), (b - 1));

        return (double) (firstPart * secondPart);

    }

    public double getModa(int a1, int b1) {
        double a = (double) a1;
        double b = (double) b1;

        if (a > 1 && b > 1) {
            return (a - 1) / (a + b - 2);
        } else if (a < 1 && b < 1) {
            return 1;
        } else if (((a < 1) && (b >= 1)) || ((a == 1) && (b > 1))) {
            return 0;
        } else if (((a >= 1) && (b < 1)) || ((a > 1) && (b == 1))) {
            return 1;
        } else {
            return 1;
        }

    }

    @Override
    public String toString() {
        return "Beta";
    }

}
