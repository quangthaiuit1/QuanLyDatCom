package trong.lixco.com.danhgianangluc.general;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.jboss.logging.Logger;
import org.primefaces.PrimeFaces;

import trong.lixco.com.account.servicepublics.Account;
import trong.lixco.com.account.servicepublics.AccountServicePublic;
import trong.lixco.com.account.servicepublics.AccountServicePublicProxy;
import trong.lixco.com.account.servicepublics.DepartNoticeRela;
import trong.lixco.com.account.servicepublics.DepartNoticeRelaServicePublic;
import trong.lixco.com.account.servicepublics.DepartNoticeRelaServicePublicProxy;
import trong.lixco.com.account.servicepublics.MemNoticeRela;
import trong.lixco.com.account.servicepublics.MemNoticeRelaServicePublic;
import trong.lixco.com.account.servicepublics.MemNoticeRelaServicePublicProxy;
import trong.lixco.com.account.servicepublics.Member;
import trong.lixco.com.account.servicepublics.MemberServicePublic;
import trong.lixco.com.account.servicepublics.MemberServicePublicProxy;
import trong.lixco.com.account.servicepublics.PrivateConfigServicePublic;
import trong.lixco.com.account.servicepublics.PrivateConfigServicePublicProxy;
import trong.lixco.com.classInfor.ChangePassword;
import trong.lixco.com.classInfor.NoticeSystem;
import trong.lixco.com.classInfor.PrivateConfig;
import trong.lixco.com.ejb.service.AccountDatabaseService;
import trong.lixco.com.jpa.entity.AccountDatabase;
import trong.lixco.com.util.Notify;

@ManagedBean
@SessionScoped
public class ApplicationBean implements Serializable {
	private static final long serialVersionUID = 1000L;
	private Notify notify;
	private Account account;
	private AccountServicePublic accountServicePublic;
	private MemNoticeRelaServicePublic memNoticeRelaServicePublic;
	private DepartNoticeRelaServicePublic departNoticeRelaServicePublic;
	private PrivateConfigServicePublic privateConfigServicePublic;
	private MemberServicePublic memberServicePublic;

	private ChangePassword changePassword;
	private List<NoticeSystem> noticeSystems;

	private PrivateConfig cf;
	private String hourLogin;
	@Inject
	private Logger logger;

	@PostConstruct
	public void init() {
		accountServicePublic = new AccountServicePublicProxy();
		memNoticeRelaServicePublic = new MemNoticeRelaServicePublicProxy();
		departNoticeRelaServicePublic = new DepartNoticeRelaServicePublicProxy();
		privateConfigServicePublic = new PrivateConfigServicePublicProxy();
		memberServicePublic = new MemberServicePublicProxy();

		changePassword = new ChangePassword();
		noticeSystems = new ArrayList<NoticeSystem>();
		SimpleDateFormat sf = new SimpleDateFormat("hh:mm");
		hourLogin = sf.format(new Date());
		setSettingPerson();
		try {
			if (!cf.isShowHeader()) {
				addclass();
			}
		} catch (Exception e) {
		}
	}

