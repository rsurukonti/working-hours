package app.springbootdemo;

import app.springbootdemo.controller.model.TimeTableView;
import app.springbootdemo.service.model.TimeTableBO;

public class TimeTableBOMapper {

    public static TimeTableBO from (TimeTableView timeTableView) {
        TimeTableBO timeTableBO = new TimeTableBO();
        timeTableBO.setBegin(timeTableView.getBegin());
        timeTableBO.setBegin_break(timeTableView.getBegin_break());
        timeTableBO.setEnd(timeTableView.getEnd());
        timeTableBO.setEnd_break(timeTableView.getEnd_break());
        timeTableBO.setId(timeTableView.getId());

        return timeTableBO;
    }
}
