package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.HoliDay;
import java.lang.String;
import java.util.Date;

public class HoliDayMapper {
    public static HoliDay from (Date startTime, Date beginBreak, Date endBreak, Date endTime) {
        HoliDay holiDay = new HoliDay();
        holiDay.setBegin(startTime);
        holiDay.setBegin_break(beginBreak);
        holiDay.setEnd_break(endBreak);
        holiDay.setEnd(endTime);

        return holiDay;
    }
}


