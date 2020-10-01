package trong.lixco.com.servlet;

import java.io.Closeable;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trong.lixco.com.account.servicepublics.Account;
import trong.lixco.com.account.servicepublics.AccountServicePublic;
import trong.lixco.com.account.servicepublics.AccountServicePublicProxy;
import trong.lixco.com.account.servicepublics.SingleSignOn;
import trong.lixco.com.danhgianangluc.general.AuthorizationManager;
import trong.lixco.com.ejb.service.AccountDatabaseService;
import trong.lixco.com.jpa.entity.AccountDatabase;
import trong.lixco.com.util.NameSytem;
import trong.lixco.com.util.StaticPath;

@WebServlet(name = "authorServlet", urlPatterns = { "/authorServlet/*" })
public class AuthorServlet extends HttpServlet {
	@Inject
	private AuthorizationManager authorizationManager;
	@Inject
	private AccountDatabaseService accountDatabaseService;

	private String path;
	private String pathlocal;
	private String pathcenter;

	protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String idStr = request.getParameter("id");
			String database = request.getParameter("database");
			if (idStr != null && database != null) {
				session.setAttribute("database", database);
				setPathLink(request);
				AccountServicePublic accountServicePublic = new AccountServicePublicProxy();
				String loginURL = path + "/account/pages/Start.jsf";
				SingleSignOn singleSignOn = accountServicePublic.findSSOById(Long.parseLong(idStr));
				if (singleSignOn != null) {
					Account account = accountServicePublic.findById(Long.parseLong(singleSignOn.getValue()));
					accountServicePublic.deleteSSO(singleSignOn);
					if (account != null) {
						// Kiem tra User nay co cho phep truy cap chuong
						// trinh hay khong
						// Neu cho phep thi cai dat bo quyen cho cho user
						boolean allow = authorizationManager.isAllowed(account);
						session.setAttribute("account", account);
						if (allow) {
							response.sendRedirect(pathlocal + "/quanlydatcom/pages/home.htm");
						} else {
							response.sendRedirect(pathlocal + "/quanlydatcom/pages/dangkycom.htm");
						}
					}
				} else {
					response.sendRedirect(loginURL);
				}
			} else {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setPathLink(HttpServletRequest request) {
		AccountDatabase accdb = accountDatabaseService.findByName(NameSytem.NAMEACCOUNT);
		boolean check = checkAddressLocal(request);
		if (check) {
			path = accdb.getAddress();
		} else {
			path = accdb.getAddressPublic();
		}
		StaticPath.setPath(path);

		AccountDatabase accdblocal = accountDatabaseService.findByName(NameSytem.NAMEPROGRAM);
		if (check) {
			pathlocal = accdblocal.getAddress();
		} else {
			pathlocal = accdblocal.getAddressPublic();
		}
		StaticPath.setPathLocal(pathlocal);

		AccountDatabase accdbcenter = accountDatabaseService.findByName(NameSytem.NAMEMAIN);
		if (check) {
			pathcenter = accdbcenter.getAddress();
		} else {
			pathcenter = accdbcenter.getAddressPublic();
		}
		StaticPath.setPathCenter(pathcenter);
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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequestPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequestPost(request, response);
	}

	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
			}
		}
	}

}
