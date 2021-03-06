/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author Admin
 */
public class Brand {
    private String BrandID;
    private String BrandName;

    public Brand(String BrandID, String BrandName) {
        this.BrandID=BrandID;
        this.BrandName=BrandName;
    }
    
    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }
    
    
    
}
