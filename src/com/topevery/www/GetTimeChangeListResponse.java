/**
 * GetTimeChangeListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class GetTimeChangeListResponse  implements java.io.Serializable {
    private com.topevery.www.WSGetTimeChangeListResult getTimeChangeListResult;

    public GetTimeChangeListResponse() {
    }

    public GetTimeChangeListResponse(
           com.topevery.www.WSGetTimeChangeListResult getTimeChangeListResult) {
           this.getTimeChangeListResult = getTimeChangeListResult;
    }


    /**
     * Gets the getTimeChangeListResult value for this GetTimeChangeListResponse.
     * 
     * @return getTimeChangeListResult
     */
    public com.topevery.www.WSGetTimeChangeListResult getGetTimeChangeListResult() {
        return getTimeChangeListResult;
    }


    /**
     * Sets the getTimeChangeListResult value for this GetTimeChangeListResponse.
     * 
     * @param getTimeChangeListResult
     */
    public void setGetTimeChangeListResult(com.topevery.www.WSGetTimeChangeListResult getTimeChangeListResult) {
        this.getTimeChangeListResult = getTimeChangeListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetTimeChangeListResponse)) return false;
        GetTimeChangeListResponse other = (GetTimeChangeListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getTimeChangeListResult==null && other.getGetTimeChangeListResult()==null) || 
             (this.getTimeChangeListResult!=null &&
              this.getTimeChangeListResult.equals(other.getGetTimeChangeListResult())));
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
        if (getGetTimeChangeListResult() != null) {
            _hashCode += getGetTimeChangeListResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetTimeChangeListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">GetTimeChangeListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getTimeChangeListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetTimeChangeListResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSGetTimeChangeListResult"));
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
