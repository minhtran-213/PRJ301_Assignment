/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DTOS.Brand;
import Utils.Connector;
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
public class BrandDAO {
    public ArrayList<Brand> getAll() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql="SELECT * FROM tblBrand";
        
        ArrayList<Brand> lst = new ArrayList<>();
        try{
            con = Connector();
            if(con!=null){
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    String id = rs.getString("BrandID");
                    String name = rs.getString("BrandName");
                    
                    Brand b = new Brand(id, name);
                    lst.add(b);
                }
            }
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(rs!=null){
                rs.close();
            }
        }
        return lst;
    }
}
