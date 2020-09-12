package trong.lixco.com.bean;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jboss.logging.Logger;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.PrimeFaces;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import trong.lixco.com.account.servicepublics.Department;
import trong.lixco.com.account.servicepublics.DepartmentServicePublic;
import trong.lixco.com.account.servicepublics.DepartmentServicePublicProxy;
import trong.lixco.com.bean.entities.OrderFoodReport;
import trong.lixco.com.bean.staticentity.Notification;
import trong.lixco.com.bean.staticentity.ShiftsUtil;
import trong.lixco.com.ejb.service.FoodNhaAnService;
import trong.lixco.com.ejb.service.OrderFoodService;
import trong.lixco.com.jpa.entity.FoodNhaAn;
import trong.lixco.com.jpa.entity.OrderFood;
import trong.lixco.com.servicepublic.EmployeeDTO;
import trong.lixco.com.servicepublic.EmployeeServicePublic;
import trong.lixco.com.servicepublic.EmployeeServicePublicProxy;

@Named
@ViewScoped
public class BaoCaoBean extends AbstractBean<OrderFood> {
	private static final long serialVersionUID = 1L;
	SimpleDateFormat formatter;
	private String loaiBaoCao;
	private List<FoodNhaAn> foodNhaAns;
	private int shifts;
	private Date dateSearch;
	private int shifts1;
	private int shifts2;
	private int shifts3;

	// du bao suat an
	private Date fromDate;
	private Date toDate;
	// chi tiet
	private Date fromDateDetail;
	private Date toDateDetail;

	private boolean[] checkedRenderView;
	private int valueChecked;

	@Inject
	private FoodNhaAnService FOOD_NHA_AN_SERVICE;
	@Inject
	private OrderFoodService ORDER_FOOD_SERVICE;

	EmployeeServicePublic EMPLOYEE_SERVICE_PUBLIC;
	DepartmentServicePublic DEPARTMENT_SERVICE_PUBLIC;

	@Override
	protected void initItem() {
		DEPARTMENT_SERVICE_PUBLIC = new DepartmentServicePublicProxy();
		EMPLOYEE_SERVICE_PUBLIC = new EmployeeServicePublicProxy();
		formatter = new SimpleDateFormat("dd-MM-yyyy");
		dateSearch = new Date();
		shifts1 = ShiftsUtil.SHIFTS1_ID;
		shifts2 = ShiftsUtil.SHIFTS2_ID;
		shifts3 = ShiftsUtil.SHIFTS3_ID;
		// du bao suat an
		fromDate = new Date();
		toDate = new Date();

		fromDateDetail = new Date();
		toDateDetail = new Date();

		checkedRenderView = new boolean[3];
		for (int i = 0; i < checkedRenderView.length; i++) {
			checkedRenderView[i] = false;
		}
	}

	public void handleRenderView() {
		// set false toan bo view
		for (int i = 0; i < checkedRenderView.length; i++) {
			checkedRenderView[i] = false;
		}
		if (valueChecked != 0) {
			// value checked == 1
			if (valueChecked == 1) {
				checkedRenderView[0] = true;
				PrimeFaces.current().ajax().update("formBaoCao");

				return;
			}
			if (valueChecked == 2) {
				checkedRenderView[1] = true;
				PrimeFaces.current().ajax().update("formBaoCao");
				return;
			}
			if (valueChecked == 3) {
				checkedRenderView[2] = true;
				PrimeFaces.current().ajax().update("formBaoCao");
				return;
			}
		} else {
			// set false toan bo view
			for (int i = 0; i < checkedRenderView.length; i++) {
				checkedRenderView[i] = false;
			}
			PrimeFaces.current().ajax().update("formBaoCao");
			return;
		}
	}

