package app.springbootdemo.database.dbmodel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "TimeTable")
@DiscriminatorValue("W")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="timeType",
        discriminatorType=DiscriminatorType.STRING
)
public class TimeTable  {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "begin")
    @NotBlank
    private String begin;

    @Column(name = "end")
    @NotBlank
    private String end;

    @Column(name = "begin_break")
    @NotBlank
    private String begin_break;

    @Column(name = "end_break")
    @NotBlank
    private String end_break;

   //@ManyToOne
   //@JoinColumn(name="emp_id", nullable = true)
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public TimeTable() {
        super();
    }
}
