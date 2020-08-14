/**
 * DepartNoticeRela.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public class DepartNoticeRela  extends trong.lixco.com.account.servicepublics.AbstractEntity  implements java.io.Serializable {
    private trong.lixco.com.account.servicepublics.Department department;

    private trong.lixco.com.account.servicepublics.NoticeSystem noticeSystem;

    public DepartNoticeRela() {
    }

    public DepartNoticeRela(
           java.util.Calendar createdDate,
           java.lang.String createdUser,
           boolean disable,
           java.lang.Long id,
           java.util.Calendar modifiedDate,
           java.lang.String note,
           boolean select,
           trong.lixco.com.account.servicepublics.Department department,
           trong.lixco.com.account.servicepublics.NoticeSystem noticeSystem) {
        super(
            createdDate,
            createdUser,
            disable,
            id,
            modifiedDate,
            note,
            select);
        this.department = department;
        this.noticeSystem = noticeSystem;
    }


    /**
     * Gets the department value for this DepartNoticeRela.
     * 
     * @return department
     */
    public trong.lixco.com.account.servicepublics.Department getDepartment() {
        return department;
    }


    /**
     * Sets the department value for this DepartNoticeRela.
     * 
     * @param department
     */
    public void setDepartment(trong.lixco.com.account.servicepublics.Department department) {
        this.department = department;
    }


    /**
     * Gets the noticeSystem value for this DepartNoticeRela.
     * 
     * @return noticeSystem
     */
    public trong.lixco.com.account.servicepublics.NoticeSystem getNoticeSystem() {
        return noticeSystem;
    }


    /**
     * Sets the noticeSystem value for this DepartNoticeRela.
     * 
     * @param noticeSystem
     */
    public void setNoticeSystem(trong.lixco.com.account.servicepublics.NoticeSystem noticeSystem) {
        this.noticeSystem = noticeSystem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DepartNoticeRela)) return false;
        DepartNoticeRela other = (DepartNoticeRela) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.department==null && other.getDepartment()==null) || 
             (this.department!=null &&
              this.department.equals(other.getDepartment()))) &&
            ((this.noticeSystem==null && other.getNoticeSystem()==null) || 
             (this.noticeSystem!=null &&
              this.noticeSystem.equals(other.getNoticeSystem())));
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
        if (getDepartment() != null) {
            _hashCode += getDepartment().hashCode();
        }
        if (getNoticeSystem() != null) {
            _hashCode += getNoticeSystem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DepartNoticeRela.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "departNoticeRela"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("department");
        elemField.setXmlName(new javax.xml.namespace.QName("", "department"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "department"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noticeSystem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "noticeSystem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "noticeSystem"));
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
