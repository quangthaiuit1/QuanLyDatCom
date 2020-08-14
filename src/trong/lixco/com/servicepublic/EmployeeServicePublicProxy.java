package trong.lixco.com.servicepublic;

public class EmployeeServicePublicProxy implements trong.lixco.com.servicepublic.EmployeeServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.servicepublic.EmployeeServicePublic employeeServicePublic = null;
  
  public EmployeeServicePublicProxy() {
    _initEmployeeServicePublicProxy();
  }
  
  public EmployeeServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeServicePublicProxy();
  }
  
  private void _initEmployeeServicePublicProxy() {
    try {
      employeeServicePublic = (new trong.lixco.com.servicepublic.EmployeeServicePublicServiceLocator()).getEmployeeServicePublicPort();
      if (employeeServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeServicePublic != null)
      ((javax.xml.rpc.Stub)employeeServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.servicepublic.EmployeeServicePublic getEmployeeServicePublic() {
    if (employeeServicePublic == null)
      _initEmployeeServicePublicProxy();
    return employeeServicePublic;
  }
  
  public trong.lixco.com.servicepublic.EmployeeDTO[] findByDep(java.lang.String[] arg0) throws java.rmi.RemoteException{
    if (employeeServicePublic == null)
      _initEmployeeServicePublicProxy();
    return employeeServicePublic.findByDep(arg0);
  }
  
  public trong.lixco.com.servicepublic.EmployeeDTO findByCode(java.lang.String arg0) throws java.rmi.RemoteException{
    if (employeeServicePublic == null)
      _initEmployeeServicePublicProxy();
    return employeeServicePublic.findByCode(arg0);
  }
  
  public void updateEmail(long arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (employeeServicePublic == null)
      _initEmployeeServicePublicProxy();
    employeeServicePublic.updateEmail(arg0, arg1);
  }
  
  public trong.lixco.com.servicepublic.EmployeeDTO[] findAll() throws java.rmi.RemoteException{
    if (employeeServicePublic == null)
      _initEmployeeServicePublicProxy();
    return employeeServicePublic.findAll();
  }
  
  public trong.lixco.com.servicepublic.EmployeeDTO findByCodeOld(java.lang.String arg0, java.lang.String[] arg1) throws java.rmi.RemoteException{
    if (employeeServicePublic == null)
      _initEmployeeServicePublicProxy();
    return employeeServicePublic.findByCodeOld(arg0, arg1);
  }
  
  public trong.lixco.com.servicepublic.EmployeeDTO[] findByAllDepart() throws java.rmi.RemoteException{
    if (employeeServicePublic == null)
      _initEmployeeServicePublicProxy();
    return employeeServicePublic.findByAllDepart();
  }
  
  
}