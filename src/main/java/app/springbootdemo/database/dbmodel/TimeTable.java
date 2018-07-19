package app.springbootdemo.database.dbmodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "WORKING_CALENDAR")
@DiscriminatorValue("W")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="timeType",
        discriminatorType=DiscriminatorType.STRING)

public class TimeTable implements Serializable {


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Start_Time")
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @JsonDeserialize(using=StartDateTimeDeserialize.class)
    private Date begin;

    @Column(name = "begin_break")
    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    @JsonDeserialize(using=BreakDateTimeDeserialize.class)
    private Date begin_break;

    @Column(name = "end_break")
    @JsonDeserialize(using=BreakDateTimeDeserialize.class)
    private Date end_break;

    @Column(name = "end_Time")
    @JsonDeserialize(using=EndDateTimeDeserialize.class)
    private Date end;


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
