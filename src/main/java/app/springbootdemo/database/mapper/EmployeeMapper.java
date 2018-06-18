package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.service.model.EmployeeBO;

import java.util.stream.Collectors;

public class EmployeeMapper {


    public static Employee from(EmployeeBO employeeView) {

        Employee empl = new Employee();

        empl.setFirstName(employeeView.getFirstName());
        empl.setLastName(employeeView.getLastName());
        empl.setId(employeeView.getId());
        empl.setTimeTable(employeeView.getTimeTable().stream().map(TimeTableMapper::from).collect(Collectors.toSet()));

        return empl;

    }
}
