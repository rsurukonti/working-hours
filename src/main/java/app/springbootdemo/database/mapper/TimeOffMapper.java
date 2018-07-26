package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.TimeOff;

import java.util.Date;

public class TimeOffMapper {

    public static TimeOff from (long eid, long id, String leaveType, Date fromDate, Date toDate) {
        TimeOff timeOff = new TimeOff();
        timeOff.setId(id);
        timeOff.setId(id);
        timeOff.setLeaveType(leaveType);
        timeOff.setFromDate(fromDate);
        timeOff.setToDate(toDate);


        return timeOff;
    }

}
