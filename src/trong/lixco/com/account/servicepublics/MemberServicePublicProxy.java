package trong.lixco.com.account.servicepublics;

public class MemberServicePublicProxy implements trong.lixco.com.account.servicepublics.MemberServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.MemberServicePublic memberServicePublic = null;
  
  public MemberServicePublicProxy() {
    _initMemberServicePublicProxy();
  }
  
  public MemberServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initMemberServicePublicProxy();
  }
  
  private void _initMemberServicePublicProxy() {
    try {
      memberServicePublic = (new trong.lixco.com.account.servicepublics.MemberServicePublicServiceLocator()).getMemberServicePublicPort();
      if (memberServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)memberServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)memberServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (memberServicePublic != null)
      ((javax.xml.rpc.Stub)memberServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.MemberServicePublic getMemberServicePublic() {
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic;
  }
  
  public trong.lixco.com.account.servicepublics.Member findByCode(java.lang.String arg0) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.findByCode(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Member findLike(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.findLike(arg0, arg1);
  }
  
  public trong.lixco.com.account.servicepublics.Member[] findByDepartment(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.findByDepartment(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Member[] findSearchWarehouse(java.lang.String arg0, java.lang.String[] arg1, java.lang.Boolean arg2) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.findSearchWarehouse(arg0, arg1, arg2);
  }
  
  public trong.lixco.com.account.servicepublics.Member findId(long arg0) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.findId(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Member create(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Member[] findSearch(java.lang.String arg0, java.lang.String[] arg1) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.findSearch(arg0, arg1);
  }
  
  public trong.lixco.com.account.servicepublics.Member[] findAll() throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.findAll();
  }
  
  public boolean delete(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.delete(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Member[] findByCodeDepart(java.lang.String arg0) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.findByCodeDepart(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Member update(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException{
    if (memberServicePublic == null)
      _initMemberServicePublicProxy();
    return memberServicePublic.update(arg0);
  }
  
  
}