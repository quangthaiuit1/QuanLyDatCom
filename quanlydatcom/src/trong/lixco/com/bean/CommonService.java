package trong.lixco.com.bean;

import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;

public class CommonService {
	static public void successNotify() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Thông báo", "Cập nhật thành công .");
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}
}
