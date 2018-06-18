package app.springbootdemo;

import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.service.model.EmployeeBO;

import java.util.stream.Collectors;

public class EmployeeBOMapper {


    public static EmployeeBO from(EmployeeView employeeView) {

        EmployeeBO empl = new EmployeeBO();

        empl.setFirstName(employeeView.getFirstName());
        empl.setLastName(employeeView.getLastName());
        empl.setId(employeeView.getId());
        empl.setTimeTable(employeeView.getTimeTable().stream().map(TimeTableBOMapper::from).collect(Collectors.toSet()));

        return empl;

    }
}
