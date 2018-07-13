package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.HoliDay;
import java.lang.String;

public class HoliDayMapper {
    public static HoliDay from (String startTime, String endTime, String beginBreak, String endBreak) {
        HoliDay holiDay = new HoliDay();
        holiDay.setBegin(startTime);
        holiDay.setBegin_break(beginBreak);
        holiDay.setEnd(endTime);
        holiDay.setEnd_break(endBreak);

        return holiDay;
    }
}


