package trong.lixco.com.servicepublic;

public class DepartmentServicePublicProxy implements trong.lixco.com.servicepublic.DepartmentServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.servicepublic.DepartmentServicePublic departmentServicePublic = null;
  
  public DepartmentServicePublicProxy() {
    _initDepartmentServicePublicProxy();
  }
  
  public DepartmentServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initDepartmentServicePublicProxy();
  }
  
  private void _initDepartmentServicePublicProxy() {
    try {
      departmentServicePublic = (new trong.lixco.com.servicepublic.DepartmentServicePublicServiceLocator()).getDepartmentServicePublicPort();
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
  
  public trong.lixco.com.servicepublic.DepartmentServicePublic getDepartmentServicePublic() {
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic;
  }
  
  public trong.lixco.com.servicepublic.DepartmentDTO[] findAll() throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.findAll();
  }
  
  public trong.lixco.com.servicepublic.DepartmentDTO[] findAllSubDepart(java.lang.String arg0) throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.findAllSubDepart(arg0);
  }
  
  public trong.lixco.com.servicepublic.DepartmentDTO[] findBranch(java.lang.String arg0) throws java.rmi.RemoteException{
    if (departmentServicePublic == null)
      _initDepartmentServicePublicProxy();
    return departmentServicePublic.findBranch(arg0);
  }
  
  
}