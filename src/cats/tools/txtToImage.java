package cats.tools;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author gvpm
 */
public class txtToImage {
    String fileName;

    public txtToImage(String fileName) {
        this.fileName=fileName;
        
    }
    
        
    public void convert (){   

        try {

            int w = 0;
            int h = 0;

            FileReader in;

            in = new FileReader(fileName+".txt");
            BufferedReader b;
            b = new BufferedReader(in);
            boolean eof = false;
            //Reads the file once to get the line size and the number of lines
            while (!eof) {
                String line = b.readLine();
                if (line == null) {//Case where line is empty, end of file
                    eof = true;
                } else {
                    w = line.length();
                    h++;
                }

            }

            //Crates the  image based on the numbers found above
            int type = BufferedImage.TYPE_INT_ARGB;
            File f = new File(fileName+".png");
            BufferedImage image = new BufferedImage(w, h, type);

            //Sets the RGB od the 2 colors that will be used
            int blue = new Color(0, 0, 255).getRGB();
            int white = new Color(255, 255, 255).getRGB();
            //Reads the file again
            in = new FileReader(fileName+".txt");
            b = new BufferedReader(in);
            eof = false;
            int i = 0;

            while (!eof) {
                //Loops in all the lines    
                String line = b.readLine();
                if (line == null) {//Case where line is empty, end of file
                    eof = true;
                } else {
                    //For all the cells in the lines, paints according to the number inside
                    for (int j = 0; j < line.length(); j++) {
                        char c = line.charAt(j);
                        if (c == '0') {//Case where cell is empty
                            image.setRGB(j, i, white);
//                 
                        } else if (c == '1') {//Case where cell is not empty
                            image.setRGB(j, i, blue);
                        }
                    }
                    i++;
                }

            }

            ImageIO.write(image, "PNG", f);

        } catch (IOException e) {

        }

    }

}
