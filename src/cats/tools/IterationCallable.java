package cats.tools;

import cats.core.Core;
import java.util.concurrent.Callable;

/**
 * This will be fed to the Executor to run as a thread. It gets the necessary
 * inputs to call the core.iteratePart() function when necessary.
 */
public class IterationCallable implements Callable<Integer> {

    Core core;
    int partNumber, parts;
    String name;

    public IterationCallable(Core core, int partNumber, int parts, String name) {
        this.core = core;
        this.partNumber = partNumber;
        this.parts = parts;
        this.name = name;
    }

    //Here it calls the iteration for the given part.
    @Override
    public Integer call() throws Exception {
        //System.out.println("Entered:"+name);
        core.iteratePart(partNumber, parts);

        return 1;
    }

}
