/**
 * UserRight.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public class UserRight  extends trong.lixco.com.account.servicepublics.AbstractEntity  implements java.io.Serializable {
    private boolean allow;

    private boolean delete;

    private trong.lixco.com.account.servicepublics.FormList formList;

    private boolean insert;

    private trong.lixco.com.account.servicepublics.Role role;

    private boolean update;

    public UserRight() {
    }

    public UserRight(
           java.util.Calendar createdDate,
           java.lang.String createdUser,
           boolean disable,
           java.lang.Long id,
           java.util.Calendar modifiedDate,
           java.lang.String note,
           boolean select,
           boolean allow,
           boolean delete,
           trong.lixco.com.account.servicepublics.FormList formList,
           boolean insert,
           trong.lixco.com.account.servicepublics.Role role,
           boolean update) {
        super(
            createdDate,
            createdUser,
            disable,
            id,
            modifiedDate,
            note,
            select);
        this.allow = allow;
        this.delete = delete;
        this.formList = formList;
        this.insert = insert;
        this.role = role;
        this.update = update;
    }


    /**
     * Gets the allow value for this UserRight.
     * 
     * @return allow
     */
    public boolean isAllow() {
        return allow;
    }


    /**
     * Sets the allow value for this UserRight.
     * 
     * @param allow
     */
    public void setAllow(boolean allow) {
        this.allow = allow;
    }


    /**
     * Gets the delete value for this UserRight.
     * 
     * @return delete
     */
    public boolean isDelete() {
        return delete;
    }


    /**
     * Sets the delete value for this UserRight.
     * 
     * @param delete
     */
    public void setDelete(boolean delete) {
        this.delete = delete;
    }


    /**
     * Gets the formList value for this UserRight.
     * 
     * @return formList
     */
    public trong.lixco.com.account.servicepublics.FormList getFormList() {
        return formList;
    }


    /**
     * Sets the formList value for this UserRight.
     * 
     * @param formList
     */
    public void setFormList(trong.lixco.com.account.servicepublics.FormList formList) {
        this.formList = formList;
    }


    /**
     * Gets the insert value for this UserRight.
     * 
     * @return insert
     */
    public boolean isInsert() {
        return insert;
    }


    /**
     * Sets the insert value for this UserRight.
     * 
     * @param insert
     */
    public void setInsert(boolean insert) {
        this.insert = insert;
    }


    /**
     * Gets the role value for this UserRight.
     * 
     * @return role
     */
    public trong.lixco.com.account.servicepublics.Role getRole() {
        return role;
    }


    /**
     * Sets the role value for this UserRight.
     * 
     * @param role
     */
    public void setRole(trong.lixco.com.account.servicepublics.Role role) {
        this.role = role;
    }


    /**
     * Gets the update value for this UserRight.
     * 
     * @return update
     */
    public boolean isUpdate() {
        return update;
    }


    /**
     * Sets the update value for this UserRight.
     * 
     * @param update
     */
    public void setUpdate(boolean update) {
        this.update = update;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserRight)) return false;
        UserRight other = (UserRight) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.allow == other.isAllow() &&
            this.delete == other.isDelete() &&
            ((this.formList==null && other.getFormList()==null) || 
             (this.formList!=null &&
              this.formList.equals(other.getFormList()))) &&
            this.insert == other.isInsert() &&
            ((this.role==null && other.getRole()==null) || 
             (this.role!=null &&
              this.role.equals(other.getRole()))) &&
            this.update == other.isUpdate();
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
        _hashCode += (isAllow() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFormList() != null) {
            _hashCode += getFormList().hashCode();
        }
        _hashCode += (isInsert() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        _hashCode += (isUpdate() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserRight.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "userRight"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("allow");
        elemField.setXmlName(new javax.xml.namespace.QName("", "allow"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("delete");
        elemField.setXmlName(new javax.xml.namespace.QName("", "delete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "formList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "formList"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insert");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insert"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role");
        elemField.setXmlName(new javax.xml.namespace.QName("", "role"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "role"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("update");
        elemField.setXmlName(new javax.xml.namespace.QName("", "update"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
