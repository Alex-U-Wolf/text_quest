/**
 * @author : AlexV
 * @since : 04.01.2022, вт
 **/
//Singletone
//single scene with text, image and actions. Load data from list
package src.main.java;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.ListIterator;

public class scene {
    private String ID;
    private String type;
    private String text;
    private List<option> optList = new ArrayList<>();

    private static final scene instance = new scene();
    JSONParser parser = new JSONParser();

    private scene(){
//        init here
    }

    public static scene getInstance() {
        return instance;
    }


    public void testprint() {
        System.out.println("Test  01");
    }

    public void load(String s) {
        JSONObject iterJson = null;
        optList.clear();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/scenes.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray  jsonArray = (JSONArray) jsonObject.get("scenes");
            ID = "99";
            Iterator i = jsonArray.iterator();
            while (!ID.equals(s)) {
                Object o = i.next();
                iterJson = (JSONObject) o;
                ID=iterJson.get("ID").toString();
            }
            JSONObject jsonSubObject = iterJson;
            ID = jsonSubObject.get("ID").toString();
            type = jsonSubObject.get("Type").toString();
            text = jsonSubObject.get("Text").toString();
            JSONArray  jsonOptArray = (JSONArray) jsonSubObject.get("Options");
            System.out.println("Option0="+jsonSubObject.get("Options").toString());
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


    }

    public void print_test_scene() {
        System.out.print("ID="+ID+" ");
        System.out.print("Type="+type+" ");
        System.out.println("Text="+text);
        for (ListIterator<option> iter = optList.listIterator(); iter.hasNext();) {
            option opt = iter.next();
            System.out.print("Option="+opt.getOption()+" ");
            System.out.print("Text="+opt.getText()+" ");
            System.out.println("Action="+opt.getAction());
        }
        optList.iterator();
    }


    public void showScene() {
//        Runtime.getRuntime().exec("cls");
        ClearConsole();
        System.out.println("Text="+text);
        System.out.println("Ohh, what will you d now?");
        for (ListIterator<option> iter = optList.listIterator(); iter.hasNext();) {
            option opt = iter.next();
            System.out.println(opt.getOption()+" "+opt.getText());
        }

    }

    public String readActions() {
        return "01";
    }


    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
