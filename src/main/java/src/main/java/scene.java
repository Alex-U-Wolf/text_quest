/**
 * @author : AlexV
 * @since : 04.01.2022, вт
 **/
//Singletone
//single scene with text, image and actions. Load data from list
package src.main.java;

import java.io.IOException;
import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class scene {
    private String ID;
    private String type;
    private String text;
    private List<option> optList = new ArrayList<>();

    private static final scene instance = new scene();
    JSONParser parser = new JSONParser();

    private scene() {
//        init here
    }

    public static scene getInstance() {
        return instance;
    }


    public void load(String s) {
        JSONObject iterJson = null;
        optList.clear();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/scenes.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("scenes");
            ID = "99";
            Iterator i = jsonArray.iterator();
            while (!ID.equals(s)) {
                Object o = i.next();
                iterJson = (JSONObject) o;
                ID = iterJson.get("ID").toString();
            }
            JSONObject jsonSubObject = iterJson;
            ID = jsonSubObject.get("ID").toString();
            type = jsonSubObject.get("Type").toString();
            text = jsonSubObject.get("Text").toString();
            JSONArray jsonOptArray = (JSONArray) jsonSubObject.get("Options");
//            System.out.println("Option0="+jsonSubObject.get("Options").toString());
            i = jsonOptArray.iterator();
            while (i.hasNext()) {
                option opt = new option();
                Object o = i.next();
                iterJson = (JSONObject) o;
                opt.setOption(iterJson.get("Option").toString());
                opt.setText(iterJson.get("Text").toString());
                opt.setAction(iterJson.get("Action").toString());
                optList.add(opt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        option opt = new option();
        opt.setOption("7");
        opt.setText("Look around");
        opt.setAction("80");
        optList.add(opt);

        opt = new option();
        opt.setOption("8");
        opt.setText("Check inventory");
        opt.setAction("81");
        optList.add(opt);

        opt = new option();
        opt.setOption("9");
        opt.setText("Check map");
        opt.setAction("82");
        optList.add(opt);

    }

    public void print_test_scene() {
        System.out.print("ID=" + ID + " ");
        System.out.print("Type=" + type + " ");
        System.out.println("Text=" + text);
        for (ListIterator<option> iter = optList.listIterator(); iter.hasNext(); ) {
            option opt = iter.next();
            System.out.print("Option=" + opt.getOption() + " ");
            System.out.print("Text=" + opt.getText() + " ");
            System.out.println("Action=" + opt.getAction());
        }
        optList.iterator();
    }


    public void showScene() {
//        Runtime.getRuntime().exec("cls");
        ClearConsole();
        System.out.println();
        System.out.println(text);
        System.out.println("Ohh, what will you do now?");
        for (ListIterator<option> iter = optList.listIterator(); iter.hasNext(); ) {
            option opt = iter.next();
            System.out.println(opt.getOption() + " " + opt.getText());
        }

    }

    public String readActions() throws IOException {
        JSONObject iterJson = null;
        String choice = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                choice = (br.readLine());
            } catch (NumberFormatException nfe) {
                System.err.println("Can't get what you want...");
            }
            try {
       //         Iterator i = optList.iterator();
                for (option o : optList) {
        //            o = i.next();
   //                 iterJson = (JSONObject) o;


                    if (o.getOption().equals(choice)) {
                        choice = o.getAction();

                        switch (choice) {
                            case "80":
                                showScene();
                                break;
                            case "81":
                                ShowInventory();
                                break;
                            case "82":
                                ShowMap();
                                break;
                            case "01":
                            case "07":
                            case "13":
                            case "19":
                            case "25":
                            case "02":
                            case "08":
                            case "14":
                            case "20":
                            case "00":
                            case "03":
                            case "09":
                            case "15":
                            case "21":
                            case "04":
                            case "10":
                            case "16":
                            case "22":
                            case "05":
                            case "11":
                            case "17":
                            case "23":
                            case "06":
                            case "12":
                            case "18":
                            case "24":
                                return choice;
                            default:
                                System.out.println("Can't get what you want...\nAre you sure there is such an option????");
                        }
                    }
                }
            } catch (NullPointerException e) {
                System.err.println("Can't get what you want...");
            }
        }
    }


    public static void ClearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void ShowMap() {
        System.out.println("Showing map now!!!");
    }

    public static void ShowInventory() {
        System.out.println("Showing inventory now!!!");
    }


}
