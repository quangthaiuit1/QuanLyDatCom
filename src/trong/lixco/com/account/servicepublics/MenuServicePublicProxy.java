package trong.lixco.com.account.servicepublics;

public class MenuServicePublicProxy implements trong.lixco.com.account.servicepublics.MenuServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.MenuServicePublic menuServicePublic = null;
  
  public MenuServicePublicProxy() {
    _initMenuServicePublicProxy();
  }
  
  public MenuServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initMenuServicePublicProxy();
  }
  
  private void _initMenuServicePublicProxy() {
    try {
      menuServicePublic = (new trong.lixco.com.account.servicepublics.MenuServicePublicServiceLocator()).getMenuServicePublicPort();
      if (menuServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)menuServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)menuServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (menuServicePublic != null)
      ((javax.xml.rpc.Stub)menuServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.MenuServicePublic getMenuServicePublic() {
    if (menuServicePublic == null)
      _initMenuServicePublicProxy();
    return menuServicePublic;
  }
  
  
  public trong.lixco.com.account.servicepublics.Menu find_ID(long arg0) throws java.rmi.RemoteException{
    if (menuServicePublic == null)
      _initMenuServicePublicProxy();
    return menuServicePublic.find_ID(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Menu find_Name(java.lang.String arg0, trong.lixco.com.account.servicepublics.Program arg1) throws java.rmi.RemoteException{
    if (menuServicePublic == null)
      _initMenuServicePublicProxy();
    return menuServicePublic.find_Name(arg0, arg1);
  }
  
  public boolean delete(trong.lixco.com.account.servicepublics.Menu arg0) throws java.rmi.RemoteException{
    if (menuServicePublic == null)
      _initMenuServicePublicProxy();
    return menuServicePublic.delete(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Menu[] findAll() throws java.rmi.RemoteException{
    if (menuServicePublic == null)
      _initMenuServicePublicProxy();
    return menuServicePublic.findAll();
  }
  
  public trong.lixco.com.account.servicepublics.Menu[] find_Program(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException{
    if (menuServicePublic == null)
      _initMenuServicePublicProxy();
    return menuServicePublic.find_Program(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Menu create(trong.lixco.com.account.servicepublics.Menu arg0) throws java.rmi.RemoteException{
    if (menuServicePublic == null)
      _initMenuServicePublicProxy();
    return menuServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Menu update(trong.lixco.com.account.servicepublics.Menu arg0) throws java.rmi.RemoteException{
    if (menuServicePublic == null)
      _initMenuServicePublicProxy();
    return menuServicePublic.update(arg0);
  }
  
  
}