/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DTOS.Phone;
import static Utils.Connector.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhoneDAO {
    
    public ArrayList<Phone> getAllPhone() throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql="SELECT * FROM tblPhone";
        
        ArrayList<Phone> lst = new ArrayList<>();
        try{
            con = Connector();
            if(con!=null){
                pstm = con.prepareStatement(sql);
                rs = pstm.executeQuery();
                while(rs.next())
                {
                    String id = rs.getString("PhoneID");
                    String name = rs.getString("PhoneName");
                    String desc = rs.getString("Description");
                    String brand = rs.getString("BrandID");
                    String url = rs.getString("ImageURL");
                    double price = rs.getDouble("Price");
                    
                    Phone p = new Phone(id, name, desc, brand, url, price);
                    lst.add(p);         
                }
            }
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(pstm!=null){
                pstm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return lst;    
    }
    
    public boolean addPhone(Phone p) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "INSERT INTO tblPhone(PhoneID, "
                + "PhoneName, Description, BrandID, ImageURL, Price)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        
        try{
            con = Connector();
            if(con!=null){
                pstm = con.prepareStatement(sql);
                
                pstm.setString(1, p.getPhoneID());
                pstm.setString(2, p.getPhoneName());
                pstm.setString(3, p.getDescription());
                pstm.setString(4, p.getBrandID());
                pstm.setString(5, p.getImageURL());
                pstm.setDouble(6, p.getPrice());
                
                pstm.executeUpdate();
                
                return true;
            }
            
        }
        finally{
            if(con!=null){
                con.close();
            }
            if(pstm!=null){
                pstm.close();
            }
            if(rs!=null){
                rs.close();
            }
        }
        return false;
    }
    
    public Phone getPhonebyID(String pid) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM tblPhone WHERE PhoneID=?";
        try{
            con =Connector();
            if(con!=null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, pid);
                rs = pstm.executeQuery();
                
                if(rs.next()){
                    String id = rs.getString("PhoneID");
                    String name = rs.getString("PhoneName");
                    String desc = rs.getString("Description");
                    String brand = rs.getString("BrandID");
                    String url = rs.getString("ImageURL");
                    Double price = rs.getDouble("Price");
                    
                    Phone p = new Phone(pid, name, desc, brand, url, price);
                    
                    return p;
                    
                }
                
            }
        }
        finally{
            if(con!=null){
                con.close();
            }
            if(pstm!=null){
                pstm.close();
            }
            if(rs!=null){
                rs.close();
            }
        }
        return null;
    }
    
    public boolean deletePhone(String id) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        
        String sql="DELETE FROM tblPhone WHERE PhoneID=?";
        try{
            con = Connector();
            if(con!=null){
                pstm = con.prepareStatement(sql);
                pstm.setString(1, id);
                
                pstm.executeUpdate();
                return true;
            }
        }
        finally{
            if(con!=null){
                con.close();
            }
            if(pstm!=null){
                pstm.close();
            }
        }
        return false;
    }
    
    public boolean updatePhone(Phone p) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        
        String sql = "UPDATE tblPhone SET PhoneName=?, Description=?,"
                +"BrandID=?, imageURL=?, Price=? WHERE PhoneID=?";
        
        try{
            con = Connector();
            if(con!=null){
                pstm = con.prepareStatement(sql);
                
                pstm.setString(1, p.getPhoneName());
                pstm.setString(2, p.getDescription());
                pstm.setString(3, p.getBrandID());
                pstm.setString(4, p.getImageURL());
                pstm.setDouble(5, p.getPrice());
                pstm.setString(6, p.getPhoneID());
                
                pstm.executeUpdate();
                return true;
            }
        }
        finally{
            if(con!=null){
                con.close();
            }
            if(pstm!=null){
                pstm.close();
            }
        }
        return false;
    }
    
}
