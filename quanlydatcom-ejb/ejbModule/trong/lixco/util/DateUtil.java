package trong.lixco.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	// Lay danh sach ngay giua hai ngay
	public static List<Calendar> getListDateBetweenTwoDate(Date startDate, Date endDate) {
		Calendar sd = Calendar.getInstance();
		sd.setTime(startDate);
		Calendar ed = Calendar.getInstance();
		ed.setTime(endDate);
		List<Calendar> results = new ArrayList<Calendar>();
		while (sd.before(ed)) {
			Calendar cl = Calendar.getInstance();
			cl.setTime(sd.getTime());
			results.add(cl);
			sd.add(Calendar.DATE, 1);
		}
		if (sd.equals(ed))
			results.add(sd);
		return results;
	}

	// Them ngay so voi ngay nhap vao;
	public static Date add(Date date, int number) {
		if (date == null)
			return null;
		Calendar sd = Calendar.getInstance();
		sd.setTime(date);
		sd.add(Calendar.DATE, number);
		return sd.getTime();
	}

	// Them gio so voi gio nhap vao;
	public static Date addHour(Date date, int number) {
		if (date == null)
			return null;
		Calendar sd = Calendar.getInstance();
		sd.setTime(date);
		sd.add(Calendar.HOUR, number);
		return sd.getTime();
	}

	// So sanh ngay co giua hai ngay;
	public static boolean compareDayBetweenTwoDay(Date dateStart, Date dateEnd, Date dateparam) {
		if ((dateparam.after(dateStart) && dateparam.before(dateEnd)) || dateparam.equals(dateStart)
				|| dateparam.equals(dateEnd))
			return true;
		return false;

	}

	// Them ngay so voi ngay nha vao;
	public static Date addMinute(Date date, int number) {
		if (date == null)
			return null;
		Calendar sd = Calendar.getInstance();
		sd.setTime(date);
		sd.add(Calendar.MINUTE, number);
		return sd.getTime();
	}

	public static double subtract(Date date1, Date date2) {
		try {
			if (date1 == null || date2 == null)
				return 0;
			Long d1 = date1.getTime();
			Long d2 = date2.getTime();
			String hour = (((double) (d1 - d2)) / 1000 / 60 / 60) + "";
			BigDecimal bd = new BigDecimal(hour).setScale(1, RoundingMode.HALF_UP);
			return bd.doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public static double subtractReturnDay(Date date1, Date date2) {
		try {
			if (date1 == null || date2 == null)
				return 0;
			Long d1 = date1.getTime();
			Long d2 = date2.getTime();
			String hour = (((double) (d1 - d2)) / 1000 / 60 / 60 / 24) + "";
			BigDecimal bd = new BigDecimal(hour).setScale(1, RoundingMode.HALF_UP);
			return bd.doubleValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public static void main(String[] args) {
		Date sd = null, ed = null;
		try {
			sd = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss").parse("26/09/2019 07:00:00");
			ed = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss").parse("28/09/2019 17:46:52");
			
			List<Calendar> rs=getListDateBetweenTwoDate(sd, ed);
			System.out.println(rs.size());

//			// Tinh them gio
//			double timeactual = DateUtil.subtract(ed, sd);
//			double themgio = 0;
//			double overtime = 0;
//			if (timeactual - 9 >= 0.8) {
//				themgio = timeactual - 9;
//				
//			}
//			if (themgio >= 0.8)
//				if (themgio >= 0.8 && themgio <= 1) {
//					overtime = 1;
//				} else {
//					double pd = NumberUtil.layPhanDu(themgio, 1);
//					System.out.println("pd: "+pd);
//					if (pd < 0.3) {
//						overtime = (int) themgio;
//					} else if (pd > 0.3 && pd < 0.7) {
//						overtime = (int) themgio + 0.5;
//					} else if (pd >= 0.7) {
//						overtime = (int) themgio + 1;
//					}
//				}
//			System.out.println((int) themgio+1);
//			System.out.println("overtime "+ overtime);

		} catch (Exception e) {
			// TODO: handle exception
		}

		// System.out.println(sd.getDay());
		// System.out.println(sd.getDate());
		// System.out.println("Start..");
		// List<Calendar> dateList = DateUtil.getListDateBetweenTwoDate(sd, ed);
		// System.out.println(dateList.size());
		// System.out.println(subtract(sd, ed));

		// double a=2.3;
		// double d = 4.24;
		// BigDecimal bd = new BigDecimal(d - Math.floor(d));
		// bd = bd.setScale(1, RoundingMode.HALF_UP);
//		String[] date = new String[31];
//		for (int i = 0; i < date.length; i++) {
//			date[i] = i + "";
//		}
//		for (int i = 0; i < date.length; i++) {
//			System.out.println(date[i]);
//		}

	}

}
