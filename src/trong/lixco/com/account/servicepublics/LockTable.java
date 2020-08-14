/**
 * LockTable.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public class LockTable  extends trong.lixco.com.account.servicepublics.AbstractEntity  implements java.io.Serializable {
    private boolean locks;

    private int month;

    private trong.lixco.com.account.servicepublics.Program program;

    private int year;

    public LockTable() {
    }

    public LockTable(
           java.util.Calendar createdDate,
           java.lang.String createdUser,
           boolean disable,
           java.lang.Long id,
           java.util.Calendar modifiedDate,
           java.lang.String note,
           boolean select,
           boolean locks,
           int month,
           trong.lixco.com.account.servicepublics.Program program,
           int year) {
        super(
            createdDate,
            createdUser,
            disable,
            id,
            modifiedDate,
            note,
            select);
        this.locks = locks;
        this.month = month;
        this.program = program;
        this.year = year;
    }


    /**
     * Gets the locks value for this LockTable.
     * 
     * @return locks
     */
    public boolean isLocks() {
        return locks;
    }


    /**
     * Sets the locks value for this LockTable.
     * 
     * @param locks
     */
    public void setLocks(boolean locks) {
        this.locks = locks;
    }


    /**
     * Gets the month value for this LockTable.
     * 
     * @return month
     */
    public int getMonth() {
        return month;
    }


    /**
     * Sets the month value for this LockTable.
     * 
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }


    /**
     * Gets the program value for this LockTable.
     * 
     * @return program
     */
    public trong.lixco.com.account.servicepublics.Program getProgram() {
        return program;
    }


    /**
     * Sets the program value for this LockTable.
     * 
     * @param program
     */
    public void setProgram(trong.lixco.com.account.servicepublics.Program program) {
        this.program = program;
    }


    /**
     * Gets the year value for this LockTable.
     * 
     * @return year
     */
    public int getYear() {
        return year;
    }


    /**
     * Sets the year value for this LockTable.
     * 
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LockTable)) return false;
        LockTable other = (LockTable) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.locks == other.isLocks() &&
            this.month == other.getMonth() &&
            ((this.program==null && other.getProgram()==null) || 
             (this.program!=null &&
              this.program.equals(other.getProgram()))) &&
            this.year == other.getYear();
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
        _hashCode += (isLocks() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getMonth();
        if (getProgram() != null) {
            _hashCode += getProgram().hashCode();
        }
        _hashCode += getYear();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LockTable.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "lockTable"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locks");
        elemField.setXmlName(new javax.xml.namespace.QName("", "locks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("", "month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("", "year"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
