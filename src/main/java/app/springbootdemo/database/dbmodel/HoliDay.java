package app.springbootdemo.database.dbmodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("H")
public class HoliDay extends TimeTable {
}
