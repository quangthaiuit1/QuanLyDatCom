/**
 * DepartNoticeRelaServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface DepartNoticeRelaServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.DepartNoticeRela[] findByDepartment(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.DepartNoticeRela saveOrUpdater(trong.lixco.com.account.servicepublics.DepartNoticeRela arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.DepartNoticeRela[] findByNotice(trong.lixco.com.account.servicepublics.NoticeSystem arg0) throws java.rmi.RemoteException;
}
