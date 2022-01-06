/**
 * @author : AlexV
 * @since : 04.01.2022, вт
 **/

//main class to handle scenes
package src.main.java;

import org.apache.log4j.Logger;

import java.io.IOException;

public class orchestrator {

    final static Logger logger = Logger.getLogger(orchestrator.class);

    public void initialize(){
        logger.debug("Orchestrator initialisation");
    }

    public void start() throws IOException {
        String currentScene = "01";
        logger.debug("Starting. Setting location to 01");

        scene sc = scene.getInstance();
        while (!currentScene.equals("06")){
            sc.load(currentScene);
            sc.showScene();
            currentScene = sc.readActions();
        }
        System.out.println("You light a small fire, eat few fruits, grab few more for tomorrow and now can take a rest, while new locations to be created.");
    }
}
