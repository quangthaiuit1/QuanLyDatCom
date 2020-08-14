/**
 * This class is made by Lam Quan Vu.
 * @Copyright 2013 by Lam Quan Vu. Email : LamQuanVu@gmail.com
 */
package trong.lixco.com.util;

import java.text.Normalizer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;

import trong.lixco.com.account.servicepublics.DepartmentServicePublic;
import trong.lixco.com.account.servicepublics.DepartmentServicePublicProxy;
import trong.lixco.com.account.servicepublics.MemberServicePublic;
import trong.lixco.com.account.servicepublics.MemberServicePublicProxy;
import trong.lixco.com.servicepublic.EmployeeDTO;

@ManagedBean
public class AbstractAutoComplete {

	MemberServicePublic memberServicePublic;
	DepartmentServicePublic departmentService;

	@PostConstruct
	public void init() {
		memberServicePublic = new MemberServicePublicProxy();
		departmentService = new DepartmentServicePublicProxy();
	}
	// Nhan vien
	// @SuppressWarnings("unchecked")
	// public List<EmployeeDTO> completeEmployee(final String containedStr)
	// throws NamingException, ClassNotFoundException {
	// FacesContext context = FacesContext.getCurrentInstance();
	// String filters = (String)
	// UIComponent.getCurrentComponent(context).getAttributes().get("filters");
	// String[] split = filters.split(",");
	// List<EmployeeDTO> linkedList = new LinkedList<EmployeeDTO>();
	// String searchText = converViToEn(containedStr);
	//
	//
	// linkedList = employeeService.findLike(split, "%" + searchText + "%");
	//
	// List<Employee> linkedListTemp = new LinkedList<Employee>();
	// if (searchText.contains("D")) {
	// linkedListTemp = employeeService.findLike(split, "%" +
	// containedStr.replace("D", "Đ") + "%");
	// linkedList.addAll(linkedListTemp);
	// }
	// if (containedStr.contains("d")) {
	// linkedListTemp = employeeService.findLike(split, "%" +
	// containedStr.replace("d", "đ") + "%");
	// linkedList.addAll(linkedListTemp);
	// }
	// return linkedList;
	// }
	public static String converViToEn(String s) {
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		String result = pattern.matcher(temp).replaceAll("");
		return pattern.matcher(result).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d");
	}
}
