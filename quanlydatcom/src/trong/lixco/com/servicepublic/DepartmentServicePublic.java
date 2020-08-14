/**
 * DepartmentServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.servicepublic;

public interface DepartmentServicePublic extends java.rmi.Remote {
    public trong.lixco.com.servicepublic.DepartmentDTO[] findAll() throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.DepartmentDTO[] findAllSubDepart(java.lang.String arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.DepartmentDTO[] findBranch(java.lang.String arg0) throws java.rmi.RemoteException;
}
