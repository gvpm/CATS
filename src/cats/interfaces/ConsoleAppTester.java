package cats.interfaces;

import cats.core.Core;
import cats.core.SimulationParameters;
import java.util.concurrent.ExecutionException;
import javax.swing.JTextArea;

/**
 * The console way to run the simulation.
 *
 */
public class ConsoleAppTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        FDPProviderFactory factory = new FDPProviderFactory();
//        
//        FDPProviderBeta fbeta = (FDPProviderBeta)factory.fabricate("beta");
//        //System.out.println(fbeta.fatorial(5));
//        //System.out.println(fbeta.getFirstParcel(5,5));
//        //System.out.println(fbeta.getSecondParcel(5,5,(float)0.5));
//        //System.out.println(fbeta.getBeta(4, 9, (float)0.28));
//        for (int i = 0; i < 50; i++) {
//            System.out.println(fbeta.provide(4, 9));
//            
//        }
        //-------------------------------------(int speedLimit, float probP, int simulationTime, int discardTime, int statisticTime, float initialDensity, float deltaDendity, float finalDensity, int cellsInX, int cellsInY, float cellSize, float defaultCarSize, String model) 
        SimulationParameters parameters = new SimulationParameters(25, 35, 15000, 10000, 121, (float) 0.01, (float) 0.01, (float) 0.9, 10000, 1, (float) 1.5, (float) 7.5, "naschWithBeta", "plotar", 0);
        //SimulationParameters parameters = new SimulationParameters(25, 35, 15000, 10000, 121, (float) 0.01, (float) 0.01, (float) 0.9, 10000, 1, (float) 1.5, (float) 7.5, "nasch");

        Core core = new Core(parameters);

        //---------(FDPProvider fdpProvider, String name, int size, int velMax, int ahead, int safeDistance, int velIncrement, double percentageOccurrence, float alphaAcc, float betaAcc, float alphaAnt, float betaAnt) 
        core.createProfile("beta", "Nasch Basic", 5, 25, 0, 0, 5, 1, 4, 1, 4, 1);
        //core.createProfile("uniform", "Nasch Basic", 5, 25, 0, 0, 5, 1, 1, 4, 1, 4);

        core.init();

//        JTextArea jta =  new JTextArea(); 
//        MessageConsole mc = new MessageConsole(jta);
//        mc.redirectOut(null, System.out);
//        mc.setMessageLines(100);
        core.simulateAllDensities();

    }

}
