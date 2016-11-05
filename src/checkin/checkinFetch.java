/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mayankkasturia
 */
public class checkinFetch {

    public static void checkinTable() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException, java.text.ParseException {
        ArrayList<JSONObject> json = new ArrayList<JSONObject>();
        String bidList = null;
        int in = 0;
        //String in=null;
        String mint = "00";
        String two;
        String[] split2;
        String day;
        String value = null;
        String weekDay = null;
        JSONObject obj;
        // The name of the file to open.
        String fileName = "C:\\Users\\Mayankkasturia\\Downloads\\fall 2016\\DataBase\\assignments\\yelpdatabase\\YelpDataset-CptS451\\yelp_checkin.json";
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
                JSONObject time = (JSONObject) obj.get("checkin_info");
                Set timeSet = time.entrySet();
                Iterator itr = timeSet.iterator();
                while (itr.hasNext()) {
                    //System.out.println(itr.next().toString());
                    String s = itr.next().toString();
                    String[] split1 = s.split("-");
                    in = Integer.parseInt(split1[0]);
                    //in=split1[0];
                    two = split1[1];
                    split2 = two.split("=");
                    day = split2[0];
                    value = split2[1];
                    weekDay = null;

//                System.out.println(startDate);
                    if (day.equalsIgnoreCase("0")) {
                        weekDay = "Sunday";
                    }
                    if (day.equalsIgnoreCase("1")) {
                        weekDay = "Monday";
                    }
                    if (day.equalsIgnoreCase("2")) {
                        weekDay = "Tuesday";
                    }
                    if (day.equalsIgnoreCase("3")) {
                        weekDay = "Wednesday";
                    }
                    if (day.equalsIgnoreCase("4")) {
                        weekDay = "Thursday";
                    }
                    if (day.equalsIgnoreCase("5")) {
                        weekDay = "Friday";
                    }
                    if (day.equalsIgnoreCase("6")) {
                        weekDay = "Saturday";
                    }
//                    SimpleDateFormat ft = new SimpleDateFormat ("E, HH:mm:ss"); 
                    //String a= weekDay+", "+in+":"+mint+":"+mint;
//                    //System.out.println(a);
//                    Date date = ft.parse(a);
//                    //System.out.println(date);
                    //System.out.println(ft.format(date));
//                    Date t=ft.format(null)
//                    
//                    
//                    
//                    //DateFormat df = new SimpleDateFormat("hh:mm");
//                    //Date startDate = df.parse(in);
//                    System.out.println("Checkin @ "+t+" on "+weekDay+" value = "+value  );
                    insertCheckinData.insertCheckinQuery(bidList, in, weekDay, value);
                }

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
