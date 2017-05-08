/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gvpm
 */
public class RandomTest {

    public static void main(String[] args) {
        float roundA;
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0;

        for (int i = 0; i < 500000; i++) {
            roundA = (float) (Math.round(Math.random() * 100.0) / 100.0);
            //int calculatedAcceletarion = (int) Math.round(5 * (1 - roundA));
            int calculatedAcceletarion = (int) Math.floor((5 + 1) * (1 - roundA));
            if (calculatedAcceletarion > 5) {
                calculatedAcceletarion = 5;
            }
            //System.out.println(calculatedAcceletarion);
            if (calculatedAcceletarion == 0) {
                a++;
            } else if (calculatedAcceletarion == 1) {
                b++;
            } else if (calculatedAcceletarion == 2) {
                c++;
            } else if (calculatedAcceletarion == 3) {
                d++;
            } else if (calculatedAcceletarion == 4) {
                e++;
            } else if (calculatedAcceletarion == 5) {
                f++;
            } else if (calculatedAcceletarion == 6) {
                g++;
            }

        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g);
    }

}
