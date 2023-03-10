package com.example.lab8;

public class City{

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof City)) {
            return false;
        }

        City c = (City) o;
        return c.getCityName().equals(this.getCityName()) && c.getProvinceName().equals(this.getProvinceName());
    }
}
