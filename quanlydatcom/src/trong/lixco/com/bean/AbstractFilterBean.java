package trong.lixco.com.bean;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AbstractFilterBean {
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
