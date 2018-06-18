package app.springbootdemo.service;


import app.springbootdemo.EmployeeMapper;
import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.repository.EmployeeRepository;
import app.springbootdemo.service.model.EmployeeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

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

    public List<Employee> findByLastName(String lastName) {

        List<Employee> employee = employeeRepository.findByLastName(lastName);
        return employee;
    }

    public void deleteEmployee(long id){

        employeeRepository.deleteById(id);
    }
}
