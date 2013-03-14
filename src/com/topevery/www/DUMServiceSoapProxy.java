package com.topevery.www;

public class DUMServiceSoapProxy implements com.topevery.www.DUMServiceSoap {
  private String _endpoint = null;
  private com.topevery.www.DUMServiceSoap dUMServiceSoap = null;
  
  public DUMServiceSoapProxy() {
    _initDUMServiceSoapProxy();
  }
  
  public DUMServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initDUMServiceSoapProxy();
  }
  
  private void _initDUMServiceSoapProxy() {
    try {
      dUMServiceSoap = (new com.topevery.www.DUMServiceLocator()).getDUMServiceSoap();
      if (dUMServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dUMServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dUMServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dUMServiceSoap != null)
      ((javax.xml.rpc.Stub)dUMServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.topevery.www.DUMServiceSoap getDUMServiceSoap() {
    if (dUMServiceSoap == null)
      _initDUMServiceSoapProxy();
    return dUMServiceSoap;
  }
  
  public com.topevery.www.SZCGEventTask getTasks(com.topevery.www.WSGetTasksParameter para) throws java.rmi.RemoteException{
    if (dUMServiceSoap == null)
      _initDUMServiceSoapProxy();
    return dUMServiceSoap.getTasks(para);
  }
  
  public com.topevery.www.WSProcessSZCGEventResult processSZCGEvent(com.topevery.www.WSProcessSZCGEventParameter para) throws java.rmi.RemoteException{
    if (dUMServiceSoap == null)
      _initDUMServiceSoapProxy();
    return dUMServiceSoap.processSZCGEvent(para);
  }
  
  public com.topevery.www.WSRollbackSZCGEventResult rollBackSZCGEvent(com.topevery.www.WSRollbackSZCGEventParameter para) throws java.rmi.RemoteException{
    if (dUMServiceSoap == null)
      _initDUMServiceSoapProxy();
    return dUMServiceSoap.rollBackSZCGEvent(para);
  }
  
  public com.topevery.www.WSGetTimeChangeListResult getTimeChangeList(com.topevery.www.WSGetTimeChangeListParameter para) throws java.rmi.RemoteException{
    if (dUMServiceSoap == null)
      _initDUMServiceSoapProxy();
    return dUMServiceSoap.getTimeChangeList(para);
  }
  
  public com.topevery.www.WSTimeChangeRequestResult changeTimeRequest(com.topevery.www.WSTimeChangeRequestParameter para) throws java.rmi.RemoteException{
    if (dUMServiceSoap == null)
      _initDUMServiceSoapProxy();
    return dUMServiceSoap.changeTimeRequest(para);
  }
  
  public com.topevery.www.WSTimeChangeHistoryResult getTimeChangeHistory(com.topevery.www.WSTimeChangeHistoryParameter para) throws java.rmi.RemoteException{
    if (dUMServiceSoap == null)
      _initDUMServiceSoapProxy();
    return dUMServiceSoap.getTimeChangeHistory(para);
  }
  
  public com.topevery.www.GetMapDataResponseGetMapDataResult getMapData(com.topevery.www.WSParameter para) throws java.rmi.RemoteException{
    if (dUMServiceSoap == null)
      _initDUMServiceSoapProxy();
    return dUMServiceSoap.getMapData(para);
  }
  
  public com.topevery.www.GetBigClassDataResponseGetBigClassDataResult getBigClassData(com.topevery.www.WSParameter para) throws java.rmi.RemoteException{
    if (dUMServiceSoap == null)
      _initDUMServiceSoapProxy();
    return dUMServiceSoap.getBigClassData(para);
  }
  
  
}