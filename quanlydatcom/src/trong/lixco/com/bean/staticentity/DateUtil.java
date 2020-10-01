package trong.lixco.com.bean.staticentity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	public static boolean compareHHMM(Date date, String hhmm) {
		Date dateCurrent = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String getCurrentTime = sdf.format(dateCurrent.getTime());
		String getTestTime = hhmm;
		if (getCurrentTime.compareTo(getTestTime) > 0) {
			return true;
		}
		if (getCurrentTime.compareTo(getTestTime) < 0) {
			return false;
		} else {
			return true;
		}
	}
}
