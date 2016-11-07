/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import review.insertReviewData;

/**
 *
 * @author Mayankkasturia
 */
public class userFetch {
    public static void userTable() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException, java.text.ParseException {
        ArrayList<JSONObject> json = new ArrayList<JSONObject>();
        String userList = null;
        String date = null;
        String name=null;
        double avgStar = 0.0;
        int reviewCount = 0;
        int number_frinds=0;
//        String weekDay = null;
        JSONObject obj;
        // The name of the file to open.
        String fileName = "C:\\Users\\Mayankkasturia\\Downloads\\fall 2016\\DataBase\\assignments\\yelpdatabase\\YelpDataset-CptS451\\yelp_user.json";
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
                userList = obj.get("user_id").toString();
                date = obj.get("yelping_since").toString();
                name = obj.get("name").toString();
                reviewCount = Integer.parseInt(obj.get("review_count").toString());
                avgStar = Double.parseDouble(obj.get("average_stars").toString());
                DateFormat df = new SimpleDateFormat("yyyy-MM");
                Date yelpingSince = df.parse(date);
                //System.out.println(startDate);
                JSONArray frindsList = (JSONArray) obj.get("friends");
                number_frinds= frindsList.size();
                
                //System.out.println("Business_id is "+bidList+" user_id is "+userList+" review_id "+reviewList+" stars = "+stars+" on "+startDate+" votes is "+totalVotes  );
                insertUserData.insertUserQuery(userList, name, reviewCount, avgStar, yelpingSince, number_frinds);

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

    }
}
