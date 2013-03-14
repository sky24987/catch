/**
 * GetMapDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class GetMapDataResponse  implements java.io.Serializable {
    private com.topevery.www.GetMapDataResponseGetMapDataResult getMapDataResult;

    public GetMapDataResponse() {
    }

    public GetMapDataResponse(
           com.topevery.www.GetMapDataResponseGetMapDataResult getMapDataResult) {
           this.getMapDataResult = getMapDataResult;
    }


    /**
     * Gets the getMapDataResult value for this GetMapDataResponse.
     * 
     * @return getMapDataResult
     */
    public com.topevery.www.GetMapDataResponseGetMapDataResult getGetMapDataResult() {
        return getMapDataResult;
    }


    /**
     * Sets the getMapDataResult value for this GetMapDataResponse.
     * 
     * @param getMapDataResult
     */
    public void setGetMapDataResult(com.topevery.www.GetMapDataResponseGetMapDataResult getMapDataResult) {
        this.getMapDataResult = getMapDataResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMapDataResponse)) return false;
        GetMapDataResponse other = (GetMapDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getMapDataResult==null && other.getGetMapDataResult()==null) || 
             (this.getMapDataResult!=null &&
              this.getMapDataResult.equals(other.getGetMapDataResult())));
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
        if (getGetMapDataResult() != null) {
            _hashCode += getGetMapDataResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetMapDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">GetMapDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getMapDataResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetMapDataResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">>GetMapDataResponse>GetMapDataResult"));
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
