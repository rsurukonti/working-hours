package app.springbootdemocontroller;

import app.springbootdemorepository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//it is the combination of spring controller and responsebody
//controller says to define controller and responsebody is to indicate return value of method should be used as r b of request
@RestController
@RequestMapping(value="/api")
public class EmployeeController {

@Autowired
EmployeeRepository repository;


//is a short form of requestmapping and requesttype is get
@GetMapping(value="/employee",  produces=MediaType.APPLICATION_JSON_VALUE)
public List<Employee> getAll() {
	List<Employee> list = new ArrayList();
	Iterable<Employee> employees = repository.findAll();

	employees.forEach(list::add);
	return list;
}

@PostMapping(value="/postemployee" ,consumes=MediaType.APPLICATION_JSON_VALUE)
public Employee postEmployee(@RequestBody Employee employee) {
//requestbody is to bind the request body with a method parameter
	repository.save(new Employee(employee.getFirstName(), employee.getLastName()));
	return employee;
}

@GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
public List<Employee> findByLastName(@PathVariable("lastName") String lastName) {

	List<Employee> employees = repository.findByLastName(lastName);
	return employees;
}


@DeleteMapping(value="/employee/{id}")
public void deleteEmployee(@PathVariable long id){
	
	repository.deleteById(id);
}
}
