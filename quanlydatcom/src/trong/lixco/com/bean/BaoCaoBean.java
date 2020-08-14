//package trong.lixco.com.bean;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.docx4j.org.xhtmlrenderer.pdf.ITextRenderer;
//import org.jboss.logging.Logger;
//import org.omnifaces.cdi.ViewScoped;
//import org.primefaces.PrimeFaces;
//
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import jxl.CellType;
//import trong.lixco.com.account.servicepublics.Department;
//import trong.lixco.com.account.servicepublics.DepartmentServicePublic;
//import trong.lixco.com.account.servicepublics.DepartmentServicePublicProxy;
//import trong.lixco.com.classInfor.BaoCaoTongHopTable;
//import trong.lixco.com.classInfor.BaoCaoTuyChonTable;
//import trong.lixco.com.classInfor.DanhGiaNhanVien;
//import trong.lixco.com.classInfor.NhanVienKyDanhGia;
//import trong.lixco.com.ejb.service.ChiTietNangLucService;
//import trong.lixco.com.ejb.service.KetQuaDanhGiaService;
//import trong.lixco.com.ejb.service.KhungNangLucService;
//import trong.lixco.com.ejb.service.KyDanhGiaService;
//import trong.lixco.com.ejb.service.LoaiKyDanhGiaService;
//import trong.lixco.com.ejb.service.NangLucService;
//import trong.lixco.com.jpa.dto.BaoCaoTongHopDTO;
//import trong.lixco.com.jpa.dto.BaoCaoTuyChonDTO;
//import trong.lixco.com.jpa.entity.KetQuaDanhGia;
//import trong.lixco.com.jpa.entity.KhungNangLuc;
//import trong.lixco.com.jpa.entity.KyDanhGia;
//import trong.lixco.com.jpa.entity.LoaiKyDanhGia;
//import trong.lixco.com.jpa.entity.NangLuc;
//import trong.lixco.com.servicepublic.EmployeeDTO;
//import trong.lixco.com.servicepublic.EmployeeServicePublic;
//import trong.lixco.com.servicepublic.EmployeeServicePublicProxy;
//import trong.lixco.com.servicepublic.PositionJobDTO;
//import trong.lixco.com.servicepublic.PositionJobServicePublic;
//import trong.lixco.com.servicepublic.PositionJobServicePublicProxy;
//import trong.lixco.com.util.DepartmentUtil;
//import trong.lixco.com.util.Notify;
//import trong.lixco.com.util.ToExcel;
//import trong.lixco.com.util.ToObjectFromClass;
//
//@Named
//@ViewScoped
//public class BaoCaoBean extends AbstractBean {
//	private static final long serialVersionUID = 1L;
//	private Notify notify;
//	private List<KhungNangLuc> khungNangLucs;
//	private KhungNangLuc khungNangLuc;
//
//	private LoaiKyDanhGia loaiKyDanhGiath;
//	private LoaiKyDanhGia loaiKyDanhGiatc;
//	private List<LoaiKyDanhGia> loaiKyDanhGias;
//
//	private KyDanhGia kyDanhGiath;
//	private KyDanhGia kyDanhGiatc;
//	private List<KyDanhGia> kyDanhGiaths;
//	private List<KyDanhGia> kyDanhGiatcs;
//
//	private Department departmentth;
//	private Department departmenttc;
//	private List<Department> departments;
//
//	private NangLuc nangLuc;
//	private List<NangLuc> nangLucs;
//
//	private int soluongnangluc;
//	private String loaidanhgia;
//	private String ketqua;
//
//	// Thai
//	private String loaiBaoCao = "";
//	private LoaiKyDanhGia loaiKyDanhGiaNangLuc;
//	private KyDanhGia kyDanhGiaNangLuc;
//	private List<KyDanhGia> kyDanhGiaNangLucs;
//	private Department departmentNangLuc;
//	private List<NangLuc> nangLucThais;
//	// End Thai
//
//	private PositionJobDTO positionJobDTO;
//	private List<PositionJobDTO> positionJobDTOs;
//
//	EmployeeServicePublic employeeServicePublic;
//	DepartmentServicePublic departmentServicePublic;
//	PositionJobServicePublic positionJobServicePublic;
//	@Inject
//	private NangLucService nangLucService;
//	@Inject
//	private KhungNangLucService khungNangLucService;
//	@Inject
//	private ChiTietNangLucService chiTietNangLucService;
//	@Inject
//	private Logger logger;
//	@Inject
//	private LoaiKyDanhGiaService loaiKyDanhGiaService;
//	@Inject
//	private KyDanhGiaService kyDanhGiaService;
//	@Inject
//	private KetQuaDanhGiaService ketQuaDanhGiaService;
//
//	List<BaoCaoTongHopDTO> baoCaoTongHopDTOs;
//	List<BaoCaoTuyChonDTO> baoCaoTuyChonDTOs;
//
//	@Override
//	protected Logger getLogger() {
//		return logger;
//	}
//
//	@Override
//	public void initItem() {
//		loaidanhgia = "";
//		ketqua = "";
//
//		baoCaoTongHopDTOs = new ArrayList<BaoCaoTongHopDTO>();
//		baoCaoTuyChonDTOs = new ArrayList<BaoCaoTuyChonDTO>();
//		departmentServicePublic = new DepartmentServicePublicProxy();
//		positionJobServicePublic = new PositionJobServicePublicProxy();
//		employeeServicePublic = new EmployeeServicePublicProxy();
//		departments = new ArrayList<Department>();
//		nangLucs = new ArrayList<NangLuc>();
//
//		loaiKyDanhGias = loaiKyDanhGiaService.findAll();
//		if (loaiKyDanhGias.size() != 0) {
//			loaiKyDanhGiath = loaiKyDanhGias.get(0);
//			ajaxLoaiKyDanhGiath();
//			loaiKyDanhGiatc = loaiKyDanhGias.get(0);
//			ajaxLoaiKyDanhGiatc();
//			loaiKyDanhGiaNangLuc = loaiKyDanhGias.get(0);
//			ajaxLoaiKyDanhGiaNangLuc();
//		}
//		try {
//			Department[] deps = departmentServicePublic.getAllDepartSubByParent("10001");
//			for (int i = 0; i < deps.length; i++) {
//				if (deps[i].getLevelDep().getLevel() <= 2)
//					departments.add(deps[i]);
//			}
//			if (departments.size() != 0) {
//				departments = DepartmentUtil.sort(departments);
//			}
//
//		} catch (Exception e) {
//		}
//	}
//
//	public void ajaxLoaiKyDanhGiath() {
//		if (loaiKyDanhGiath != null) {
//			try {
//				kyDanhGiaths = kyDanhGiaService.findRange(loaiKyDanhGiath);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public void ajaxLoaiKyDanhGiatc() {
//		if (loaiKyDanhGiatc != null) {
//			try {
//				kyDanhGiatcs = kyDanhGiaService.findRange(loaiKyDanhGiatc);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	// Thai
//	public void ajaxLoaiKyDanhGiaNangLuc() {
//		if (loaiKyDanhGiaNangLuc != null) {
//			try {
//				kyDanhGiaNangLucs = kyDanhGiaService.findRange(loaiKyDanhGiaNangLuc);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public void ajaxDepNangLuc() {
//		String codeDep = "";
//		if (departmentNangLuc != null)
//			codeDep = departmentNangLuc.getCode();
//		try {
//			nangLucThais = nangLucService.findDepartment(codeDep);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	// End Thai
//
//	public void ajaxDeptc() {
//		String codeDep = "";
//		if (departmenttc != null)
//			codeDep = departmenttc.getCode();
//		try {
//			nangLucs = nangLucService.findDepartment(codeDep);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void baocaotonghop() {
//		notify = new Notify(FacesContext.getCurrentInstance());
//		try {
//			if (kyDanhGiath != null) {
//				List<String> manvs = new ArrayList<String>();
//				if (departmentth != null) {
//					String[] codearr = { departmentth.getCode() };
//					EmployeeDTO[] employeeDTOs = employeeServicePublic.findByDep(codearr);
//					if (employeeDTOs != null)
//						for (int j = 0; j < employeeDTOs.length; j++) {
//							manvs.add(employeeDTOs[j].getCode());
//						}
//				}
//				baoCaoTongHopDTOs = ketQuaDanhGiaService.baocaotonghop(kyDanhGiath.getId(), soluongnangluc, manvs,
//						loaidanhgia);
//				System.out.println("baoCaoTongHopDTOs: " + baoCaoTongHopDTOs.size());
//			}
//		} catch (Exception e) {
//			writeLogError(e.getLocalizedMessage());
//			notify.warning("LÃ¡Â»â€”i khi lÃ†Â°u: " + e.getLocalizedMessage());
//		}
//	}
//
//	public void baocaotuychon() {
//		notify = new Notify(FacesContext.getCurrentInstance());
//		try {
//			List<String> manvs = new ArrayList<String>();
//			if (departmenttc != null) {
//				List<String> codeDeps = new ArrayList<String>();
//				codeDeps.add(departmenttc.getCode());
//				Department[] departments = departmentServicePublic.getAllDepartSubByParent(departmenttc.getCode());
//				if (departments != null)
//					for (int j = 0; j < departments.length; j++) {
//						codeDeps.add(departments[j].getCode());
//					}
//
//				String[] codearr = codeDeps.stream().toArray(String[]::new);
//				EmployeeDTO[] employeeDTOs = employeeServicePublic.findByDep(codearr);
//				if (employeeDTOs != null)
//					for (int j = 0; j < employeeDTOs.length; j++) {
//						manvs.add(employeeDTOs[j].getCode());
//					}
//			}
//			String manl = null;
//			if (nangLuc != null)
//				manl = nangLuc.getMa();
//			baoCaoTuyChonDTOs = ketQuaDanhGiaService.baocaotuychon(kyDanhGiatc.getId(), manvs, manl, ketqua);
//			for (int i = 0; i < baoCaoTuyChonDTOs.size(); i++) {
//				try {
//					EmployeeDTO emp = employeeServicePublic.findByCode(baoCaoTuyChonDTOs.get(i).getManv());
//					if (emp != null) {
//						baoCaoTuyChonDTOs.get(i).setMaphongban(emp.getCodeDepart());
//						baoCaoTuyChonDTOs.get(i).setPhongban(emp.getNameDepart());
//						baoCaoTuyChonDTOs.get(i).setTennv(emp.getName());
//					}
//					PositionJobDTO pos = positionJobServicePublic.findByCode(baoCaoTuyChonDTOs.get(i).getMachucdanh());
//					if (pos != null)
//						baoCaoTuyChonDTOs.get(i).setChucdanh(pos.getName());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//			}
//		} catch (Exception e) {
//			writeLogError(e.getLocalizedMessage());
//			notify.warning("Lá»—i khi táº£i: " + e.getLocalizedMessage());
//		}
//	}
//
//	public void baocaotuychonxls() {
//		try {
//			executeScript("target='_blank';monitorDownload( showStatus , hideStatus)");
//			List<Object[]> listObject = ToObjectFromClass.baocaotuychon(baoCaoTuyChonDTOs);
//			String filename = "baocao";
//			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
//					.getExternalContext().getResponse();
//			httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + filename + ".xlsx");
//			ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//			ToExcel.writeXLSX(listObject, servletOutputStream);
//			FacesContext.getCurrentInstance().responseComplete();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	// Thai
//
//	private static XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
//		XSSFFont font = workbook.createFont();
//		font.setBold(true);
//		XSSFCellStyle style = workbook.createCellStyle();
//		style.setFont(font);
//		return style;
//	}
//
//	public void baoCaoNangLucCanDaoTao() throws IOException {
////		PrimeFaces.current().executeScript("start().click()");
//		if (loaiBaoCao.equals("")) {
//			loaiBaoCao = "DT";
//		}
//		// handle data
//		// neu khong chon ky danh gia nao
//		if (kyDanhGiaNangLuc == null) {
//			kyDanhGiaNangLuc = kyDanhGiaNangLucs.get(0);
//		}
//		// Nang luc can dao tao
//		List<KetQuaDanhGia> listKetQuaDanhGia = new ArrayList<>();
//		if (loaiBaoCao.equals("DT")) {
//			listKetQuaDanhGia = ketQuaDanhGiaService.findByResultLessThan(100, kyDanhGiaNangLuc);
//		}
//		// Tuyen duong
//		if (loaiBaoCao.equals("TD")) {
//			listKetQuaDanhGia = ketQuaDanhGiaService.findByResultGreaterThan(100, kyDanhGiaNangLuc);
//		}
//
//		XSSFWorkbook workbook = new XSSFWorkbook();
//		XSSFSheet sheet = null;
//		if(loaiBaoCao.equals("DT")){
//			sheet = workbook.createSheet("BÃ¡o cÃ¡o nÄƒng lá»±c cáº§n Ä‘Ã o táº¡o");
//		}
//		if(loaiBaoCao.equals("TD")){
//			sheet = workbook.createSheet("BÃ¡o cÃ¡o nÄƒng lá»±c cáº§n tuyÃªn dÆ°Æ¡ng");
//		}
//		
//
//		int rownum = 0;
//		Cell cell;
//		Row row;
//		XSSFCellStyle style = createStyleForTitle(workbook);
//		style.setAlignment(CellStyle.ALIGN_CENTER);
//
//		CellStyle styleContent = workbook.createCellStyle();
//		row = sheet.createRow(rownum);
//
//		// EmpNo
//		cell = row.createCell(0);
//		cell.setCellValue("MÃ£ NV má»›i");
//
//		cell = row.createCell(5);
//		cell.setCellValue("NhÃ³m nÄƒng lá»±c");
//		cell.setCellStyle(style);
//		// xep loai
//		cell = row.createCell(6);
//		cell.setCellValue("MÃ£ nÄƒng lá»±c");
//		cell.setCellStyle(style);
//		// xep loai
//		cell = row.createCell(7);
//		cell.setCellValue("TÃªn nÄƒng lá»±c");
//		cell.setCellStyle(style);
//		// xep loai
//		cell = row.createCell(8);
//		cell.setCellValue("Káº¿t quáº£");
//		cell.setCellStyle(style);
//		// xep loai// EmpName
//		cell = row.createCell(1);
//		cell.setCellValue("MÃ£ NV cÅ©");
//		cell.setCellStyle(style);
//		// Salary
//		cell = row.createCell(2);
//		cell.setCellValue("PhÃ²ng");
//		cell.setCellStyle(style);
//		// Grade
//		cell = row.createCell(3);
//		cell.setCellValue("Há»� vÃ  tÃªn");
//		cell.setCellStyle(style);
//		// Bonus
//		cell = row.createCell(4);
//		cell.setCellValue("Chá»©c danh");
//		cell.setCellStyle(style);
//		// xep loai
//		cell = row.createCell(9);
//		cell.setCellValue("Nháº­n xÃ©t");
//		cell.setCellStyle(style);
//
////		 Data
//		for (KetQuaDanhGia kq : listKetQuaDanhGia) {
//			Gson gson = new Gson();
//			EmployeeDTO empTemp = employeeServicePublic.findByCode(kq.getManhanvien());
//			if (empTemp != null && kq.getChiTietNangLuc() != null) {
//				rownum++;
//				row = sheet.createRow(rownum);
//				// EmpNo (A)
//				cell = row.createCell(0);
//				cell.setCellValue(kq.getManhanvien());
//				// EmpName (B)
//				cell = row.createCell(1);
//				cell.setCellValue(empTemp.getCodeOld());
//				// phong
//				cell = row.createCell(2);
//				cell.setCellValue(empTemp.getNameDepart());
//				// ten nhan vien
//				cell = row.createCell(3);
//				cell.setCellValue(empTemp.getName());
//
//				// Chuc danh
//				String tenchucdanh = "";
//				Type listType = new TypeToken<List<NhanVienKyDanhGia>>() {
//				}.getType();
//				List<NhanVienKyDanhGia> nvs = gson.fromJson(this.kyDanhGiaNangLuc.getNhanviendanhgia(), listType);
//				for (int i = 0; i < nvs.size(); i++) {
//					if (nvs.get(i).getManhanvien().equals(kq.getManhanvien())) {
//						tenchucdanh = nvs.get(i).getTenchucdanh();
//						break;
//					}
//				}
//
//				cell = row.createCell(4);
//				cell.setCellValue(tenchucdanh);
//
//				// Nhom nang luc
//				cell = row.createCell(5);
//				cell.setCellValue(kq.getChiTietNangLuc().getNangLuc().getNhomNangLuc().getTen());
//				cell = row.createCell(6);
//				cell.setCellValue(kq.getManl());
//				cell = row.createCell(7);
//				cell.setCellValue(kq.getTennl());
//				cell = row.createCell(8);
//				cell.setCellValue(kq.getKetqua());
//				cell = row.createCell(9);
//				if (loaiBaoCao.equals("DT")) {
//					cell.setCellValue("KhÃ´ng Ä‘áº¡t");
//				}
//				if (loaiBaoCao.equals("TD")) {
//					cell.setCellValue("Xuáº¥t sáº¯c");
//				}
//			}
//		}
//
//		String filename = "baocaonangluc.xlsx";
//		FacesContext facesContext = FacesContext.getCurrentInstance();
//		ExternalContext externalContext = facesContext.getExternalContext();
//		externalContext.setResponseContentType("application/vnd.ms-excel");
//		externalContext.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
//		workbook.write(externalContext.getResponseOutputStream());
//		//cancel progress
//		facesContext.responseComplete();
//	}
//
//	// End Thai
//	public void chitiet(BaoCaoTuyChonDTO baoCaoTuyChonDTO) {
//		try {
//			FacesContext facesContext = FacesContext.getCurrentInstance();
//			ExternalContext externalContext = facesContext.getExternalContext();
//			HttpSession session = (HttpSession) externalContext.getSession(true);
//			HttpServletRequest ht = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
//					.getRequest();
//			ITextRenderer renderer = new ITextRenderer();
//			String url = "http://" + ht.getServerName() + ":" + ht.getServerPort()
//					+ "/danhgianangluc/pages/chitietdanhgia.htm?kydanhgia_id=" + baoCaoTuyChonDTO.getKyDanhGia().getId()
//					+ "&nv=" + baoCaoTuyChonDTO.getManv();
//
//			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public List<KyDanhGia> getKyDanhGiaNangLucs() {
//		return kyDanhGiaNangLucs;
//	}
//
//	public void setKyDanhGiaNangLucs(List<KyDanhGia> kyDanhGiaNangLucs) {
//		this.kyDanhGiaNangLucs = kyDanhGiaNangLucs;
//	}
//
//	public List<KhungNangLuc> getKhungNangLucs() {
//		return khungNangLucs;
//	}
//
//	public void setKhungNangLucs(List<KhungNangLuc> khungNangLucs) {
//		this.khungNangLucs = khungNangLucs;
//	}
//
//	public KhungNangLuc getKhungNangLuc() {
//		return khungNangLuc;
//	}
//
//	public void setKhungNangLuc(KhungNangLuc khungNangLuc) {
//		this.khungNangLuc = khungNangLuc;
//	}
//
//	public LoaiKyDanhGia getLoaiKyDanhGiath() {
//		return loaiKyDanhGiath;
//	}
//
//	public void setLoaiKyDanhGiath(LoaiKyDanhGia loaiKyDanhGiath) {
//		this.loaiKyDanhGiath = loaiKyDanhGiath;
//	}
//
//	public LoaiKyDanhGia getLoaiKyDanhGiatc() {
//		return loaiKyDanhGiatc;
//	}
//
//	public void setLoaiKyDanhGiatc(LoaiKyDanhGia loaiKyDanhGiatc) {
//		this.loaiKyDanhGiatc = loaiKyDanhGiatc;
//	}
//
//	public List<LoaiKyDanhGia> getLoaiKyDanhGias() {
//		return loaiKyDanhGias;
//	}
//
//	public void setLoaiKyDanhGias(List<LoaiKyDanhGia> loaiKyDanhGias) {
//		this.loaiKyDanhGias = loaiKyDanhGias;
//	}
//
//	public KyDanhGia getKyDanhGiath() {
//		return kyDanhGiath;
//	}
//
//	public void setKyDanhGiath(KyDanhGia kyDanhGiath) {
//		this.kyDanhGiath = kyDanhGiath;
//	}
//
//	public KyDanhGia getKyDanhGiatc() {
//		return kyDanhGiatc;
//	}
//
//	public void setKyDanhGiatc(KyDanhGia kyDanhGiatc) {
//		this.kyDanhGiatc = kyDanhGiatc;
//	}
//
//	public List<KyDanhGia> getKyDanhGiaths() {
//		return kyDanhGiaths;
//	}
//
//	public void setKyDanhGiaths(List<KyDanhGia> kyDanhGiaths) {
//		this.kyDanhGiaths = kyDanhGiaths;
//	}
//
//	public List<KyDanhGia> getKyDanhGiatcs() {
//		return kyDanhGiatcs;
//	}
//
//	public void setKyDanhGiatcs(List<KyDanhGia> kyDanhGiatcs) {
//		this.kyDanhGiatcs = kyDanhGiatcs;
//	}
//
//	public Department getDepartmentth() {
//		return departmentth;
//	}
//
//	public void setDepartmentth(Department departmentth) {
//		this.departmentth = departmentth;
//	}
//
//	public Department getDepartmenttc() {
//		return departmenttc;
//	}
//
//	public void setDepartmenttc(Department departmenttc) {
//		this.departmenttc = departmenttc;
//	}
//
//	public List<Department> getDepartments() {
//		return departments;
//	}
//
//	public void setDepartments(List<Department> departments) {
//		this.departments = departments;
//	}
//
//	public PositionJobDTO getPositionJobDTO() {
//		return positionJobDTO;
//	}
//
//	public void setPositionJobDTO(PositionJobDTO positionJobDTO) {
//		this.positionJobDTO = positionJobDTO;
//	}
//
//	public List<PositionJobDTO> getPositionJobDTOs() {
//		return positionJobDTOs;
//	}
//
//	public void setPositionJobDTOs(List<PositionJobDTO> positionJobDTOs) {
//		this.positionJobDTOs = positionJobDTOs;
//	}
//
//	public ChiTietNangLucService getChiTietNangLucService() {
//		return chiTietNangLucService;
//	}
//
//	public void setChiTietNangLucService(ChiTietNangLucService chiTietNangLucService) {
//		this.chiTietNangLucService = chiTietNangLucService;
//	}
//
//	public List<BaoCaoTongHopDTO> getBaoCaoTongHopDTOs() {
//		return baoCaoTongHopDTOs;
//	}
//
//	public void setBaoCaoTongHopDTOs(List<BaoCaoTongHopDTO> baoCaoTongHopDTOs) {
//		this.baoCaoTongHopDTOs = baoCaoTongHopDTOs;
//	}
//
//	public List<BaoCaoTuyChonDTO> getBaoCaoTuyChonDTOs() {
//		return baoCaoTuyChonDTOs;
//	}
//
//	public void setBaoCaoTuyChonDTOs(List<BaoCaoTuyChonDTO> baoCaoTuyChonDTOs) {
//		this.baoCaoTuyChonDTOs = baoCaoTuyChonDTOs;
//	}
//
//	public int getSoluongnangluc() {
//		return soluongnangluc;
//	}
//
//	public void setSoluongnangluc(int soluongnangluc) {
//		this.soluongnangluc = soluongnangluc;
//	}
//
//	public String getLoaidanhgia() {
//		return loaidanhgia;
//	}
//
//	public void setLoaidanhgia(String loaidanhgia) {
//		this.loaidanhgia = loaidanhgia;
//	}
//
//	public String getKetqua() {
//		return ketqua;
//	}
//
//	public void setKetqua(String ketqua) {
//		this.ketqua = ketqua;
//	}
//
//	public NangLuc getNangLuc() {
//		return nangLuc;
//	}
//
//	public void setNangLuc(NangLuc nangLuc) {
//		this.nangLuc = nangLuc;
//	}
//
//	public List<NangLuc> getNangLucs() {
//		return nangLucs;
//	}
//
//	public void setNangLucs(List<NangLuc> nangLucs) {
//		this.nangLucs = nangLucs;
//	}
//
//	public String getLoaiBaoCao() {
//		return loaiBaoCao;
//	}
//
//	public void setLoaiBaoCao(String loaiBaoCao) {
//		this.loaiBaoCao = loaiBaoCao;
//	}
//
//	public LoaiKyDanhGia getLoaiKyDanhGiaNangLuc() {
//		return loaiKyDanhGiaNangLuc;
//	}
//
//	public void setLoaiKyDanhGiaNangLuc(LoaiKyDanhGia loaiKyDanhGiaNangLuc) {
//		this.loaiKyDanhGiaNangLuc = loaiKyDanhGiaNangLuc;
//	}
//
//	public KyDanhGia getKyDanhGiaNangLuc() {
//		return kyDanhGiaNangLuc;
//	}
//
//	public void setKyDanhGiaNangLuc(KyDanhGia kyDanhGiaNangLuc) {
//		this.kyDanhGiaNangLuc = kyDanhGiaNangLuc;
//	}
//
//	public Department getDepartmentNangLuc() {
//		return departmentNangLuc;
//	}
//
//	public void setDepartmentNangLuc(Department departmentNangLuc) {
//		this.departmentNangLuc = departmentNangLuc;
//	}
//
//	public List<NangLuc> getNangLucThais() {
//		return nangLucThais;
//	}
//
//	public void setNangLucThais(List<NangLuc> nangLucThais) {
//		this.nangLucThais = nangLucThais;
//	}
//
//}
