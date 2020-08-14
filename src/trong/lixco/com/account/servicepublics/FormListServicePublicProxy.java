package trong.lixco.com.account.servicepublics;

public class FormListServicePublicProxy implements trong.lixco.com.account.servicepublics.FormListServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.FormListServicePublic formListServicePublic = null;
  
  public FormListServicePublicProxy() {
    _initFormListServicePublicProxy();
  }
  
  public FormListServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initFormListServicePublicProxy();
  }
  
  private void _initFormListServicePublicProxy() {
    try {
      formListServicePublic = (new trong.lixco.com.account.servicepublics.FormListServicePublicServiceLocator()).getFormListServicePublicPort();
      if (formListServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)formListServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)formListServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (formListServicePublic != null)
      ((javax.xml.rpc.Stub)formListServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.FormListServicePublic getFormListServicePublic() {
    if (formListServicePublic == null)
      _initFormListServicePublicProxy();
    return formListServicePublic;
  }
  public trong.lixco.com.account.servicepublics.FormList[] findByProgram(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException{
    if (formListServicePublic == null)
      _initFormListServicePublicProxy();
    return formListServicePublic.findByProgram(arg0);
  }
  
  public boolean delete(trong.lixco.com.account.servicepublics.FormList arg0) throws java.rmi.RemoteException{
    if (formListServicePublic == null)
      _initFormListServicePublicProxy();
    return formListServicePublic.delete(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.FormList[] findAll() throws java.rmi.RemoteException{
    if (formListServicePublic == null)
      _initFormListServicePublicProxy();
    return formListServicePublic.findAll();
  }
  
  public trong.lixco.com.account.servicepublics.FormList findId(long arg0) throws java.rmi.RemoteException{
    if (formListServicePublic == null)
      _initFormListServicePublicProxy();
    return formListServicePublic.findId(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.FormList create(trong.lixco.com.account.servicepublics.FormList arg0) throws java.rmi.RemoteException{
    if (formListServicePublic == null)
      _initFormListServicePublicProxy();
    return formListServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.FormList update(trong.lixco.com.account.servicepublics.FormList arg0) throws java.rmi.RemoteException{
    if (formListServicePublic == null)
      _initFormListServicePublicProxy();
    return formListServicePublic.update(arg0);
  }
  
  
}