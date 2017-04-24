
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import processing.core.*;

public class PictureLogViwer extends PApplet {

    int rows, columns;
    int x = 1250;
    int y = 50;
    int[] grid;
    String line;
    FileReader f;
    BufferedReader b;
    boolean eof;

    public static void main(String[] args) {

        PApplet.main(new String[]{"PictureLogViwer"});
    }

    @Override
    public void settings() {
        size(x, y);
    }

    @Override
    public void setup() {
        rows = 1;
        columns = 1250;
        background(255);

        try {
            f = new FileReader("0.5.txt");

            b = new BufferedReader(f);
            eof = false;

            line = b.readLine();
            if (line == null) {//Case where line is empty, end of file
                eof = true;
            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

    }

    @Override
    public void draw() {
        background(255);
        stroke(0);
        String[] splittedLine = line.split("");
        if (splittedLine.length > 0) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int lineValue = Integer.parseInt(splittedLine[j]);
                    if (lineValue != 0) {
                        fill(0);
                        int center = 20;
                        rect(j, center + i, 1, 1);
                        rect(j, center + i + 1, 1, 1);
                        rect(j, center + i + 2, 1, 1);
                        rect(j, center + i + 3, 1, 1);
                        rect(j, center + i + 4, 1, 1);
                    }

                }

            }
        }

    }

    @Override
    public void keyPressed() {

        if (key == 'i') {

            iterate();

        }

    }

    private void iterate() {
        try {

            if (!eof) {
                line = b.readLine();
                if (line == null) {//Case where line is empty, end of file
                    eof = true;
                    b.close();
                }

            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

    }
}
