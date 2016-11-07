/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import DataLoading.createDrop;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                //insertUserData.insertUserQuery(userList, name, reviewCount, avgStar, yelpingSince, number_frinds);
                
                String url="jdbc:oracle:thin:@localhost:1523:orcl123";
        String uname="sys as sysdba";
        String password="Mansimalik2402";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(url,uname,password)) {
              
                Date date1=yelpingSince;
                java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                int count=0;
                String query ="insert into B_USER values(?,?,?,?,?,?)";
                try (PreparedStatement stm = con.prepareStatement(query)) {
                    //((OraclePreparedStatement)stm).setExecuteBatch (3000);
                    stm.setString(1, userList);
                    stm.setString(2, name);
                    stm.setInt(3, reviewCount);
                    stm.setDouble(4, avgStar);
                    stm.setDate(5, sqlDate);
                    stm.setInt(6, number_frinds);
                    stm.executeUpdate();
                    stm.addBatch();
                    count++;
                    if(count % 100==0){
                    stm.executeBatch();
                    con.commit();
                    stm.clearBatch();
                    
                
                }
                con.commit();
                stm.close();
               
                }
                
            }

            
            }catch (ClassNotFoundException ex) {
            Logger.getLogger(createDrop.class.getName()).log(Level.SEVERE, null, ex);
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

    }
}
