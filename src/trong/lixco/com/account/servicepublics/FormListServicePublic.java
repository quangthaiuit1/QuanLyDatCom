/**
 * FormListServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface FormListServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.FormList[] findByProgram(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException;
    public boolean delete(trong.lixco.com.account.servicepublics.FormList arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.FormList[] findAll() throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.FormList findId(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.FormList create(trong.lixco.com.account.servicepublics.FormList arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.FormList update(trong.lixco.com.account.servicepublics.FormList arg0) throws java.rmi.RemoteException;
}
