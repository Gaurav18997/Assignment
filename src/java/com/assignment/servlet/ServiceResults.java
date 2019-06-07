
package com.assignment.servlet;
//Basic POJO 
public class ServiceResults{

    private String Name;
    private String Lowest_price;
    private String Rating;
    private String Max_speed;
    private String Description;
    private String Contact_no;
    private String Email;
    private String Image;
    private String Url;

    public ServiceResults(String Name, String Lowest_price){
        this.Name= Name;
        this.Lowest_price= Lowest_price;
    }
    
    
    public ServiceResults(){}
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLowest_price() {
        return Lowest_price;
    }

    public void setLowest_price(String Lowest_price) {
        this.Lowest_price = Lowest_price;
    }
    public String getRating() {
        return Rating;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }

    public String getMax_speed() {
        return Max_speed;
    }

    public void setMax_speed(String Max_speed) {
        this.Max_speed = Max_speed;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String Contact_no) {
        this.Contact_no = Contact_no;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

}
