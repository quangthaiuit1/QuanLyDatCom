package trong.lixco.com.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import trong.lixco.com.account.servicepublics.Department;

public class DepartmentUtil {
	public static List<Department> sort(List<Department> items) {
		try {
			Collections.sort(items, new Comparator<Department>() {
				@Override
				public int compare(Department sv1, Department sv2) {
					try {
						return sv1.showAllNameDepartFull().compareTo(sv2.showAllNameDepartFull());
					} catch (Exception e) {
						return -1;
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}
}
