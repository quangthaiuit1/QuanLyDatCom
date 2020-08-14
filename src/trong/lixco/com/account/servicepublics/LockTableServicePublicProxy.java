package trong.lixco.com.account.servicepublics;

public class LockTableServicePublicProxy implements trong.lixco.com.account.servicepublics.LockTableServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.LockTableServicePublic lockTableServicePublic = null;
  
  public LockTableServicePublicProxy() {
    _initLockTableServicePublicProxy();
  }
  
  public LockTableServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initLockTableServicePublicProxy();
  }
  
  private void _initLockTableServicePublicProxy() {
    try {
      lockTableServicePublic = (new trong.lixco.com.account.servicepublics.LockTableServicePublicServiceLocator()).getLockTableServicePublicPort();
      if (lockTableServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)lockTableServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)lockTableServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (lockTableServicePublic != null)
      ((javax.xml.rpc.Stub)lockTableServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.LockTableServicePublic getLockTableServicePublic() {
    if (lockTableServicePublic == null)
      _initLockTableServicePublicProxy();
    return lockTableServicePublic;
  }
  
  public trong.lixco.com.account.servicepublics.LockTable[] findByProgram(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException{
    if (lockTableServicePublic == null)
      _initLockTableServicePublicProxy();
    return lockTableServicePublic.findByProgram(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.LockTable findMonthYear(int arg0, int arg1, trong.lixco.com.account.servicepublics.Program arg2) throws java.rmi.RemoteException{
    if (lockTableServicePublic == null)
      _initLockTableServicePublicProxy();
    return lockTableServicePublic.findMonthYear(arg0, arg1, arg2);
  }
  
  public trong.lixco.com.account.servicepublics.LockTable findId(long arg0) throws java.rmi.RemoteException{
    if (lockTableServicePublic == null)
      _initLockTableServicePublicProxy();
    return lockTableServicePublic.findId(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.LockTable[] findAll() throws java.rmi.RemoteException{
    if (lockTableServicePublic == null)
      _initLockTableServicePublicProxy();
    return lockTableServicePublic.findAll();
  }
  
  public boolean delete(trong.lixco.com.account.servicepublics.LockTable arg0) throws java.rmi.RemoteException{
    if (lockTableServicePublic == null)
      _initLockTableServicePublicProxy();
    return lockTableServicePublic.delete(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.LockTable create(trong.lixco.com.account.servicepublics.LockTable arg0) throws java.rmi.RemoteException{
    if (lockTableServicePublic == null)
      _initLockTableServicePublicProxy();
    return lockTableServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.LockTable update(trong.lixco.com.account.servicepublics.LockTable arg0) throws java.rmi.RemoteException{
    if (lockTableServicePublic == null)
      _initLockTableServicePublicProxy();
    return lockTableServicePublic.update(arg0);
  }
  
  
}