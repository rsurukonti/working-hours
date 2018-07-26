package app.springbootdemo.database.dbmodel;


import javax.persistence.*;
import javax.swing.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_id")
    private long id;

    @Column(name = "firstname")
    @NotBlank
    private String firstName;

    @Column(name = "lastname")
    @NotBlank
    private String lastName;

    //@OneToMany(cascade=CascadeType.ALL)
   /// private Set<TimeTable> timeTable = new HashSet<TimeTable>();

   @OneToMany(cascade=CascadeType.ALL)
   private Set<TimeTable> timeTable = new HashSet<TimeTable>();

    @OneToMany(cascade=CascadeType.ALL)
    private Set<TimeOff> timeOff = new HashSet<TimeOff>();

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Set<TimeTable> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Set<TimeTable> timeTable) {
        this.timeTable = timeTable;
    }




  public Set<TimeOff> getTimeOff() {
        return timeOff;
    }

    public void setTimeOff(Set<TimeOff> timeOff) {
        this.timeOff = timeOff;
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }

}
