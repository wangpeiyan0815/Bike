package com.week.bike.mycity.bean;

/**
 * Created by dell on 2017/1/27.
 */

public class CityBean {
    private String cityName;
    private String nameSort;

    public CityBean() {

    }

    public CityBean(String nameSort, String cityName) {
        this.nameSort = nameSort;
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getNameSort() {
        return nameSort;
    }

    public void setNameSort(String nameSort) {
        this.nameSort = nameSort;
    }
}
