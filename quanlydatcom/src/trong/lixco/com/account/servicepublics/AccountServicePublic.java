/**
 * AccountServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface AccountServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.Account find_User_Pass_Ext(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Account findById(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.SingleSignOn findSSOById(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Program[] findProgramByAccount(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Account findMember(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.UserRight[] findUserRightByAccPro(trong.lixco.com.account.servicepublics.Account arg0, trong.lixco.com.account.servicepublics.Program arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Account[] findAllNotAccount(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException;
    public boolean deleteSSO(trong.lixco.com.account.servicepublics.SingleSignOn arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.SingleSignOn createSSO(trong.lixco.com.account.servicepublics.SingleSignOn arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Account create(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Account find_User_Pass(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.SingleSignOn[] findSSOByValue(java.lang.String arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Account find_User(java.lang.String arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Role[] findRoleByAccPro(trong.lixco.com.account.servicepublics.Account arg0, trong.lixco.com.account.servicepublics.Program arg1) throws java.rmi.RemoteException;
    public boolean delete(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Menu[] findMenuByProgram(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.Account update(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException;
}
