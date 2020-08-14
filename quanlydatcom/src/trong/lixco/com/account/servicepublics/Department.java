/**
 * Department.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public class Department  extends trong.lixco.com.account.servicepublics.AbstractEntity  implements java.io.Serializable {
    private java.lang.String code;

    private java.lang.String codeMem;

    private trong.lixco.com.account.servicepublics.Department department;

    private trong.lixco.com.account.servicepublics.LevelDep levelDep;

    private java.lang.String name;

    public Department() {
    }

    public Department(
           java.util.Calendar createdDate,
           java.lang.String createdUser,
           boolean disable,
           java.lang.Long id,
           java.util.Calendar modifiedDate,
           java.lang.String note,
           boolean select,
           java.lang.String code,
           java.lang.String codeMem,
           trong.lixco.com.account.servicepublics.Department department,
           trong.lixco.com.account.servicepublics.LevelDep levelDep,
           java.lang.String name) {
        super(
            createdDate,
            createdUser,
            disable,
            id,
            modifiedDate,
            note,
            select);
        this.code = code;
        this.codeMem = codeMem;
        this.department = department;
        this.levelDep = levelDep;
        this.name = name;
    }


    /**
     * Gets the code value for this Department.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this Department.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the codeMem value for this Department.
     * 
     * @return codeMem
     */
    public java.lang.String getCodeMem() {
        return codeMem;
    }


    /**
     * Sets the codeMem value for this Department.
     * 
     * @param codeMem
     */
    public void setCodeMem(java.lang.String codeMem) {
        this.codeMem = codeMem;
    }


    /**
     * Gets the department value for this Department.
     * 
     * @return department
     */
    public trong.lixco.com.account.servicepublics.Department getDepartment() {
        return department;
    }


    /**
     * Sets the department value for this Department.
     * 
     * @param department
     */
    public void setDepartment(trong.lixco.com.account.servicepublics.Department department) {
        this.department = department;
    }


    /**
     * Gets the levelDep value for this Department.
     * 
     * @return levelDep
     */
    public trong.lixco.com.account.servicepublics.LevelDep getLevelDep() {
        return levelDep;
    }


    /**
     * Sets the levelDep value for this Department.
     * 
     * @param levelDep
     */
    public void setLevelDep(trong.lixco.com.account.servicepublics.LevelDep levelDep) {
        this.levelDep = levelDep;
    }


    /**
     * Gets the name value for this Department.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Department.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Department)) return false;
        Department other = (Department) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.codeMem==null && other.getCodeMem()==null) || 
             (this.codeMem!=null &&
              this.codeMem.equals(other.getCodeMem()))) &&
            ((this.department==null && other.getDepartment()==null) || 
             (this.department!=null &&
              this.department.equals(other.getDepartment()))) &&
            ((this.levelDep==null && other.getLevelDep()==null) || 
             (this.levelDep!=null &&
              this.levelDep.equals(other.getLevelDep()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName())));
        __equalsCalc = null;
        return _equals;
    }
    public String showAllNameDepart() {
		try {
			if (levelDep.getLevel() == 1) {
				return name;
			} else {
				String lt = "";
				for (int i = 0; i < levelDep.getLevel(); i++) {
					lt = lt + "&emsp;";
				}
				if (department != null)
					return lt + name;
				return name;
			}
		} catch (Exception e) {
			return name;
		}
	}

	public String showAllNameDepartFull() {
		try {
			if (levelDep.getLevel() == 1) {
				return name;
			} else {
				String lt = "";
				for (int i = 0; i < levelDep.getLevel(); i++) {
					lt = lt + "&emsp;";
				}
				if (department != null)
					return department.showAllNameDepartFull() + lt + name;
				return name;
			}
		} catch (Exception e) {
			return name;
		}
	}
    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getCodeMem() != null) {
            _hashCode += getCodeMem().hashCode();
        }
        if (getDepartment() != null) {
            _hashCode += getDepartment().hashCode();
        }
        if (getLevelDep() != null) {
            _hashCode += getLevelDep().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Department.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "department"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codeMem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codeMem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("department");
        elemField.setXmlName(new javax.xml.namespace.QName("", "department"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "department"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("levelDep");
        elemField.setXmlName(new javax.xml.namespace.QName("", "levelDep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "levelDep"));
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
