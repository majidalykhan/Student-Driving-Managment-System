package com.example.studentdrivingmanagementsystem;

public class ExpenseData {
    private String id,expensetype, paymentmode, totalcost, Litre, Notes,dateBtn, descr;

    ExpenseData(){

    }
    public ExpenseData( String expensetype,String  paymentmode,String  totalcost,String  Litre,String  Notes,String dateBtn, String descr){
       // this.id=id;
        this.expensetype=expensetype;
        this.paymentmode=paymentmode;
        this.totalcost=totalcost;
        this.Litre=Litre;
        this.Notes=Notes;
        this.dateBtn = dateBtn;
        this.descr = descr;
    }

   /*
    public String getId() {
        return id;
    }
    */
   public String getdateBtn() {
       return dateBtn;
   }
    public String getExpensetype() {
        return expensetype;
    }
    public String getPaymentmode() {
        return paymentmode;
    }
    public String getTotalcost(){return totalcost;}
    public String getLitre(){return Litre;}
    public String getNotes(){return Notes;}
    public String getDescr() {
        return descr;
    }


    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setdateBtn(String dateBtn) {
       this.dateBtn = dateBtn;
    }
    public void setExpensetype(String expensetype) {
        this.expensetype = expensetype;
    }
    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }
    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }
    public void setLitre(String Litre) {
        this.Litre = Litre;
    }
    public void setNotes(String Notes) {
        this.Notes = Notes;
    }
}
