package trong.lixco.com.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;

import org.jboss.logging.Logger;

import trong.lixco.com.account.servicepublics.Member;
import trong.lixco.com.bean.staticentity.Notification;
import trong.lixco.com.bean.staticentity.ShiftsUtil;
import trong.lixco.com.ejb.service.CategoryFoodService;
import trong.lixco.com.ejb.service.FoodDayByDayService;
import trong.lixco.com.ejb.service.ShiftsService;
import trong.lixco.com.jpa.entity.CategoryFood;
import trong.lixco.com.jpa.entity.FoodByDay;
import trong.lixco.com.jpa.entity.OrderFood;
import trong.lixco.com.jpa.entity.Shifts;

@javax.faces.bean.ManagedBean
@ViewScoped
public class CaiDatMonAnBean extends AbstractBean<OrderFood> {
	private static final long serialVersionUID = 1L;

	private Member member;
	private int shifts = 1;
	private Date dateSearch;
	private List<FoodByDay> foodsByDate;
	private List<CategoryFood> categoryFoods;
	private List<CategoryFood> categoryFoodsFilter;
	private CategoryFood categoryFoodSelected;
	private List<CategoryFood> categoryFoodsSelected;
	private java.sql.Date dateSearchSQL;
	private int shifts1;
	private int shifts2;
	private int shifts3;

	@EJB
	private FoodDayByDayService FOOD_DAYBYDAY_SERVICE;
	@EJB
	private CategoryFoodService CATEGORY_FOOD_SERVICE;
	@EJB
	private ShiftsService SHIFTS_SERVICE;

	@Override
	protected void initItem() {
		// init variable
		dateSearch = new Date();
		dateSearchSQL = new java.sql.Date(dateSearch.getTime());
		try {
			foodsByDate = FOOD_DAYBYDAY_SERVICE.findByDate(dateSearchSQL, shifts);
		} catch (Exception e) {
		}
		member = getAccount().getMember();
		categoryFoods = CATEGORY_FOOD_SERVICE.findAll();
		shifts1 = ShiftsUtil.SHIFTS1_ID;
		shifts2 = ShiftsUtil.SHIFTS2_ID;
		shifts3 = ShiftsUtil.SHIFTS3_ID;
	}

	public void convertCategoryFoodToSelected() {
		try {
			List<CategoryFood> cfTemp = new ArrayList<>();
			for (FoodByDay f : foodsByDate) {
				cfTemp.add(f.getCategory_food());
			}
			categoryFoodsSelected = new ArrayList<>();
			if (!cfTemp.isEmpty()) {
				this.categoryFoodsSelected.addAll(cfTemp);
			}
		} catch (Exception e) {
		}
	}

	public void dateSearchChange() {
		try {
			java.sql.Date dateSearchSQL = new java.sql.Date(dateSearch.getTime());
			foodsByDate = FOOD_DAYBYDAY_SERVICE.findByDate(dateSearchSQL, shifts);
		} catch (Exception e) {
		}

	}

	public void shiftChange() {
		try {
			java.sql.Date dateSearchSQL = new java.sql.Date(dateSearch.getTime());
			foodsByDate = FOOD_DAYBYDAY_SERVICE.findByDate(dateSearchSQL, shifts);
		} catch (Exception e) {
		}
	}

//	public void addRowNew() {
//		FoodByDay foodTemp = new FoodByDay();
//		foodTemp.setCreatedUser(member.getName());
//		foodTemp.setFood_date(dateSearch);
//		Shifts sTemp = SHIFTS_SERVICE.findById(shifts);
//		foodTemp.setShifts(sTemp);
//		foodsByDate.add(foodTemp);
//	}
//
//	public void saveOrUpdate() {
//		// remove list deleted
//		for (FoodByDay f : foodsRemove) {
//			FOOD_DAYBYDAY_SERVICE.delete(f);
//		}
//
//		// update
//		for (int i = 0; i < foodsByDate.size(); i++) {
//			// chua co duoi db
//			if (foodsByDate.get(i).getId() == null) {
//				if (foodsByDate.get(i).getCategory_food() != null) {
//					FoodByDay a = FOOD_DAYBYDAY_SERVICE.create(foodsByDate.get(i));
//					if (a != null) {
//						System.out.println("Thanh cong");
//					} else {
//						System.out.println("That bai");
//					}
//				}
//			} else {
//				FOOD_DAYBYDAY_SERVICE.update(foodsByDate.get(i));
//			}
//		}
//		foodsRemove = new ArrayList<>();
//		CommonService.successNotify();
//	}

