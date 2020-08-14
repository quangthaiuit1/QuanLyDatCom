/**
 * Program.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public class Program  extends trong.lixco.com.account.servicepublics.AbstractEntity  implements java.io.Serializable {
    private java.lang.String description;

    private java.lang.String fullname;

    private short indexProgram;

    private byte[] logo;

    private java.lang.String name;

    private java.lang.String serveraddress;

    private java.lang.String serveraddressPublic;

    private java.lang.String uRL;
    private short indexSort;

    public Program() {
    }

    public Program(
           java.util.Calendar createdDate,
           java.lang.String createdUser,
           boolean disable,
           java.lang.Long id,
           java.util.Calendar modifiedDate,
           java.lang.String note,
           boolean select,
           java.lang.String description,
           java.lang.String fullname,
           short indexProgram,
           byte[] logo,
           java.lang.String name,
           java.lang.String serveraddress,
           java.lang.String serveraddressPublic,
           java.lang.String uRL) {
        super(
            createdDate,
            createdUser,
            disable,
            id,
            modifiedDate,
            note,
            select);
        this.description = description;
        this.fullname = fullname;
        this.indexProgram = indexProgram;
        this.logo = logo;
        this.name = name;
        this.serveraddress = serveraddress;
        this.serveraddressPublic = serveraddressPublic;
        this.uRL = uRL;
    }


    /**
     * Gets the description value for this Program.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this Program.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the fullname value for this Program.
     * 
     * @return fullname
     */
    public java.lang.String getFullname() {
        return fullname;
    }


    /**
     * Sets the fullname value for this Program.
     * 
     * @param fullname
     */
    public void setFullname(java.lang.String fullname) {
        this.fullname = fullname;
    }


    /**
     * Gets the indexProgram value for this Program.
     * 
     * @return indexProgram
     */
    public short getIndexProgram() {
        return indexProgram;
    }


    /**
     * Sets the indexProgram value for this Program.
     * 
     * @param indexProgram
     */
    public void setIndexProgram(short indexProgram) {
        this.indexProgram = indexProgram;
    }


    /**
     * Gets the logo value for this Program.
     * 
     * @return logo
     */
    public byte[] getLogo() {
        return logo;
    }


    /**
     * Sets the logo value for this Program.
     * 
     * @param logo
     */
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }


    /**
     * Gets the name value for this Program.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Program.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the serveraddress value for this Program.
     * 
     * @return serveraddress
     */
    public java.lang.String getServeraddress() {
        return serveraddress;
    }


    /**
     * Sets the serveraddress value for this Program.
     * 
     * @param serveraddress
     */
    public void setServeraddress(java.lang.String serveraddress) {
        this.serveraddress = serveraddress;
    }


    /**
     * Gets the serveraddressPublic value for this Program.
     * 
     * @return serveraddressPublic
     */
    public java.lang.String getServeraddressPublic() {
        return serveraddressPublic;
    }


    /**
     * Sets the serveraddressPublic value for this Program.
     * 
     * @param serveraddressPublic
     */
    public void setServeraddressPublic(java.lang.String serveraddressPublic) {
        this.serveraddressPublic = serveraddressPublic;
    }


    /**
     * Gets the uRL value for this Program.
     * 
     * @return uRL
     */
    public java.lang.String getURL() {
        return uRL;
    }


    /**
     * Sets the uRL value for this Program.
     * 
     * @param uRL
     */
    public void setURL(java.lang.String uRL) {
        this.uRL = uRL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Program)) return false;
        Program other = (Program) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.fullname==null && other.getFullname()==null) || 
             (this.fullname!=null &&
              this.fullname.equals(other.getFullname()))) &&
            this.indexProgram == other.getIndexProgram() &&
            ((this.logo==null && other.getLogo()==null) || 
             (this.logo!=null &&
              java.util.Arrays.equals(this.logo, other.getLogo()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.serveraddress==null && other.getServeraddress()==null) || 
             (this.serveraddress!=null &&
              this.serveraddress.equals(other.getServeraddress()))) &&
            ((this.serveraddressPublic==null && other.getServeraddressPublic()==null) || 
             (this.serveraddressPublic!=null &&
              this.serveraddressPublic.equals(other.getServeraddressPublic()))) &&
            ((this.uRL==null && other.getURL()==null) || 
             (this.uRL!=null &&
              this.uRL.equals(other.getURL())));
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getFullname() != null) {
            _hashCode += getFullname().hashCode();
        }
        _hashCode += getIndexProgram();
        if (getLogo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLogo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLogo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getServeraddress() != null) {
            _hashCode += getServeraddress().hashCode();
        }
        if (getServeraddressPublic() != null) {
            _hashCode += getServeraddressPublic().hashCode();
        }
        if (getURL() != null) {
            _hashCode += getURL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Program.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "program"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fullname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fullname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indexProgram");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indexProgram"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("serveraddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serveraddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serveraddressPublic");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serveraddressPublic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("URL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uRL"));
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
