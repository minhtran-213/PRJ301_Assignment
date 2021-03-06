/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ihtng
 */
public class Connector {

    public static Connection Connector() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String username = "minh";
            String password = "minh";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=SE1502_Assignment_Groupxx";
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }
}
