/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import java.io.Serializable;
import Patient.Fecha;

/**
 *
 * @author Sofia
 */

public class Patient implements Serializable {
      private static final long serialVersionUID = 1L;
    
    public enum GENDER{male, female, other}
    private final String id;
    private final String name;
    private final String surname;
    private final Fecha dob;
    private final float weight;
    private final float height;
    private final String asthmaType;
    private final String doctor;

    
    private GENDER gender;
    
    public Patient(String id, String name, String surname, Fecha dob, float weight, float height, String asthmaType, String doctor, GENDER gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.weight = weight;
        this.height = height;
        this.asthmaType = asthmaType;
        this.doctor = doctor;
        
        this.gender = gender;
    }

    public Patient() {
        this.id = "001";
        this.name = "Juana";
        this.surname = "La loca";
        this.dob = Fecha.setFechaComp(0, 0, 0);
        this.weight = 40;
        this.height = 164;
        this.asthmaType = "Severe";
        this.doctor = "McDreamy";
        
        this.gender = gender.other;
    }

    @Override
    public String toString() {
        return "Patient to String{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", weight=" + weight + ", height=" + height + ", asthmaType=" + asthmaType + ", doctor=" + doctor +  ", gender=" + gender + '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Fecha getDob() {
        return dob;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public String getAsthmaType() {
        return asthmaType;
    }

    public String getDoctor() {
        return doctor;
    }

  

    public GENDER getGender() {
        return gender;
    }

   
}
