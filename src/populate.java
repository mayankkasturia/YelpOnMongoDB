

import DataLoading.jdbcConnection;
import business.businessFetch;
import checkin.checkinFetch;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import review.reviewFetch;
import user.userFetch;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mayankkasturia
 */
public class populate {

    public static void main(String[] args) throws SQLException, IOException, FileNotFoundException, ClassNotFoundException, ParseException {

//       businessFetch.businessTable();
//       checkinFetch.checkinTable();
//       jdbcConnection.query();
//       reviewFetch.reviewTable();
        userFetch.userTable();
    }
}
