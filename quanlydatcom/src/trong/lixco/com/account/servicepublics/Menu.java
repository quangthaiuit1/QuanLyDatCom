/**
 * Menu.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public class Menu  extends trong.lixco.com.account.servicepublics.AbstractEntity  implements java.io.Serializable {
    private java.lang.String icon;

    private java.lang.String moTa;

    private trong.lixco.com.account.servicepublics.Menu parent;

    private trong.lixco.com.account.servicepublics.Program program;

    private java.lang.String tenHienThi;

    private java.lang.String url;

    public Menu() {
    }

    public Menu(
           java.util.Calendar createdDate,
           java.lang.String createdUser,
           boolean disable,
           java.lang.Long id,
           java.util.Calendar modifiedDate,
           java.lang.String note,
           boolean select,
           java.lang.String icon,
           java.lang.String moTa,
           trong.lixco.com.account.servicepublics.Menu parent,
           trong.lixco.com.account.servicepublics.Program program,
           java.lang.String tenHienThi,
           java.lang.String url) {
        super(
            createdDate,
            createdUser,
            disable,
            id,
            modifiedDate,
            note,
            select);
        this.icon = icon;
        this.moTa = moTa;
        this.parent = parent;
        this.program = program;
        this.tenHienThi = tenHienThi;
        this.url = url;
    }


    /**
     * Gets the icon value for this Menu.
     * 
     * @return icon
     */
    public java.lang.String getIcon() {
        return icon;
    }


    /**
     * Sets the icon value for this Menu.
     * 
     * @param icon
     */
    public void setIcon(java.lang.String icon) {
        this.icon = icon;
    }


    /**
     * Gets the moTa value for this Menu.
     * 
     * @return moTa
     */
    public java.lang.String getMoTa() {
        return moTa;
    }


    /**
     * Sets the moTa value for this Menu.
     * 
     * @param moTa
     */
    public void setMoTa(java.lang.String moTa) {
        this.moTa = moTa;
    }


    /**
     * Gets the parent value for this Menu.
     * 
     * @return parent
     */
    public trong.lixco.com.account.servicepublics.Menu getParent() {
        return parent;
    }


    /**
     * Sets the parent value for this Menu.
     * 
     * @param parent
     */
    public void setParent(trong.lixco.com.account.servicepublics.Menu parent) {
        this.parent = parent;
    }


    /**
     * Gets the program value for this Menu.
     * 
     * @return program
     */
    public trong.lixco.com.account.servicepublics.Program getProgram() {
        return program;
    }


    /**
     * Sets the program value for this Menu.
     * 
     * @param program
     */
    public void setProgram(trong.lixco.com.account.servicepublics.Program program) {
        this.program = program;
    }


    /**
     * Gets the tenHienThi value for this Menu.
     * 
     * @return tenHienThi
     */
    public java.lang.String getTenHienThi() {
        return tenHienThi;
    }


    /**
     * Sets the tenHienThi value for this Menu.
     * 
     * @param tenHienThi
     */
    public void setTenHienThi(java.lang.String tenHienThi) {
        this.tenHienThi = tenHienThi;
    }


    /**
     * Gets the url value for this Menu.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this Menu.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Menu)) return false;
        Menu other = (Menu) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.icon==null && other.getIcon()==null) || 
             (this.icon!=null &&
              this.icon.equals(other.getIcon()))) &&
            ((this.moTa==null && other.getMoTa()==null) || 
             (this.moTa!=null &&
              this.moTa.equals(other.getMoTa()))) &&
            ((this.parent==null && other.getParent()==null) || 
             (this.parent!=null &&
              this.parent.equals(other.getParent()))) &&
            ((this.program==null && other.getProgram()==null) || 
             (this.program!=null &&
              this.program.equals(other.getProgram()))) &&
            ((this.tenHienThi==null && other.getTenHienThi()==null) || 
             (this.tenHienThi!=null &&
              this.tenHienThi.equals(other.getTenHienThi()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getIcon() != null) {
            _hashCode += getIcon().hashCode();
        }
        if (getMoTa() != null) {
            _hashCode += getMoTa().hashCode();
        }
        if (getParent() != null) {
            _hashCode += getParent().hashCode();
        }
        if (getProgram() != null) {
            _hashCode += getProgram().hashCode();
        }
        if (getTenHienThi() != null) {
            _hashCode += getTenHienThi().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Menu.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "menu"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("icon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "icon"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moTa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moTa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "menu"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("program");
        elemField.setXmlName(new javax.xml.namespace.QName("", "program"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "program"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tenHienThi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tenHienThi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
