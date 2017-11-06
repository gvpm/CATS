package cats.interfaces;

import cats.json.RedisSubscriber;
import cats.gui.GUIOutputWindow;
import cats.json.JsonInterface;
import cats.tools.MessageConsole;

/**
 * The console way to run the simulation.
 *
 * It runs the file given via arguments. It runs the simulation.txt if no
 * arguments are passed.
 *
 */
public class ConsoleAppLoader {

    public static void main(String[] args) {
        if (args.length == 0) {
            helpMenu();
        } else {

            switch (args[0]) {

                case "sub":
                    System.out.println("Redis Subscriber Mode");
                    //Starts a redis subscriber with the server and the channel
                    RedisSubscriber sub = new RedisSubscriber(args[1], args[2]);
                    sub.run();
                    break;

                case "json":

                    JsonInterface jsonRunner = new JsonInterface(args[1]);
                    jsonRunner.call();
                    break;

                case "txt":

                    boolean GUI = false;

                    if (args.length == 1) {

                        if (GUI) {
                            guiRedirect();
                        }
                        FileInterface fileRunner = new FileInterface("simulation.txt");
                        fileRunner.call();
                    } else {
                        FileInterface fileRunner = new FileInterface(args[1]);
                        fileRunner.call();
                    }

                    break;
                default:
                    helpMenu();

            }

        }

    }

    private static void helpMenu() {
        System.out.println("CATS - Cellular Automata Traffic Simulator\n");
        System.out.println("Help Menu\n");
        System.out.println("\nMode 1: TXT Loader");
        System.out.println("Example: java -jar CATS.jar txt <input.txt>");
//        System.out.println("Running \"-jar CATS.jar txt\" with no fileName w\\n\");\n" +
//"        System.out.println(\"Redis Subill run 'simulation.txt' file" );
        System.out.println("\nMode 2: Json Loader");
        System.out.println("Example: java -jar CATS.jar json <oneLineJsonString>\n");
        System.out.println("Mode 3: Redis Subscriber");
        System.out.println("Example: java -jar CATS.jar sub <server> <channel>\n");

    }

    private static void guiRedirect() {
        GUIOutputWindow frame = new GUIOutputWindow();
        frame.setVisible(true);
        MessageConsole mc = new MessageConsole(frame.getjTextArea1());
        mc.redirectOut();
        mc.setMessageLines(100);
        //Case where arguments were given, running on prompt probably     }

    }
}
