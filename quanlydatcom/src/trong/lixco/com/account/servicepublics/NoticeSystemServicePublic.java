/**
 * NoticeSystemServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface NoticeSystemServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.NoticeSystem[] findSearch(java.lang.String arg0, java.lang.String[] arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.NoticeSystem createOrUpdate(trong.lixco.com.account.servicepublics.NoticeSystem arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.NoticeSystem findByCode(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.NoticeSystem findId(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.NoticeSystem[] findAll() throws java.rmi.RemoteException;
    public boolean delete(trong.lixco.com.account.servicepublics.NoticeSystem arg0) throws java.rmi.RemoteException;
}
