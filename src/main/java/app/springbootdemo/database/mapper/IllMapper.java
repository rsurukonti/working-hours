package app.springbootdemo.database.mapper;

import app.springbootdemo.database.dbmodel.Ill;
import java.lang.String;

public class IllMapper {

        public static Ill from (String startTime, String endTime, String beginBreak, String endBreak) {
            Ill ill = new Ill();
            ill.setBegin(startTime);
            ill.setBegin_break(beginBreak);
            ill.setEnd(endTime);
            ill.setEnd_break(endBreak);

            return ill;
        }
    }


