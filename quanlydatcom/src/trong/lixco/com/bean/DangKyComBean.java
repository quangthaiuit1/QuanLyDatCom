package trong.lixco.com.bean;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.joda.time.LocalDate;

import trong.lixco.com.account.servicepublics.Account;
import trong.lixco.com.account.servicepublics.Department;
import trong.lixco.com.account.servicepublics.DepartmentServicePublic;
import trong.lixco.com.account.servicepublics.DepartmentServicePublicProxy;
import trong.lixco.com.account.servicepublics.Member;
import trong.lixco.com.account.servicepublics.MemberServicePublic;
import trong.lixco.com.account.servicepublics.MemberServicePublicProxy;
import trong.lixco.com.bean.staticentity.Notification;
import trong.lixco.com.bean.staticentity.ShiftsUtil;
import trong.lixco.com.ejb.service.FoodDayByDayService;
import trong.lixco.com.ejb.service.OrderAndFoodByDateService;
import trong.lixco.com.ejb.service.OrderFoodService;
import trong.lixco.com.jpa.entity.FoodByDay;
import trong.lixco.com.jpa.entity.OrderAndFoodByDate;
import trong.lixco.com.jpa.entity.OrderFood;
import trong.lixco.com.servicepublic.EmployeeDTO;
import trong.lixco.com.servicepublic.EmployeeServicePublic;
import trong.lixco.com.servicepublic.EmployeeServicePublicProxy;
import trong.lixco.com.util.DepartmentUtil;
import trong.lixco.com.util.Notify;

@javax.faces.bean.ManagedBean
@ViewScoped
// KPI ca nhan
public class DangKyComBean extends AbstractBean<OrderFood> {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat sf;
	private Notify notify;

	private Department departmentSearch;
	private List<Department> departmentSearchs;
	private boolean isEmp = false;// la nhan vien

	private int monthSearch = 0;
	private int yearSearch = 0;
	private boolean select = false;

	private int monthCopy = 0;
	private int yearCopy = 0;

	@Inject
	private Logger logger;

	private Department department;
	private List<Department> departments;
	private Member member;
	private List<Member> members;

	DepartmentServicePublic departmentServicePublic;
	MemberServicePublic memberServicePublic;

	private OrderFood orderFoodEdit;
	private List<OrderFood> orderFilters;
	private Department dpm;
	private int weekSearch;
	private int fromDay;
	private int toDay;
	private List<EmployeeDTO> employeesByAdminDepartment;
	private List<EmployeeDTO> employeesByAdminDepartmentFilters;
	private Date firstDayInMonthByWeekCurrent;

	// list du lieu de load len bang dang ky
	private List<OrderFood> orderFoods;
	private List<FoodByDay> foodsShifts1;
	private List<FoodByDay> foodsShifts2;
	private List<FoodByDay> foodsShifts3;
	

	private FoodByDay food1Selected;
	private FoodByDay food2Selected;
	private FoodByDay food3Selected;

	@EJB
	private OrderFoodService ORDER_FOOD_SERVICE;

	@EJB
	private FoodDayByDayService FOOD_BY_DAY_SERVICE;

	@EJB 
	private OrderAndFoodByDateService ORDER_AND_FOOD_BY_DATE_SERVICE; 
	
	EmployeeServicePublic EMPLOYEE_SERVICE_PUBLIC;

	private Date startDate;
	private Date endDate;
	private int week;
	private int yearOfWeek;
	private List<OrderAndFoodByDate> ofsByDate;
	public void ajax_setDate() {
		LocalDate lc = new LocalDate();
		startDate = lc.withWeekOfWeekyear(week).withYear(yearOfWeek).dayOfWeek().withMinimumValue().toDate();
		endDate = lc.withWeekOfWeekyear(week).withYear(yearOfWeek).dayOfWeek().withMaximumValue().toDate();
	}

