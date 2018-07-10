package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.HoliDay;

public class HoliDayMapper {
    public static HoliDay from (String begin, String end, String beginBreak, String endBreak) {
        HoliDay holiDay = new HoliDay();
        holiDay.setBegin(begin);
        holiDay.setBegin_break(endBreak);
        holiDay.setEnd(end);
        holiDay.setEnd_break(endBreak);

        return holiDay;
    }
}


