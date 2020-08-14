/**
 * LockTableServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface LockTableServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.LockTable[] findByProgram(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.LockTable findMonthYear(int arg0, int arg1, trong.lixco.com.account.servicepublics.Program arg2) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.LockTable findId(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.LockTable[] findAll() throws java.rmi.RemoteException;
    public boolean delete(trong.lixco.com.account.servicepublics.LockTable arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.LockTable create(trong.lixco.com.account.servicepublics.LockTable arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.LockTable update(trong.lixco.com.account.servicepublics.LockTable arg0) throws java.rmi.RemoteException;
}