	public void updateAccountBD() {
		MemberServicePublic memberService = new MemberServicePublicProxy();
		AccountServicePublic acService = new AccountServicePublicProxy();
		try {
			Member[] findMemberForCode = memberService.findAll();
			PrivateConfigServicePublic prcfService = new PrivateConfigServicePublicProxy();
			for (int i = 0; i < findMemberForCode.length; i++) {
				if (findMemberForCode[i].isDisable() == false) {
					Account account = acService.findMember(findMemberForCode[i]);
					if (account == null) {

						trong.lixco.com.account.servicepublics.PrivateConfig privateConfig = new trong.lixco.com.account.servicepublics.PrivateConfig();
						PrivateConfig prcf = new PrivateConfig();
						privateConfig.setShowHeader(true);
						privateConfig.setThousandSeparator(".");
						privateConfig.setDecimalSeparator(",");
						privateConfig.setPattentDate(prcf.getFormatDate());
						StringBuffer pt = new StringBuffer("#,###,###,###,###,###,##0");
						privateConfig.setDecimalPattent(pt.toString());
						privateConfig.setDecimalNumber(prcf.getDecimalNumber());
						try {
							privateConfig = prcfService.create(privateConfig);
						} catch (RemoteException e) {
							e.printStackTrace();
						}

						account = new Account();
						account.setUserName(findMemberForCode[i].getCode());
						account.setPassword(RandomStringUtils.randomNumeric(4));
						account.setMember(findMemberForCode[i]);

						account.setPrivateConfig(privateConfig);
						acService.create(account);
					}
				}
			}
			FacesMessage msg = new FacesMessage("Thông báo!", "Thành công.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Doi mat khau
	public void changePassword() {
		notify = new Notify(FacesContext.getCurrentInstance());
		getAccountFormSession();
		if (account != null) {
			try {
				Account acc = accountServicePublic.findById(account.getId());
				if (changePassword.getPasswordOld().equals(acc.getPassword())) {
					acc.setPassword(changePassword.getPasswordNew());
					accountServicePublic.update(acc);
					notify.success();
					logger.info("(" + getAccount().getUserName() + "): Đổi mật khẩu " + acc.toString());
				} else {
					notify.warning("Không đúng mật khẩu cũ!");
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				notify.error();
			}
		}
	}

	// Hien thi thong bao he thong
	public void showNoticeSystem() {
		
		if (account != null) {
			try {
				account.setNotice(false);
				accountServicePublic.update(account);
				setAccountFormSession(account);
			} catch (RemoteException e1) {
			}
			try {
				MemNoticeRela[] memNoticeRelas = memNoticeRelaServicePublic.findByMember(account.getMember());
				DepartNoticeRela[] departNoticeRelas = departNoticeRelaServicePublic.findByDepartment(account
						.getMember().getDepartment());

				noticeSystems = new ArrayList<NoticeSystem>();
				if (departNoticeRelas != null)
					for (int i = 0; i < departNoticeRelas.length; i++) {
						NoticeSystem ns = new NoticeSystem();
						ns.setDate(departNoticeRelas[i].getNoticeSystem().getCreatedDate().getTime());
						ns.setTitle(departNoticeRelas[i].getNoticeSystem().getTitle());
						ns.setContent(departNoticeRelas[i].getNoticeSystem().getContent());
						noticeSystems.add(ns);
					}
				if (memNoticeRelas != null)
					for (int i = 0; i < memNoticeRelas.length; i++) {
						NoticeSystem ns = new NoticeSystem();
						ns.setDate(memNoticeRelas[i].getNoticeSystem().getCreatedDate().getTime());
						ns.setTitle(memNoticeRelas[i].getNoticeSystem().getTitle());
						ns.setContent(memNoticeRelas[i].getNoticeSystem().getContent());
						noticeSystems.add(ns);
					}
				noticeSystems.sort((NoticeSystem o1, NoticeSystem o2) -> o1.getDate().compareTo(o2.getDate()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	// Kiem tra co thong bao
	public void checkNotice() {
		
		try {
			Account acc = accountServicePublic.findById(account.getId());
			if (acc.isNotice()) {
				setAccountFormSession(acc);
			}
		} catch (Exception e) {
		}
	}


	// Dang xuat
	public void logout() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().invalidateSession();
			logger.info("(" + getAccount().getUserName() + "): Đăng xuất. ");
			context.getExternalContext().redirect(getPathLink()  + "/account/logout/");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Dang xuat
	public void logoutHome() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().invalidateSession();
			logger.info("(" + getAccount().getUserName() + "): Đăng xuất. ");
			context.getExternalContext().redirect(
					getPathLink() + "/account/pages/Start.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Inject
	AccountDatabaseService accountDatabaseService;

	public String getPathLink() {
		String path;
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		AccountDatabase accdb = accountDatabaseService.findByName("hethong");
		boolean check = checkAddressLocal(request);
		if (check) {
			path = accdb.getAddress();
		} else {
			path = accdb.getAddressPublic();
		}
		return path;
	}

	public boolean checkAddressLocal(HttpServletRequest request) {
		try {

			String ipAddress = request.getHeader("X-FORWARDED-FOR");// ip
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
				boolean temp = ipAddress.contains("192.168.");
				if (temp == false) {
					temp = ipAddress.contains("127.0.0.1");
				}
				return temp;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

	public void getAccountFormSession() {
		try {
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
					.getRequest();
			HttpSession session = req.getSession();
			account = (Account) session.getAttribute("account");
		} catch (Exception e) {

		}
	}

	public void setAccountFormSession(Account account) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpSession session = req.getSession();
		session.setAttribute("account", account);
	}

	public void saveSettingPerson() {
		
		notify = new Notify(FacesContext.getCurrentInstance());
		if (account != null) {
			trong.lixco.com.account.servicepublics.PrivateConfig privateConfig = new trong.lixco.com.account.servicepublics.PrivateConfig();
			privateConfig.setShowHeader(cf.isShowHeader());
			if (cf.getId() != 0)
				privateConfig.setId(cf.getId());
			if (cf.getDecimalSeparator().equals(".")) {
				privateConfig.setThousandSeparator(",");
				privateConfig.setDecimalSeparator(".");
			} else {
				privateConfig.setThousandSeparator(".");
				privateConfig.setDecimalSeparator(",");
			}
			privateConfig.setPattentDate(cf.getFormatDate());
			StringBuffer pt = new StringBuffer("#,###,###,###,###,###,##0");
			for (int i = 0; i < cf.getDecimalNumber(); i++) {
				if (i == 0) {
					pt.append(".");
				}
				pt.append("0");
			}
			privateConfig.setDecimalPattent(pt.toString());
			privateConfig.setDecimalNumber(cf.getDecimalNumber());
			if (privateConfig.getId() != null) {
				try {
					privateConfigServicePublic.update(privateConfig);
					logger.info("(" + getAccount().getUserName() + "): Cập nhật lại cấu hình cá nhân "
							+ privateConfig.toString());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			} else {
				try {
					privateConfig = privateConfigServicePublic.create(privateConfig);
					logger.info("(" + getAccount().getUserName() + "): Cài đặt cấu hình cá nhân "
							+ privateConfig.toString());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			try {
				Account acc = accountServicePublic.findById(account.getId());
				acc.setPrivateConfig(privateConfig);
				accountServicePublic.update(acc);
				setAccount(acc);
				cf = new PrivateConfig(privateConfig);
				setAccountFormSession(acc);
				notify.success();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public void saveShowHidenHeader() {
		
		notify = new Notify(FacesContext.getCurrentInstance());
		if (account != null) {
			trong.lixco.com.account.servicepublics.PrivateConfig privateConfig = new trong.lixco.com.account.servicepublics.PrivateConfig();
			privateConfig.setShowHeader(cf.isShowHeader());
			if (cf.getId() != 0)
				privateConfig.setId(cf.getId());
			if (cf.getDecimalSeparator().equals(".")) {
				privateConfig.setThousandSeparator(",");
				privateConfig.setDecimalSeparator(".");
			} else {
				privateConfig.setThousandSeparator(".");
				privateConfig.setDecimalSeparator(",");
			}
			privateConfig.setPattentDate(cf.getFormatDate());
			StringBuffer pt = new StringBuffer("#,###,###,###,###,###,##0");
			for (int i = 0; i < cf.getDecimalNumber(); i++) {
				if (i == 0) {
					pt.append(".");
				}
				pt.append("0");
			}
			privateConfig.setDecimalPattent(pt.toString());
			privateConfig.setDecimalNumber(cf.getDecimalNumber());
			if (privateConfig.getId() != null) {
				try {
					privateConfigServicePublic.update(privateConfig);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			} else {
				try {
					privateConfig = privateConfigServicePublic.create(privateConfig);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
			try {
				Account acc = accountServicePublic.findById(account.getId());
				acc.setPrivateConfig(privateConfig);
				accountServicePublic.update(acc);
				setAccount(acc);
				cf = new PrivateConfig(privateConfig);
				setAccountFormSession(acc);
			} catch (Exception e) {
			}

		}
	}

	public void setSettingPerson() {
		
		if (account == null)
			getAccountFormSession();
		if (account != null) {
			try {
				Account acc = accountServicePublic.findById(account.getId());
				HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
						.getRequest();
				HttpSession session = req.getSession();
				session.setAttribute("account", acc);
				setAccount(acc);

				trong.lixco.com.account.servicepublics.PrivateConfig privateConfig = acc.getPrivateConfig();
				if (privateConfig != null) {
					cf = new PrivateConfig(privateConfig);
				} else {
					cf = new PrivateConfig();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public void addclass() {
		cf.setShowHeader(false);
		saveShowHidenHeader();
		PrimeFaces.current().executeScript("addclass()");

	}

	public void removeclass() {
		cf.setShowHeader(true);
		saveShowHidenHeader();
		PrimeFaces.current().executeScript("removeclass()");
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<NoticeSystem> getNoticeSystems() {
		return noticeSystems;
	}

	public void setNoticeSystems(List<NoticeSystem> noticeSystems) {
		this.noticeSystems = noticeSystems;
	}

	public ChangePassword getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(ChangePassword changePassword) {
		this.changePassword = changePassword;
	}

	public PrivateConfig getCf() {
		return cf;
	}

	public void setCf(PrivateConfig cf) {
		this.cf = cf;
	}

	public String getHourLogin() {
		return hourLogin;
	}

	public void setHourLogin(String hourLogin) {
		this.hourLogin = hourLogin;
	}

}
