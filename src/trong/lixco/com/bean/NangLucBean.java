//package trong.lixco.com.bean;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.faces.context.FacesContext;
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//import org.jboss.logging.Logger;
//import org.omnifaces.cdi.ViewScoped;
//import org.primefaces.PrimeFaces;
//import org.primefaces.event.FileUploadEvent;
//import org.primefaces.model.UploadedFile;
//
//import trong.lixco.com.account.servicepublics.Department;
//import trong.lixco.com.account.servicepublics.DepartmentServicePublic;
//import trong.lixco.com.account.servicepublics.DepartmentServicePublicProxy;
//import trong.lixco.com.ejb.service.ChiTietNangLucService;
//import trong.lixco.com.ejb.service.NangLucService;
//import trong.lixco.com.jpa.entity.ChiTietNangLuc;
//import trong.lixco.com.jpa.entity.NangLuc;
//import trong.lixco.com.util.DepartmentUtil;
//import trong.lixco.com.util.Notify;
//import trong.lixco.com.util.ToExcel;
//import trong.lixco.com.util.ToObjectFromClass;
//
//@Named
//@ViewScoped
//public class NangLucBean extends AbstractBean<NangLuc> {
//	private static final long serialVersionUID = 1L;
//	private Notify notify;
//	private List<NangLuc> nangLucs;
//	private NangLuc nangLuc;
//	private NangLuc nangLucEdit;
//	private ChiTietNangLuc cttoithieu;
//	private ChiTietNangLuc ctcoban;
//	private ChiTietNangLuc ctdatyeucau;
//	private ChiTietNangLuc ctthanhthao;
//	private ChiTietNangLuc ctxuatsac;
//
//	private Department departmentSearch;
//	private List<Department> departmentSearchs;
//
//	DepartmentServicePublic departmentServicePublic;
//	@Inject
//	private NangLucService nangLucService;
//	@Inject
//	private ChiTietNangLucService chiTietNangLucService;
//	@Inject
//	private Logger logger;
//
//	@Override
//	protected Logger getLogger() {
//		return logger;
//	}
//
//	@Override
//	public void initItem() {
//		reset();
//		departmentServicePublic = new DepartmentServicePublicProxy();
//		departmentSearchs = new ArrayList<Department>();
//		try {
//			Department[] deps = departmentServicePublic.getAllDepartSubByParent("10001");
//			for (int i = 0; i < deps.length; i++) {
//				if (deps[i].getLevelDep().getLevel() <= 2)
//					departmentSearchs.add(deps[i]);
//			}
//			if (departmentSearchs.size() != 0) {
//				departmentSearchs = DepartmentUtil.sort(departmentSearchs);
//			}
//
//		} catch (Exception e) {
//		}
//		search();
//	}
//
//	public void doctuExcel(FileUploadEvent event) {
//		notify = new Notify(FacesContext.getCurrentInstance());
//		UploadedFile uploadedFile = event.getFile();
//		uploadedFile.getFileName();
//		try {
//			uploadedFile.getInputstream();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		List<NangLuc> nangLucs = ToExcel.docexcelnangluc(uploadedFile);
//		if (nangLucs.size() != 0) {
//			if (allowSave(null)) {
//				nangLucService.luunangluctuexcel(nangLucs);
//				search();
//				PrimeFaces.current().executeScript("PF('nanglucchung').hide();");
//				notify.success();
//			} else {
//				notify.warningDetail();
//			}
//		} else {
//			showDialog("thongbao");
//		}
//	}
//
//	public void filemau() {
//		try {
//			PrimeFaces.current().executeScript("target='_blank';monitorDownload( showStatus , hideStatus)");
//			String filename = "File excel mau nang luc chung";
//			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
//					.getExternalContext().getResponse();
//			httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + filename + ".xlsx");
//			ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//			String file = FacesContext.getCurrentInstance().getExternalContext()
//					.getRealPath("/resources/maufile/maufilenanglucchung.xlsx");
//			InputStream inputStream = new FileInputStream(file);
//			byte[] buffer = new byte[1024];
//			int len;
//			while ((len = inputStream.read(buffer)) != -1) {
//				servletOutputStream.write(buffer, 0, len);
//			}
//			FacesContext.getCurrentInstance().responseComplete();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public void doctuExcelchuyenmon(FileUploadEvent event) {
//		notify = new Notify(FacesContext.getCurrentInstance());
//		UploadedFile uploadedFile = event.getFile();
//		uploadedFile.getFileName();
//		try {
//			uploadedFile.getInputstream();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		List<NangLuc> nangLucs = ToExcel.docexcelnangluc(uploadedFile);
//		if (nangLucs.size() != 0) {
//			if (allowSave(null)&&departmentSearch!=null) {
//				nangLucService.luunanglucchuyenmontuexcel(departmentSearch.getCode(),nangLucs);
//				search();
//				PrimeFaces.current().executeScript("PF('nanglucchuyenmon').hide();");
//				notify.success();
//			} else {
//				notify.warningDetail();
//			}
//		} else {
//			showDialog("thongbao");
//		}
//	}
//	public void filemauchuyenmon() {
//		try {
//			PrimeFaces.current().executeScript("target='_blank';monitorDownload( showStatus , hideStatus)");
//			String filename = "File excel mau nang luc chuyen mon";
//			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance()
//					.getExternalContext().getResponse();
//			httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + filename + ".xlsx");
//			ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
//			String file = FacesContext.getCurrentInstance().getExternalContext()
//					.getRealPath("/resources/maufile/maufilenanglucchuyenmon.xlsx");
//			InputStream inputStream = new FileInputStream(file);
//			byte[] buffer = new byte[1024];
//			int len;
//			while ((len = inputStream.read(buffer)) != -1) {
//				servletOutputStream.write(buffer, 0, len);
//			}
//			FacesContext.getCurrentInstance().responseComplete();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void search() {
//		String code = null;
//		if (departmentSearch != null)
//			code = departmentSearch.getCode();
//		nangLucs = nangLucService.findDepartment(code);
//	}
//
//	public void update() {
//		notify = new Notify(FacesContext.getCurrentInstance());
//		try {
//			if (nangLuc != null) {
//				if (!"".equals(nangLuc.getMa()) && !"".equals(nangLuc.getTen())) {
//					if (allowUpdate(null)) {
//						nangLuc = installUpdate(nangLuc);
//						nangLuc = nangLucService.update(nangLuc);
//						int index = nangLucs.indexOf(nangLuc);
//						nangLucs.set(index, nangLuc);
//						chiTietNangLucService.update(cttoithieu);
//						chiTietNangLucService.update(ctcoban);
//						chiTietNangLucService.update(ctdatyeucau);
//						chiTietNangLucService.update(ctthanhthao);
//						chiTietNangLucService.update(ctxuatsac);
//						writeLogInfo("Cập nhật " + nangLuc.toString());
//						notify.success();
//						search();
//					} else {
//						notify.warningDetail();
//					}
//				} else {
//					notify.warning("Điền đầy đủ thông tin!");
//				}
//			}
//		} catch (Exception e) {
//			writeLogError(e.getLocalizedMessage());
//			notify.warning("Mã đã tồn tại!");
//		}
//	}
//
//	public void reset() {
//		nangLuc = new NangLuc();
//		nangLucEdit = null;
//
//	}
//
//	public void showEdit() {
//		try {
//			this.nangLuc = nangLucService.findByIdAll(nangLucEdit.getId());
//			cttoithieu = nangLuc.getChiTietNangLucs().get(0);
//			ctcoban = nangLuc.getChiTietNangLucs().get(1);
//			ctdatyeucau = nangLuc.getChiTietNangLucs().get(2);
//			ctthanhthao = nangLuc.getChiTietNangLucs().get(3);
//			ctxuatsac = nangLuc.getChiTietNangLucs().get(4);
//			showDialog("chitiet");
//		} catch (Exception e) {
//			noticeDialog("Lỗi khi tải chi tiết năng lực.");
//		}
//
//	}
//
//	public void delete() {
//		notify = new Notify(FacesContext.getCurrentInstance());
//		if (nangLuc.getId() != null) {
//			if (allowDelete(null)) {
//				boolean status = nangLucService.delete(nangLuc);
//				if (status) {
//					nangLucs.remove(nangLuc);
//					writeLogInfo("Xoá " + nangLuc.toString());
//					reset();
//					search();
//					PrimeFaces.current().executeScript("PF('nanglucchuyenmon').hide();");
//					notify.success();
//
//				} else {
//					writeLogError("Lỗi khi xoá " + nangLuc.toString());
//					notify.error();
//				}
//			} else {
//				notify.warningDetail();
//			}
//		} else {
//			notify.warning("Chưa chọn trong danh sách!");
//		}
//	}
//
//	public List<NangLuc> getNangLucs() {
//		return nangLucs;
//	}
//
//	public void setNangLucs(List<NangLuc> NangLucs) {
//		this.nangLucs = NangLucs;
//	}
//
//	public NangLuc getNangLuc() {
//		return nangLuc;
//	}
//
//	public void setNangLuc(NangLuc NangLuc) {
//		this.nangLuc = NangLuc;
//	}
//
//	public NangLuc getNangLucEdit() {
//		return nangLucEdit;
//	}
//
//	public void setNangLucEdit(NangLuc NangLucEdit) {
//		this.nangLucEdit = NangLucEdit;
//	}
//
//	public Department getDepartmentSearch() {
//		return departmentSearch;
//	}
//
//	public void setDepartmentSearch(Department departmentSearch) {
//		this.departmentSearch = departmentSearch;
//	}
//
//	public List<Department> getDepartmentSearchs() {
//		return departmentSearchs;
//	}
//
//	public void setDepartmentSearchs(List<Department> departmentSearchs) {
//		this.departmentSearchs = departmentSearchs;
//	}
//
//	public ChiTietNangLuc getCttoithieu() {
//		return cttoithieu;
//	}
//
//	public void setCttoithieu(ChiTietNangLuc cttoithieu) {
//		this.cttoithieu = cttoithieu;
//	}
//
//	public ChiTietNangLuc getCtcoban() {
//		return ctcoban;
//	}
//
//	public void setCtcoban(ChiTietNangLuc ctcoban) {
//		this.ctcoban = ctcoban;
//	}
//
//	public ChiTietNangLuc getCtdatyeucau() {
//		return ctdatyeucau;
//	}
//
//	public void setCtdatyeucau(ChiTietNangLuc ctdatyeucau) {
//		this.ctdatyeucau = ctdatyeucau;
//	}
//
//	public ChiTietNangLuc getCtthanhthao() {
//		return ctthanhthao;
//	}
//
//	public void setCtthanhthao(ChiTietNangLuc ctthanhthao) {
//		this.ctthanhthao = ctthanhthao;
//	}
//
//	public ChiTietNangLuc getCtxuatsac() {
//		return ctxuatsac;
//	}
//
//	public void setCtxuatsac(ChiTietNangLuc ctxuatsac) {
//		this.ctxuatsac = ctxuatsac;
//	}
//
//}
