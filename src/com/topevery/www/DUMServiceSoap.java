/**
 * DUMServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public interface DUMServiceSoap extends java.rmi.Remote {
    public com.topevery.www.SZCGEventTask getTasks(com.topevery.www.WSGetTasksParameter para) throws java.rmi.RemoteException;
    public com.topevery.www.WSProcessSZCGEventResult processSZCGEvent(com.topevery.www.WSProcessSZCGEventParameter para) throws java.rmi.RemoteException;
    public com.topevery.www.WSRollbackSZCGEventResult rollBackSZCGEvent(com.topevery.www.WSRollbackSZCGEventParameter para) throws java.rmi.RemoteException;
    public com.topevery.www.WSGetTimeChangeListResult getTimeChangeList(com.topevery.www.WSGetTimeChangeListParameter para) throws java.rmi.RemoteException;
    public com.topevery.www.WSTimeChangeRequestResult changeTimeRequest(com.topevery.www.WSTimeChangeRequestParameter para) throws java.rmi.RemoteException;
    public com.topevery.www.WSTimeChangeHistoryResult getTimeChangeHistory(com.topevery.www.WSTimeChangeHistoryParameter para) throws java.rmi.RemoteException;
    public com.topevery.www.GetMapDataResponseGetMapDataResult getMapData(com.topevery.www.WSParameter para) throws java.rmi.RemoteException;
    public com.topevery.www.GetBigClassDataResponseGetBigClassDataResult getBigClassData(com.topevery.www.WSParameter para) throws java.rmi.RemoteException;
}
