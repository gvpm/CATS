package cats.tools;

import cats.core.Core;
import java.util.concurrent.Callable;

/**
 * This will be fed to the Executor to run as a thread. It gets the necessary
 * inputs to call the core.iteratePart() function when necessary.
 */
public final class IterationCallable implements Callable<Integer> {

    Core core;
    int partNumber, processors, lastPart;
    String name;
    int[] beginnings;

    public IterationCallable(Core core, int partNumber, int processors, String name) {
        this.core = core;
        this.partNumber = partNumber;
        this.processors = processors;
        this.name = name;
        this.beginnings = getBeginnings();
        this.lastPart = processors-1;

    }


    public int[] getBeginnings() {
        
        int partSize = (core.getVehicles().size())/ processors;
        int[] response = new int[processors];
        for (int i = 0; i < processors; i++) {
            response[i] = partSize * i;
        }
        return response;
    }

    //Here it calls the iteration for the given part.
    @Override
    public Integer call() throws Exception {
        //System.out.println("Entered:"+name);
        int numberApplied = core.iteratePart(partNumber, lastPart, beginnings);
        //int numberApplied = core.iteratePart(partNumber, parts);

        return numberApplied;
    }

}
