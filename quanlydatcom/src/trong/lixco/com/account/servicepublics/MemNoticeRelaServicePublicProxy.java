package trong.lixco.com.account.servicepublics;

public class MemNoticeRelaServicePublicProxy implements trong.lixco.com.account.servicepublics.MemNoticeRelaServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.MemNoticeRelaServicePublic memNoticeRelaServicePublic = null;
  
  public MemNoticeRelaServicePublicProxy() {
    _initMemNoticeRelaServicePublicProxy();
  }
  
  public MemNoticeRelaServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initMemNoticeRelaServicePublicProxy();
  }
  
  private void _initMemNoticeRelaServicePublicProxy() {
    try {
      memNoticeRelaServicePublic = (new trong.lixco.com.account.servicepublics.MemNoticeRelaServicePublicServiceLocator()).getMemNoticeRelaServicePublicPort();
      if (memNoticeRelaServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)memNoticeRelaServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)memNoticeRelaServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (memNoticeRelaServicePublic != null)
      ((javax.xml.rpc.Stub)memNoticeRelaServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.MemNoticeRelaServicePublic getMemNoticeRelaServicePublic() {
    if (memNoticeRelaServicePublic == null)
      _initMemNoticeRelaServicePublicProxy();
    return memNoticeRelaServicePublic;
  }
  
  
  public trong.lixco.com.account.servicepublics.MemNoticeRela[] findByMember(trong.lixco.com.account.servicepublics.Member arg0) throws java.rmi.RemoteException{
    if (memNoticeRelaServicePublic == null)
      _initMemNoticeRelaServicePublicProxy();
    return memNoticeRelaServicePublic.findByMember(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.MemNoticeRela saveOrUpdater(trong.lixco.com.account.servicepublics.MemNoticeRela arg0) throws java.rmi.RemoteException{
    if (memNoticeRelaServicePublic == null)
      _initMemNoticeRelaServicePublicProxy();
    return memNoticeRelaServicePublic.saveOrUpdater(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.MemNoticeRela[] findByNotice(trong.lixco.com.account.servicepublics.NoticeSystem arg0) throws java.rmi.RemoteException{
    if (memNoticeRelaServicePublic == null)
      _initMemNoticeRelaServicePublicProxy();
    return memNoticeRelaServicePublic.findByNotice(arg0);
  }
  
  
}