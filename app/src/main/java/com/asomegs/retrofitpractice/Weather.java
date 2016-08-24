package com.asomegs.retrofitpractice;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Gyeongsik Kim on 2016-08-24.
 */
public class Weather {
    private double temp;
    private double pressure;
    private double humidity;
    private double temp_min;
    private double temp_max;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    @Override
    public String toString() {
        return "[temp = " + temp + ", pressure = " + pressure + ", humidity = " + humidity + ", temp_min = " + temp_min + ", temp_max = "+ temp_max + "]";
    }
}
