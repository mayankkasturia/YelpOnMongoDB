/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkin;

import DataLoading.jdbcConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author Mayankkasturia
 */
public class insertCheckinData {
    public static void insertCheckinQuery(String bidList,int in,String weekDay,String value) throws SQLException, IOException {
        //System.out.println(bidList+" Checkin @ "+in+" on "+weekDay+" value = "+value  );
        String url="jdbc:oracle:thin:@localhost:1523:orcl123";
        String uname="sys as sysdba";
        String password="Mansimalik2402";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(url,uname,password)) {
                String b_id= bidList;
                //Date checkintime=in;
                //String checkin=in;
                //Timestamp checkin = Timestamp.valueOf(in);
                String day= weekDay;
                String number_checkin= value;
                java.sql.Timestamp sqltime = new java.sql.Timestamp(0,0,0,in,0,0,0);
                String query ="insert into B_CHECKIN values(?,?,?,?)";
                try (PreparedStatement stm = con.prepareStatement(query)) {
                    ((OraclePreparedStatement)stm).setExecuteBatch (30000);
                    stm.setString(1, b_id);
                    stm.setTimestamp(2, sqltime);
                    //stm.setInt(3, checkouttime);
                    stm.setString(3, day);
                    stm.setString(4, number_checkin);
                    stm.executeUpdate();
                }
            }

            
            }catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
