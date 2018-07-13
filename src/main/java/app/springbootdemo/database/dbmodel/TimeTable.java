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
    private String begin;

    @Column(name = "end_Time")
    @JsonDeserialize(using=EndDateTimeDeserialize.class)
    private String end;

    @Column(name = "begin_break")
    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    @JsonDeserialize(using=BreakDateTimeDeserialize.class)
    private String begin_break;

    @Column(name = "end_break")
    @JsonDeserialize(using=BreakDateTimeDeserialize.class)
    private String end_break;

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
