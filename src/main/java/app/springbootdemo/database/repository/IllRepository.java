package app.springbootdemo.database.repository;

import app.springbootdemo.database.dbmodel.Ill;
import org.springframework.data.repository.CrudRepository;

public interface IllRepository extends CrudRepository<Ill, Long> {
}
