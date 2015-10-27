import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertTrue;

/**
 * Created by lancema on 15/10/20.
 */
public class CalendarUtilTest {
    @Test
    public void testIsWeekend() throws ParseException {
//        assertTrue(CalendarUtil.isWeekend("20151018"));
        assertTrue(CalendarUtil.isWeekend("20151017"));
    }
}
