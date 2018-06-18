package app.springbootdemo.controller.model;

public class TimeTableView {

    private static final long serialVersionUID = 1L;

    private int id;

    private String begin;

    private String end;

    private String begin_break;

    private String end_break;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBegin_break() {
        return begin_break;
    }

    public void setBegin_break(String begin_break) {
        this.begin_break = begin_break;
    }

    public String getEnd_break() {
        return end_break;
    }

    public void setEnd_break(String end_break) {
        this.end_break = end_break;
    }
}
