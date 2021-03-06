/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DTOS.User;
import static Utils.Connector.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ihtng
 */
public class UserDAO {
    public boolean login(User user) {
        Connection con = Connector();
        try {
            String sql = "SELECT * FROM tblUser WHERE Username = ? AND Password = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, user.getUsername());
            pre.setString(2, user.getPassword());

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                if (rs.getString("Username").equals(user.getUsername()) && rs.getString("Password").equals(user.getPassword())) {
                    con.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean addUser(User user) {
        Connection con = Connector();
        try {
            String sql = "INSERT INTO tblUser VALUES (?, ?, ?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, user.getuID());
            pre.setString(2, user.getUsername());
            pre.setString(3, user.getPassword());
            pre.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public  boolean searchUser(String username) {
        Connection con = Connector();
        try {
            String sql = "SELECT * FROM tblUser WHERE Username = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                con.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
