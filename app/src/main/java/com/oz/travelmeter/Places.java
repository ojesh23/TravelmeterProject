package com.oz.travelmeter;

/**
 * Created by Ojesh on 1/5/2016.
 */
public class Places {
    private int _id;
    private String _placesname;

    public Places(String placesname) {

        this._placesname = placesname;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_placesname(String _placesname) {
        this._placesname = _placesname;
    }

    public int get_id() {
        return _id;
    }

    public String get_placesname() {
        return _placesname;
    }
}
