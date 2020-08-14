/**
 * UserRightServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.account.servicepublics;

public interface UserRightServicePublic extends java.rmi.Remote {
    public trong.lixco.com.account.servicepublics.UserRight findId(long arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.UserRight[] findUserRightByRole(trong.lixco.com.account.servicepublics.Role arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.UserRight create(trong.lixco.com.account.servicepublics.UserRight arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.account.servicepublics.UserRight update(trong.lixco.com.account.servicepublics.UserRight arg0) throws java.rmi.RemoteException;
}
