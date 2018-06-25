package app.springbootdemo.database.repository;

import app.springbootdemo.database.dbmodel.Employee;
import app.springbootdemo.database.dbmodel.TimeTable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

 

public interface TimeTableRepository extends CrudRepository<TimeTable, Long>


{


}