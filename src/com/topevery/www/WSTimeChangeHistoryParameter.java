/**
 * WSTimeChangeHistoryParameter.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class WSTimeChangeHistoryParameter  extends com.topevery.www.WSParameter  implements java.io.Serializable {
    private java.lang.String eventId;

    public WSTimeChangeHistoryParameter() {
    }

    public WSTimeChangeHistoryParameter(
           java.lang.String loginName,
           java.lang.String loginPass,
           java.lang.String departId,
           java.lang.String eventId) {
        super(
            loginName,
            loginPass,
            departId);
        this.eventId = eventId;
    }


    /**
     * Gets the eventId value for this WSTimeChangeHistoryParameter.
     * 
     * @return eventId
     */
    public java.lang.String getEventId() {
        return eventId;
    }


    /**
     * Sets the eventId value for this WSTimeChangeHistoryParameter.
     * 
     * @param eventId
     */
    public void setEventId(java.lang.String eventId) {
        this.eventId = eventId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSTimeChangeHistoryParameter)) return false;
        WSTimeChangeHistoryParameter other = (WSTimeChangeHistoryParameter) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.eventId==null && other.getEventId()==null) || 
             (this.eventId!=null &&
              this.eventId.equals(other.getEventId())));
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
        if (getEventId() != null) {
            _hashCode += getEventId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSTimeChangeHistoryParameter.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeHistoryParameter"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "EventId"));
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
