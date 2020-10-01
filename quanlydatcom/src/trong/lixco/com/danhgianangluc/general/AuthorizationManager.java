/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package trong.lixco.com.danhgianangluc.general;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import trong.lixco.com.account.servicepublics.Account;
import trong.lixco.com.account.servicepublics.AccountServicePublic;
import trong.lixco.com.account.servicepublics.AccountServicePublicProxy;
import trong.lixco.com.account.servicepublics.Program;
import trong.lixco.com.account.servicepublics.ProgramServicePublic;
import trong.lixco.com.account.servicepublics.ProgramServicePublicProxy;
import trong.lixco.com.account.servicepublics.Role;
import trong.lixco.com.account.servicepublics.UserRight;
import trong.lixco.com.account.servicepublics.UserRightServicePublic;
import trong.lixco.com.account.servicepublics.UserRightServicePublicProxy;
import trong.lixco.com.util.NameSytem;
import trong.lixco.com.util.UrlPermission;

@ManagedBean
@SessionScoped
public class AuthorizationManager implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String ANY_RESOURCE_PATTERN = "*";
	private List<UrlPermission> urlPermissions;
	private UrlPermission permission;
	private List<String> uriUnprotected;

	private AccountServicePublic accountServicePublic;
	private UserRightServicePublic userRightServicePublic;
	private ProgramServicePublic programServicePublic;

	@PostConstruct
	public void init() {
		accountServicePublic = new AccountServicePublicProxy();
		userRightServicePublic = new UserRightServicePublicProxy();
		programServicePublic = new ProgramServicePublicProxy();

		urlPermissions = new ArrayList<UrlPermission>();
		uriUnprotected = new ArrayList<String>();
		uriUnprotected.add("/quanlydatcom/pages/home.htm");
		uriUnprotected.add("/quanlydatcom/pages/dangkycom.htm");
	}

	public Program getProgram() {

		try {
			return programServicePublic.findByName(NameSytem.NAMEPROGRAM);
		} catch (RemoteException e) {
			return null;
		}
	}

	public boolean allowAccessForm(String uri) {
		boolean allow = false;
		for (int i = 0; i < uriUnprotected.size(); i++) {
			if (uriUnprotected.get(i).contains(uri)) {
				allow = true;
				break;
			}
		}
		if (allow == false) {
			for (int i = 0; i < urlPermissions.size(); i++) {
				if (urlPermissions.get(i).getUrl().contains(uri)) {
					permission = urlPermissions.get(i);
					allow = true;
					break;
				}
			}
		}
		return allow;
	}

	/*
	 * Kiem tra co cho phep truy cap. Neu cho phep thi set bo quyen cho account
	 * với chương trinh. Bo quyen cai dat duoc uu tien gia tri cho phep
	 */
	public boolean isAllowed(Account account) {
		init();
		boolean allow = false;
		try {
			Program[] programs = accountServicePublic.findProgramByAccount(account);
			for (int i = 0; i < programs.length; i++) {
				if (NameSytem.NAMEPROGRAM.equals(programs[i].getName())) {
					Role[] roles = accountServicePublic.findRoleByAccPro(account, programs[i]);
					for (int j = 0; j < roles.length; j++) {
						UserRight[] userRights = userRightServicePublic.findUserRightByRole(roles[j]);
						try {

							for (int k = 0; k < userRights.length; k++) {
								if (userRights[k].isAllow()) {
									UrlPermission item = new UrlPermission();
									item.setUrl(userRights[k].getFormList().getURL());
									item.setAllow(userRights[k].isAllow());
									item.setDelete(userRights[k].isDelete());
									item.setSave(userRights[k].isInsert());
									item.setUpdate(userRights[k].isUpdate());
									if (urlPermissions.size() == 0) {
										urlPermissions.add(item);
									} else {
										boolean status = urlPermissions.contains(item);
										if (status) {
											for (int l = 0; l < urlPermissions.size(); l++) {
												if (urlPermissions.get(i).equals(item)) {
													if (item.isDelete())
														urlPermissions.get(i).setDelete(true);
													if (item.isSave())
														urlPermissions.get(i).setSave(true);
													if (item.isUpdate())
														urlPermissions.get(i).setUpdate(true);
												}
											}
										} else {
											urlPermissions.add(item);
										}
									}
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
						}

					}
					allow = true;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allow;
	}

	private boolean matches(String pattern, String uri) {
		try {
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(uri);
			boolean b = m.matches();
			return b;
		} catch (PatternSyntaxException e) {
			return false;
		}

	}

	public List<UrlPermission> getUrlPermissions() {
		return urlPermissions;
	}

	// public void setUrlPermissions(List<UrlPermission> urlPermissions) {
	// this.urlPermissions = urlPermissions;
	// }

	public UrlPermission getPermission() {
		return permission;
	}

	public void setPermission(UrlPermission permission) {
		this.permission = permission;
	}

}