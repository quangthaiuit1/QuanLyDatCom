package trong.lixco.com.servicepublic;

public class EmpPJobServicePublicProxy implements trong.lixco.com.servicepublic.EmpPJobServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.servicepublic.EmpPJobServicePublic empPJobServicePublic = null;
  
  public EmpPJobServicePublicProxy() {
    _initEmpPJobServicePublicProxy();
  }
  
  public EmpPJobServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmpPJobServicePublicProxy();
  }
  
  private void _initEmpPJobServicePublicProxy() {
    try {
      empPJobServicePublic = (new trong.lixco.com.servicepublic.EmpPJobServicePublicServiceLocator()).getEmpPJobServicePublicPort();
      if (empPJobServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)empPJobServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)empPJobServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (empPJobServicePublic != null)
      ((javax.xml.rpc.Stub)empPJobServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.servicepublic.EmpPJobServicePublic getEmpPJobServicePublic() {
    if (empPJobServicePublic == null)
      _initEmpPJobServicePublicProxy();
    return empPJobServicePublic;
  }
  
  public trong.lixco.com.servicepublic.EmpPJobDTO[] findAll() throws java.rmi.RemoteException{
    if (empPJobServicePublic == null)
      _initEmpPJobServicePublicProxy();
    return empPJobServicePublic.findAll();
  }
  
  public trong.lixco.com.servicepublic.EmpPJobDTO[] findByCodeEmp(java.lang.String arg0) throws java.rmi.RemoteException{
    if (empPJobServicePublic == null)
      _initEmpPJobServicePublicProxy();
    return empPJobServicePublic.findByCodeEmp(arg0);
  }
  
  public trong.lixco.com.servicepublic.EmpPJobDTO[] findByCodecodePJob(java.lang.String arg0) throws java.rmi.RemoteException{
    if (empPJobServicePublic == null)
      _initEmpPJobServicePublicProxy();
    return empPJobServicePublic.findByCodecodePJob(arg0);
  }
  
  
}