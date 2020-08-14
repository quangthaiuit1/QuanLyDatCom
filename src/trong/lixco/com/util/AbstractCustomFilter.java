/**
 * This class is made by Lam Quan Vu.
 * @Copyright 2013 by Lam Quan Vu. Email : LamQuanVu@gmail.com
 */
package trong.lixco.com.util;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AbstractCustomFilter {
	 public boolean filterByText(Object value, Object filter, Locale locale) {
	        String filterText = (filter == null) ? null : filter.toString().trim();
	        if(filterText == null||filterText.equals("")) {
	            return true;
	        }
	        if(value == null) {
	            return false;
	        }
	         return converViToEn(value.toString().toLowerCase()).contains(converViToEn(filterText.toLowerCase()));
	    }

	 public static String converViToEn(String s) {
			String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			String result = pattern.matcher(temp).replaceAll("");
			return pattern.matcher(result).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d");
		}
}
