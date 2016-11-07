/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

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
public class insertUserData {
    public static void insertUserQuery(String userList,String name,int reviewCount,double avgStar,Date yelpingSince,int numberFrinds) throws SQLException, IOException {
        //System.out.println(bidList);
        //System.out.println("Checkin @ "+in+" Checkout @ "+checkout+" on "+weekDay+" value = "+value  );
        String url="jdbc:oracle:thin:@localhost:1523:orcl123";
        String uname="sys as sysdba";
        String password="Mansimalik2402";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(url,uname,password)) {
              
                Date date1=yelpingSince;
                java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
                
                String query ="insert into B_USER values(?,?,?,?,?,?)";
                try (PreparedStatement stm = con.prepareStatement(query)) {
                    ((OraclePreparedStatement)stm).setExecuteBatch (3000);
                    stm.setString(1, userList);
                    stm.setString(2, name);
                    stm.setInt(3, reviewCount);
                    stm.setDouble(4, avgStar);
                    stm.setDate(5, sqlDate);
                    stm.setInt(6, numberFrinds);
                    stm.executeUpdate();
                }
            }

            
            }catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
