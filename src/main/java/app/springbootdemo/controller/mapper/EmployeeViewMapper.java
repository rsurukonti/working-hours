package app.springbootdemo.controller.mapper;

import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.service.model.EmployeeBO;

import java.util.stream.Collectors;

public class EmployeeViewMapper {


    public static EmployeeView from(EmployeeBO employeeView) {

        EmployeeView empl = new EmployeeView();

        empl.setFirstName(employeeView.getFirstName());
        empl.setLastName(employeeView.getLastName());
        empl.setId(employeeView.getId());
        empl.setTimeTable(employeeView.getTimeTable().stream().map(TimeTableViewMapper::from).collect(Collectors.toSet()));

        return empl;

    }
}
