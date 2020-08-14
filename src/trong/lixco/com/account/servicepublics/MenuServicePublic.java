/**
 * MenuServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface MenuServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.Menu find_ID(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Menu find_Name(java.lang.String arg0, trong.lixco.com.account.servicepublics.Program arg1) throws java.rmi.RemoteException;
    public boolean delete(trong.lixco.com.account.servicepublics.Menu arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Menu[] findAll() throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Menu[] find_Program(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Menu create(trong.lixco.com.account.servicepublics.Menu arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Menu update(trong.lixco.com.account.servicepublics.Menu arg0) throws java.rmi.RemoteException;
}
