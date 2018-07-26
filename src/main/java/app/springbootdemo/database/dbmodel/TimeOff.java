package app.springbootdemo.database.dbmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "timeoff")

    public class TimeOff implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "timeoff_id")
    private long id;


    //@Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private long eid;

    @Column(name = "leavetype")
    private String leaveType;

    @Column(name = "fromDate")
    //@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @JsonDeserialize(using = StartDateTimeDeserialize.class)
    private Date fromDate;

    @Column(name = "toDate")
    //@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @JsonDeserialize(using = EndDateTimeDeserialize.class)
    private Date toDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
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

