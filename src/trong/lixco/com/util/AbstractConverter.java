package trong.lixco.com.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.thoughtworks.xstream.XStream;

@FacesConverter(value = "abstractConverter")
public class AbstractConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		XStream stream = new XStream();
		Object backObj=null;
		try {
			 backObj = stream.fromXML(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return backObj;

	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		XStream stream = new XStream();
		String xml = stream.toXML(value);
		return xml;
	}
}