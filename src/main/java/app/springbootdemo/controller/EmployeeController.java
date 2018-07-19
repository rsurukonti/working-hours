package app.springbootdemo.controller;


import app.springbootdemo.controller.mapper.EmployeeViewMapper;
import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.controller.model.HoliDayView;
import app.springbootdemo.controller.model.IllView;
import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.dbmodel.TimeOff;
import app.springbootdemo.database.repository.EmployeeRepository;
import app.springbootdemo.service.EmployeeService;
import app.springbootdemo.service.mapper.EmployeeBOMapper;
import app.springbootdemo.service.mapper.HoliDayBOMapper;
import app.springbootdemo.service.mapper.IllBOMapper;
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
	public EmployeeView postEmployee(@RequestBody EmployeeView employeeView) {
		return EmployeeViewMapper.from(employeeService.postEmployee(EmployeeBOMapper.from(employeeView)));
	}

	/*@PostMapping(value="/posttimeoff" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public TimeOff posttimeoff(@RequestBody TimeOff timeoff) {
		return timeoff;
	}*/

	@PostMapping(value="/ill" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void ill(@RequestBody IllView illView) {
		employeeService.ill(IllBOMapper.from(illView));
	}


	@PostMapping(value="/holiday" ,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void holiDay(@RequestBody HoliDayView holiDayView) {
		employeeService.holiDay(HoliDayBOMapper.from(holiDayView));
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
