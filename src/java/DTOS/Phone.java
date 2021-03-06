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
public class Phone {
    private String PhoneID;
    private String PhoneName;
    private String Description;
    private String BrandID;
    private String ImageURL;
    private double price;

    public Phone() {
    }
    
    public Phone(String PhoneID, String PhoneName, String Description, String BrandID, String ImageURL, double price) {
        this.PhoneID = PhoneID;
        this.PhoneName = PhoneName;
        this.Description = Description;
        this.BrandID = BrandID;
        this.ImageURL = ImageURL;
        this.price = price;
    }
    
    public String getPhoneID() {
        return PhoneID;
    }

    public void setPhoneID(String PhoneID) {
        this.PhoneID = PhoneID;
    }

    public String getPhoneName() {
        return PhoneName;
    }

    public void setPhoneName(String PhoneName) {
        this.PhoneName = PhoneName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String BrandID) {
        this.BrandID = BrandID;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
