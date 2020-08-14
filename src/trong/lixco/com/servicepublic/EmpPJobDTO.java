/**
 * EmpPJobDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.servicepublic;

public class EmpPJobDTO  implements java.io.Serializable {
    private java.lang.String codeEmp;

    private java.lang.String codePJob;

    public EmpPJobDTO() {
    }

    public EmpPJobDTO(
           java.lang.String codeEmp,
           java.lang.String codePJob) {
           this.codeEmp = codeEmp;
           this.codePJob = codePJob;
    }


    /**
     * Gets the codeEmp value for this EmpPJobDTO.
     * 
     * @return codeEmp
     */
    public java.lang.String getCodeEmp() {
        return codeEmp;
    }


    /**
     * Sets the codeEmp value for this EmpPJobDTO.
     * 
     * @param codeEmp
     */
    public void setCodeEmp(java.lang.String codeEmp) {
        this.codeEmp = codeEmp;
    }


    /**
     * Gets the codePJob value for this EmpPJobDTO.
     * 
     * @return codePJob
     */
    public java.lang.String getCodePJob() {
        return codePJob;
    }


    /**
     * Sets the codePJob value for this EmpPJobDTO.
     * 
     * @param codePJob
     */
    public void setCodePJob(java.lang.String codePJob) {
        this.codePJob = codePJob;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmpPJobDTO)) return false;
        EmpPJobDTO other = (EmpPJobDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codeEmp==null && other.getCodeEmp()==null) || 
             (this.codeEmp!=null &&
              this.codeEmp.equals(other.getCodeEmp()))) &&
            ((this.codePJob==null && other.getCodePJob()==null) || 
             (this.codePJob!=null &&
              this.codePJob.equals(other.getCodePJob())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCodeEmp() != null) {
            _hashCode += getCodeEmp().hashCode();
        }
        if (getCodePJob() != null) {
            _hashCode += getCodePJob().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EmpPJobDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublic.com.lixco.trong/", "empPJobDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeEmp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeEmp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codePJob");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codePJob"));
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
