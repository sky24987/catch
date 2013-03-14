/**
 * WSTimeChangeHistoryResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class WSTimeChangeHistoryResult  extends com.topevery.www.WSRetValue  implements java.io.Serializable {
    private com.topevery.www.WSTimeChangeHistoryResultHistory history;

    public WSTimeChangeHistoryResult() {
    }

    public WSTimeChangeHistoryResult(
           boolean success,
           java.lang.String errorMsg,
           com.topevery.www.WSTimeChangeHistoryResultHistory history) {
        super(
            success,
            errorMsg);
        this.history = history;
    }


    /**
     * Gets the history value for this WSTimeChangeHistoryResult.
     * 
     * @return history
     */
    public com.topevery.www.WSTimeChangeHistoryResultHistory getHistory() {
        return history;
    }


    /**
     * Sets the history value for this WSTimeChangeHistoryResult.
     * 
     * @param history
     */
    public void setHistory(com.topevery.www.WSTimeChangeHistoryResultHistory history) {
        this.history = history;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSTimeChangeHistoryResult)) return false;
        WSTimeChangeHistoryResult other = (WSTimeChangeHistoryResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.history==null && other.getHistory()==null) || 
             (this.history!=null &&
              this.history.equals(other.getHistory())));
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
        if (getHistory() != null) {
            _hashCode += getHistory().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSTimeChangeHistoryResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeHistoryResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("history");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "History"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">WSTimeChangeHistoryResult>History"));
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
