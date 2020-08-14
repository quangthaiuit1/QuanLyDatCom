package trong.lixco.com.account.servicepublics;

public class AccountServicePublicProxy implements trong.lixco.com.account.servicepublics.AccountServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.AccountServicePublic accountServicePublic = null;
  
  public AccountServicePublicProxy() {
    _initAccountServicePublicProxy();
  }
  
  public AccountServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initAccountServicePublicProxy();
  }
  
  private void _initAccountServicePublicProxy() {
    try {
      accountServicePublic = (new trong.lixco.com.account.servicepublics.AccountServicePublicServiceLocator()).getAccountServicePublicPort();
      if (accountServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)accountServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)accountServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (accountServicePublic != null)
      ((javax.xml.rpc.Stub)accountServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.AccountServicePublic getAccountServicePublic() {
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic;
  }
  
  public trong.lixco.com.account.servicepublics.Account find_User_Pass_Ext(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.find_User_Pass_Ext(arg0, arg1, arg2);
  }
  
  public trong.lixco.com.account.servicepublics.Account findById(long arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.findById(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.SingleSignOn findSSOById(long arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.findSSOById(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Program[] findProgramByAccount(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.findProgramByAccount(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Account findMember(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.findMember(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.UserRight[] findUserRightByAccPro(trong.lixco.com.account.servicepublics.Account arg0, trong.lixco.com.account.servicepublics.Program arg1) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.findUserRightByAccPro(arg0, arg1);
  }
  
  public trong.lixco.com.account.servicepublics.Account[] findAllNotAccount(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.findAllNotAccount(arg0);
  }
  
  public boolean deleteSSO(trong.lixco.com.account.servicepublics.SingleSignOn arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.deleteSSO(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.SingleSignOn createSSO(trong.lixco.com.account.servicepublics.SingleSignOn arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.createSSO(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Account create(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Account find_User_Pass(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.find_User_Pass(arg0, arg1);
  }
  
  public trong.lixco.com.account.servicepublics.SingleSignOn[] findSSOByValue(java.lang.String arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.findSSOByValue(arg0);
  }
  
  
  public trong.lixco.com.account.servicepublics.Account find_User(java.lang.String arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.find_User(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Role[] findRoleByAccPro(trong.lixco.com.account.servicepublics.Account arg0, trong.lixco.com.account.servicepublics.Program arg1) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.findRoleByAccPro(arg0, arg1);
  }
  
  public boolean delete(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.delete(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Menu[] findMenuByProgram(trong.lixco.com.account.servicepublics.Program arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.findMenuByProgram(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Account update(trong.lixco.com.account.servicepublics.Account arg0) throws java.rmi.RemoteException{
    if (accountServicePublic == null)
      _initAccountServicePublicProxy();
    return accountServicePublic.update(arg0);
  }
  
  
}