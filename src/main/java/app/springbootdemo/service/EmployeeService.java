package app.springbootdemo.service;


import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.mapper.EmployeeMapper;
import app.springbootdemo.database.mapper.HoliDayMapper;
import app.springbootdemo.database.mapper.IllMapper;
import app.springbootdemo.database.repository.EmployeeRepository;
import app.springbootdemo.database.repository.TimeTableRepository;
import app.springbootdemo.service.model.EmployeeBO;
import app.springbootdemo.service.model.HoliDayBO;
import app.springbootdemo.service.model.IllBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

        String startTime = illBO.getIllDate() + "10.01.1989";
        String endTime = illBO.getIllDate() + "10.02.1969";

        Employee emp = employeeRepository.findById(Long.valueOf(illBO.getEmpId())).get();

        emp.getTimeTable().add(IllMapper.from(startTime,null,null, endTime));

        employeeRepository.save(emp);
    }


    public void holiDay(HoliDayBO holiDayBO) {

        String startTime = holiDayBO.getFromDate() + "10.02.1969";
        String endTime = holiDayBO.getToDate() + "10.02.1969";

        Employee emp = employeeRepository.findById(Long.valueOf(holiDayBO.getId())).get();

        emp.getTimeTable().add(HoliDayMapper.from(startTime, null,null, endTime));

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
