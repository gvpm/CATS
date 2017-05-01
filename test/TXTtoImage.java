
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gvpm
 */
public class TXTtoImage {

    public static void main(String[] args) throws IOException {
        try {

            int w = 0;
            int h = 0;

            FileReader in;

            in = new FileReader("0.3.txt");

            BufferedReader b;
            b = new BufferedReader(in);
            boolean eof = false;

            while (!eof) {
                String line = b.readLine();
                if (line == null) {//Case where line is empty, end of file
                    eof = true;
                } else {
                    w = line.length();
                    h++;
                }

            }
            System.out.println(w + "" + h);

            int type = BufferedImage.TYPE_INT_ARGB;
            File f = new File("MyFile.png");

            BufferedImage image = new BufferedImage(w, h, type);

            int blue = new Color(0, 0, 255).getRGB();
            int white = new Color(255, 255, 255).getRGB();
            
            in = new FileReader("0.3.txt");
            b = new BufferedReader(in);
            eof = false;
            int i = 0;

            while (!eof) {
                
                String line = b.readLine();
                if (line == null) {//Case where line is empty, end of file
                    eof = true;
                } else {
                    for (int j = 0; j < line.length(); j++) {
                        char c = line.charAt(j);
                        if (c == '0') {
                            image.setRGB(j, i, white);
//                            if(i>9990){
//                            System.out.println(i+" "+j);
//                            }
                        } else if (c == '1') {
                            image.setRGB(j, i, blue);
                            
                        }

                    }

                    i++;
                }

            }

//            for (int x = 0; x < w; x++) {
//                for (int y = 0; y < h; y++) {
//
//                    image.setRGB(x, y, blue);
//                }
//            }
            ImageIO.write(image, "PNG", f);

        } catch (IOException e) {

        }
    }
}
