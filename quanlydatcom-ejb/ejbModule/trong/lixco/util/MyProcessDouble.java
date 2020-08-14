package trong.lixco.util;

import java.math.BigDecimal;

public class MyProcessDouble {
	/**
	 * Cong hai so kieu double
	 * 
	 * @param a
	 *            so thu nhat
	 * @param b
	 *            so thu hai
	 * @return Tong hai so
	 */
	public static double add(double a, double b) {
		return new BigDecimal(a + "").add(new BigDecimal(b + "")).doubleValue();
	}

	/**
	 * Ham tru hai so
	 * 
	 * @param a
	 *            So thu nhat
	 * @param b
	 *            So thu hai
	 * @return Phep tru hai so
	 */
	public static double subtract(double a, double b) {
		return new BigDecimal(a + "").subtract(new BigDecimal(b + "")).doubleValue();
	}

	/**
	 * Ham nhan hai so
	 * 
	 * @param a
	 *            So thu nhat
	 * @param b
	 *            So thu hai
	 * @return Ket qua phep nhan hai so
	 */
	public static double multiply(double a, double b) {
		return new BigDecimal(a + "").multiply(new BigDecimal(b + "")).doubleValue();
	}

	/**
	 * Ham chia hai so
	 * 
	 * @param a
	 *            So thu nhat
	 * @param b
	 *            So thu hai
	 * @return Ket qua phep chia hai so
	 */
	public static double divide(double a, double b) {
		return new BigDecimal(a + "").divide(new BigDecimal(b + "")).doubleValue();
	}
}