	@Override
	public void initItem() {
		ofsByDate = ORDER_AND_FOOD_BY_DATE_SERVICE.findAll();
//		food1Selected = new FoodDayByDay();
//		food2Selected = new FoodDayByDay();
//		food3Selected = new FoodDayByDay();
		sf = new SimpleDateFormat("dd/MM/yyyy");
		departmentSearch = new Department();

		// xu ly tuan
		LocalDate today = new LocalDate();
		startDate = today.dayOfWeek().withMinimumValue().toDate();
		endDate = today.dayOfWeek().withMaximumValue().toDate();
		week = today.getWeekOfWeekyear();
		yearOfWeek = today.getYear();

		try {
			departmentServicePublic = new DepartmentServicePublicProxy();
			memberServicePublic = new MemberServicePublicProxy();
			EMPLOYEE_SERVICE_PUBLIC = new EmployeeServicePublicProxy();
			departments = new ArrayList<Department>();
			members = new ArrayList<Member>();
			member = getAccount().getMember();
			departmentSearchs = new ArrayList<Department>();
			if (getAccount().isAdmin()) {
				Department[] deps = departmentServicePublic.findAll();
				for (int i = 0; i < deps.length; i++) {
					if (deps[i].getLevelDep() != null)
						if (deps[i].getLevelDep().getLevel() > 1)
							departmentSearchs.add(deps[i]);
				}

			} else {
				departmentSearchs.add(member.getDepartment());
			}
			if (departmentSearchs.size() != 0) {
				departmentSearchs = DepartmentUtil.sort(departmentSearchs);
				departmentSearch = departmentSearchs.get(0);
			}
		} catch (Exception e) {
		}

		LocalDate lc = new LocalDate();
	}

	public void ajaxSelectDep() {
		// if (departmentParent != null)
		// employees = employeeService.findByDepp(departmentParent);
	}

	public Department findDeplevel2(Department department) {
		if (department.getLevelDep().getLevel() == 2) {
			return department;
		} else {
			return findDeplevel2(department.getDepartment());
		}
	}

	boolean manager = false;
	private Account account;

	public void ajaxdepartmentSearch() {
		// if (departmentParentSearch != null) {
		// departmentSearchs =
		// departmentService.findDepartment(departmentParentSearch);
		// departmentSearch = null;
		//
		// }
	}

	public void findData() {
		// list order food tu DB
		java.sql.Date start = new java.sql.Date(startDate.getTime());
		java.sql.Date end = new java.sql.Date(endDate.getTime());

		orderFoods = ORDER_FOOD_SERVICE.findByDayToDay(start, end, member.getCode());
		resetData(this.orderFoods);
	}

	// Load lai data
	public void resetData(List<OrderFood> orderFoods) {
		// tinh so ngay cua thang
		boolean namNhuan = false;
		// get nam hien tai
		int year = Calendar.getInstance().get(Calendar.YEAR);
		// kiem tra nhuan
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			namNhuan = true;
		}

		// set so ngay cua moi thang vao mang
		int[] month = new int[11];
		if (namNhuan) {
			month = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		}
		if (namNhuan == false) {
			month = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		}

