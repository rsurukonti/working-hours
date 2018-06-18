package app.springbootdemo;

import app.springbootdemo.database.dbmodel.TimeTable;
import app.springbootdemo.service.model.TimeTableBO;

public class TimeTableMapper {

    public static TimeTable from (TimeTableBO timeTableBO) {
        TimeTable timeTable = new TimeTable();
        timeTable.setBegin(timeTableBO.getBegin());
        timeTable.setBegin_break(timeTableBO.getBegin_break());
        timeTable.setEnd(timeTableBO.getEnd());
        timeTable.setEnd_break(timeTableBO.getEnd_break());
        timeTable.setId(timeTableBO.getId());

        return timeTable;
    }
}