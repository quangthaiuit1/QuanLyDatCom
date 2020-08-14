/**
 * DepartmentServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface DepartmentServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.Department[] findSearch(java.lang.String arg0, java.lang.String[] arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Department findByCode(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Department[] getAllDepartSubByParent(java.lang.String arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Department findId(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Department[] findAll() throws java.rmi.RemoteException;
    public boolean delete(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Department create(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Department update(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException;
}
