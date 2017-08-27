
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import processing.core.*;

public class CircularPictureLogViwer extends PApplet {

    int x = 600;
    int y = 600;
    int[] grid;
    String line;
    FileReader f;
    BufferedReader b;
    boolean eof;

    String line2;
    FileReader f2;
    BufferedReader b2;
    boolean eof2;

    int i = 1;
    int carSize = 5;

    int lastCar1Middle = 0;
    int lastCar2Middle = 0;

    int roundsCountCar1 = 0;
    int roundsCountCar2 = 0;

    public static void main(String[] args) {

        PApplet.main(new String[]{"CircularPictureLogViwer"});
    }

    @Override
    public void settings() {
        size(x, y);
    }

    @Override
    public void setup() {

        background(255);

        try {
            f = new FileReader("360s/nasch-d0.8.txt");

            b = new BufferedReader(f);
            eof = false;

            line = b.readLine();
            if (line == null) {//Case where line is empty, end of file
                eof = true;
            }

            f2 = new FileReader("360s/3010-d0.8.txt");

            b2 = new BufferedReader(f2);
            eof2 = false;

            line2 = b2.readLine();
            if (line2 == null) {//Case where line is empty, end of file
                eof2 = true;
            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

    }

    @Override
    public void draw() {

        ArrayList<CircularCar> CircularCars = new ArrayList<>();
        background(200);
        stroke(0);
        fill(255);
        String[] splittedLine = line.split("");

        if (splittedLine.length > 0) {

            int sizeCount = 0;

            for (int j = 0; j < splittedLine.length; j++) {
                if (!"0".equals(splittedLine[j])) {
                    sizeCount++;
                }
                if (sizeCount == 5) {

                    int index = Integer.parseInt(splittedLine[j]);
                    CircularCars.add(new CircularCar(j - 2, carSize, index));
                    sizeCount = 0;
                    if (index == 2) {
                        if (j - 2 < lastCar1Middle) {
                            roundsCountCar1++;
                        }
                        lastCar1Middle = j - 2;
                    }

                }

            }
            //System.out.println("TotalCars1"+CircularCars.size() );
            for (int j = 0; j < CircularCars.size(); j++) {
                if (CircularCars.get(j).index == 2) {
                    fill(0);
                }
                ellipse(CircularCars.get(j).getMiddle(), 300, carSize, carSize);

                fill(255);

            }
            textSize(14);
            text(roundsCountCar1, 380, 300);
        }

        ArrayList<CircularCar> CircularCars2 = new ArrayList<>();
        stroke(0);
        fill(255);
        String[] splittedLine2 = line2.split("");

        if (splittedLine2.length > 0) {

            int sizeCount2 = 0;

            for (int j = 0; j < splittedLine2.length; j++) {
                int index = Integer.parseInt(splittedLine2[j]);
                if (!"0".equals(splittedLine2[j])) {
                    sizeCount2++;
                }
                if (j == 4 && sizeCount2 > 0 && sizeCount2 < 5) {
                    int totalSize = CircularCars2.size();
                    switch (sizeCount2) {
                        case 1:
                            CircularCars2.add(new CircularCar(totalSize - 2, carSize, index));
                            break;
                        case 2:
                            CircularCars2.add(new CircularCar(totalSize - 1, carSize, index));
                            break;
                        case 3:
                            CircularCars2.add(new CircularCar(0, carSize, index));
                            break;
                        case 4:
                            CircularCars2.add(new CircularCar(1, carSize, index));
                            break;
                        default:

                            break;
                    }
                    sizeCount2 = 0;
                    if (index == 2) {
                        if (((j - 2) - lastCar2Middle)< -5) {
                            roundsCountCar2++;
                        }
                        lastCar2Middle = j - 2;
                    }
                } else if (sizeCount2 == 5) {
                    CircularCars2.add(new CircularCar(j - 2, carSize, index));
                    sizeCount2 = 0;
                    if (index == 2) {
                        if (((j - 2) - lastCar2Middle)< -5) {
                            roundsCountCar2++;
                        }
                        lastCar2Middle = j - 2;
                    }
                }

            }
            //System.out.println("TotalCars2"+CircularCars2.size() );
            for (int j = 0; j < CircularCars2.size(); j++) {
                if (CircularCars2.get(j).index == 2) {
                    fill(0);
                }
                ellipse(CircularCars2.get(j).getMiddle(), 330, carSize, carSize);

                fill(255);

            }

            textSize(14);
            text(roundsCountCar2, 380, 330);
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

            if (!eof2) {
                line2 = b2.readLine();
                if (line2 == null) {//Case where line is empty, end of file
                    eof2 = true;
                    b2.close();
                }

            }

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

    }
}
