package com.use;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UseManagement {
    public  void readUserFromAPI() throws  Exception{
        UseController useController=new UseController();
        try {
            String apiURL="https://jsonplaceholder.typicode.com/posts";
            URL url=new URL(apiURL);

            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response=new StringBuilder();
            String line;
            while ((line= reader.readLine())!=null){
                response.append(line);
            }
            reader.close();



            org.json.JSONArray jsonArray=new org.json.JSONArray(response.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                org.json.JSONObject product=(org.json.JSONObject)jsonArray.get(i);

                Post newPost = new Post(
                        Integer.parseInt(product.get("id").toString()),
                        Integer.parseInt(product.get("userId").toString()),
                        product.get("title").toString(),
                        product.get("body").toString()

                );

                System.out.println("Inserting.......");
                useController.insertNewPost(newPost);
//                int userId=Integer.parseInt(product.get("userId").toString());
//                int id=Integer.parseInt(product.get("id").toString());
//                String title=product.get("title").toString();
//                String body=product.get("body").toString();
//
////                System.out.println(userId+","+id+","+title+","+body);

            }
            conn.disconnect();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void readJsonUse() throws Exception{
        try {
            JSONParser jsonParser=new JSONParser();
            Object obj=jsonParser.parse(new FileReader("Use"));

            JSONObject jsonObject=(JSONObject) obj;
            Use use=new Use();

            int userId= Integer.parseInt(jsonObject.get("userId").toString());
            int id=Integer.parseInt(jsonObject.get("id").toString());
            String title=jsonObject.get("title").toString();
            String body=jsonObject.get("body").toString();

            use.setUserId(userId);
            use.setId(id);
            use.setTitle(title);
            use.setBody(body);


        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}
