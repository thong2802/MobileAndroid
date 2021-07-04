package com.example.gridview_nangcao;

public class DataModel_Quocgia {
    private String nameCountry;
    private int imageQuocki;

    public DataModel_Quocgia(String nameCountry, int imageQuocki) {
        this.nameCountry = nameCountry;
        this.imageQuocki = imageQuocki;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public int getImageQuocki() {
        return imageQuocki;
    }

    public void setImageQuocki(int imageQuocki) {
        this.imageQuocki = imageQuocki;
    }
}