	private static XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public void baoCaoTheoNgayExcel() throws IOException {
		List<FoodNhaAn> foods = new ArrayList<>();
		String nameSheet = "";
		java.sql.Date dateSQL = new java.sql.Date(dateSearch.getTime());
		if (shifts == 0) {
			nameSheet = formatter.format(dateSearch);
			foods = FOOD_NHA_AN_SERVICE.findByDate(dateSQL, 0);
		}
		if (shifts == ShiftsUtil.SHIFTS1_ID) {
			nameSheet = ShiftsUtil.SHIFTS1_NAME + "-" + formatter.format(dateSearch);
			foods = FOOD_NHA_AN_SERVICE.findByDate(dateSQL, shifts);
		}
		if (shifts == ShiftsUtil.SHIFTS2_ID) {
			nameSheet = ShiftsUtil.SHIFTS2_NAME + "-" + formatter.format(dateSearch);
			foods = FOOD_NHA_AN_SERVICE.findByDate(dateSQL, shifts);
		}
		if (shifts == ShiftsUtil.SHIFTS3_ID) {
			nameSheet = ShiftsUtil.SHIFTS2_NAME + "-" + formatter.format(dateSearch);
			foods = FOOD_NHA_AN_SERVICE.findByDate(dateSQL, shifts);
		}
		// handle data
		// neu khong chon ky khao sat nao

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = null;
		sheet = workbook.createSheet(nameSheet);

		int rownum = 0;
		Cell cell;
		Row row;
		XSSFCellStyle style = createStyleForTitle(workbook);
		style.setAlignment(CellStyle.ALIGN_CENTER);

		// cell style for date
		XSSFCellStyle cellStyleDate = workbook.createCellStyle();
		CreationHelper createHelper = workbook.getCreationHelper();
		cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		XSSFCellStyle styleContent = workbook.createCellStyle();
		row = sheet.createRow(rownum);

		// EmpNo
		cell = row.createCell(0);
		cell.setCellValue("Mã NV");
		// xep loai// EmpName
		cell = row.createCell(1);
		cell.setCellValue("Tên NV");
		cell.setCellStyle(style);
		// Salary
		cell = row.createCell(2);
		cell.setCellValue("Phòng ban");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("Ngày");
		cell.setCellStyle(style);

		// Grade
		cell = row.createCell(4);
		cell.setCellValue("Ca làm việc");
		cell.setCellStyle(style);
		// Bonus
		cell = row.createCell(5);
		cell.setCellValue("Tên món");
		cell.setCellStyle(style);
		// xep loai

//		 Data
		if (!foods.isEmpty()) {
			for (FoodNhaAn f : foods) {
//				Gson gson = new Gson();
				rownum++;
				row = sheet.createRow(rownum);

				// Tim nhan vien
				EmployeeDTO employeeTemp = EMPLOYEE_SERVICE_PUBLIC.findByCode(f.getEmployee_code());
				if (employeeTemp != null) {
					// ma nhan vien
					cell = row.createCell(0);
					cell.setCellValue(employeeTemp.getCode());
					// ten nhan vien
					cell = row.createCell(1);
					cell.setCellValue(employeeTemp.getName());
				}
				// phong
				Department departmentTemp = DEPARTMENT_SERVICE_PUBLIC.findByCode("code", f.getDepartment_code());
				if (departmentTemp != null) {
					// ten phong ban
					cell = row.createCell(2);
					cell.setCellValue(departmentTemp.getName());
				}
				// ngay
				cell = row.createCell(3);
				cell.setCellValue(f.getFood_date());
				cell.setCellStyle(cellStyleDate);
				// ten ca lam viec
				cell = row.createCell(4);
				cell.setCellValue(f.getShifts().getName());
				// ten mon an
				cell = row.createCell(5);
				cell.setCellValue(f.getCategory_food().getName());
			}
		}

		String filename = "baocao.xlsx";
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.setResponseContentType("application/vnd.ms-excel");
		externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		workbook.write(externalContext.getResponseOutputStream());
		// cancel progress
		facesContext.responseComplete();
	}

