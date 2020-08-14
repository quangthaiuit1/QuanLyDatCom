package trong.lixco.com.account.servicepublics;

public class UserRightServicePublicProxy implements trong.lixco.com.account.servicepublics.UserRightServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.UserRightServicePublic userRightServicePublic = null;
  
  public UserRightServicePublicProxy() {
    _initUserRightServicePublicProxy();
  }
  
  public UserRightServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initUserRightServicePublicProxy();
  }
  
  private void _initUserRightServicePublicProxy() {
    try {
      userRightServicePublic = (new trong.lixco.com.account.servicepublics.UserRightServicePublicServiceLocator()).getUserRightServicePublicPort();
      if (userRightServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)userRightServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)userRightServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (userRightServicePublic != null)
      ((javax.xml.rpc.Stub)userRightServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.UserRightServicePublic getUserRightServicePublic() {
    if (userRightServicePublic == null)
      _initUserRightServicePublicProxy();
    return userRightServicePublic;
  }
  
  public trong.lixco.com.account.servicepublics.UserRight findId(long arg0) throws java.rmi.RemoteException{
    if (userRightServicePublic == null)
      _initUserRightServicePublicProxy();
    return userRightServicePublic.findId(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.UserRight[] findUserRightByRole(trong.lixco.com.account.servicepublics.Role arg0) throws java.rmi.RemoteException{
    if (userRightServicePublic == null)
      _initUserRightServicePublicProxy();
    return userRightServicePublic.findUserRightByRole(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.UserRight create(trong.lixco.com.account.servicepublics.UserRight arg0) throws java.rmi.RemoteException{
    if (userRightServicePublic == null)
      _initUserRightServicePublicProxy();
    return userRightServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.UserRight update(trong.lixco.com.account.servicepublics.UserRight arg0) throws java.rmi.RemoteException{
    if (userRightServicePublic == null)
      _initUserRightServicePublicProxy();
    return userRightServicePublic.update(arg0);
  }
  
  
}