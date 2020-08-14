/**
 * PositionJobServicePublic.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package trong.lixco.com.servicepublic;

public interface PositionJobServicePublic extends java.rmi.Remote {
    public trong.lixco.com.servicepublic.PositionJobDTO[] findAll() throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.PositionJobDTO findByCode(java.lang.String arg0) throws java.rmi.RemoteException;
    public trong.lixco.com.servicepublic.PositionJobDTO[] findDep(java.lang.String arg0) throws java.rmi.RemoteException;
}
