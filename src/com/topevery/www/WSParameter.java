/**
 * WSParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class WSParameter  implements java.io.Serializable {
    private java.lang.String loginName;

    private java.lang.String loginPass;

    private java.lang.String departId;

    public WSParameter() {
    }

    public WSParameter(
           java.lang.String loginName,
           java.lang.String loginPass,
           java.lang.String departId) {
           this.loginName = loginName;
           this.loginPass = loginPass;
           this.departId = departId;
    }


    /**
     * Gets the loginName value for this WSParameter.
     * 
     * @return loginName
     */
    public java.lang.String getLoginName() {
        return loginName;
    }


    /**
     * Sets the loginName value for this WSParameter.
     * 
     * @param loginName
     */
    public void setLoginName(java.lang.String loginName) {
        this.loginName = loginName;
    }


    /**
     * Gets the loginPass value for this WSParameter.
     * 
     * @return loginPass
     */
    public java.lang.String getLoginPass() {
        return loginPass;
    }


    /**
     * Sets the loginPass value for this WSParameter.
     * 
     * @param loginPass
     */
    public void setLoginPass(java.lang.String loginPass) {
        this.loginPass = loginPass;
    }


    /**
     * Gets the departId value for this WSParameter.
     * 
     * @return departId
     */
    public java.lang.String getDepartId() {
        return departId;
    }


    /**
     * Sets the departId value for this WSParameter.
     * 
     * @param departId
     */
    public void setDepartId(java.lang.String departId) {
        this.departId = departId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSParameter)) return false;
        WSParameter other = (WSParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loginName==null && other.getLoginName()==null) || 
             (this.loginName!=null &&
              this.loginName.equals(other.getLoginName()))) &&
            ((this.loginPass==null && other.getLoginPass()==null) || 
             (this.loginPass!=null &&
              this.loginPass.equals(other.getLoginPass()))) &&
            ((this.departId==null && other.getDepartId()==null) || 
             (this.departId!=null &&
              this.departId.equals(other.getDepartId())));
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
        if (getLoginName() != null) {
            _hashCode += getLoginName().hashCode();
        }
        if (getLoginPass() != null) {
            _hashCode += getLoginPass().hashCode();
        }
        if (getDepartId() != null) {
            _hashCode += getDepartId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "LoginName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginPass");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "LoginPass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "DepartId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
