package trong.lixco.com.servicepublic;

public class PositionJobServicePublicProxy implements trong.lixco.com.servicepublic.PositionJobServicePublic {
  private String _endpoint = null;
  private trong.lixco.com.servicepublic.PositionJobServicePublic positionJobServicePublic = null;
  
  public PositionJobServicePublicProxy() {
    _initPositionJobServicePublicProxy();
  }
  
  public PositionJobServicePublicProxy(String endpoint) {
    _endpoint = endpoint;
    _initPositionJobServicePublicProxy();
  }
  
  private void _initPositionJobServicePublicProxy() {
    try {
      positionJobServicePublic = (new trong.lixco.com.servicepublic.PositionJobServicePublicServiceLocator()).getPositionJobServicePublicPort();
      if (positionJobServicePublic != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)positionJobServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)positionJobServicePublic)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (positionJobServicePublic != null)
      ((javax.xml.rpc.Stub)positionJobServicePublic)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public trong.lixco.com.servicepublic.PositionJobServicePublic getPositionJobServicePublic() {
    if (positionJobServicePublic == null)
      _initPositionJobServicePublicProxy();
    return positionJobServicePublic;
  }
  
  public trong.lixco.com.servicepublic.PositionJobDTO[] findAll() throws java.rmi.RemoteException{
    if (positionJobServicePublic == null)
      _initPositionJobServicePublicProxy();
    return positionJobServicePublic.findAll();
  }
  
  public trong.lixco.com.servicepublic.PositionJobDTO findByCode(java.lang.String arg0) throws java.rmi.RemoteException{
    if (positionJobServicePublic == null)
      _initPositionJobServicePublicProxy();
    return positionJobServicePublic.findByCode(arg0);
  }
  
  public trong.lixco.com.servicepublic.PositionJobDTO[] findDep(java.lang.String arg0) throws java.rmi.RemoteException{
    if (positionJobServicePublic == null)
      _initPositionJobServicePublicProxy();
    return positionJobServicePublic.findDep(arg0);
  }
  
  
}