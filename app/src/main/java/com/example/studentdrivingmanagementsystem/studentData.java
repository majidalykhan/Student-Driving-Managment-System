package com.example.studentdrivingmanagementsystem;

public class studentData {

    private String no, name, address, postal, email, mobile, licenseNo, medical, reference, note, date;

    studentData(){

    }

    public studentData(String no, String name, String address, String postal, String email,
                       String mobile, String licenseNo, String medical, String reference,
                       String note, String date) {
        this.no = no;
        this.name = name;
        this.address = address;
        this.postal = postal;
        this.email = email;
        this.mobile = mobile;
        this.licenseNo = licenseNo;
        this.medical = medical;
        this.reference = reference;
        this.note = note;
        this.date = date;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPostal() {
        return postal;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public String getMedical() {
        return medical;
    }

    public String getReference() {
        return reference;
    }

    public String getNote() {
        return note;
    }

    public String getDate() {
        return date;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
