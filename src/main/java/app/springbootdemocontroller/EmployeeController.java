package app.springbootdemocontroller;


import app.springbootdemomodel.Employee;
import app.springbootdemorepository.EmployeeRepository;
import app.springbootdemoservice.EmployeeService;
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
	public Employee postEmployee(@RequestBody Employee employee) {
		return employeeService.postEmployee(employee);
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