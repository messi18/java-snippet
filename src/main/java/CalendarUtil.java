import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by lancema on 15/10/20.
 */
public class CalendarUtil {
    public static boolean isWeekend(String datestr) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = simpleDateFormat.parse(datestr);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
//        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        return Calendar.SATURDAY == i || Calendar.SUNDAY == i;
    }
}
