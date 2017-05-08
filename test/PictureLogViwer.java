
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import processing.core.*;

public class PictureLogViwer extends PApplet {

    int rows, columns;
    int x = 1050;
    int y = 50;
    int[] grid;
    String line;
    FileReader f;
    BufferedReader b;
    boolean eof;
    int i = 1;
    
    PImage img;

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
        columns = 351;
        background(255);

        try {
            f = new FileReader("0.3.txt");

            b = new BufferedReader(f);
            eof = false;

            line = b.readLine();
            if (line == null) {//Case where line is empty, end of file
                eof = true;
            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        img = loadImage("car.png");

    }

    @Override
    public void draw() {
        
        //iterate();
        background(200);
        stroke(0);
        String[] splittedLine = line.split("");
        if (splittedLine.length > 0) {
            
                for (int j = 1; j < columns; j++) {
                    int lineValue = Integer.parseInt(splittedLine[j]);
                    int frontLineValue = Integer.parseInt(splittedLine[j+1]);
                    int backLineValue = Integer.parseInt(splittedLine[j-1]);
                    
                    //if (lineValue != 0) {
                    if (lineValue != 0 && frontLineValue!=0 && backLineValue==0 ) {    
                        fill(0);
                        int center = 20;
//                        rect(j, center + i, 1, 1);
//                        rect(j, center + i + 1, 1, 1);
//                        rect(j, center + i + 2, 1, 1);
//                        rect(j, center + i + 3, 1, 1);
//                        rect(j, center + i + 4, 1, 1);
                        fill(100);
                        //rect(j+(j*2), center + i, 29 ,15);
                        image(img, j+(j*2), center+i);
//                        rect(j+(j*2), center + i + 1, 1, 1);
//                        rect(j+(j*2), center + i + 2, 1, 1);
//                        rect(j+(j*2), center + i + 3, 1, 1);
//                        rect(j+(j*2), center + i + 4, 1, 1);
                    }

                }

            
        }
        //rect(1000, 30, 5, 5);
        //rect(500, 30, 1, 1);
        

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
