/**
 * MemberServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface MemberServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.Member findByCode(java.lang.String arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Member findLike(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Member[] findByDepartment(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Member[] findSearchWarehouse(java.lang.String arg0, java.lang.String[] arg1, java.lang.Boolean arg2) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Member findId(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Member create(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Member[] findSearch(java.lang.String arg0, java.lang.String[] arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Member[] findAll() throws java.rmi.RemoteException;
    public boolean delete(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Member[] findByCodeDepart(java.lang.String arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Member update(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException;
}
