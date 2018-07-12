package app.springbootdemo.controller.model;

import java.util.Date;

public class TimeTableView {

    private static final long serialVersionUID = 1L;

    private int id;

    private Date begin;

    private Date begin_break;

    private Date end_break;

    private Date end;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getBegin_break() {
        return begin_break;
    }

    public void setBegin_break(Date begin_break) {
        this.begin_break = begin_break;
    }

    public Date getEnd_break() {
        return end_break;
    }

    public void setEnd_break(Date end_break) {
        this.end_break = end_break;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
