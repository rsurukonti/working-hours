package app.springbootdemo.database.repository;

import app.springbootdemo.database.dbmodel.TimeOff;
import org.springframework.data.repository.CrudRepository;

public interface TimeOffRepository extends CrudRepository<TimeOff, Long> {
}
