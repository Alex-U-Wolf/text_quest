/**
 * @author : AlexV
 * @since : 04.01.2022, вт
 *
 *Flow:
 *ID, scene type, text and actions stored in scenes.json
 *Quest runs orchestrator which:
 * 1. Initialize scenes list (data loaded into the list)
 * 2. initialize scene and print text
 * 3. Repeat 2 in the loop tille the end of the game.
**/


package src.main.java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class quest {

    public static void main(String[] args) throws IOException {
        guess_game gg = new guess_game();
        gg.guess();
    }
}
