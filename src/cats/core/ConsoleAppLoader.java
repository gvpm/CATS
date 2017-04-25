package cats.core;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * The console way to run the simulation.
 *
 * It runs the file given via arguments. It runs the simulation.txt if no
 * arguments are passed.
 *
 */
public class ConsoleAppLoader {

    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        boolean GUI = true;

        FileLoader fileLoader;

        if (args.length == 0) {

            fileLoader = new FileLoader("simulation.txt");

            if (GUI) {
                GUIOutputWindow frame = new GUIOutputWindow();
                frame.setVisible(true);
                MessageConsole mc = new MessageConsole(frame.getjTextArea1());
                mc.redirectOut();

                mc.setMessageLines(100);

                //Case where arguments were given, running on prompt probably    
            }
        } else {
            fileLoader = new FileLoader(args[0]);
        }

        fileLoader.load();

        Core core = fileLoader.getCore();
        
        //Override of the log name if a second parameter is passed.
         if (args.length == 2){
             core.getParameters().setLogName(args[1]);
         }

        core.init();

        core.simulateAllDensities();

    }

}
