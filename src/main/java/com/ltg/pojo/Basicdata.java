package com.ltg.pojo;

import java.io.Serializable;
import java.util.Date;

public class Basicdata implements Serializable {
    private Integer id;
    private Integer sid;
    private String firstName;
    private String lastName;
    private String eMail;
    private Character gender;
    private Integer age;
    private Boolean member;
    private Float chineseScore;
    private Float mathScore;
    private Float englishScore;
    private Float politicalScore;
    private Float totalScore;
    private String ipAddress;
    private String address;
    private String contactPhone;
    private Date joinDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMember() {
        return member;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    public Float getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(Float chineseScore) {
        this.chineseScore = chineseScore;
    }

    public Float getMathScore() {
        return mathScore;
    }

    public void setMathScore(Float mathScore) {
        this.mathScore = mathScore;
    }

    public Float getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Float englishScore) {
        this.englishScore = englishScore;
    }

    public Float getPoliticalScore() {
        return politicalScore;
    }

    public void setPoliticalScore(Float politicalScore) {
        this.politicalScore = politicalScore;
    }

    public Float getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Float totalScore) {
        this.totalScore = totalScore;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Basicdata() {
    }

    public Basicdata(Integer id, Integer sid, String firstName, String lastName, String eMail, Character gender, Integer age, Boolean member, Float chineseScore, Float mathScore, Float englishScore, Float politicalScore, Float totalScore, String ipAddress, String address, String contactPhone, Date joinDate) {
        this.id = id;
        this.sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.gender = gender;
        this.age = age;
        this.member = member;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.politicalScore = politicalScore;
        this.totalScore = totalScore;
        this.ipAddress = ipAddress;
        this.address = address;
        this.contactPhone = contactPhone;
        this.joinDate = joinDate;
    }

    public Basicdata(Integer sid, String firstName, String lastName, String eMail, Character gender, Integer age, Boolean member, Float chineseScore, Float mathScore, Float englishScore, Float politicalScore, Float totalScore, String ipAddress, String address, String contactPhone, Date joinDate) {
        this.sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.gender = gender;
        this.age = age;
        this.member = member;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.politicalScore = politicalScore;
        this.totalScore = totalScore;
        this.ipAddress = ipAddress;
        this.address = address;
        this.contactPhone = contactPhone;
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "Basicdata{" +
                "id=" + id +
                ", sid=" + sid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", member=" + member +
                ", chineseScore=" + chineseScore +
                ", mathScore=" + mathScore +
                ", englishScore=" + englishScore +
                ", politicalScore=" + politicalScore +
                ", totalScore=" + totalScore +
                ", ipAddress='" + ipAddress + '\'' +
                ", address='" + address + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}