/**
 * ProgramServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface ProgramServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.Program getFirst() throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Program[] findIndex(int arg0) throws java.rmi.RemoteException;
    public boolean delete(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Program[] findAll() throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Program findId(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Program create(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Program findByName(java.lang.String arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Program update(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException;
}
