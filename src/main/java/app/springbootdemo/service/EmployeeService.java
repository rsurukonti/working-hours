package app.springbootdemo.service;


import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.mapper.EmployeeMapper;
import app.springbootdemo.database.mapper.HoliDayMapper;
import app.springbootdemo.database.mapper.IllMapper;
import app.springbootdemo.database.mapper.TimeOffMapper;
import app.springbootdemo.database.repository.EmployeeRepository;
import app.springbootdemo.database.repository.TimeTableRepository;
import app.springbootdemo.service.model.EmployeeBO;
import app.springbootdemo.service.model.HoliDayBO;
import app.springbootdemo.service.model.IllBO;
import app.springbootdemo.service.model.TimeOffBO;
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

    public void timeOff(TimeOffBO timeOffBO) {

        long id = timeOffBO.getId();// + "8:00";
        String leaveType = timeOffBO.getLeaveType();// + "16:00";
        Date fromDate = timeOffBO.getFromDate();// + "11:30";
        Date toDate = timeOffBO.getToDate();// + "12:00";

        Employee emp = employeeRepository.findById(Long.valueOf(timeOffBO.getId())).get();

        emp.getTimeOff().add(TimeOffMapper.from(id, leaveType, fromDate, toDate));

        employeeRepository.save(emp);
    }


    public void ill(IllBO illBO) {

        Date startTime = illBO.getIllDate();// + "8:00";
        Date endTime = illBO.getIllDate();// + "16:00";
        Date begin_Break = illBO.getIllDate();// + "12:00";
        Date end_Break = illBO.getIllDate();// + "12:30";


        Employee emp = employeeRepository.findById(Long.valueOf(illBO.getEmpId())).get();

        emp.getTimeTable().add(IllMapper.from(startTime, begin_Break, end_Break, endTime));

        employeeRepository.save(emp);
    }


    public void holiDay(HoliDayBO holiDayBO) {

        Date startTime = holiDayBO.getFromDate();// + "8:00";
        Date endTime = holiDayBO.getToDate();// + "16:00";
        Date begin_Break = holiDayBO.getFromDate();// + "11:30";
        Date end_Break = holiDayBO.getToDate();// + "12:00";




        Employee emp = employeeRepository.findById(Long.valueOf(holiDayBO.getId())).get();

        emp.getTimeTable().add(HoliDayMapper.from(startTime, begin_Break, end_Break, endTime));

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
