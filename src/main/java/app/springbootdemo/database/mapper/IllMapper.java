package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.Ill;
import app.springbootdemo.database.dbmodel.TimeTable;
import app.springbootdemo.service.model.TimeTableBO;

public class IllMapper {

        public static Ill from (String begin, String end, String beginBreack, String endBreak) {
            Ill ill = new Ill();
            ill.setBegin(begin);
            ill.setBegin_break(endBreak);
            ill.setEnd(end);
            ill.setEnd_break(endBreak);

            return ill;
        }
    }


