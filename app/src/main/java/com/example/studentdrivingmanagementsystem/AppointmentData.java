package com.example.studentdrivingmanagementsystem;

class AppointmentData {
    private String dateBtnapp;

    AppointmentData() {

    }

    public AppointmentData(String dateBtnapp) {
        // this.id=id;
        this.dateBtnapp = dateBtnapp;
       //this.btnDatePicker=btnDatePicker;
    }


    /*
     public String getId() {
         return id;
     }
     */
    public String dateBtnapp() {
        return dateBtnapp;
    }

//
//    public String btnDatePicker() {
//        return btnDatePicker;
//    }
}