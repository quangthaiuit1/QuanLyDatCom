package trong.lixco.com.account.servicepublics;

public class PrivateConfigServicePublicProxy implements trong.lixco.com.account.servicepublics.PrivateConfigServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.PrivateConfigServicePublic privateConfigServicePublic = null;
  
  public PrivateConfigServicePublicProxy() {
    _initPrivateConfigServicePublicProxy();
  }
  
  public PrivateConfigServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initPrivateConfigServicePublicProxy();
  }
  
  private void _initPrivateConfigServicePublicProxy() {
    try {
      privateConfigServicePublic = (new trong.lixco.com.account.servicepublics.PrivateConfigServicePublicServiceLocator()).getPrivateConfigServicePublicPort();
      if (privateConfigServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)privateConfigServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)privateConfigServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (privateConfigServicePublic != null)
      ((javax.xml.rpc.Stub)privateConfigServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.PrivateConfigServicePublic getPrivateConfigServicePublic() {
    if (privateConfigServicePublic == null)
      _initPrivateConfigServicePublicProxy();
    return privateConfigServicePublic;
  }
  
  
  public boolean delete(trong.lixco.com.account.servicepublics.PrivateConfig arg0) throws java.rmi.RemoteException{
    if (privateConfigServicePublic == null)
      _initPrivateConfigServicePublicProxy();
    return privateConfigServicePublic.delete(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.PrivateConfig findId(long arg0) throws java.rmi.RemoteException{
    if (privateConfigServicePublic == null)
      _initPrivateConfigServicePublicProxy();
    return privateConfigServicePublic.findId(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.PrivateConfig create(trong.lixco.com.account.servicepublics.PrivateConfig arg0) throws java.rmi.RemoteException{
    if (privateConfigServicePublic == null)
      _initPrivateConfigServicePublicProxy();
    return privateConfigServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.PrivateConfig update(trong.lixco.com.account.servicepublics.PrivateConfig arg0) throws java.rmi.RemoteException{
    if (privateConfigServicePublic == null)
      _initPrivateConfigServicePublicProxy();
    return privateConfigServicePublic.update(arg0);
  }
  
  
}