package cats.interfaces;

import cats.core.Core;
import cats.tools.FileLoader;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author gvpm
 */
public class FileInterface implements Callable<Integer> {

    String fileName;
    FileLoader fileLoader;

    public FileInterface(String fileName) {
        this.fileName = fileName;
        fileLoader = new FileLoader(fileName);
    }

    @Override
    public Integer call() {

        try {

            fileLoader = new FileLoader(fileName);
            fileLoader.load();
            Core core = fileLoader.getCore();

            core.init();
            long startTime = System.currentTimeMillis();
            core.simulateAllDensities();
            long elapsedTime = System.currentTimeMillis() - startTime;
            long secondsTotal = elapsedTime / 1000;
            long minutes = secondsTotal / 60;
            long secondsRest = secondsTotal % 60;
            System.out.println("Total Simulation Time: " + minutes + " minutes and " + secondsRest + " seconds.");

        } catch (JsonGenerationException e) {
            System.out.println(e);

        } catch (JsonMappingException | ExecutionException | InterruptedException e) {
            System.out.println(e);

        } catch (IOException e) {
            System.out.println(e);
        }

        return 1;
    }

}
