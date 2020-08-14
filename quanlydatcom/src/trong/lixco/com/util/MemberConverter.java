package trong.lixco.com.util;

import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import trong.lixco.com.account.servicepublics.DepartmentServicePublic;
import trong.lixco.com.account.servicepublics.Member;
import trong.lixco.com.account.servicepublics.MemberServicePublic;
import trong.lixco.com.account.servicepublics.MemberServicePublicProxy;

@FacesConverter(value = "memberConverter")
public class MemberConverter implements Converter {
	MemberServicePublic memberServicePublic;
	DepartmentServicePublic departmentService;

	@PostConstruct
	public void init() {
		memberServicePublic = new MemberServicePublicProxy();
	}
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		Object backObj=null;
		try {
			backObj=	memberServicePublic.findId(Long.parseLong(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return backObj;

	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		 return String.valueOf(((Member) value).getId());
	}
}