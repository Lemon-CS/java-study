package com.lemon.pojo;

import org.springframework.data.redis.core.index.Indexed;

public class Address {

    @Indexed
    private String city; //城市
    @Indexed
    private String country; //国家

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
