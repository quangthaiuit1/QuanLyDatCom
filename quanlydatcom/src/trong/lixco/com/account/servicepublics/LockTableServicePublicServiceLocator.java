/**
 * LockTableServicePublicServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

import trong.lixco.com.util.StaticPath;

public class LockTableServicePublicServiceLocator extends org.apache.axis.client.Service implements trong.lixco.com.account.servicepublics.LockTableServicePublicService {

    public LockTableServicePublicServiceLocator() {
    }


    public LockTableServicePublicServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LockTableServicePublicServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LockTableServicePublicPort
    private java.lang.String LockTableServicePublicPort_address = StaticPath.getPath()+"/account_service/LockTableServicePublic";

    public java.lang.String getLockTableServicePublicPortAddress() {
        return LockTableServicePublicPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LockTableServicePublicPortWSDDServiceName = "LockTableServicePublicPort";

    public java.lang.String getLockTableServicePublicPortWSDDServiceName() {
        return LockTableServicePublicPortWSDDServiceName;
    }

    public void setLockTableServicePublicPortWSDDServiceName(java.lang.String name) {
        LockTableServicePublicPortWSDDServiceName = name;
    }

    public trong.lixco.com.account.servicepublics.LockTableServicePublic getLockTableServicePublicPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LockTableServicePublicPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLockTableServicePublicPort(endpoint);
    }

    public trong.lixco.com.account.servicepublics.LockTableServicePublic getLockTableServicePublicPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            trong.lixco.com.account.servicepublics.LockTableServicePublicServiceSoapBindingStub _stub = new trong.lixco.com.account.servicepublics.LockTableServicePublicServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getLockTableServicePublicPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLockTableServicePublicPortEndpointAddress(java.lang.String address) {
        LockTableServicePublicPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (trong.lixco.com.account.servicepublics.LockTableServicePublic.class.isAssignableFrom(serviceEndpointInterface)) {
                trong.lixco.com.account.servicepublics.LockTableServicePublicServiceSoapBindingStub _stub = new trong.lixco.com.account.servicepublics.LockTableServicePublicServiceSoapBindingStub(new java.net.URL(LockTableServicePublicPort_address), this);
                _stub.setPortName(getLockTableServicePublicPortWSDDServiceName());
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
        if ("LockTableServicePublicPort".equals(inputPortName)) {
            return getLockTableServicePublicPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "LockTableServicePublicService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "LockTableServicePublicPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LockTableServicePublicPort".equals(portName)) {
            setLockTableServicePublicPortEndpointAddress(address);
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
