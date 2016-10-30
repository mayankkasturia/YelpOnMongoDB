/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package review;

import DataLoading.jdbcConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author Mayankkasturia
 */
public class insertReviewData {
    public static void insertReviewQuery(String bidList, String userList,String reviewList,int star,Date startDate,int totalVotes,String review) throws SQLException, IOException {
        //System.out.println(bidList);
        //System.out.println("Checkin @ "+in+" Checkout @ "+checkout+" on "+weekDay+" value = "+value  );
        String url="jdbc:oracle:thin:@localhost:1523:orcl123";
        String uname="sys as sysdba";
        String password="Mansimalik2402";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(url,uname,password)) {
                //String b_id= bidList;
                //String u_id= userList;
                //String r_id= reviewList;
                //String reviewName=review;
                //int number_stars=star;
                Date date1=startDate;
                //int number_votes= totalVotes;
                java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                
                String query ="insert into B_REVIEW values(?,?,?,?,?,?,?)";
                try (PreparedStatement stm = con.prepareStatement(query)) {
                    ((OraclePreparedStatement)stm).setExecuteBatch (3000);
                    stm.setString(1, bidList);
                    stm.setString(2, userList);
                    stm.setString(3, reviewList);
                    stm.setInt(4, star);
                    stm.setDate(5, sqlDate);
                    stm.setInt(6, totalVotes);
                    stm.setString(7, review);
                    stm.executeUpdate();
                }
            }

            
            }catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
