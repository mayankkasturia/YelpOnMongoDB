/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package review;

import checkin.insertCheckinData;
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
public class reviewFetch {

    public static void reviewTable() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException, java.text.ParseException {
        ArrayList<JSONObject> json = new ArrayList<JSONObject>();
        String bidList = null;
        String userList = null;
        String reviewList = null;
        String review=null;
        int stars = 0;
        String date = null;
        int funny = 0;
        int useful = 0;
        int cool = 0;
        int totalVotes = 0;
//        String weekDay = null;
        JSONObject obj;
        // The name of the file to open.
        String fileName = "C:\\Users\\Mayankkasturia\\Downloads\\fall 2016\\DataBase\\assignments\\yelpdatabase\\YelpDataset-CptS451\\yelp_review.json";
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
                userList = obj.get("user_id").toString();
                reviewList = obj.get("review_id").toString();
                review=obj.get("text").toString();
                stars = Integer.parseInt(obj.get("stars").toString());
                date = obj.get("date").toString();
                //System.out.println(date);
//              Date dNow = new Date();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = df.parse(date);
                //System.out.println(startDate);
                JSONObject votes = (JSONObject) obj.get("votes");
                funny = Integer.parseInt(votes.get("funny").toString());
                useful = Integer.parseInt(votes.get("useful").toString());
                cool = Integer.parseInt(votes.get("cool").toString());
                totalVotes = funny + useful + cool;
                //System.out.println("Business_id is "+bidList+" user_id is "+userList+" review_id "+reviewList+" stars = "+stars+" on "+startDate+" votes is "+totalVotes  );
                insertReviewData.insertReviewQuery(bidList, userList, reviewList, stars, startDate, totalVotes,review);

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
