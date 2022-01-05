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
        sc.testprint();
        sc.load(currentScene);
        sc.print_test_scene();
        sc.load("02");
        sc.print_test_scene();

        while (!currentScene.equals("6")){
            sc.load(currentScene);
            sc.showScene();
            currentScene = sc.readActions();
        }

    }

}
