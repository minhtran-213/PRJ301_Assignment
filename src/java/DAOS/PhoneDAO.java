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
    
    
    
}
