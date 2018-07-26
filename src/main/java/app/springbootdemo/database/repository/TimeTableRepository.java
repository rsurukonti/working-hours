package app.springbootdemo.database.repository;

import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.dbmodel.TimeTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface TimeTableRepository extends CrudRepository<TimeTable, Long> {

   // @Query("select TimeTable from working_calendar wc inner join employee_time_table ett on wc.id = ett.time_table_id where ett.employee_emp_id = :employeeId")
   // Set<TimeTable> getTimeTableByEmployee(@Param("employeeId") long employeeId);

    @Query(value = "select u from Employee u where u.id=?3",name = "findEmployeewithId")
    public Employee findEmployeewithId(long id);

}