package rek.oop.model.client;

/**
 * Created by Rekdon on 27.03.2017.
 */
public class Client {
    private int id;
    private int salary;
    private String fullname;
    private String dataOfBirth;
    private String placeOfBirth;
    private String sex;
    private int identificationCode;

    public Client() {
    }

    public Client(int id, int salary, String fullname, String dataOfBirth, String placeOfBirth, String sex, int identificationCode) {
        this.id = id;
        this.salary = salary;
        this.fullname = fullname;
        this.dataOfBirth = dataOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.sex = sex;
        this.identificationCode = identificationCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(String dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(int identificationCode) {
        this.identificationCode = identificationCode;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", salary=" + salary +
                ", fullname='" + fullname + '\'' +
                ", dataOfBirth='" + dataOfBirth + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", sex='" + sex + '\'' +
                ", identificationCode=" + identificationCode +
                '}';
    }
}
