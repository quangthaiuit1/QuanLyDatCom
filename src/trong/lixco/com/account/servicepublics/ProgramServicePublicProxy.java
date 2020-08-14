package trong.lixco.com.account.servicepublics;

public class ProgramServicePublicProxy implements trong.lixco.com.account.servicepublics.ProgramServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.ProgramServicePublic programServicePublic = null;
  
  public ProgramServicePublicProxy() {
    _initProgramServicePublicProxy();
  }
  
  public ProgramServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initProgramServicePublicProxy();
  }
  
  private void _initProgramServicePublicProxy() {
    try {
      programServicePublic = (new trong.lixco.com.account.servicepublics.ProgramServicePublicServiceLocator()).getProgramServicePublicPort();
      if (programServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)programServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)programServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (programServicePublic != null)
      ((javax.xml.rpc.Stub)programServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.ProgramServicePublic getProgramServicePublic() {
    if (programServicePublic == null)
      _initProgramServicePublicProxy();
    return programServicePublic;
  }
  
  public trong.lixco.com.account.servicepublics.Program getFirst() throws java.rmi.RemoteException{
    if (programServicePublic == null)
      _initProgramServicePublicProxy();
    return programServicePublic.getFirst();
  }
  public trong.lixco.com.account.servicepublics.Program[] findIndex(int arg0) throws java.rmi.RemoteException{
    if (programServicePublic == null)
      _initProgramServicePublicProxy();
    return programServicePublic.findIndex(arg0);
  }
  
  public boolean delete(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException{
    if (programServicePublic == null)
      _initProgramServicePublicProxy();
    return programServicePublic.delete(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Program[] findAll() throws java.rmi.RemoteException{
    if (programServicePublic == null)
      _initProgramServicePublicProxy();
    return programServicePublic.findAll();
  }
  
  public trong.lixco.com.account.servicepublics.Program findId(long arg0) throws java.rmi.RemoteException{
    if (programServicePublic == null)
      _initProgramServicePublicProxy();
    return programServicePublic.findId(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Program create(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException{
    if (programServicePublic == null)
      _initProgramServicePublicProxy();
    return programServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Program findByName(java.lang.String arg0) throws java.rmi.RemoteException{
    if (programServicePublic == null)
      _initProgramServicePublicProxy();
    return programServicePublic.findByName(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Program update(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException{
    if (programServicePublic == null)
      _initProgramServicePublicProxy();
    return programServicePublic.update(arg0);
  }
  
  
}