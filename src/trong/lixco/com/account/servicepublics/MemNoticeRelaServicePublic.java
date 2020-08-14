/**
 * MemNoticeRelaServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface MemNoticeRelaServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.MemNoticeRela[] findByMember(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.MemNoticeRela saveOrUpdater(trong.lixco.com.account.servicepublics.MemNoticeRela arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.MemNoticeRela[] findByNotice(trong.lixco.com.account.servicepublics.NoticeSystem arg0) throws java.rmi.RemoteException;
}
