/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mayankkasturia
 */
public class businessFetch {

    public static void businessTable() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
        ArrayList<JSONObject> json = new ArrayList<JSONObject>();
        String bidList = null;
        String city=null;
        String state=null;
        String bName=null;
        float star;
        JSONObject obj;
        // The name of the file to open.
        String fileName = "C:\\Users\\Mayankkasturia\\Downloads\\fall 2016\\DataBase\\assignments\\yelpdatabase\\YelpDataset-CptS451\\yelp_business.json";
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                obj = (JSONObject) new JSONParser().parse(line);
                json.add(obj);
                //System.out.println((String) obj.get("business_id"));
                bidList = obj.get("business_id").toString();
                city=obj.get("city").toString();;
                state=obj.get("state").toString();;
                bName=obj.get("name").toString();;
                star=Float.parseFloat(obj.get("stars").toString());;
                //String key;
                ArrayList<String> cat = new ArrayList<String>();
                ArrayList<String> subCat = new ArrayList<String>();
                JSONArray slideContent = (JSONArray) obj.get("categories");
                Iterator i = slideContent.iterator();

                while (i.hasNext()) {
                    String key = i.next().toString();
                    if (key.equalsIgnoreCase("active life") || key.equalsIgnoreCase("arts & entertainment") || key.equalsIgnoreCase("automotive")
                            || key.equalsIgnoreCase("car rental") || key.equalsIgnoreCase("cafes") || key.equalsIgnoreCase("beauty & spas")
                            || key.equalsIgnoreCase("convenience stores") || key.equalsIgnoreCase("dentists") || key.equalsIgnoreCase("doctors")
                            || key.equalsIgnoreCase("drugstores") || key.equalsIgnoreCase("department stores") || key.equalsIgnoreCase("education")
                            || key.equalsIgnoreCase("event planning & services") || key.equalsIgnoreCase("flowers & gifts") || key.equalsIgnoreCase("food")
                            || key.equalsIgnoreCase("health & medical") || key.equalsIgnoreCase("home services") || key.equalsIgnoreCase("home & garden")
                            || key.equalsIgnoreCase("hospitals") || key.equalsIgnoreCase("hotels & travel") || key.equalsIgnoreCase("hardware stores")
                            || key.equalsIgnoreCase("grocery") || key.equalsIgnoreCase("medical centers") || key.equalsIgnoreCase("nurseries & gardening")
                            || key.equalsIgnoreCase("nightlife") || key.equalsIgnoreCase("restaurants") || key.equalsIgnoreCase("shopping")
                            || key.equalsIgnoreCase("transportation")) {
                        cat.add(key);
                        //System.out.println("I am a Category : "+key);
                    } else {
                        subCat.add(key);
                        //System.out.println("I am a SubCategory : "+key);
                    }
                    //System.out.println(i.next());
                }
                insertData.insertQuery(bidList,cat,subCat,city,state,bName,star);
                
            }
            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");
            // Or we could just do this: 
            // ex.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //return business;
    }

}
