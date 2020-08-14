/**
 * RoleServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface RoleServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.Role[] findByProgram(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException;
    public boolean delete(trong.lixco.com.account.servicepublics.Role arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Role[] findAll() throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Role findId(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Role create(trong.lixco.com.account.servicepublics.Role arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Role update(trong.lixco.com.account.servicepublics.Role arg0) throws java.rmi.RemoteException;
}
