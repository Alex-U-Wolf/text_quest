/**
 * @author : AlexV
 * @since : 04.01.2022, вт
 **/

package src.main.java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class guess_game {

    int iter = 1;
    int rnd = 0;
    public void guess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        rnd = random.nextInt(100);
        System.out.println("Enter Integer: 0 - 100");
        while (rnd!=iter) {
            try {
                iter = Integer.parseInt(br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid Format!");
            }
            if (iter>rnd) System.out.println("Too much");
            if (iter<rnd) System.out.println("Not enough");
        }
        System.out.println("Match! Value="+rnd);
    }

}
