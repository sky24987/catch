/**
 * RollBackSZCGEventResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class RollBackSZCGEventResponse  implements java.io.Serializable {
    private com.topevery.www.WSRollbackSZCGEventResult rollBackSZCGEventResult;

    public RollBackSZCGEventResponse() {
    }

    public RollBackSZCGEventResponse(
           com.topevery.www.WSRollbackSZCGEventResult rollBackSZCGEventResult) {
           this.rollBackSZCGEventResult = rollBackSZCGEventResult;
    }


    /**
     * Gets the rollBackSZCGEventResult value for this RollBackSZCGEventResponse.
     * 
     * @return rollBackSZCGEventResult
     */
    public com.topevery.www.WSRollbackSZCGEventResult getRollBackSZCGEventResult() {
        return rollBackSZCGEventResult;
    }


    /**
     * Sets the rollBackSZCGEventResult value for this RollBackSZCGEventResponse.
     * 
     * @param rollBackSZCGEventResult
     */
    public void setRollBackSZCGEventResult(com.topevery.www.WSRollbackSZCGEventResult rollBackSZCGEventResult) {
        this.rollBackSZCGEventResult = rollBackSZCGEventResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RollBackSZCGEventResponse)) return false;
        RollBackSZCGEventResponse other = (RollBackSZCGEventResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rollBackSZCGEventResult==null && other.getRollBackSZCGEventResult()==null) || 
             (this.rollBackSZCGEventResult!=null &&
              this.rollBackSZCGEventResult.equals(other.getRollBackSZCGEventResult())));
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
        if (getRollBackSZCGEventResult() != null) {
            _hashCode += getRollBackSZCGEventResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RollBackSZCGEventResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">RollBackSZCGEventResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rollBackSZCGEventResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "RollBackSZCGEventResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSRollbackSZCGEventResult"));
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
