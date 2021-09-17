package com.barmej.interactiveapp;

public class PlaceActivity {
    int idDrawable;
    int idNameDrawable;

    public PlaceActivity(int idDrawable, int nameDrawable) {
        this.idDrawable = idDrawable;
        this.idNameDrawable = nameDrawable;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getIdNameDrawable() {
        return idNameDrawable;
    }
}
