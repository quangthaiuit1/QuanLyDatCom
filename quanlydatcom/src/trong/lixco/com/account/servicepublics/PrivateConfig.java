/**
 * PrivateConfig.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public class PrivateConfig  extends trong.lixco.com.account.servicepublics.AbstractEntity  implements java.io.Serializable {
    private int decimalNumber;

    private java.lang.String decimalPattent;

    private java.lang.String decimalSeparator;

    private java.lang.String pattentDate;

    private boolean showHeader;

    private java.lang.String thousandSeparator;

    public PrivateConfig() {
    }

    public PrivateConfig(
           java.util.Calendar createdDate,
           java.lang.String createdUser,
           boolean disable,
           java.lang.Long id,
           java.util.Calendar modifiedDate,
           java.lang.String note,
           boolean select,
           int decimalNumber,
           java.lang.String decimalPattent,
           java.lang.String decimalSeparator,
           java.lang.String pattentDate,
           boolean showHeader,
           java.lang.String thousandSeparator) {
        super(
            createdDate,
            createdUser,
            disable,
            id,
            modifiedDate,
            note,
            select);
        this.decimalNumber = decimalNumber;
        this.decimalPattent = decimalPattent;
        this.decimalSeparator = decimalSeparator;
        this.pattentDate = pattentDate;
        this.showHeader = showHeader;
        this.thousandSeparator = thousandSeparator;
    }


    /**
     * Gets the decimalNumber value for this PrivateConfig.
     * 
     * @return decimalNumber
     */
    public int getDecimalNumber() {
        return decimalNumber;
    }


    /**
     * Sets the decimalNumber value for this PrivateConfig.
     * 
     * @param decimalNumber
     */
    public void setDecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }


    /**
     * Gets the decimalPattent value for this PrivateConfig.
     * 
     * @return decimalPattent
     */
    public java.lang.String getDecimalPattent() {
        return decimalPattent;
    }


    /**
     * Sets the decimalPattent value for this PrivateConfig.
     * 
     * @param decimalPattent
     */
    public void setDecimalPattent(java.lang.String decimalPattent) {
        this.decimalPattent = decimalPattent;
    }


    /**
     * Gets the decimalSeparator value for this PrivateConfig.
     * 
     * @return decimalSeparator
     */
    public java.lang.String getDecimalSeparator() {
        return decimalSeparator;
    }


    /**
     * Sets the decimalSeparator value for this PrivateConfig.
     * 
     * @param decimalSeparator
     */
    public void setDecimalSeparator(java.lang.String decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }


    /**
     * Gets the pattentDate value for this PrivateConfig.
     * 
     * @return pattentDate
     */
    public java.lang.String getPattentDate() {
        return pattentDate;
    }


    /**
     * Sets the pattentDate value for this PrivateConfig.
     * 
     * @param pattentDate
     */
    public void setPattentDate(java.lang.String pattentDate) {
        this.pattentDate = pattentDate;
    }


    /**
     * Gets the showHeader value for this PrivateConfig.
     * 
     * @return showHeader
     */
    public boolean isShowHeader() {
        return showHeader;
    }


    /**
     * Sets the showHeader value for this PrivateConfig.
     * 
     * @param showHeader
     */
    public void setShowHeader(boolean showHeader) {
        this.showHeader = showHeader;
    }


    /**
     * Gets the thousandSeparator value for this PrivateConfig.
     * 
     * @return thousandSeparator
     */
    public java.lang.String getThousandSeparator() {
        return thousandSeparator;
    }


    /**
     * Sets the thousandSeparator value for this PrivateConfig.
     * 
     * @param thousandSeparator
     */
    public void setThousandSeparator(java.lang.String thousandSeparator) {
        this.thousandSeparator = thousandSeparator;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PrivateConfig)) return false;
        PrivateConfig other = (PrivateConfig) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.decimalNumber == other.getDecimalNumber() &&
            ((this.decimalPattent==null && other.getDecimalPattent()==null) || 
             (this.decimalPattent!=null &&
              this.decimalPattent.equals(other.getDecimalPattent()))) &&
            ((this.decimalSeparator==null && other.getDecimalSeparator()==null) || 
             (this.decimalSeparator!=null &&
              this.decimalSeparator.equals(other.getDecimalSeparator()))) &&
            ((this.pattentDate==null && other.getPattentDate()==null) || 
             (this.pattentDate!=null &&
              this.pattentDate.equals(other.getPattentDate()))) &&
            this.showHeader == other.isShowHeader() &&
            ((this.thousandSeparator==null && other.getThousandSeparator()==null) || 
             (this.thousandSeparator!=null &&
              this.thousandSeparator.equals(other.getThousandSeparator())));
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
        _hashCode += getDecimalNumber();
        if (getDecimalPattent() != null) {
            _hashCode += getDecimalPattent().hashCode();
        }
        if (getDecimalSeparator() != null) {
            _hashCode += getDecimalSeparator().hashCode();
        }
        if (getPattentDate() != null) {
            _hashCode += getPattentDate().hashCode();
        }
        _hashCode += (isShowHeader() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getThousandSeparator() != null) {
            _hashCode += getThousandSeparator().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PrivateConfig.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "privateConfig"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("decimalNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "decimalNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("decimalPattent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "decimalPattent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("decimalSeparator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "decimalSeparator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pattentDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pattentDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showHeader");
        elemField.setXmlName(new javax.xml.namespace.QName("", "showHeader"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("thousandSeparator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "thousandSeparator"));
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
