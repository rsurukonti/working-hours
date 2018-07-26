package app.springbootdemo.service.mapper;

import app.springbootdemo.controller.model.TimeOffView;
import app.springbootdemo.service.model.TimeOffBO;

public class TimeOffBOMapper {

    public static TimeOffBO from (TimeOffView timeOffView) {

        TimeOffBO timeOffBO = new TimeOffBO();

        timeOffBO.setEmpid(timeOffView.getEmpid());

        timeOffBO.setId(timeOffView.getId());
        timeOffBO.setLeaveType(timeOffView.getLeaveType());
        timeOffBO.setFromDate(timeOffView.getFromDate());
        timeOffBO.setToDate(timeOffView.getToDate());

        return timeOffBO;
    }


}
