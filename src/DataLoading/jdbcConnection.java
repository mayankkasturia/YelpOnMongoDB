/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLoading;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayankkasturia
 */
public class jdbcConnection {

    public static void query() throws SQLException {
        String url="jdbc:oracle:thin:@localhost:1523:orcl123";
        String uname="sys as sysdba";
        String password="Mansimalik2402";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection(url,uname,password)                                                                                                                                                                                                                                                                                                                                                 ;
            Statement stm = con.createStatement();
            String query="select distinct b_category from b_cat";
            ResultSet result = stm.executeQuery(query);
            ResultSetMetaData rsmd = result.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (result.next()) {
//                String name = result.getString("FIRST_NAME");
//                System.out.println(name);
                for (int i = 1; i <= columnCount; i++) {
                   System.out.print(result.getString(i)+"\t\t");
                   if(i==columnCount) {System.out.println();}
                }
            }
            stm.close();
            con.close();

            
            }catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
