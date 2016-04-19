package com.oz.travelmeter;

/**
 * Created by champa on 1/12/2016.
 */
public class Contact {
    String location;
    String stay;
    String doing;
    String date;
    String time;

    public Contact(String location, String stay, String doing, String date, String time) {

        this.location=location;
        this.stay=stay;
        this.doing=doing;
        this.date=date;
        this.time=time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStay() {
        return stay;
    }

    public void setStay(String stay) {
        this.stay = stay;
    }

    public String getDoing() {
        return doing;
    }

    public void setDoing(String doing) {
        this.doing = doing;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
