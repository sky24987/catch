/**
 * WSGetTimeChangeListResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class WSGetTimeChangeListResult  extends com.topevery.www.WSRetValue  implements java.io.Serializable {
    private com.topevery.www.WSTimeChange[] timeChangeList;

    public WSGetTimeChangeListResult() {
    }

    public WSGetTimeChangeListResult(
           boolean success,
           java.lang.String errorMsg,
           com.topevery.www.WSTimeChange[] timeChangeList) {
        super(
            success,
            errorMsg);
        this.timeChangeList = timeChangeList;
    }


    /**
     * Gets the timeChangeList value for this WSGetTimeChangeListResult.
     * 
     * @return timeChangeList
     */
    public com.topevery.www.WSTimeChange[] getTimeChangeList() {
        return timeChangeList;
    }


    /**
     * Sets the timeChangeList value for this WSGetTimeChangeListResult.
     * 
     * @param timeChangeList
     */
    public void setTimeChangeList(com.topevery.www.WSTimeChange[] timeChangeList) {
        this.timeChangeList = timeChangeList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WSGetTimeChangeListResult)) return false;
        WSGetTimeChangeListResult other = (WSGetTimeChangeListResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.timeChangeList==null && other.getTimeChangeList()==null) || 
             (this.timeChangeList!=null &&
              java.util.Arrays.equals(this.timeChangeList, other.getTimeChangeList())));
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
        if (getTimeChangeList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTimeChangeList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTimeChangeList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WSGetTimeChangeListResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSGetTimeChangeListResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeChangeList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "TimeChangeList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChange"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChange"));
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
