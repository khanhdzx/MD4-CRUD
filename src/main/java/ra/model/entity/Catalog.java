package ra.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Catalog {
    private int catalogId;
    private String catalogName;
    private int age;
    private boolean sex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    private String address;
    private boolean catalogStatus;

    public Catalog() {
    }


    public Catalog(int catalogId, String catalogName, int age, boolean sex, Date birthDate, String address, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.age = age;
        this.sex = sex;
        this.birthDate = birthDate;
        this.address = address;
        this.catalogStatus = catalogStatus;
    }

    public Catalog(String catalogName, int age, boolean sex, String address, Date birthDate, boolean catalogStatus) {
        this.catalogName = catalogName;
        this.age = age;
        this.sex = sex;
        this.birthDate = birthDate;
        this.address = address;
        this.catalogStatus = catalogStatus;
    }


    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", catalogStatus=" + catalogStatus +
                '}';
    }
}
