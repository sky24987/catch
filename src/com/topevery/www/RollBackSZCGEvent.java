/**
 * RollBackSZCGEvent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class RollBackSZCGEvent  implements java.io.Serializable {
    private com.topevery.www.WSRollbackSZCGEventParameter para;

    public RollBackSZCGEvent() {
    }

    public RollBackSZCGEvent(
           com.topevery.www.WSRollbackSZCGEventParameter para) {
           this.para = para;
    }


    /**
     * Gets the para value for this RollBackSZCGEvent.
     * 
     * @return para
     */
    public com.topevery.www.WSRollbackSZCGEventParameter getPara() {
        return para;
    }


    /**
     * Sets the para value for this RollBackSZCGEvent.
     * 
     * @param para
     */
    public void setPara(com.topevery.www.WSRollbackSZCGEventParameter para) {
        this.para = para;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RollBackSZCGEvent)) return false;
        RollBackSZCGEvent other = (RollBackSZCGEvent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.para==null && other.getPara()==null) || 
             (this.para!=null &&
              this.para.equals(other.getPara())));
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
        if (getPara() != null) {
            _hashCode += getPara().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RollBackSZCGEvent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", ">RollBackSZCGEvent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("para");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "para"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSRollbackSZCGEventParameter"));
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
