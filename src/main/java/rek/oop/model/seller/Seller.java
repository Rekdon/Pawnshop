package rek.oop.model.seller;

import rek.oop.model.check.Check;

/**
 * Created by Rekdon on 27.03.2017.
 */
public class Seller {
    private int id;
    private String fullName;
    private int sallary;
    private int workExperience;

    public Seller(int id, String fullName, int sallary, int workExperience) {
        this.id = id;
        this.fullName = fullName;
        this.sallary = sallary;
        this.workExperience = workExperience;
    }

    public Seller() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSallary() {
        return sallary;
    }

    public void setSallary(int sallary) {
        this.sallary = sallary;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }


    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", sallary=" + sallary +
                ", workExperience=" + workExperience +
                '}';
    }
}

