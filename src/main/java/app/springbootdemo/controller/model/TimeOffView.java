package app.springbootdemo.controller.model;

import java.util.Date;

public class TimeOffView {

    private long id;



    private long empid;

    private String leaveType;


    private Date fromDate;

    private Date toDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmpid() {
        return empid;
    }

    public void setEmpid(long empid) {
        this.empid = empid;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }


}
