package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.HoliDay;

import java.util.Date;

public class HoliDayMapper {
    public static HoliDay from (Date startTime, Date endTime, Date beginBreak, Date endBreak) {
        HoliDay holiDay = new HoliDay();
        holiDay.setBegin(startTime);
        holiDay.setBegin_break(beginBreak);
        holiDay.setEnd(endTime);
        holiDay.setEnd_break(endBreak);

        return holiDay;
    }
}


