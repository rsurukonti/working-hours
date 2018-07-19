package app.springbootdemo.controller.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class IllView {



    private String empId;

    private Date illDate;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }


    public Date getIllDate() {
        return illDate;
    }

    public void setIllDate(Date illDate) {
        this.illDate = illDate;
    }
}
