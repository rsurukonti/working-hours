package app.springbootdemo.service.mapper;

import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.service.model.EmployeeBO;

import java.util.stream.Collectors;

public class EmployeeBOMapper {


    public static EmployeeBO from(EmployeeView employeeView) {

        EmployeeBO empBo = new EmployeeBO();

        empBo.setFirstName(employeeView.getFirstName());
        empBo.setLastName(employeeView.getLastName());
        empBo.setId(employeeView.getId());
        empBo.setTimeTable(employeeView.getTimeTable().stream().map(TimeTableBOMapper::from).collect(Collectors.toSet()));

        return empBo;

    }

    public static EmployeeBO from(Employee employee) {

        EmployeeBO empBo = new EmployeeBO();

        empBo.setFirstName(employee.getFirstName());
        empBo.setLastName(employee.getLastName());
        empBo.setId(employee.getId());
        empBo.setTimeTable(employee.getTimeTable().stream().map(TimeTableBOMapper::from).collect(Collectors.toSet()));

        return empBo;

    }
}
