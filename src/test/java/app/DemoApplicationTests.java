package app;

import app.springbootdemo.controller.model.EmployeeView;
import app.springbootdemo.controller.model.TimeTableView;
import app.springbootdemo.service.mapper.EmployeeBOMapper;
import app.springbootdemo.service.model.EmployeeBO;
import app.springbootdemo.service.model.TimeTableBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testEmployeeBoMapper() {
        // Create input employee
        final Set<TimeTableView> timeTableViews = new HashSet<>();

        final TimeTableView ttv = new TimeTableView();
        ttv.setId(21);
        ttv.setBegin(new String());
        ttv.setEnd(new String());
        ttv.setBegin_break(new String());
        ttv.setEnd_break(new String());

        timeTableViews.add(ttv);

        final EmployeeView input = new EmployeeView();
        input.setId(21L);
        input.setFirstName("Hadi");
        input.setLastName("Afshar");
        input.setTimeTable(timeTableViews);

        // Create output exployee
        final Set<TimeTableBO> timeTable = new HashSet<>();

        final TimeTableBO tt = new TimeTableBO();
        tt.setId(21);
        tt.setBegin(new String());
        tt.setEnd(new String());
        tt.setBegin_break(new String());
        tt.setEnd_break(new String());

        timeTable.add(tt);

        final EmployeeBO expectedOutput = new EmployeeBO();
        expectedOutput.setId(42);
        expectedOutput.setFirstName("Hadi");
        expectedOutput.setLastName("Afshar");
        expectedOutput.setTimeTable(timeTable);

        // Run mapper method
        final EmployeeBO actualOutput = EmployeeBOMapper.from(input);

        assertEquals(expectedOutput, actualOutput);
    }

}


