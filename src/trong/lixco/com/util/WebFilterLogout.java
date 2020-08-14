package trong.lixco.com.util;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;

import trong.lixco.com.account.servicepublics.Account;

@javax.servlet.annotation.WebFilter("/logout/*")
public class WebFilterLogout implements Filter {
	@Inject
	private Logger logger;
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException,
			IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		try {
			Account account = (Account) session.getAttribute("account");
			if (account != null)
				logger.info("(" + account.getUserName() + "): Đăng xuất. ");
			session.removeAttribute("account");
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().invalidateSession();
			context.getExternalContext().redirect(StaticPath.getPath() + "/account/logout/");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}