/**
 * GetTimeChangeHistoryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class GetTimeChangeHistoryResponse  implements java.io.Serializable {
    private com.topevery.www.WSTimeChangeHistoryResult getTimeChangeHistoryResult;

    public GetTimeChangeHistoryResponse() {
    }

    public GetTimeChangeHistoryResponse(
           com.topevery.www.WSTimeChangeHistoryResult getTimeChangeHistoryResult) {
           this.getTimeChangeHistoryResult = getTimeChangeHistoryResult;
    }


    /**
     * Gets the getTimeChangeHistoryResult value for this GetTimeChangeHistoryResponse.
     * 
     * @return getTimeChangeHistoryResult
     */
    public com.topevery.www.WSTimeChangeHistoryResult getGetTimeChangeHistoryResult() {
        return getTimeChangeHistoryResult;
    }


    /**
     * Sets the getTimeChangeHistoryResult value for this GetTimeChangeHistoryResponse.
     * 
     * @param getTimeChangeHistoryResult
     */
    public void setGetTimeChangeHistoryResult(com.topevery.www.WSTimeChangeHistoryResult getTimeChangeHistoryResult) {
        this.getTimeChangeHistoryResult = getTimeChangeHistoryResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTimeChangeHistoryResponse)) return false;
        GetTimeChangeHistoryResponse other = (GetTimeChangeHistoryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getTimeChangeHistoryResult==null && other.getGetTimeChangeHistoryResult()==null) || 
             (this.getTimeChangeHistoryResult!=null &&
              this.getTimeChangeHistoryResult.equals(other.getGetTimeChangeHistoryResult())));
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
        if (getGetTimeChangeHistoryResult() != null) {
            _hashCode += getGetTimeChangeHistoryResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTimeChangeHistoryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">GetTimeChangeHistoryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getTimeChangeHistoryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetTimeChangeHistoryResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeHistoryResult"));
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
