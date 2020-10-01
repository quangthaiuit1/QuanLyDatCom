package trong.lixco.com.bean;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;
import org.omnifaces.cdi.ViewScoped;

import trong.lixco.com.account.servicepublics.Member;
import trong.lixco.com.bean.staticentity.Notification;
import trong.lixco.com.bean.staticentity.ShiftsUtil;
import trong.lixco.com.ejb.service.ReportFoodByDayService;
import trong.lixco.com.ejb.service.ShiftsService;
import trong.lixco.com.jpa.entity.OrderFood;
import trong.lixco.com.jpa.entity.ReportFoodByDay;
import trong.lixco.com.jpa.entity.Shifts;

@Named
@ViewScoped
public class BaoSuatAnBean extends AbstractBean<OrderFood> {

	private static final long serialVersionUID = 1L;
	private Date dateSearch;
	private ReportFoodByDay reportFood;
	private int quantityShifts1;
	private int quantityShifts2;
	private int quantityShifts3;
	private List<ReportFoodByDay> reportFoodsByDay;
	private Member member;

	@Inject
	private ReportFoodByDayService REPORT_FOOD_BY_DAY_SERVICE;
	@Inject
	private ShiftsService SHIFTS_SERVICE;

	@Override
	protected void initItem() {
		member = getAccount().getMember();
		reportFood = new ReportFoodByDay();
		dateSearch = new Date();
		java.sql.Date dateSearchSQL = new java.sql.Date(dateSearch.getTime());
		reportFoodsByDay = REPORT_FOOD_BY_DAY_SERVICE.findByDate(dateSearchSQL, 0L);
		if (!reportFoodsByDay.isEmpty()) {
			for (ReportFoodByDay r : reportFoodsByDay) {
				if (r.getShifts().getId() == ShiftsUtil.SHIFTS1_ID) {
					quantityShifts1 = r.getQuantity();
				}
				if (r.getShifts().getId() == ShiftsUtil.SHIFTS2_ID) {
					quantityShifts2 = r.getQuantity();
				}
				if (r.getShifts().getId() == ShiftsUtil.SHIFTS3_ID) {
					quantityShifts3 = r.getQuantity();
				}
			}
		}
	}

	public void dateSearchChange() {
		System.out.println(reportFood);
		reportFoodsByDay = REPORT_FOOD_BY_DAY_SERVICE.findByDate(dateSearch, 0L);
		if (!reportFoodsByDay.isEmpty()) {
			for (ReportFoodByDay r : reportFoodsByDay) {
				if (r.getShifts().getId() == ShiftsUtil.SHIFTS1_ID) {
					quantityShifts1 = r.getQuantity();
				}
				if (r.getShifts().getId() == ShiftsUtil.SHIFTS2_ID) {
					quantityShifts2 = r.getQuantity();
				}
				if (r.getShifts().getId() == ShiftsUtil.SHIFTS3_ID) {
					quantityShifts3 = r.getQuantity();
				}
			}
		}
		//chua co du lieu
		else {
			quantityShifts1 = 0;
			quantityShifts2 = 0;
			quantityShifts3 = 0;
		}
	}

	public void saveOrUpdate() {
		// kiem tra co chua -> co thi xoa roi them moi lai;
		List<ReportFoodByDay> checkExists = REPORT_FOOD_BY_DAY_SERVICE.findByDate(dateSearch, 0L);
		// kiem tra qua trinh xoa co thanh cong hay khong
		boolean deleteError = false;
		if (!checkExists.isEmpty()) {
			// xoa toan bo
			for (ReportFoodByDay r : checkExists) {
				boolean checkDel = REPORT_FOOD_BY_DAY_SERVICE.delete(r);
				if (!checkDel) {
					deleteError = true;
				}
			}
		}
		// neu xoa khong loi thi cho them moi
		if (!deleteError) {
			ReportFoodByDay newEntity = new ReportFoodByDay();
			newEntity.setReport_date(dateSearch);
			newEntity.setQuantity(quantityShifts1);
			Shifts shifts = SHIFTS_SERVICE.findById(ShiftsUtil.SHIFTS1_ID);
			newEntity.setShifts(shifts);
			newEntity.setCreatedUser(member.getCode());
			newEntity.setCreatedDate(new Date());
			ReportFoodByDay checkAddNew = REPORT_FOOD_BY_DAY_SERVICE.create(newEntity);
			if (checkAddNew == null) {
				Notification.NOTI_ERROR("Lỗi");
				return;
			}
			// them entity 2
			ReportFoodByDay newEntity1 = new ReportFoodByDay();
			newEntity1.setReport_date(dateSearch);
			newEntity1.setQuantity(quantityShifts2);
			Shifts shifts1 = SHIFTS_SERVICE.findById(ShiftsUtil.SHIFTS2_ID);
			newEntity1.setShifts(shifts1);
			newEntity1.setCreatedUser(member.getCode());
			newEntity1.setCreatedDate(new Date());
			ReportFoodByDay checkAddNew1 = REPORT_FOOD_BY_DAY_SERVICE.create(newEntity1);
			if (checkAddNew1 == null) {
				Notification.NOTI_ERROR("Lỗi");
				return;
			}

			// them entity 3
			ReportFoodByDay newEntity2 = new ReportFoodByDay();
			newEntity2.setReport_date(dateSearch);
			newEntity2.setQuantity(quantityShifts3);
			Shifts shifts2 = SHIFTS_SERVICE.findById(ShiftsUtil.SHIFTS3_ID);
			newEntity2.setShifts(shifts2);
			newEntity2.setCreatedUser(member.getCode());
			newEntity2.setCreatedDate(new Date());
			ReportFoodByDay checkAddNew2 = REPORT_FOOD_BY_DAY_SERVICE.create(newEntity2);
			if (checkAddNew2 == null) {
				Notification.NOTI_ERROR("Lỗi");
				return;
			}
			Notification.NOTI_SUCCESS("Thành công");
		}
	}

	@Override
	protected Logger getLogger() {
		return null;
	}

	public int getQuantityShifts1() {
		return quantityShifts1;
	}

	public void setQuantityShifts1(int quantityShifts1) {
		this.quantityShifts1 = quantityShifts1;
	}

	public int getQuantityShifts2() {
		return quantityShifts2;
	}

	public void setQuantityShifts2(int quantityShifts2) {
		this.quantityShifts2 = quantityShifts2;
	}

	public int getQuantityShifts3() {
		return quantityShifts3;
	}

	public void setQuantityShifts3(int quantityShifts3) {
		this.quantityShifts3 = quantityShifts3;
	}

	public Date getDateSearch() {
		return dateSearch;
	}

	public void setDateSearch(Date dateSearch) {
		this.dateSearch = dateSearch;
	}

	public ReportFoodByDay getReportFood() {
		return reportFood;
	}

	public void setReportFood(ReportFoodByDay reportFood) {
		this.reportFood = reportFood;
	}
}
