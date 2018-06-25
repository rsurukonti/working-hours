package app.springbootdemo.service;


import app.springbootdemo.database.mapper.EmployeeMapper;
import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.mapper.IllMapper;
import app.springbootdemo.database.repository.EmployeeRepository;
import app.springbootdemo.database.repository.TimeTableRepository;
import app.springbootdemo.service.model.EmployeeBO;
import app.springbootdemo.service.model.IllBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TimeTableRepository timeTableRepository;

    public List<Employee> getAll() {
        List<Employee> list = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();
        employees.forEach(list::add);
        return list;
    }

    public EmployeeBO postEmployee(EmployeeBO employeeBO) {
        employeeRepository.save(EmployeeMapper.from(employeeBO));
        return employeeBO;
    }

    public void ill(IllBO illBO) {

        String startTime = illBO.getIllDate() + "9:00";
        String endTime = illBO.getIllDate() + "17:00";

        Employee emp = employeeRepository.findById(Long.valueOf(illBO.getEmpId())).get();

        emp.getTimeTable().add(IllMapper.from(startTime, endTime,"33214","32141"));

        employeeRepository.save(emp);
    }

    public List<Employee> findByLastName(String lastName) {

        List<Employee> employee = employeeRepository.findByLastName(lastName);
        return employee;
    }

    public void deleteEmployee(long id){

        employeeRepository.deleteById(id);
    }
}
