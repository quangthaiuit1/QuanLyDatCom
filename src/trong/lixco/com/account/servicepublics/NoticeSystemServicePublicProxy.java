package trong.lixco.com.account.servicepublics;

public class NoticeSystemServicePublicProxy implements trong.lixco.com.account.servicepublics.NoticeSystemServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.NoticeSystemServicePublic noticeSystemServicePublic = null;
  
  public NoticeSystemServicePublicProxy() {
    _initNoticeSystemServicePublicProxy();
  }
  
  public NoticeSystemServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initNoticeSystemServicePublicProxy();
  }
  
  private void _initNoticeSystemServicePublicProxy() {
    try {
      noticeSystemServicePublic = (new trong.lixco.com.account.servicepublics.NoticeSystemServicePublicServiceLocator()).getNoticeSystemServicePublicPort();
      if (noticeSystemServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)noticeSystemServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)noticeSystemServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (noticeSystemServicePublic != null)
      ((javax.xml.rpc.Stub)noticeSystemServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.NoticeSystemServicePublic getNoticeSystemServicePublic() {
    if (noticeSystemServicePublic == null)
      _initNoticeSystemServicePublicProxy();
    return noticeSystemServicePublic;
  }
  
  public trong.lixco.com.account.servicepublics.NoticeSystem[] findSearch(java.lang.String arg0, java.lang.String[] arg1) throws java.rmi.RemoteException{
    if (noticeSystemServicePublic == null)
      _initNoticeSystemServicePublicProxy();
    return noticeSystemServicePublic.findSearch(arg0, arg1);
  }
  
  public trong.lixco.com.account.servicepublics.NoticeSystem createOrUpdate(trong.lixco.com.account.servicepublics.NoticeSystem arg0) throws java.rmi.RemoteException{
    if (noticeSystemServicePublic == null)
      _initNoticeSystemServicePublicProxy();
    return noticeSystemServicePublic.createOrUpdate(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.NoticeSystem findByCode(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (noticeSystemServicePublic == null)
      _initNoticeSystemServicePublicProxy();
    return noticeSystemServicePublic.findByCode(arg0, arg1);
  }
  
  public trong.lixco.com.account.servicepublics.NoticeSystem findId(long arg0) throws java.rmi.RemoteException{
    if (noticeSystemServicePublic == null)
      _initNoticeSystemServicePublicProxy();
    return noticeSystemServicePublic.findId(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.NoticeSystem[] findAll() throws java.rmi.RemoteException{
    if (noticeSystemServicePublic == null)
      _initNoticeSystemServicePublicProxy();
    return noticeSystemServicePublic.findAll();
  }
  
  public boolean delete(trong.lixco.com.account.servicepublics.NoticeSystem arg0) throws java.rmi.RemoteException{
    if (noticeSystemServicePublic == null)
      _initNoticeSystemServicePublicProxy();
    return noticeSystemServicePublic.delete(arg0);
  }
  
  
}