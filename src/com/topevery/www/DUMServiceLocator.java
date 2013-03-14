/**
 * DUMServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class DUMServiceLocator extends org.apache.axis.client.Service implements com.topevery.www.DUMService {

    public DUMServiceLocator() {
    }


    public DUMServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DUMServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DUMServiceSoap
    private java.lang.String DUMServiceSoap_address = "http://59.36.241.83:8010/jmum/ASMX/DUMService.asmx";

    public java.lang.String getDUMServiceSoapAddress() {
        return DUMServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DUMServiceSoapWSDDServiceName = "DUMServiceSoap";

    public java.lang.String getDUMServiceSoapWSDDServiceName() {
        return DUMServiceSoapWSDDServiceName;
    }

    public void setDUMServiceSoapWSDDServiceName(java.lang.String name) {
        DUMServiceSoapWSDDServiceName = name;
    }

    public com.topevery.www.DUMServiceSoap getDUMServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DUMServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDUMServiceSoap(endpoint);
    }

    public com.topevery.www.DUMServiceSoap getDUMServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.topevery.www.DUMServiceSoapStub _stub = new com.topevery.www.DUMServiceSoapStub(portAddress, this);
            _stub.setPortName(getDUMServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDUMServiceSoapEndpointAddress(java.lang.String address) {
        DUMServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.topevery.www.DUMServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.topevery.www.DUMServiceSoapStub _stub = new com.topevery.www.DUMServiceSoapStub(new java.net.URL(DUMServiceSoap_address), this);
                _stub.setPortName(getDUMServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("DUMServiceSoap".equals(inputPortName)) {
            return getDUMServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.topevery.com/", "DUMService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.topevery.com/", "DUMServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DUMServiceSoap".equals(portName)) {
            setDUMServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
