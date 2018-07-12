package app.springbootdemo.service.model;


import java.util.Date;

public class HoliDayBO {

    private long id;

    private Date leaveType;

    private Date fromDate;

    private Date toDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(Date leaveType) {
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

