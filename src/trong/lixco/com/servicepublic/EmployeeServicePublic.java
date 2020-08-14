/**
 * EmployeeServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.servicepublic;

public interface EmployeeServicePublic extends java.rmi.Remote {
    public trong.lixco.com.servicepublic.EmployeeDTO[] findByDep(java.lang.String[] arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.EmployeeDTO findByCode(java.lang.String arg0) throws java.rmi.RemoteException;
    public void updateEmail(long arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.EmployeeDTO[] findAll() throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.EmployeeDTO findByCodeOld(java.lang.String arg0, java.lang.String[] arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.EmployeeDTO[] findByAllDepart() throws java.rmi.RemoteException;
}
