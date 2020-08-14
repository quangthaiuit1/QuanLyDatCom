/**
 * EmpPJobServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.servicepublic;

public interface EmpPJobServicePublic extends java.rmi.Remote {
    public trong.lixco.com.servicepublic.EmpPJobDTO[] findAll() throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.EmpPJobDTO[] findByCodeEmp(java.lang.String arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.EmpPJobDTO[] findByCodecodePJob(java.lang.String arg0) throws java.rmi.RemoteException;
}
