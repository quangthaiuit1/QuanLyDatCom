/**
 * ProgramServicePublicServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

import trong.lixco.com.util.StaticPath;

public class ProgramServicePublicServiceLocator extends org.apache.axis.client.Service implements trong.lixco.com.account.servicepublics.ProgramServicePublicService {

    public ProgramServicePublicServiceLocator() {
    }


    public ProgramServicePublicServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProgramServicePublicServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ProgramServicePublicPort
    private java.lang.String ProgramServicePublicPort_address = StaticPath.getPath()+"/account_service/ProgramServicePublic";

    public java.lang.String getProgramServicePublicPortAddress() {
        return ProgramServicePublicPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProgramServicePublicPortWSDDServiceName = "ProgramServicePublicPort";

    public java.lang.String getProgramServicePublicPortWSDDServiceName() {
        return ProgramServicePublicPortWSDDServiceName;
    }

    public void setProgramServicePublicPortWSDDServiceName(java.lang.String name) {
        ProgramServicePublicPortWSDDServiceName = name;
    }

    public trong.lixco.com.account.servicepublics.ProgramServicePublic getProgramServicePublicPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ProgramServicePublicPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProgramServicePublicPort(endpoint);
    }

    public trong.lixco.com.account.servicepublics.ProgramServicePublic getProgramServicePublicPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            trong.lixco.com.account.servicepublics.ProgramServicePublicServiceSoapBindingStub _stub = new trong.lixco.com.account.servicepublics.ProgramServicePublicServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getProgramServicePublicPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProgramServicePublicPortEndpointAddress(java.lang.String address) {
        ProgramServicePublicPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (trong.lixco.com.account.servicepublics.ProgramServicePublic.class.isAssignableFrom(serviceEndpointInterface)) {
                trong.lixco.com.account.servicepublics.ProgramServicePublicServiceSoapBindingStub _stub = new trong.lixco.com.account.servicepublics.ProgramServicePublicServiceSoapBindingStub(new java.net.URL(ProgramServicePublicPort_address), this);
                _stub.setPortName(getProgramServicePublicPortWSDDServiceName());
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
        if ("ProgramServicePublicPort".equals(inputPortName)) {
            return getProgramServicePublicPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "ProgramServicePublicService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://servicepublics.account.com.lixco.trong/", "ProgramServicePublicPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ProgramServicePublicPort".equals(portName)) {
            setProgramServicePublicPortEndpointAddress(address);
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
