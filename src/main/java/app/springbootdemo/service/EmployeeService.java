package app.springbootdemo.service;


import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.dbmodel.HoliDay;
import app.springbootdemo.database.dbmodel.Ill;
import app.springbootdemo.database.dbmodel.TimeTable;
import app.springbootdemo.database.mapper.EmployeeMapper;
import app.springbootdemo.database.mapper.HoliDayMapper;
import app.springbootdemo.database.mapper.IllMapper;
import app.springbootdemo.database.repository.EmployeeRepository;
import app.springbootdemo.database.repository.TimeTableRepository;
import app.springbootdemo.service.mapper.EmployeeBOMapper;
import app.springbootdemo.service.model.EmployeeBO;
import app.springbootdemo.service.model.HoliDayBO;
import app.springbootdemo.service.model.IllBO;
import app.springbootdemo.service.model.TimeOffBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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
        EmployeeBO employeeBO1 = EmployeeBOMapper.from(employeeRepository.save(EmployeeMapper.from(employeeBO)));
        return employeeBO1;
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

        Date startTime = holiDayBO.getFromDate();
        //Calendar.set(Calendar.HOUR_OF_DAY, int hours);
        startTime.setHours(Calendar.HOUR_OF_DAY);
        Date endTime = holiDayBO.getToDate();// + "16:00";
        Date begin_Break = null;
        Date end_Break = null;


        for (LocalDate date = holiDayBO.getFromDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); date.isBefore(holiDayBO.getToDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()); date = date.plusDays(1))
        {
            Employee emp = employeeRepository.findById(Long.valueOf(holiDayBO.getId())).get();

            emp.getTimeTable().add(HoliDayMapper.from(startTime, begin_Break,null,null));

            employeeRepository.save(emp);        }

    }
    public List<Employee> findByLastName(String lastName) {

        List<Employee> employee = employeeRepository.findByLastName(lastName);
        return employee;
    }

    public void deleteEmployee(long id){

        employeeRepository.deleteById(id);
    }

    public void startTime(long pEmployeeId){


        Employee emp = employeeRepository.findById(pEmployeeId).get();
        TimeTable lcWorkingDay = new TimeTable();
       // lcWorkingDay.setId(emp.getId()); //new
        lcWorkingDay.setEmployee(emp);   //new
        lcWorkingDay.setBegin(new Date());
        emp.getTimeTable().add(lcWorkingDay);
        employeeRepository.save(emp);   //timetablerepository    save 1cworkingday


    }

    public void endTime(long pEmployeeId){

        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Optional<TimeTable> currentTimeTableOptional = timeTableRepository.findForCurrentTimeTableForEmployee(emp.getId()).stream().findFirst();
        if (currentTimeTableOptional.isPresent()) {
            TimeTable currentTimeTable = currentTimeTableOptional.get();
            currentTimeTable.setEnd(new Date());
            timeTableRepository.save(currentTimeTable);
        }


    }



    public void startBreakTime(long pEmployeeId) {

        Employee emp = employeeRepository.findById(pEmployeeId).get();
        TimeTable lcWorkingDay = new TimeTable();
        lcWorkingDay.setId(emp.getId());
        lcWorkingDay.setEmployee(emp);
        lcWorkingDay.setBegin_break(new Date());
        emp.getTimeTable().add(lcWorkingDay);
        employeeRepository.save(emp);
    }

    public void stopBreakTime(long pEmployeeId) {

        Employee emp = employeeRepository.findById(pEmployeeId).get();
        TimeTable lcWorkingDay = new TimeTable();
        lcWorkingDay.setId(emp.getId());
        lcWorkingDay.setEmployee(emp);
        lcWorkingDay.setEnd_break(new Date());
        emp.getTimeTable().add(lcWorkingDay);
        employeeRepository.save(emp);
    }

   /* public void endTime(long pEmployeeId){
        Employee emp = employeeRepository.findById(pEmployeeId).get();
        TimeTable lcWorkingDay = (TimeTable) (emp.getTimeTable().toArray())[0];
        lcWorkingDay.setEnd(new Date());

        Date newdate = new Date();
        newdate.setYear(2019);
        newdate.setMonth(11);

        timeTableRepository.save(lcWorkingDay);
    }*/

   /* public Employee findEmployeewithId(long id) {

        Employee employee = employeeRepository.findEmployeewithId(id);

        return employee;
    }*/


    public void illStartTime(long pEmployeeId) {

        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Ill lcWorkingDay = new Ill();
        lcWorkingDay.setId(emp.getId());
        lcWorkingDay.setEmployee(emp);
        lcWorkingDay.setBegin(new Date());
        emp.getTimeTable().add(lcWorkingDay);
        employeeRepository.save(emp);
    }

    public void illEndTime(long pEmployeeId) {

        Employee emp = employeeRepository.findById(pEmployeeId).get();
        Ill lcWorkingDay = new Ill();
        lcWorkingDay.setId(emp.getId());
        lcWorkingDay.setEmployee(emp);
        lcWorkingDay.setEnd(new Date());
        emp.getTimeTable().add(lcWorkingDay);
        employeeRepository.save(emp);
    }

    public void holidayStartTime(long pEmployeeId) {

        Employee emp = employeeRepository.findById(pEmployeeId).get();
        HoliDay lcWorkingDay = new HoliDay();
        lcWorkingDay.setId(emp.getId());
        lcWorkingDay.setEmployee(emp);
        lcWorkingDay.setBegin(new Date());
        emp.getTimeTable().add(lcWorkingDay);
        employeeRepository.save(emp);
    }

    public void holidayEndTime(long pEmployeeId) {

        Employee emp = employeeRepository.findById(pEmployeeId).get();
        HoliDay lcWorkingDay = new HoliDay();
        lcWorkingDay.setId(emp.getId());
        lcWorkingDay.setEmployee(emp);
        lcWorkingDay.setEnd(new Date());
        emp.getTimeTable().add(lcWorkingDay);
        employeeRepository.save(emp);
    }
}
