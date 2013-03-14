package util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*     */public class DateUtil
/*     */{
	/*     */public static final String JAVA_DATE_FORMAT_YMDHM = "yyyy-MM-dd HH:mm";
	/*     */public static final String JAVA_DATE_FORMAT_YMD = "yyyy-MM-dd";
	/*     */public static final String JAVA_DATE_FORMAT_YM = "yyyy-MM";
	/*     */public static final String JAVA_DATE_FORMAT_HM = "HH:mm";
	/*     */public static final String JAVA_DATE_FORMAT_YMDW = "yyyy-MM-dd EEEE";
	/*     */public static final String JAVA_DATE_FORMAT_W = "EEEE";

	/*     */private static String padChar(String num)
	/*     */{
		/* 159 */if (num.length() == 2) {
			/* 160 */return num;
			/*     */}
		/* 162 */return "0" + num;
		/*     */}

	/*     */
	/*     */private static String padChar(int num)
	/*     */{
		/* 173 */return padChar(String.valueOf(num));
		/*     */}

	/*     */
	/*     */private static int fixYear(int year)
	/*     */{
		/* 183 */return (year + 1900);
		/*     */}

	/*     */
	/*     */private static int fixSetYear(int year)
	/*     */{
		/* 193 */return (year - 1900);
		/*     */}

	/*     */

	/*     */public static String getFormatHHMM(java.util.Date date)
	/*     */{
		/* 337 */if (date == null) {
			/* 338 */return "";
			/*     */}
		
		
		
		/*     */
		/* 341 */StringBuffer sb = new StringBuffer();
		/* 342 */sb.append(padChar(date.getHours()));
		/* 343 */sb.append(":");
		/* 344 */sb.append(padChar(date.getMinutes()));
		/*     */
		/* 346 */return sb.toString();
		/*     */}

	/**
	 * @param date1
	 *            需要比较的时间 不能为空(null),需要正确的日期格式 ,如：2009-09-12
	 * @param date2
	 *            被比较的时间 为空(null)则为当前时间
	 * @param stype
	 *            返回值类型 0为多少天，1为多少个月，2为多少年
	 * @return 举例： compareDate("2009-09-12", null, 0);//比较天
	 *         compareDate("2009-09-12", null, 1);//比较月
	 *         compareDate("2009-09-12", null, 2);//比较年
	 */
	public static int compareDate(String startDay, String endDay, int stype) {
		int n = 0;
		String[] u = { "天", "月", "年" };
		String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";

		endDay = endDay == null ? getCurrentDate("yyyy-MM-dd") : endDay;

		DateFormat df = new SimpleDateFormat(formatStyle);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(df.parse(startDay));
			c2.setTime(df.parse(endDay));
		} catch (Exception e3) {
			System.out.println("wrong occured");
		}
		// List list = new ArrayList();
		while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
			// list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来
			n++;
			if (stype == 1) {
				c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
			} else {
				c1.add(Calendar.DATE, 1); // 比较天数，日期+1
			}
		}
		n = n - 1;
		if (stype == 2) {
			n = (int) n / 365;
		}
		System.out.println(startDay + " -- " + endDay + " 相差多少" + u[stype]
				+ ":" + n);
		return n;
	}

	public static String getCurrentDate(String format) {
		Calendar day = Calendar.getInstance();
		day.add(Calendar.DATE, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(format);// "yyyy-MM-dd"
		String date = sdf.format(day.getTime());
		return date;
	}
	/*     */

	/*     */
}
