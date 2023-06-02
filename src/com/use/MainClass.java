package com.use;
import org.json.simple.parser.JSONParser;

import java.util.jar.JarEntry;

public class MainClass {
    public static void main(String[] args) {
        try {
            UseManagement useManagement=new UseManagement();
            useManagement.readUserFromAPI();
//            useManagement.addUserFromAPI();
        }catch (Exception e ){
            System.out.println(e.getMessage());

        }
    }
}
