/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import DataLoading.jdbcConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mayankkasturia
 */
public class insertData {
   
    public static void insertQuery(String bidList,ArrayList<String> cat,ArrayList<String> subCat,String city,String state,String bName,Float star) throws SQLException, IOException {
        
        String url="jdbc:oracle:thin:@localhost:1523:orcl123";
        String uname="sys as sysdba";
        String password="Mansimalik2402";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try (Connection con = DriverManager.getConnection(url,uname,password)) {
                    String id=bidList;
                    String b_name=bName;
                    String b_city=city;
                    String b_state=state;
                    Float b_star=star;
                    String queryInfo="insert into B_INFO values(?,?,?,?,?)";
                    PreparedStatement stm1 = con.prepareStatement(queryInfo);
                        stm1.setString(1, id);
                        stm1.setString(2, b_name);
                        stm1.setString(3, b_city);
                        stm1.setString(4, b_state);
                        stm1.setFloat(5, b_star);
                        stm1.executeUpdate();
                    
                    
                for(int i=0;i<cat.size();i++){
                    String b_id= bidList;
                    //System.out.println(b_id);
                    String category=cat.get(i);
                    //System.out.println(category);
                    String query ="insert into B_CAT values(?,?)";
                    try (PreparedStatement stm = con.prepareStatement(query)) {
                        stm.setString(1, b_id);
                        stm.setString(2, category);
                        stm.executeUpdate();
                    }
}
                for(int j=0;j<cat.size();j++){
                    for(int k=0;k<subCat.size();k++){
                    String b_id= bidList;
                    //System.out.println(b_id);
                    String category=cat.get(j);
                    String Subcategory=subCat.get(k);
                    //System.out.println(category);
                    String query ="insert into B_SUBCAT values(?,?,?)";
                    try (PreparedStatement stm = con.prepareStatement(query)) {
                        stm.setString(3, b_id);
                        stm.setString(1, category);
                        stm.setString(2, Subcategory);
                        stm.executeUpdate();
                    }
}}
                
            }}

            
            catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}