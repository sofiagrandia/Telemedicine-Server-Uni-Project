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

    
    public Fecha(){
        this.day=0;
        this.month=0;
        this.year=0;
       
    }
    
 
    public Fecha(int day, int month, int year){
        this.day=day;
        this.month=month;
        this.year=year;
        
    }

public Fecha(String day, String month, String year){
        this.day= Integer.parseInt(day);
        this.month=Integer.parseInt(month);
        this.year=Integer.parseInt(year);
       
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

    
    public static Fecha setFechaComp(int day, int month, int year){
        Fecha f = new Fecha (day, month, year);
        return f;
    }
    
   
    
    @Override
    public String toString() {
        return "Date: " + "day=" + day + ", month=" + month + ", year=" + year +  '\n';
    }
    
    
    
    
    
}
