package trong.lixco.com.account.servicepublics;

public class DepartNoticeRelaServicePublicProxy implements trong.lixco.com.account.servicepublics.DepartNoticeRelaServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.DepartNoticeRelaServicePublic departNoticeRelaServicePublic = null;
  
  public DepartNoticeRelaServicePublicProxy() {
    _initDepartNoticeRelaServicePublicProxy();
  }
  
  public DepartNoticeRelaServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initDepartNoticeRelaServicePublicProxy();
  }
  
  private void _initDepartNoticeRelaServicePublicProxy() {
    try {
      departNoticeRelaServicePublic = (new trong.lixco.com.account.servicepublics.DepartNoticeRelaServicePublicServiceLocator()).getDepartNoticeRelaServicePublicPort();
      if (departNoticeRelaServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)departNoticeRelaServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)departNoticeRelaServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (departNoticeRelaServicePublic != null)
      ((javax.xml.rpc.Stub)departNoticeRelaServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.DepartNoticeRelaServicePublic getDepartNoticeRelaServicePublic() {
    if (departNoticeRelaServicePublic == null)
      _initDepartNoticeRelaServicePublicProxy();
    return departNoticeRelaServicePublic;
  }
  public trong.lixco.com.account.servicepublics.DepartNoticeRela[] findByDepartment(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException{
    if (departNoticeRelaServicePublic == null)
      _initDepartNoticeRelaServicePublicProxy();
    return departNoticeRelaServicePublic.findByDepartment(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.DepartNoticeRela saveOrUpdater(trong.lixco.com.account.servicepublics.DepartNoticeRela arg0) throws java.rmi.RemoteException{
    if (departNoticeRelaServicePublic == null)
      _initDepartNoticeRelaServicePublicProxy();
    return departNoticeRelaServicePublic.saveOrUpdater(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.DepartNoticeRela[] findByNotice(trong.lixco.com.account.servicepublics.NoticeSystem arg0) throws java.rmi.RemoteException{
    if (departNoticeRelaServicePublic == null)
      _initDepartNoticeRelaServicePublicProxy();
    return departNoticeRelaServicePublic.findByNotice(arg0);
  }
  
  
}