/**
 * Account.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public class Account  extends trong.lixco.com.account.servicepublics.AbstractEntity  implements java.io.Serializable {
    private boolean admin;

    private trong.lixco.com.account.servicepublics.Member member;

    private boolean notice;

    private boolean online;

    private java.lang.String password;

    private trong.lixco.com.account.servicepublics.PrivateConfig privateConfig;

    private java.lang.String userName;

    public Account() {
    }

    public Account(
           java.util.Calendar createdDate,
           java.lang.String createdUser,
           boolean disable,
           java.lang.Long id,
           java.util.Calendar modifiedDate,
           java.lang.String note,
           boolean select,
           boolean admin,
           trong.lixco.com.account.servicepublics.Member member,
           boolean notice,
           boolean online,
           java.lang.String password,
           trong.lixco.com.account.servicepublics.PrivateConfig privateConfig,
           java.lang.String userName) {
        super(
            createdDate,
            createdUser,
            disable,
            id,
            modifiedDate,
            note,
            select);
        this.admin = admin;
        this.member = member;
        this.notice = notice;
        this.online = online;
        this.password = password;
        this.privateConfig = privateConfig;
        this.userName = userName;
    }


    /**
     * Gets the admin value for this Account.
     * 
     * @return admin
     */
    public boolean isAdmin() {
        return admin;
    }


    /**
     * Sets the admin value for this Account.
     * 
     * @param admin
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    /**
     * Gets the member value for this Account.
     * 
     * @return member
     */
    public trong.lixco.com.account.servicepublics.Member getMember() {
        return member;
    }


    /**
     * Sets the member value for this Account.
     * 
     * @param member
     */
    public void setMember(trong.lixco.com.account.servicepublics.Member member) {
        this.member = member;
    }


    /**
     * Gets the notice value for this Account.
     * 
     * @return notice
     */
    public boolean isNotice() {
        return notice;
    }


    /**
     * Sets the notice value for this Account.
     * 
     * @param notice
     */
    public void setNotice(boolean notice) {
        this.notice = notice;
    }


    /**
     * Gets the online value for this Account.
     * 
     * @return online
     */
    public boolean isOnline() {
        return online;
    }


    /**
     * Sets the online value for this Account.
     * 
     * @param online
     */
    public void setOnline(boolean online) {
        this.online = online;
    }


    /**
     * Gets the password value for this Account.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this Account.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the privateConfig value for this Account.
     * 
     * @return privateConfig
     */
    public trong.lixco.com.account.servicepublics.PrivateConfig getPrivateConfig() {
        return privateConfig;
    }


    /**
     * Sets the privateConfig value for this Account.
     * 
     * @param privateConfig
     */
    public void setPrivateConfig(trong.lixco.com.account.servicepublics.PrivateConfig privateConfig) {
        this.privateConfig = privateConfig;
    }


    /**
     * Gets the userName value for this Account.
     * 
     * @return userName
     */
    public java.lang.String getUserName() {
        return userName;
    }


    /**
     * Sets the userName value for this Account.
     * 
     * @param userName
     */
    public void setUserName(java.lang.String userName) {
        this.userName = userName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Account)) return false;
        Account other = (Account) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.admin == other.isAdmin() &&
            ((this.member==null && other.getMember()==null) || 
             (this.member!=null &&
              this.member.equals(other.getMember()))) &&
            this.notice == other.isNotice() &&
            this.online == other.isOnline() &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.privateConfig==null && other.getPrivateConfig()==null) || 
             (this.privateConfig!=null &&
              this.privateConfig.equals(other.getPrivateConfig()))) &&
            ((this.userName==null && other.getUserName()==null) || 
             (this.userName!=null &&
              this.userName.equals(other.getUserName())));
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
        _hashCode += (isAdmin() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMember() != null) {
            _hashCode += getMember().hashCode();
        }
        _hashCode += (isNotice() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isOnline() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getPrivateConfig() != null) {
            _hashCode += getPrivateConfig().hashCode();
        }
        if (getUserName() != null) {
            _hashCode += getUserName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Account.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "account"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("admin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "admin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("member");
        elemField.setXmlName(new javax.xml.namespace.QName("", "member"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "member"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "notice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("online");
        elemField.setXmlName(new javax.xml.namespace.QName("", "online"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("privateConfig");
        elemField.setXmlName(new javax.xml.namespace.QName("", "privateConfig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "privateConfig"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userName"));
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
