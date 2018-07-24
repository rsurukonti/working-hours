package app.springbootdemo.database.repository;

import app.springbootdemo.database.dbmodel.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

 
 // employee type of interface and extends CRUD is to expose a complete set of methods to manipulate entities

public interface EmployeeRepository extends CrudRepository<Employee, Long>


 // query builder mechanism and which trips the prefixes..findBy, readBy, queryBy..from the method and starts parsing the rest 
{

	@Query(value = "select u from Employee u where u.id=?1",name = "findEmployeewithId")
	public Employee findEmployeewithId(long id);

	List<Employee> findByLastName(String lastName);

}