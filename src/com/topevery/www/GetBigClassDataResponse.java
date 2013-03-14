/**
 * GetBigClassDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class GetBigClassDataResponse  implements java.io.Serializable {
    private com.topevery.www.GetBigClassDataResponseGetBigClassDataResult getBigClassDataResult;

    public GetBigClassDataResponse() {
    }

    public GetBigClassDataResponse(
           com.topevery.www.GetBigClassDataResponseGetBigClassDataResult getBigClassDataResult) {
           this.getBigClassDataResult = getBigClassDataResult;
    }


    /**
     * Gets the getBigClassDataResult value for this GetBigClassDataResponse.
     * 
     * @return getBigClassDataResult
     */
    public com.topevery.www.GetBigClassDataResponseGetBigClassDataResult getGetBigClassDataResult() {
        return getBigClassDataResult;
    }


    /**
     * Sets the getBigClassDataResult value for this GetBigClassDataResponse.
     * 
     * @param getBigClassDataResult
     */
    public void setGetBigClassDataResult(com.topevery.www.GetBigClassDataResponseGetBigClassDataResult getBigClassDataResult) {
        this.getBigClassDataResult = getBigClassDataResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetBigClassDataResponse)) return false;
        GetBigClassDataResponse other = (GetBigClassDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getBigClassDataResult==null && other.getGetBigClassDataResult()==null) || 
             (this.getBigClassDataResult!=null &&
              this.getBigClassDataResult.equals(other.getGetBigClassDataResult())));
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
        if (getGetBigClassDataResult() != null) {
            _hashCode += getGetBigClassDataResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetBigClassDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">GetBigClassDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getBigClassDataResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetBigClassDataResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">>GetBigClassDataResponse>GetBigClassDataResult"));
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
