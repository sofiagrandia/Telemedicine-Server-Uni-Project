/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sofia
 */

//ESTE OBJETO LO PASAMOS AL SOCKET
public class Data implements Serializable {
    private static final long serialVersionUID = 1L;
    public enum SYMPTOMS{NO_SYMPTOMS,BREATHING_DIFFICULTY,BREATHING_WHISTLING,CHEST_PREASSURE,INSMONIA, HEADACHE, OTHERS};
    public enum ACTIVITIES{EXERCISE,WITH_DOG,WITH_CAT,AT_HOME,SLEEPING,WORKING,OTHERS};
    public enum MEDICATION{NO_MEDICATION,RESCUE_INHALER,CONTROL_TREATMENT,ANTIHISTAMINES,IBUPROPHEN,PARACETAMOL,OTHERS};
    private ArrayList<Integer> ECG = new ArrayList();
    private ArrayList<Integer> time = new ArrayList();
    private ArrayList<Integer> ACC = new ArrayList();
    private List<SYMPTOMS>symptoms = new ArrayList();
    private List<ACTIVITIES>activities = new ArrayList();
    private List<MEDICATION>medication = new ArrayList();
    Date date;
    public Data(ArrayList<Integer> ECG, ArrayList<Integer> ACC){
        this.ECG = ECG;
        this.ACC= ACC;
        }
    public ArrayList<Integer> getECG() {
        return ECG;
    }

    public void setECG(ArrayList<Integer> ECG) {
        this.ECG = ECG;
    }
  
    public ArrayList<Integer> getTime() {
        return time;
    }

    public void setTime(ArrayList<Integer> time) {
        this.time = time;
    }

    public ArrayList<Integer> getACC() {
        return ACC;
    }

    public void setACC(ArrayList<Integer> ACC) {
        this.ACC = ACC;
    }

    public List<SYMPTOMS> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<SYMPTOMS> symptoms) {
        this.symptoms = symptoms;
    }
    
    public void addSymptom(SYMPTOMS symptom){
        this.symptoms.add(symptom);
    }
    
    public void deleteSymptom(SYMPTOMS symptom){
        this.symptoms.remove(symptom);
    }
    public List<ACTIVITIES> getActivities() {
        return activities;
    }

    public void setActivities(List<ACTIVITIES> activities) {
        this.activities = activities;
    }
    public void addActivity(ACTIVITIES activity){
        this.activities.add(activity);
    }
    
    public void deleteActivity(ACTIVITIES activity){
        this.activities.remove(activity);
    }
    public List<MEDICATION> getMedication() {
        return medication;
    }

    public void setMedication(List<MEDICATION> medication) {
        this.medication = medication;
    }
    public void addMedication(MEDICATION medication){
        this.medication.add(medication);
    }
    
    public void deleteMedication(MEDICATION symptom){
        this.symptoms.remove(symptom);
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     @Override
    public String toString() {
        return "Data{ " + "symptoms=" + symptoms + ", activities=" + activities + ", medication=" 
                + medication + ", date=" + date + "ECG" + ECG+ "ACC" +ACC+ " }";
    }
    
    
}
