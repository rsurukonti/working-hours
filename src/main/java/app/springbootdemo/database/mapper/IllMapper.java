package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.Ill;
import java.lang.String;
import java.util.Date;

public class IllMapper {

        public static Ill from (Date startTime, Date endTime, Date beginBreak, Date endBreak) {
            Ill ill = new Ill();
            ill.setBegin(startTime);
            ill.setBegin_break(beginBreak);
            ill.setEnd_break(endBreak);
            ill.setEnd(endTime);


            return ill;
        }
    }


