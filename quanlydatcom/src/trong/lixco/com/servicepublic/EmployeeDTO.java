/**
 * EmployeeDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.servicepublic;

public class EmployeeDTO  implements java.io.Serializable {
    private java.lang.String cateJobCode;

    private java.lang.String code;

    private java.lang.String codeDepart;

    private java.lang.String codeOld;

    private java.util.Calendar dayAtWork;

    private java.lang.String email;

    private long id;

    private boolean layOff;

    private java.lang.String name;

    private java.lang.String nameDepart;

    private int numberDayOff;

    private java.util.Calendar timeFixed;

    private boolean workShift;

    public EmployeeDTO() {
    }

    public EmployeeDTO(
           java.lang.String cateJobCode,
           java.lang.String code,
           java.lang.String codeDepart,
           java.lang.String codeOld,
           java.util.Calendar dayAtWork,
           java.lang.String email,
           long id,
           boolean layOff,
           java.lang.String name,
           java.lang.String nameDepart,
           int numberDayOff,
           java.util.Calendar timeFixed,
           boolean workShift) {
           this.cateJobCode = cateJobCode;
           this.code = code;
           this.codeDepart = codeDepart;
           this.codeOld = codeOld;
           this.dayAtWork = dayAtWork;
           this.email = email;
           this.id = id;
           this.layOff = layOff;
           this.name = name;
           this.nameDepart = nameDepart;
           this.numberDayOff = numberDayOff;
           this.timeFixed = timeFixed;
           this.workShift = workShift;
    }


    /**
     * Gets the cateJobCode value for this EmployeeDTO.
     * 
     * @return cateJobCode
     */
    public java.lang.String getCateJobCode() {
        return cateJobCode;
    }


    /**
     * Sets the cateJobCode value for this EmployeeDTO.
     * 
     * @param cateJobCode
     */
    public void setCateJobCode(java.lang.String cateJobCode) {
        this.cateJobCode = cateJobCode;
    }


    /**
     * Gets the code value for this EmployeeDTO.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this EmployeeDTO.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the codeDepart value for this EmployeeDTO.
     * 
     * @return codeDepart
     */
    public java.lang.String getCodeDepart() {
        return codeDepart;
    }


    /**
     * Sets the codeDepart value for this EmployeeDTO.
     * 
     * @param codeDepart
     */
    public void setCodeDepart(java.lang.String codeDepart) {
        this.codeDepart = codeDepart;
    }


    /**
     * Gets the codeOld value for this EmployeeDTO.
     * 
     * @return codeOld
     */
    public java.lang.String getCodeOld() {
        return codeOld;
    }


    /**
     * Sets the codeOld value for this EmployeeDTO.
     * 
     * @param codeOld
     */
    public void setCodeOld(java.lang.String codeOld) {
        this.codeOld = codeOld;
    }


    /**
     * Gets the dayAtWork value for this EmployeeDTO.
     * 
     * @return dayAtWork
     */
    public java.util.Calendar getDayAtWork() {
        return dayAtWork;
    }


    /**
     * Sets the dayAtWork value for this EmployeeDTO.
     * 
     * @param dayAtWork
     */
    public void setDayAtWork(java.util.Calendar dayAtWork) {
        this.dayAtWork = dayAtWork;
    }


    /**
     * Gets the email value for this EmployeeDTO.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this EmployeeDTO.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the id value for this EmployeeDTO.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this EmployeeDTO.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the layOff value for this EmployeeDTO.
     * 
     * @return layOff
     */
    public boolean isLayOff() {
        return layOff;
    }


    /**
     * Sets the layOff value for this EmployeeDTO.
     * 
     * @param layOff
     */
    public void setLayOff(boolean layOff) {
        this.layOff = layOff;
    }


    /**
     * Gets the name value for this EmployeeDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this EmployeeDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the nameDepart value for this EmployeeDTO.
     * 
     * @return nameDepart
     */
    public java.lang.String getNameDepart() {
        return nameDepart;
    }


    /**
     * Sets the nameDepart value for this EmployeeDTO.
     * 
     * @param nameDepart
     */
    public void setNameDepart(java.lang.String nameDepart) {
        this.nameDepart = nameDepart;
    }


    /**
     * Gets the numberDayOff value for this EmployeeDTO.
     * 
     * @return numberDayOff
     */
    public int getNumberDayOff() {
        return numberDayOff;
    }


    /**
     * Sets the numberDayOff value for this EmployeeDTO.
     * 
     * @param numberDayOff
     */
    public void setNumberDayOff(int numberDayOff) {
        this.numberDayOff = numberDayOff;
    }


    /**
     * Gets the timeFixed value for this EmployeeDTO.
     * 
     * @return timeFixed
     */
    public java.util.Calendar getTimeFixed() {
        return timeFixed;
    }


    /**
     * Sets the timeFixed value for this EmployeeDTO.
     * 
     * @param timeFixed
     */
    public void setTimeFixed(java.util.Calendar timeFixed) {
        this.timeFixed = timeFixed;
    }


    /**
     * Gets the workShift value for this EmployeeDTO.
     * 
     * @return workShift
     */
    public boolean isWorkShift() {
        return workShift;
    }


    /**
     * Sets the workShift value for this EmployeeDTO.
     * 
     * @param workShift
     */
    public void setWorkShift(boolean workShift) {
        this.workShift = workShift;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EmployeeDTO)) return false;
        EmployeeDTO other = (EmployeeDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cateJobCode==null && other.getCateJobCode()==null) || 
             (this.cateJobCode!=null &&
              this.cateJobCode.equals(other.getCateJobCode()))) &&
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.codeDepart==null && other.getCodeDepart()==null) || 
             (this.codeDepart!=null &&
              this.codeDepart.equals(other.getCodeDepart()))) &&
            ((this.codeOld==null && other.getCodeOld()==null) || 
             (this.codeOld!=null &&
              this.codeOld.equals(other.getCodeOld()))) &&
            ((this.dayAtWork==null && other.getDayAtWork()==null) || 
             (this.dayAtWork!=null &&
              this.dayAtWork.equals(other.getDayAtWork()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            this.id == other.getId() &&
            this.layOff == other.isLayOff() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.nameDepart==null && other.getNameDepart()==null) || 
             (this.nameDepart!=null &&
              this.nameDepart.equals(other.getNameDepart()))) &&
            this.numberDayOff == other.getNumberDayOff() &&
            ((this.timeFixed==null && other.getTimeFixed()==null) || 
             (this.timeFixed!=null &&
              this.timeFixed.equals(other.getTimeFixed()))) &&
            this.workShift == other.isWorkShift();
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
        if (getCateJobCode() != null) {
            _hashCode += getCateJobCode().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getCodeDepart() != null) {
            _hashCode += getCodeDepart().hashCode();
        }
        if (getCodeOld() != null) {
            _hashCode += getCodeOld().hashCode();
        }
        if (getDayAtWork() != null) {
            _hashCode += getDayAtWork().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        _hashCode += new Long(getId()).hashCode();
        _hashCode += (isLayOff() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getNameDepart() != null) {
            _hashCode += getNameDepart().hashCode();
        }
        _hashCode += getNumberDayOff();
        if (getTimeFixed() != null) {
            _hashCode += getTimeFixed().hashCode();
        }
        _hashCode += (isWorkShift() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EmployeeDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublic.com.lixco.trong/", "employeeDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cateJobCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cateJobCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeDepart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeDepart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeOld");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeOld"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dayAtWork");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dayAtWork"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("layOff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "layOff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nameDepart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nameDepart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberDayOff");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberDayOff"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timeFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workShift");
        elemField.setXmlName(new javax.xml.namespace.QName("", "workShift"));
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
