/**
 * ChangeTimeRequestResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class ChangeTimeRequestResponse  implements java.io.Serializable {
    private com.topevery.www.WSTimeChangeRequestResult changeTimeRequestResult;

    public ChangeTimeRequestResponse() {
    }

    public ChangeTimeRequestResponse(
           com.topevery.www.WSTimeChangeRequestResult changeTimeRequestResult) {
           this.changeTimeRequestResult = changeTimeRequestResult;
    }


    /**
     * Gets the changeTimeRequestResult value for this ChangeTimeRequestResponse.
     * 
     * @return changeTimeRequestResult
     */
    public com.topevery.www.WSTimeChangeRequestResult getChangeTimeRequestResult() {
        return changeTimeRequestResult;
    }


    /**
     * Sets the changeTimeRequestResult value for this ChangeTimeRequestResponse.
     * 
     * @param changeTimeRequestResult
     */
    public void setChangeTimeRequestResult(com.topevery.www.WSTimeChangeRequestResult changeTimeRequestResult) {
        this.changeTimeRequestResult = changeTimeRequestResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChangeTimeRequestResponse)) return false;
        ChangeTimeRequestResponse other = (ChangeTimeRequestResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.changeTimeRequestResult==null && other.getChangeTimeRequestResult()==null) || 
             (this.changeTimeRequestResult!=null &&
              this.changeTimeRequestResult.equals(other.getChangeTimeRequestResult())));
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
        if (getChangeTimeRequestResult() != null) {
            _hashCode += getChangeTimeRequestResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChangeTimeRequestResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">ChangeTimeRequestResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changeTimeRequestResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "ChangeTimeRequestResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeRequestResult"));
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
