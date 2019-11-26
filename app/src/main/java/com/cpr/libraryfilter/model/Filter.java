package com.cpr.libraryfilter.model;

public class Filter {
    private String nameFilter;
    private String config;
    private int imageFilter;

    public Filter(String nameFilter, String config, int imageFilter) {
        this.nameFilter = nameFilter;
        this.imageFilter = imageFilter;
        this.config = config;
    }

    public String getConfig() {
        return config;
    }
    public void setConfig(String config){
        this.config = config;
    }

    public String getNameFilter() {
        return nameFilter;
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    public int getImageFilter() {
        return imageFilter;
    }

    public void setImageFilter(int imageFilter) {
        this.imageFilter = imageFilter;
    }
}
