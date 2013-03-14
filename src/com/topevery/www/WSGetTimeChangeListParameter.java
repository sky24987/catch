/**
 * WSGetTimeChangeListParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class WSGetTimeChangeListParameter  extends com.topevery.www.WSParameter  implements java.io.Serializable {
    private java.lang.String curActInstId;

    public WSGetTimeChangeListParameter() {
    }

    public WSGetTimeChangeListParameter(
           java.lang.String loginName,
           java.lang.String loginPass,
           java.lang.String departId,
           java.lang.String curActInstId) {
        super(
            loginName,
            loginPass,
            departId);
        this.curActInstId = curActInstId;
    }


    /**
     * Gets the curActInstId value for this WSGetTimeChangeListParameter.
     * 
     * @return curActInstId
     */
    public java.lang.String getCurActInstId() {
        return curActInstId;
    }


    /**
     * Sets the curActInstId value for this WSGetTimeChangeListParameter.
     * 
     * @param curActInstId
     */
    public void setCurActInstId(java.lang.String curActInstId) {
        this.curActInstId = curActInstId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSGetTimeChangeListParameter)) return false;
        WSGetTimeChangeListParameter other = (WSGetTimeChangeListParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.curActInstId==null && other.getCurActInstId()==null) || 
             (this.curActInstId!=null &&
              this.curActInstId.equals(other.getCurActInstId())));
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
        if (getCurActInstId() != null) {
            _hashCode += getCurActInstId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSGetTimeChangeListParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSGetTimeChangeListParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curActInstId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "curActInstId"));
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
