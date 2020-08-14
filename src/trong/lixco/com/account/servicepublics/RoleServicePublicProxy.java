package trong.lixco.com.account.servicepublics;

public class RoleServicePublicProxy implements trong.lixco.com.account.servicepublics.RoleServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.RoleServicePublic roleServicePublic = null;
  
  public RoleServicePublicProxy() {
    _initRoleServicePublicProxy();
  }
  
  public RoleServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initRoleServicePublicProxy();
  }
  
  private void _initRoleServicePublicProxy() {
    try {
      roleServicePublic = (new trong.lixco.com.account.servicepublics.RoleServicePublicServiceLocator()).getRoleServicePublicPort();
      if (roleServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)roleServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)roleServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (roleServicePublic != null)
      ((javax.xml.rpc.Stub)roleServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.RoleServicePublic getRoleServicePublic() {
    if (roleServicePublic == null)
      _initRoleServicePublicProxy();
    return roleServicePublic;
  }
  public trong.lixco.com.account.servicepublics.Role[] findByProgram(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException{
    if (roleServicePublic == null)
      _initRoleServicePublicProxy();
    return roleServicePublic.findByProgram(arg0);
  }
  
  public boolean delete(trong.lixco.com.account.servicepublics.Role arg0) throws java.rmi.RemoteException{
    if (roleServicePublic == null)
      _initRoleServicePublicProxy();
    return roleServicePublic.delete(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Role[] findAll() throws java.rmi.RemoteException{
    if (roleServicePublic == null)
      _initRoleServicePublicProxy();
    return roleServicePublic.findAll();
  }
  
  public trong.lixco.com.account.servicepublics.Role findId(long arg0) throws java.rmi.RemoteException{
    if (roleServicePublic == null)
      _initRoleServicePublicProxy();
    return roleServicePublic.findId(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Role create(trong.lixco.com.account.servicepublics.Role arg0) throws java.rmi.RemoteException{
    if (roleServicePublic == null)
      _initRoleServicePublicProxy();
    return roleServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Role update(trong.lixco.com.account.servicepublics.Role arg0) throws java.rmi.RemoteException{
    if (roleServicePublic == null)
      _initRoleServicePublicProxy();
    return roleServicePublic.update(arg0);
  }
  
  
}