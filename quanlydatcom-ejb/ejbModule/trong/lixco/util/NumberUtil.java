package trong.lixco.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NumberUtil {

	//Lay phan du va lam tron so
	public static double layPhanDu(double number, int lamtron) {
		BigDecimal bd = new BigDecimal(number - Math.floor(number));
		bd = bd.setScale(lamtron, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static void main(String[] args) {
		// Date sd = null, ed = null;
		// try {
		// sd = new
		// SimpleDateFormat("dd/MM/yyyy kk:mm:ss").parse("02/12/2019 14:01:35");
		// ed = new
		// SimpleDateFormat("dd/MM/yyyy kk:mm:ss").parse("01/12/2019 12:21:00");
		// } catch (Exception e) {
		// }
		// System.out.println("Start..");
		// List<Calendar> dateList = DateUtil.getListDateBetweenTwoDate(sd, ed);
		// System.out.println(dateList.size());
		// System.out.println(subtract(sd, ed));

		// double a=2.3;
		double d = 4.0014;
		System.out.println((int)d);
		BigDecimal bd = new BigDecimal(d - Math.floor(d));
		bd = bd.setScale(1, RoundingMode.HALF_UP);
		System.out.println(bd.toString());
	}

}