	public void deleteRow(FoodByDay item) {
		java.sql.Date dateSearchSQL = new java.sql.Date(dateSearch.getTime());
		try {
			boolean check = FOOD_DAYBYDAY_SERVICE.delete(item);
			if (check) {
				Notification.NOTI_SUCCESS("Xóa thành công");
				foodsByDate = FOOD_DAYBYDAY_SERVICE.findByDate(dateSearchSQL, shifts);
			} else {
				Notification.NOTI_ERROR("Xóa không thành công");
			}
		} catch (Exception e) {
		}
	}

	public void handleChooseFood() {
		java.sql.Date dateSearchSQL = new java.sql.Date(dateSearch.getTime());
		if (foodsByDate != null) {
			for (int i = 0; i < categoryFoodsSelected.size(); i++) {
				List<FoodByDay> queryChecked = FOOD_DAYBYDAY_SERVICE.findByDate(dateSearchSQL, shifts,
						categoryFoodsSelected.get(i).getId());
				if (queryChecked.isEmpty()) {
					FoodByDay foodNew = new FoodByDay();
					foodNew.setCategory_food(categoryFoodsSelected.get(i));
					foodNew.setFood_date(dateSearch);
					Shifts sTemp = SHIFTS_SERVICE.findById(shifts);
					foodNew.setShifts(sTemp);
					foodNew.setCreatedUser(member.getCode());
					foodNew.setCreatedDate(new java.util.Date());
					try {
						FOOD_DAYBYDAY_SERVICE.create(foodNew);
					} catch (Exception e) {
					}
				}
			}
			foodsByDate = FOOD_DAYBYDAY_SERVICE.findByDate(dateSearchSQL, shifts);
			Notification.NOTI_SUCCESS("Thành công");
		}
	}

	@Override
	protected Logger getLogger() {
		return null;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getDateSearch() {
		return dateSearch;
	}

	public void setDateSearch(Date dateSearch) {
		this.dateSearch = dateSearch;
	}

	public int getShifts() {
		return shifts;
	}

	public void setShifts(int shifts) {
		this.shifts = shifts;
	}

	public void setFoodsByDate(List<FoodByDay> foodsByDate) {
		this.foodsByDate = foodsByDate;
	}

	public List<FoodByDay> getFoodsByDate() {
		return foodsByDate;
	}

	public List<CategoryFood> getCategoryFoods() {
		return categoryFoods;
	}

	public void setCategoryFoods(List<CategoryFood> categoryFoods) {
		this.categoryFoods = categoryFoods;
	}

	public CategoryFood getCategoryFoodSelected() {
		return categoryFoodSelected;
	}

	public void setCategoryFoodSelected(CategoryFood categoryFoodSelected) {
		this.categoryFoodSelected = categoryFoodSelected;
	}

	public List<CategoryFood> getCategoryFoodsFilter() {
		return categoryFoodsFilter;
	}

	public void setCategoryFoodsFilter(List<CategoryFood> categoryFoodsFilter) {
		this.categoryFoodsFilter = categoryFoodsFilter;
	}

	public List<CategoryFood> getCategoryFoodsSelected() {
		return categoryFoodsSelected;
	}

	public void setCategoryFoodsSelected(List<CategoryFood> categoryFoodsSelected) {
		this.categoryFoodsSelected = categoryFoodsSelected;
	}

	public int getShifts1() {
		return shifts1;
	}

	public void setShifts1(int shifts1) {
		this.shifts1 = shifts1;
	}

	public int getShifts2() {
		return shifts2;
	}

	public void setShifts2(int shifts2) {
		this.shifts2 = shifts2;
	}

	public int getShifts3() {
		return shifts3;
	}

	public void setShifts3(int shifts3) {
		this.shifts3 = shifts3;
	}
}