	public void duBaoSuatAnPDF() {
		try {
			// list de gan qua report
			List<OrderFoodReport> ofsReport = new ArrayList<>();
			List<OrderFood> ofs = ORDER_FOOD_SERVICE.findByDayToDay(fromDate, toDate, null);
			if (!ofs.isEmpty()) {
				// set ca 3
				for (int i = 0; i < ofs.size(); i++) {
					if (ofs.get(i).getFood_by_date_shifts3() != null) {
						OrderFoodReport ofReport3 = new OrderFoodReport();
						ofReport3.setFoodName(ofs.get(i).getFood_by_date_shifts3().getCategory_food().getName());
						ofReport3.setShift(ofs.get(i).getFood_by_date_shifts3().getShifts().getId());
						ofReport3.setRegistrationDate(ofs.get(i).getRegistration_date());
						ofReport3.setSoluong(1);
						ofsReport.add(ofReport3);
					}
					if (ofs.get(i).getFood_by_date_shifts2() != null) {
						OrderFoodReport ofReport3 = new OrderFoodReport();
						ofReport3.setFoodName(ofs.get(i).getFood_by_date_shifts2().getCategory_food().getName());
						ofReport3.setShift(ofs.get(i).getFood_by_date_shifts2().getShifts().getId());
						ofReport3.setRegistrationDate(ofs.get(i).getRegistration_date());
						ofReport3.setSoluong(1);
						ofsReport.add(ofReport3);
					}
					if (ofs.get(i).getFood_by_date_shifts1() != null) {
						OrderFoodReport ofReport3 = new OrderFoodReport();
						ofReport3.setFoodName(ofs.get(i).getFood_by_date_shifts1().getCategory_food().getName());
						ofReport3.setShift(ofs.get(i).getFood_by_date_shifts1().getShifts().getId());
						ofReport3.setRegistrationDate(ofs.get(i).getRegistration_date());
						ofReport3.setSoluong(1);
						ofsReport.add(ofReport3);
					}
				}

//				for (int i = 0; i < ofs.size(); i++) {
//					if (ofs.get(i).getFood_by_date_shifts3() != null) {
//						boolean status = false;
//						for (int j = 0; j < ofsReport.size(); j++) {
//							if (ofs.get(i).getRegistration_date().equals(ofsReport.get(j).getRegistrationDate())
//									&& ofs.get(i).getFood_by_date_shifts3().getShifts().getId() == ofsReport.get(j)
//											.getShift()
//									&& ofs.get(i).getFood_by_date_shifts3().getCategory_food().getName()
//											.equals(ofsReport.get(j).getFoodName())) {
//								ofsReport.get(j).setSoluong(ofsReport.get(j).getSoluong() + 1);
//								status = true;
//								break;
//							}
//						}
//						if (!status) {
//							OrderFoodReport ofReport3 = new OrderFoodReport();
//							ofReport3.setFoodName(ofs.get(i).getFood_by_date_shifts3().getCategory_food().getName());
//							ofReport3.setShift(ofs.get(i).getFood_by_date_shifts3().getShifts().getId());
//							ofReport3.setRegistrationDate(ofs.get(i).getRegistration_date());
//							ofReport3.setSoluong(1);
//							ofsReport.add(ofReport3);
//						}
//					}
//					if (ofs.get(i).getFood_by_date_shifts2() != null) {
//						boolean status = false;
//						for (int j = 0; j < ofsReport.size(); j++) {
//							if (ofs.get(i).getRegistration_date().equals(ofsReport.get(j).getRegistrationDate())
//									&& ofs.get(i).getFood_by_date_shifts2().getShifts().getId() == ofsReport.get(j)
//											.getShift()
//									&& ofs.get(i).getFood_by_date_shifts2().getCategory_food().getName()
//											.equals(ofsReport.get(j).getFoodName())) {
//								ofsReport.get(j).setSoluong(ofsReport.get(j).getSoluong() + 1);
//								status = true;
//								break;
//							}
//						}
//						if (!status) {
//							OrderFoodReport ofReport3 = new OrderFoodReport();
//							ofReport3.setFoodName(ofs.get(i).getFood_by_date_shifts2().getCategory_food().getName());
//							ofReport3.setShift(ofs.get(i).getFood_by_date_shifts2().getShifts().getId());
//							ofReport3.setRegistrationDate(ofs.get(i).getRegistration_date());
//							ofReport3.setSoluong(1);
//							ofsReport.add(ofReport3);
//						}
//					}
//					if (ofs.get(i).getFood_by_date_shifts1() != null) {
//						boolean status = false;
//						for (int j = 0; j < ofsReport.size(); j++) {
//							if (ofs.get(i).getRegistration_date().equals(ofsReport.get(j).getRegistrationDate())
//									&& ofs.get(i).getFood_by_date_shifts1().getShifts().getId() == ofsReport.get(j)
//											.getShift()
//									&& ofs.get(i).getFood_by_date_shifts1().getCategory_food().getName()
//											.equals(ofsReport.get(j).getFoodName())) {
//								ofsReport.get(j).setSoluong(ofsReport.get(j).getSoluong() + 1);
//								status = true;
//								break;
//							}
//						}
//						if (!status) {
//							OrderFoodReport ofReport3 = new OrderFoodReport();
//							ofReport3.setFoodName(ofs.get(i).getFood_by_date_shifts1().getCategory_food().getName());
//							ofReport3.setShift(ofs.get(i).getFood_by_date_shifts1().getShifts().getId());
//							ofReport3.setRegistrationDate(ofs.get(i).getRegistration_date());
//							ofReport3.setSoluong(1);
//							ofsReport.add(ofReport3);
//						}
//					}

				ofsReport = sapxep(ofsReport);

//				Collections.sort(ofsReport);
//				System.out.println(ofsReport);

				// report
				String reportPath = FacesContext.getCurrentInstance().getExternalContext()
						.getRealPath("/resources/reports/dubaosuatan.jasper");
				// check neu list rong~
				if (!ofsReport.isEmpty()) {
					JRDataSource beanDataSource = new JRBeanCollectionDataSource(ofsReport);
					Map<String, Object> importParam = new HashMap<String, Object>();
					String image = FacesContext.getCurrentInstance().getExternalContext()
							.getRealPath("/resources/gfx/lixco_logo.png");
					importParam.put("logo", image);
					JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, importParam, beanDataSource);
					FacesContext facesContext = FacesContext.getCurrentInstance();
					OutputStream outputStream;
					outputStream = facesContext.getExternalContext().getResponseOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
					facesContext.responseComplete();
				} else {
					Notification.NOTI_ERROR("Không có dữ liệu");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void baoCaoChiTietPDF() {
		try {
			// list de gan qua report
			List<OrderFoodReport> ofsReport = new ArrayList<>();
			List<OrderFood> ofs = ORDER_FOOD_SERVICE.findByDayToDaySortByDate(fromDateDetail, toDateDetail);
			if (!ofs.isEmpty()) {
				// set ca 3
				for (int i = 0; i < ofs.size(); i++) {
					if (ofs.get(i).getFood_by_date_shifts1() != null) {
						OrderFoodReport ofrTemp = new OrderFoodReport();
						ofrTemp.setFoodName(ofs.get(i).getFood_by_date_shifts1().getCategory_food().getName());
						ofrTemp.setRegistrationDate(ofs.get(i).getRegistration_date());
						ofsReport.add(ofrTemp);
					}
					if (ofs.get(i).getFood_by_date_shifts2() != null) {
						// add item2
						OrderFoodReport ofrTemp1 = new OrderFoodReport();
						ofrTemp1 = new OrderFoodReport();
						ofrTemp1.setFoodName(ofs.get(i).getFood_by_date_shifts2().getCategory_food().getName());
						ofrTemp1.setRegistrationDate(ofs.get(i).getRegistration_date());
						ofsReport.add(ofrTemp1);
					}
					if (ofs.get(i).getFood_by_date_shifts3() != null) {
						// add item 3
						OrderFoodReport ofrTemp2 = new OrderFoodReport();
						ofrTemp2 = new OrderFoodReport();
						ofrTemp2.setFoodName(ofs.get(i).getFood_by_date_shifts3().getCategory_food().getName());
						ofrTemp2.setRegistrationDate(ofs.get(i).getRegistration_date());
						ofsReport.add(ofrTemp2);
					}
				}

				ofsReport = sortByDateAndFoodName(ofsReport);

				// report
				String reportPath = FacesContext.getCurrentInstance().getExternalContext()
						.getRealPath("/resources/reports/baocaochitiet.jasper");
				// check neu list rong~
				if (!ofsReport.isEmpty()) {
					JRDataSource beanDataSource = new JRBeanCollectionDataSource(ofsReport);
					Map<String, Object> importParam = new HashMap<String, Object>();
					String image = FacesContext.getCurrentInstance().getExternalContext()
							.getRealPath("/resources/gfx/lixco_logo.png");
					importParam.put("logo", image);
					JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, importParam, beanDataSource);
					FacesContext facesContext = FacesContext.getCurrentInstance();
					OutputStream outputStream;
					outputStream = facesContext.getExternalContext().getResponseOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
					facesContext.responseComplete();
				} else {
					Notification.NOTI_ERROR("Không có dữ liệu");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// bao cao chi tiet excel
	public void baoCaoChiTietExcel() throws IOException {

		List<OrderFoodReport> ofsReport = new ArrayList<>();
		List<OrderFood> ofs = ORDER_FOOD_SERVICE.findByDayToDaySortByDate(fromDateDetail, toDateDetail);
		if (!ofs.isEmpty()) {
			// set ca 3
			for (int i = 0; i < ofs.size(); i++) {
				if (ofs.get(i).getFood_by_date_shifts1() != null) {
					boolean status = false;
					// kiem tra co chua de tang so luong len
					for (int j = 0; j < ofsReport.size(); j++) {
						if (ofsReport.get(j).getRegistrationDate().equals(ofs.get(i).getRegistration_date())
								&& ofsReport.get(j).getFoodName()
										.equals(ofs.get(i).getFood_by_date_shifts1().getCategory_food().getName())) {
							status = true;
							int slTemp = ofsReport.get(j).getSoluong();
							ofsReport.get(j).setSoluong(slTemp + 1);
							break;
						}
					}
					if (!status) {
						OrderFoodReport ofrTemp1 = new OrderFoodReport();
						ofrTemp1.setFoodName(ofs.get(i).getFood_by_date_shifts1().getCategory_food().getName());
						ofrTemp1.setRegistrationDate(ofs.get(i).getRegistration_date());
						ofrTemp1.setSoluong(1);
						ofsReport.add(ofrTemp1);
					}

				}
				if (ofs.get(i).getFood_by_date_shifts2() != null) {
					boolean status = false;
					// kiem tra co chua de tang so luong len
					for (int j = 0; j < ofsReport.size(); j++) {
						if (ofsReport.get(j).getRegistrationDate().equals(ofs.get(i).getRegistration_date())
								&& ofsReport.get(j).getFoodName()
										.equals(ofs.get(i).getFood_by_date_shifts2().getCategory_food().getName())) {
							status = true;
							int slTemp = ofsReport.get(j).getSoluong();
							ofsReport.get(j).setSoluong(slTemp + 1);
							break;
						}
					}
					if (!status) {
						// add item2
						OrderFoodReport ofrTemp2 = new OrderFoodReport();
						ofrTemp2.setFoodName(ofs.get(i).getFood_by_date_shifts2().getCategory_food().getName());
						ofrTemp2.setRegistrationDate(ofs.get(i).getRegistration_date());
						ofrTemp2.setSoluong(1);
						ofsReport.add(ofrTemp2);
					}
				}
				if (ofs.get(i).getFood_by_date_shifts3() != null) {
					boolean status = false;
					// kiem tra co chua de tang so luong len
					for (int j = 0; j < ofsReport.size(); j++) {
						if (ofsReport.get(j).getRegistrationDate().equals(ofs.get(i).getRegistration_date())
								&& ofsReport.get(j).getFoodName()
										.equals(ofs.get(i).getFood_by_date_shifts3().getCategory_food().getName())) {
							status = true;
							int slTemp = ofsReport.get(j).getSoluong();
							ofsReport.get(j).setSoluong(slTemp + 1);
							break;
						}
					}
					if (!status) {
						// add item 3
						OrderFoodReport ofrTemp3 = new OrderFoodReport();
						ofrTemp3.setFoodName(ofs.get(i).getFood_by_date_shifts3().getCategory_food().getName());
						ofrTemp3.setRegistrationDate(ofs.get(i).getRegistration_date());
						ofrTemp3.setSoluong(1);
						ofsReport.add(ofrTemp3);
					}
				}
			}
		}

		String nameSheet = "";
		nameSheet = "BC CHI TIẾT";
		// handle data
		// neu khong chon ky khao sat nao

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = null;
		sheet = workbook.createSheet(nameSheet);

		int rownum = 0;
		Cell cell;
		Row row;
		XSSFCellStyle style = createStyleForTitle(workbook);
		style.setAlignment(CellStyle.ALIGN_CENTER);

		// cell style for date
		XSSFCellStyle cellStyleDate = workbook.createCellStyle();
		CreationHelper createHelper = workbook.getCreationHelper();
		cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		row = sheet.createRow(rownum);

		// EmpNo
		cell = row.createCell(0);
		cell.setCellValue("Ngày");
		// xep loai// EmpName
		cell = row.createCell(1);
		cell.setCellValue("Tên món ăn");
		cell.setCellStyle(style);
		// Salary
		cell = row.createCell(2);
		cell.setCellValue("Số lượng");
		cell.setCellStyle(style);

//		 Data
		if (!ofsReport.isEmpty()) {
			for (OrderFoodReport o : ofsReport) {
				rownum++;
				row = sheet.createRow(rownum);

				// ngay
				cell = row.createCell(0);
				cell.setCellValue(o.getRegistrationDate());
				cell.setCellStyle(cellStyleDate);
				// ten ca lam viec
				cell = row.createCell(1);
				cell.setCellValue(o.getFoodName());
				// ten mon an
				cell = row.createCell(5);
				cell.setCellValue(o.getSoluong());
			}
		}

		String filename = "baocao.xlsx";
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		externalContext.setResponseContentType("application/vnd.ms-excel");
		externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		workbook.write(externalContext.getResponseOutputStream());
		// cancel progress
		facesContext.responseComplete();
	}

	private List<OrderFoodReport> sapxep(List<OrderFoodReport> items) {
		try {
			Collections.sort(items, new Comparator<OrderFoodReport>() {
				@Override
				public int compare(OrderFoodReport sv1, OrderFoodReport sv2) {
					try {
						boolean ngay = sv1.getRegistrationDate().equals(sv2.getRegistrationDate());
						if (ngay) {
							if (sv1.getShift() > sv2.getShift()) {
								return 1;
							} else if (sv1.getShift() == sv2.getShift()) {
								return sv1.getFoodName().compareTo(sv2.getFoodName());
							} else {
								return -1;
							}
						} else {
							boolean ngayss = sv1.getRegistrationDate().before(sv2.getRegistrationDate());
							if (ngayss)
								return -1;
							return 1;
						}
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

	private List<OrderFoodReport> sortByDateAndFoodName(List<OrderFoodReport> items) {
		try {
			Collections.sort(items, new Comparator<OrderFoodReport>() {
				@Override
				public int compare(OrderFoodReport sv1, OrderFoodReport sv2) {
					try {
						boolean ngay = sv1.getRegistrationDate().equals(sv2.getRegistrationDate());
						if (ngay) {
							return sv1.getFoodName().compareTo(sv2.getFoodName());
						} else {
							boolean ngayss = sv1.getRegistrationDate().before(sv2.getRegistrationDate());
							if (ngayss)
								return -1;
							return 1;
						}
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

	@Override
	protected Logger getLogger() {
		return null;
	}

	public List<FoodNhaAn> getFoodNhaAns() {
		return foodNhaAns;
	}

	public void setFoodNhaAns(List<FoodNhaAn> foodNhaAns) {
		this.foodNhaAns = foodNhaAns;
	}

	public int getShifts() {
		return shifts;
	}

	public void setShifts(int shifts) {
		this.shifts = shifts;
	}

	public Date getDateSearch() {
		return dateSearch;
	}

	public void setDateSearch(Date dateSearch) {
		this.dateSearch = dateSearch;
	}

	public String getLoaiBaoCao() {
		return loaiBaoCao;
	}

	public void setLoaiBaoCao(String loaiBaoCao) {
		this.loaiBaoCao = loaiBaoCao;
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

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getFromDateDetail() {
		return fromDateDetail;
	}

	public void setFromDateDetail(Date fromDateDetail) {
		this.fromDateDetail = fromDateDetail;
	}

	public Date getToDateDetail() {
		return toDateDetail;
	}

	public void setToDateDetail(Date toDateDetail) {
		this.toDateDetail = toDateDetail;
	}

	public boolean[] getCheckedRenderView() {
		return checkedRenderView;
	}

	public void setCheckedRenderView(boolean[] checkedRenderView) {
		this.checkedRenderView = checkedRenderView;
	}

	public int getValueChecked() {
		return valueChecked;
	}

	public void setValueChecked(int valueChecked) {
		this.valueChecked = valueChecked;
	}
}
