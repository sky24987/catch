/**
 * WSTimeChangeRequestParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class WSTimeChangeRequestParameter  extends com.topevery.www.WSParameter  implements java.io.Serializable {
    private java.lang.String curActInstId;

    private java.lang.String requestType;

    private int days;

    private java.lang.String content;

    public WSTimeChangeRequestParameter() {
    }

    public WSTimeChangeRequestParameter(
           java.lang.String loginName,
           java.lang.String loginPass,
           java.lang.String departId,
           java.lang.String curActInstId,
           java.lang.String requestType,
           int days,
           java.lang.String content) {
        super(
            loginName,
            loginPass,
            departId);
        this.curActInstId = curActInstId;
        this.requestType = requestType;
        this.days = days;
        this.content = content;
    }


    /**
     * Gets the curActInstId value for this WSTimeChangeRequestParameter.
     * 
     * @return curActInstId
     */
    public java.lang.String getCurActInstId() {
        return curActInstId;
    }


    /**
     * Sets the curActInstId value for this WSTimeChangeRequestParameter.
     * 
     * @param curActInstId
     */
    public void setCurActInstId(java.lang.String curActInstId) {
        this.curActInstId = curActInstId;
    }


    /**
     * Gets the requestType value for this WSTimeChangeRequestParameter.
     * 
     * @return requestType
     */
    public java.lang.String getRequestType() {
        return requestType;
    }


    /**
     * Sets the requestType value for this WSTimeChangeRequestParameter.
     * 
     * @param requestType
     */
    public void setRequestType(java.lang.String requestType) {
        this.requestType = requestType;
    }


    /**
     * Gets the days value for this WSTimeChangeRequestParameter.
     * 
     * @return days
     */
    public int getDays() {
        return days;
    }


    /**
     * Sets the days value for this WSTimeChangeRequestParameter.
     * 
     * @param days
     */
    public void setDays(int days) {
        this.days = days;
    }


    /**
     * Gets the content value for this WSTimeChangeRequestParameter.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this WSTimeChangeRequestParameter.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSTimeChangeRequestParameter)) return false;
        WSTimeChangeRequestParameter other = (WSTimeChangeRequestParameter) obj;
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
              this.curActInstId.equals(other.getCurActInstId()))) &&
            ((this.requestType==null && other.getRequestType()==null) || 
             (this.requestType!=null &&
              this.requestType.equals(other.getRequestType()))) &&
            this.days == other.getDays() &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent())));
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
        if (getRequestType() != null) {
            _hashCode += getRequestType().hashCode();
        }
        _hashCode += getDays();
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSTimeChangeRequestParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeRequestParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("curActInstId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "curActInstId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "RequestType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("days");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "Days"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "Content"));
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
