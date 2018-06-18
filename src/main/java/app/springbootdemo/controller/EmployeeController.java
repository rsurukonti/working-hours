package app.springbootdemo.controller;


import app.springbootdemo.service.mapper.EmployeeBOMapper;
import app.springbootdemo.controller.mapper.EmployeeViewMapper;
import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.repository.EmployeeRepository;
import app.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository repository;

	@GetMapping(value="/employee",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@PostMapping(value="/postemployee" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public EmployeeView postEmployee(@RequestBody EmployeeView employee) {
		return EmployeeViewMapper.from(employeeService.postEmployee(EmployeeBOMapper.from(employee)));
	}

	@GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> findByLastName(@PathVariable("lastName") String lastName) {
		return employeeService.findByLastName(lastName);
	}

	@DeleteMapping(value="/employee/{id}")
	public void deleteEmployee(@PathVariable long id){
		employeeService.deleteEmployee(id);
	}
}