		Calendar c = Calendar.getInstance();
		c.setTime(this.startDate);
		int firstDay = c.get(Calendar.DAY_OF_MONTH);
		c.setTime(endDate);
		int lastDay = c.get(Calendar.DAY_OF_MONTH);
		// tong so ngay tim kiem
		int totalDay = 0;
		if (firstDay > lastDay) {
			totalDay = lastDay + month[endDate.getMonth() - 1] - firstDay + 1;
		}
		if (firstDay < lastDay) {
			totalDay = lastDay - firstDay + 1;
		}
		// check xem user tim tong so bao nhieu ngay
		List<OrderFood> orderFoodsTemp = new ArrayList<>();
		// them vao de tao moi
		Date dateTemp = startDate;
		for (int i = 0; i < totalDay; i++) {
			OrderFood temp = new OrderFood();
			// xu ly them ngay cho moi row
			temp.setRegistration_date(dateTemp);
			orderFoodsTemp.add(temp);
			c.setTime(dateTemp);
			c.add(Calendar.DATE, 1);
			dateTemp = c.getTime();
		}
		// orderfoods tam thoi
		List<OrderFood> ofTemps = new ArrayList<>();
		ofTemps.addAll(orderFoods);
		// kiem tra mon an da co trong db chua
		for (int i = 0; i < orderFoodsTemp.size(); i++) {
			boolean check = false;
			for (int j = 0; j < ofTemps.size(); j++) {
				if (ofTemps.get(j).getRegistration_date() != null) {
					if (ofTemps.get(j).getRegistration_date().getDate() == orderFoodsTemp.get(i).getRegistration_date()
							.getDate()) {
						check = true;
						break;
					}
				}
			}
			if (check == false) {
				orderFoods.add(orderFoodsTemp.get(i));
			}
		}
		// sap xep
		orderFoods.sort((o1, o2) -> o1.getRegistration_date().compareTo(o2.getRegistration_date()));
	}

	// show food ca 1
	public void showListFoodShift1(OrderFood orderFood) {
		java.sql.Date abc = new java.sql.Date(orderFood.getRegistration_date().getTime());
		foodsShifts1 = FOOD_BY_DAY_SERVICE.findByDate(abc, ShiftsUtil.SHIFTS1_ID);

	}

	public void showListFoodShift2(OrderFood orderFood) {
		java.sql.Date abc = new java.sql.Date(orderFood.getRegistration_date().getTime());
		foodsShifts2 = FOOD_BY_DAY_SERVICE.findByDate(abc, ShiftsUtil.SHIFTS2_ID);
	}

	public void showListFoodShift3(OrderFood orderFood) {
		java.sql.Date abc = new java.sql.Date(orderFood.getRegistration_date().getTime());
		foodsShifts3 = FOOD_BY_DAY_SERVICE.findByDate(abc, ShiftsUtil.SHIFTS3_ID);
	}

	// ktra co phai ngay hien tai hay khong
	public boolean isDateCurrent(FoodByDay dateCheck) {
		Date dateCurrent = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(dateCurrent).equals(sdf.format(dateCheck.getFood_date()));
	}

	// ktra het han chua
	public boolean isExpired(FoodByDay dateCheck) {
		Date dateCurrent = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return dateCheck.getFood_date().before(dateCurrent);
	}

	// Cap nhat food theo ca cho user
	public void createOrUpdateFoodShifts1() {
		// ca duoc chon khong co mon nao
		if (food1Selected == null) {
			Notification.NOTI_WARN("Vui lòng chọn món");
			return;
		}
		if (food1Selected != null) {
			// dieu kien khong duoc dang ky mon cua ngay hom nay
			// ktra co phai ngay hien tai khong?
			boolean isCurrent = isDateCurrent(food1Selected);
			if (isCurrent) {
				Notification.NOTI_WARN("Vui lòng đăng ký trước 1 ngày");
				return;
			}
			if (!isCurrent) {
				boolean isExpired = isExpired(food1Selected);
				if (isExpired) {
					Notification.NOTI_WARN("Hết hạn đăng ký món ăn");
					return;
				}
				if (!isExpired) {
					OrderFood temp = ORDER_FOOD_SERVICE.findByDateAndEmployeeCode(food1Selected.getFood_date(),
							member.getCode());
					EmployeeDTO employee = new EmployeeDTO();
					try {
						employee = EMPLOYEE_SERVICE_PUBLIC.findByCode(member.getCode());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					if (temp.getEmployeeName() == null && employee.getName() != null) {
						OrderFood ofSave = new OrderFood();
						ofSave.setFood_by_date_shifts1(food1Selected);
						ofSave.setRegistration_date(food1Selected.getFood_date());
						ofSave.setEmployeeName(member.getName());
						ofSave.setEmployeeCode(member.getCode());
						ofSave.setDepartment_code(member.getDepartment().getCode());
						ofSave.setDepartment_name(member.getDepartment().getName());
						ofSave.setEmployee_id(employee.getCodeOld());
						OrderFood resultCreate = ORDER_FOOD_SERVICE.create(ofSave);
						if (resultCreate != null) {
							orderFoods = ORDER_FOOD_SERVICE.findByDayToDay(startDate, endDate, member.getCode());
							resetData(orderFoods);
						}
					} else {
						temp.setFood_by_date_shifts1(food1Selected);
						OrderFood resultUpdate = ORDER_FOOD_SERVICE.update(temp);
						if (resultUpdate != null) {
							orderFoods = ORDER_FOOD_SERVICE.findByDayToDay(startDate, endDate, member.getCode());
							resetData(orderFoods);
						}
					}
				}
			}
		}
	}

	public void createOrUpdateFoodShifts2() {
		// ca chon khong co mon
		if (food2Selected == null) {
			Notification.NOTI_WARN("Vui lòng chọn món");
			return;
		}
		if (food2Selected != null) {
			// kiem tra co phai ngay hien tai khong
			boolean isCurrent = isDateCurrent(food2Selected);
			if (isCurrent) {
				Notification.NOTI_WARN("Vui lòng đăng ký trước 1 ngày");
				return;
			}
			if (!isCurrent) {
				boolean isExpired = isExpired(food2Selected);
				if (isExpired) {
					Notification.NOTI_WARN("Hết hạn đăng ký món ăn");
					return;
				}
				if (!isExpired) {
					OrderFood temp = ORDER_FOOD_SERVICE.findByDateAndEmployeeCode(food2Selected.getFood_date(),
							member.getCode());
					if (temp == null) {
						OrderFood ofSave = new OrderFood();
						ofSave.setFood_by_date_shifts2(food2Selected);
						ofSave.setRegistration_date(food2Selected.getFood_date());
						ofSave.setEmployeeName(member.getName());
						ofSave.setEmployeeCode(member.getCode());
						OrderFood resultCreate = ORDER_FOOD_SERVICE.create(ofSave);
						if (resultCreate != null) {
							orderFoods = ORDER_FOOD_SERVICE.findByDayToDay(startDate, endDate, member.getCode());
							resetData(orderFoods);
						}
					} else {
						temp.setFood_by_date_shifts2(food2Selected);
						OrderFood resultUpdate = ORDER_FOOD_SERVICE.update(temp);
						if (resultUpdate != null) {
							orderFoods = ORDER_FOOD_SERVICE.findByDayToDay(startDate, endDate, member.getCode());
							resetData(orderFoods);
						}
					}
				}
			}
		}
	}

	public void createOrUpdateFoodShifts3() {
		// ca chon khong co mon
		if (food3Selected == null) {
			Notification.NOTI_WARN("Vui lòng chọn món");
			return;
		}
		if (food3Selected != null) {
			try {
				EmployeeDTO employee = EMPLOYEE_SERVICE_PUBLIC.findByCode(member.getCode());
				//neu lam viec theo ca moi duoc chon ca 3
				if (employee.isWorkShift()) {
					// kiem tra co phai ngay hien tai khong
					boolean isCurrent = isDateCurrent(food3Selected);
					if (isCurrent) {
						Notification.NOTI_WARN("Vui lòng đăng ký trước 1 ngày");
						return;
					}
					if (!isCurrent) {
						boolean isExpired = isExpired(food2Selected);
						if (isExpired) {
							Notification.NOTI_WARN("Hết hạn đăng ký món ăn");
							return;
						}
						if (!isExpired) {
							OrderFood temp = ORDER_FOOD_SERVICE.findByDateAndEmployeeCode(food3Selected.getFood_date(),
									member.getCode());
							if (temp == null) {
								OrderFood ofSave = new OrderFood();
								ofSave.setFood_by_date_shifts3(food3Selected);
								ofSave.setRegistration_date(food3Selected.getFood_date());
								ofSave.setEmployeeName(member.getName());
								ofSave.setEmployeeCode(member.getCode());
								OrderFood resultCreate = ORDER_FOOD_SERVICE.create(ofSave);
								if (resultCreate != null) {
									orderFoods = ORDER_FOOD_SERVICE.findByDayToDay(startDate, endDate,
											member.getCode());
									resetData(orderFoods);
								}
							} else {
								temp.setFood_by_date_shifts3(food3Selected);
								OrderFood resultUpdate = ORDER_FOOD_SERVICE.update(temp);
								if (resultUpdate != null) {
									orderFoods = ORDER_FOOD_SERVICE.findByDayToDay(startDate, endDate,
											member.getCode());
									resetData(orderFoods);
								}
							}
						}
					}
				}else {
					//nhan vien van phong
					Notification.NOTI_ERROR("Không được đăng ký");
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

	public int getYearSearch() {
		return yearSearch;
	}

	public void setYearSearch(int yearSearch) {
		this.yearSearch = yearSearch;
	}

	public int getMonthCopy() {
		return monthCopy;
	}

	public void setMonthCopy(int monthCopy) {
		this.monthCopy = monthCopy;
	}

	public int getYearCopy() {
		return yearCopy;
	}

	public void setYearCopy(int yearCopy) {
		this.yearCopy = yearCopy;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}

	public boolean isEmp() {
		return isEmp;
	}

	public void setEmp(boolean isEmp) {
		this.isEmp = isEmp;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public int getMonthSearch() {
		return monthSearch;
	}

	public void setMonthSearch(int monthSearch) {
		this.monthSearch = monthSearch;
	}

	public Department getDepartmentSearch() {
		return departmentSearch;
	}

	public void setDepartmentSearch(Department departmentSearch) {
		this.departmentSearch = departmentSearch;
	}

	public List<Department> getDepartmentSearchs() {
		return departmentSearchs;
	}

	public void setDepartmentSearchs(List<Department> departmentSearchs) {
		this.departmentSearchs = departmentSearchs;
	}

	public List<OrderFood> getOrderFoods() {
		return orderFoods;
	}

	public void setOrderFoods(List<OrderFood> orderFoods) {
		this.orderFoods = orderFoods;
	}

	public OrderFood getOrderFoodEdit() {
		return orderFoodEdit;
	}

	public void setOrderFoodEdit(OrderFood orderFoodEdit) {
		this.orderFoodEdit = orderFoodEdit;
	}

	public List<OrderFood> getOrderFilters() {
		return orderFilters;
	}

	public void setOrderFilters(List<OrderFood> orderFilters) {
		this.orderFilters = orderFilters;
	}

	public Department getDpm() {
		return dpm;
	}

	public void setDpm(Department dpm) {
		this.dpm = dpm;
	}

	public List<EmployeeDTO> getEmployeesByAdminDepartment() {
		return employeesByAdminDepartment;
	}

	public void setEmployeesByAdminDepartment(List<EmployeeDTO> employeesByAdminDepartment) {
		this.employeesByAdminDepartment = employeesByAdminDepartment;
	}

	public List<EmployeeDTO> getEmployeesByAdminDepartmentFilters() {
		return employeesByAdminDepartmentFilters;
	}

	public void setEmployeesByAdminDepartmentFilters(List<EmployeeDTO> employeesByAdminDepartmentFilters) {
		this.employeesByAdminDepartmentFilters = employeesByAdminDepartmentFilters;
	}

	public int getWeekSearch() {
		return weekSearch;
	}

	public void setWeekSearch(int weekSearch) {
		this.weekSearch = weekSearch;
	}

	public int getFromDay() {
		return fromDay;
	}

	public void setFromDay(int fromDay) {
		this.fromDay = fromDay;
	}

	public int getToDay() {
		return toDay;
	}

	public void setToDay(int toDay) {
		this.toDay = toDay;
	}

	public Date getFirstDayInMonthByWeekCurrent() {
		return firstDayInMonthByWeekCurrent;
	}

	public void setFirstDayInMonthByWeekCurrent(Date firstDayInMonthByWeekCurrent) {
		this.firstDayInMonthByWeekCurrent = firstDayInMonthByWeekCurrent;
	}

	public List<FoodByDay> getFoodsShifts1() {
		return foodsShifts1;
	}

	public void setFoodsShifts1(List<FoodByDay> foodsShifts1) {
		this.foodsShifts1 = foodsShifts1;
	}

	public List<FoodByDay> getFoodsShifts2() {
		return foodsShifts2;
	}

	public void setFoodsShifts2(List<FoodByDay> foodsShifts2) {
		this.foodsShifts2 = foodsShifts2;
	}

	public List<FoodByDay> getFoodsShifts3() {
		return foodsShifts3;
	}

	public void setFoodsShifts3(List<FoodByDay> foodsShifts3) {
		this.foodsShifts3 = foodsShifts3;
	}

	public FoodByDay getFood1Selected() {
		return food1Selected;
	}

	public void setFood1Selected(FoodByDay food1Selected) {
		this.food1Selected = food1Selected;
	}

	public FoodByDay getFood2Selected() {
		return food2Selected;
	}

	public void setFood2Selected(FoodByDay food2Selected) {
		this.food2Selected = food2Selected;
	}

	public FoodByDay getFood3Selected() {
		return food3Selected;
	}

	public void setFood3Selected(FoodByDay food3Selected) {
		this.food3Selected = food3Selected;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getYearOfWeek() {
		return yearOfWeek;
	}

	public void setYearOfWeek(int yearOfWeek) {
		this.yearOfWeek = yearOfWeek;
	}

}
