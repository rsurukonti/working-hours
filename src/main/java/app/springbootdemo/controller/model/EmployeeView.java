package app.springbootdemo.controller.model;

import java.util.HashSet;
import java.util.Set;

public class EmployeeView {

    private long id;

    private String firstName;

    private String lastName;

    private Set<TimeTableView> timeTable = new HashSet<>();


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

    public Set<TimeTableView> getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(Set<TimeTableView> timeTable) {
        this.timeTable = timeTable;
    }
}
