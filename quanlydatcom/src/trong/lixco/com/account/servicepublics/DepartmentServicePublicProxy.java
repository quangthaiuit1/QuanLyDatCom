package trong.lixco.com.account.servicepublics;

public class DepartmentServicePublicProxy implements trong.lixco.com.account.servicepublics.DepartmentServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.account.servicepublics.DepartmentServicePublic departmentServicePublic = null;
  
  public DepartmentServicePublicProxy() {
    _initDepartmentServicePublicProxy();
  }
  
  public DepartmentServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initDepartmentServicePublicProxy();
  }
  
  private void _initDepartmentServicePublicProxy() {
    try {
      departmentServicePublic = (new trong.lixco.com.account.servicepublics.DepartmentServicePublicServiceLocator()).getDepartmentServicePublicPort();
      if (departmentServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)departmentServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)departmentServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (departmentServicePublic != null)
      ((javax.xml.rpc.Stub)departmentServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.account.servicepublics.DepartmentServicePublic getDepartmentServicePublic() {
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic;
  }
  
  
  public trong.lixco.com.account.servicepublics.Department[] findSearch(java.lang.String arg0, java.lang.String[] arg1) throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.findSearch(arg0, arg1);
  }
  
  public trong.lixco.com.account.servicepublics.Department findByCode(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.findByCode(arg0, arg1);
  }
  
  public trong.lixco.com.account.servicepublics.Department findId(long arg0) throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.findId(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Department[] findAll() throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.findAll();
  }
  
  public boolean delete(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.delete(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Department create(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.create(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Department update(trong.lixco.com.account.servicepublics.Department arg0) throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.update(arg0);
  }
  
  public trong.lixco.com.account.servicepublics.Department[] getAllDepartSubByParent(java.lang.String arg0) throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.getAllDepartSubByParent(arg0);
  }
  
  
}