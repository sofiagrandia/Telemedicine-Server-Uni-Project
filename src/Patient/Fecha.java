/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;
import java.io.Serializable;

public class Fecha implements Serializable{
    private int day;
    private int month;
    private int year;
    private int hour;
    private int min;
    
    public Fecha(){
        this.day=0;
        this.month=0;
        this.year=0;
        this.hour=0;
        this.min=0;
    }
    
    public Fecha(int day, int month, int year,int hour,int min){
        this.day=day;
        this.month=month;
        this.year=year;
        this.hour=hour;
        this.min=min;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        return "Date: " + "day=" + day + ", month=" + month + ", year=" + year + ", hour=" + hour + ", min=" + min + '\n';
    }
    
    
    
    
    
}
