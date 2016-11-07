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
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement stm = con.createStatement();
            //String query="select distinct b_category from b_cat";
            stm.executeQuery("drop table B_CAT");
            System.out.println("Category Table droped");
            stm.executeQuery("CREATE TABLE SYS.B_CAT(B_ID VARCHAR2(50 BYTE) NOT NULL ENABLE, B_CATEGORY VARCHAR2(50 BYTE) NOT NULL ENABLE, \n" 
                               +"PRIMARY KEY (\"B_ID\", \"B_CATEGORY\"))");
            System.out.println("Table B_CAT Created");
            
            stm.executeQuery("drop table B_SUBCAT");
            System.out.println("SubCategory Table droped");
            stm.executeQuery("CREATE TABLE SYS.B_SUBCAT(B_CATEGORY VARCHAR2(50 BYTE) NOT NULL ENABLE, B_SUBCATEGORY VARCHAR2(50 BYTE) NOT NULL ENABLE, \n" 
                               +"B_ID VARCHAR2(50 BYTE) NOT NULL ENABLE)");
            System.out.println("Table B_SUBCAT Created");
            
            stm.executeQuery("drop table B_CHECKIN");
            System.out.println("CHECKIN Table droped");
            stm.executeQuery("CREATE TABLE SYS.B_CHECKIN(B_ID VARCHAR2(50 BYTE) NOT NULL ENABLE, CHECKIN_TIME TIMESTAMP (6) NOT NULL ENABLE, \n "
                    + "CHECKIN_DAY VARCHAR2(20 BYTE) NOT NULL ENABLE, NUMBER_CHECKIN VARCHAR2(10 BYTE), PRIMARY KEY (\"B_ID\", \"CHECKIN_TIME\", \"CHECKIN_DAY\"))");
            System.out.println("Table B_CHECKIN Created");
            
            stm.executeQuery("drop table B_REVIEW");
            System.out.println("REVIEW Table droped");
            stm.executeQuery("CREATE TABLE SYS.B_REVIEW \n"
                    + " (B_ID VARCHAR2(50 BYTE) NOT NULL ENABLE, \n"
                    + "	U_ID VARCHAR2(50 BYTE) NOT NULL ENABLE, \n"
                    + "	R_ID VARCHAR2(50 BYTE) NOT NULL ENABLE, \n"
                    + "	STARS NUMBER, R_DATE DATE NOT NULL ENABLE, VOTES NUMBER, \n"
                    + "	REVIEW CLOB, PRIMARY KEY (\"B_ID\", \"U_ID\", \"R_ID\"))");
            System.out.println("Table B_REVIEW Created");
         
            stm.executeQuery("drop table B_INFO");
            System.out.println("Information Table droped");
            stm.executeQuery("CREATE TABLE SYS.B_INFO \n"
                    + "   (B_ID VARCHAR2(50 BYTE) NOT NULL ENABLE, \n"
                    + "	NAME VARCHAR2(100 BYTE), \n"
                    + "	CITY VARCHAR2(50 BYTE), \n"
                    + "	STATE VARCHAR2(10 BYTE), \n"
                    + "	STARS FLOAT(63), \n"
                    + "	 PRIMARY KEY (\"B_ID\"))");
            System.out.println("Table B_INFO Created");

            stm.executeQuery("drop table B_USER");
            System.out.println("USER Table droped");
            stm.executeQuery("CREATE TABLE SYS.B_USER \n"
                    + "   (	U_ID VARCHAR2(50 BYTE) NOT NULL ENABLE, \n"
                    + "	USER_NAME VARCHAR2(50 BYTE), \n"
                    + "	REVIEW_COUNT NUMBER, \n"
                    + "	AVG_STARS FLOAT(126), \n"
                    + "	YELPING_DATE DATE, \n"
                    + "	NUMBER_FRINDS NUMBER, \n"
                    + "	 PRIMARY KEY (\"U_ID\"))");
            System.out.println("Table B_USER Created");
            stm.close();
            con.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
