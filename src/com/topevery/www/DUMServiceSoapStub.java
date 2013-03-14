/**
 * DUMServiceSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class DUMServiceSoapStub extends org.apache.axis.client.Stub implements com.topevery.www.DUMServiceSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[8];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTasks");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.topevery.com/", "para"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.topevery.com/", "WSGetTasksParameter"), com.topevery.www.WSGetTasksParameter.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEventTask"));
        oper.setReturnClass(com.topevery.www.SZCGEventTask.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetTasksResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ProcessSZCGEvent");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.topevery.com/", "para"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.topevery.com/", "WSProcessSZCGEventParameter"), com.topevery.www.WSProcessSZCGEventParameter.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSProcessSZCGEventResult"));
        oper.setReturnClass(com.topevery.www.WSProcessSZCGEventResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.topevery.com/", "ProcessSZCGEventResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RollBackSZCGEvent");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.topevery.com/", "para"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.topevery.com/", "WSRollbackSZCGEventParameter"), com.topevery.www.WSRollbackSZCGEventParameter.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSRollbackSZCGEventResult"));
        oper.setReturnClass(com.topevery.www.WSRollbackSZCGEventResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.topevery.com/", "RollBackSZCGEventResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTimeChangeList");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.topevery.com/", "para"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.topevery.com/", "WSGetTimeChangeListParameter"), com.topevery.www.WSGetTimeChangeListParameter.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSGetTimeChangeListResult"));
        oper.setReturnClass(com.topevery.www.WSGetTimeChangeListResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetTimeChangeListResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ChangeTimeRequest");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.topevery.com/", "para"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeRequestParameter"), com.topevery.www.WSTimeChangeRequestParameter.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeRequestResult"));
        oper.setReturnClass(com.topevery.www.WSTimeChangeRequestResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.topevery.com/", "ChangeTimeRequestResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTimeChangeHistory");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.topevery.com/", "para"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeHistoryParameter"), com.topevery.www.WSTimeChangeHistoryParameter.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeHistoryResult"));
        oper.setReturnClass(com.topevery.www.WSTimeChangeHistoryResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetTimeChangeHistoryResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetMapData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.topevery.com/", "para"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.topevery.com/", "WSParameter"), com.topevery.www.WSParameter.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.topevery.com/", ">>GetMapDataResponse>GetMapDataResult"));
        oper.setReturnClass(com.topevery.www.GetMapDataResponseGetMapDataResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetMapDataResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetBigClassData");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.topevery.com/", "para"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.topevery.com/", "WSParameter"), com.topevery.www.WSParameter.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.topevery.com/", ">>GetBigClassDataResponse>GetBigClassDataResult"));
        oper.setReturnClass(com.topevery.www.GetBigClassDataResponseGetBigClassDataResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetBigClassDataResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

    }

    public DUMServiceSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public DUMServiceSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public DUMServiceSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://microsoft.com/wsdl/types/", "guid");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">>GetBigClassDataResponse>GetBigClassDataResult");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetBigClassDataResponseGetBigClassDataResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">>GetMapDataResponse>GetMapDataResult");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetMapDataResponseGetMapDataResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">ChangeTimeRequest");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.ChangeTimeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">ChangeTimeRequestResponse");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.ChangeTimeRequestResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">GetBigClassData");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetBigClassData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">GetBigClassDataResponse");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetBigClassDataResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">GetMapData");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetMapData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">GetMapDataResponse");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetMapDataResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">GetTimeChangeHistory");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetTimeChangeHistory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">GetTimeChangeHistoryResponse");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetTimeChangeHistoryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">GetTimeChangeList");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetTimeChangeList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">GetTimeChangeListResponse");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.GetTimeChangeListResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">ProcessSZCGEvent");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.ProcessSZCGEvent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">ProcessSZCGEventResponse");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.ProcessSZCGEventResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">RollBackSZCGEvent");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.RollBackSZCGEvent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">RollBackSZCGEventResponse");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.RollBackSZCGEventResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", ">WSTimeChangeHistoryResult>History");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSTimeChangeHistoryResultHistory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "ArrayOfSZCGEvent");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.SZCGEvent[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEvent");
            qName2 = new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEvent");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "ArrayOfSZCGEventFile");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.SZCGEventFile[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEventFile");
            qName2 = new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEventFile");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "ArrayOfWSTimeChange");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSTimeChange[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChange");
            qName2 = new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChange");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEvent");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.SZCGEvent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEventFile");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.SZCGEventFile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEventTask");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.SZCGEventTask.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSGetTasksParameter");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSGetTasksParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSGetTimeChangeListParameter");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSGetTimeChangeListParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSGetTimeChangeListResult");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSGetTimeChangeListResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSParameter");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSProcessSZCGEventParameter");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSProcessSZCGEventParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSProcessSZCGEventResult");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSProcessSZCGEventResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSRetValue");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSRetValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSRollbackSZCGEventParameter");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSRollbackSZCGEventParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSRollbackSZCGEventResult");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSRollbackSZCGEventResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChange");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSTimeChange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeHistoryParameter");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSTimeChangeHistoryParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeHistoryResult");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSTimeChangeHistoryResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeRequestParameter");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSTimeChangeRequestParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.topevery.com/", "WSTimeChangeRequestResult");
            cachedSerQNames.add(qName);
            cls = com.topevery.www.WSTimeChangeRequestResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.topevery.www.SZCGEventTask getTasks(com.topevery.www.WSGetTasksParameter para) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.topevery.com/GetTasks");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetTasks"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {para});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.topevery.www.SZCGEventTask) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.topevery.www.SZCGEventTask) org.apache.axis.utils.JavaUtils.convert(_resp, com.topevery.www.SZCGEventTask.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.topevery.www.WSProcessSZCGEventResult processSZCGEvent(com.topevery.www.WSProcessSZCGEventParameter para) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.topevery.com/ProcessSZCGEvent");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.topevery.com/", "ProcessSZCGEvent"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {para});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.topevery.www.WSProcessSZCGEventResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.topevery.www.WSProcessSZCGEventResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.topevery.www.WSProcessSZCGEventResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.topevery.www.WSRollbackSZCGEventResult rollBackSZCGEvent(com.topevery.www.WSRollbackSZCGEventParameter para) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.topevery.com/RollBackSZCGEvent");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.topevery.com/", "RollBackSZCGEvent"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {para});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.topevery.www.WSRollbackSZCGEventResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.topevery.www.WSRollbackSZCGEventResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.topevery.www.WSRollbackSZCGEventResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.topevery.www.WSGetTimeChangeListResult getTimeChangeList(com.topevery.www.WSGetTimeChangeListParameter para) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.topevery.com/GetTimeChangeList");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetTimeChangeList"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {para});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.topevery.www.WSGetTimeChangeListResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.topevery.www.WSGetTimeChangeListResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.topevery.www.WSGetTimeChangeListResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.topevery.www.WSTimeChangeRequestResult changeTimeRequest(com.topevery.www.WSTimeChangeRequestParameter para) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.topevery.com/ChangeTimeRequest");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.topevery.com/", "ChangeTimeRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {para});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.topevery.www.WSTimeChangeRequestResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.topevery.www.WSTimeChangeRequestResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.topevery.www.WSTimeChangeRequestResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.topevery.www.WSTimeChangeHistoryResult getTimeChangeHistory(com.topevery.www.WSTimeChangeHistoryParameter para) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.topevery.com/GetTimeChangeHistory");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetTimeChangeHistory"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {para});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.topevery.www.WSTimeChangeHistoryResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.topevery.www.WSTimeChangeHistoryResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.topevery.www.WSTimeChangeHistoryResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.topevery.www.GetMapDataResponseGetMapDataResult getMapData(com.topevery.www.WSParameter para) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.topevery.com/GetMapData");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetMapData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {para});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.topevery.www.GetMapDataResponseGetMapDataResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.topevery.www.GetMapDataResponseGetMapDataResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.topevery.www.GetMapDataResponseGetMapDataResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.topevery.www.GetBigClassDataResponseGetBigClassDataResult getBigClassData(com.topevery.www.WSParameter para) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.topevery.com/GetBigClassData");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.topevery.com/", "GetBigClassData"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {para});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.topevery.www.GetBigClassDataResponseGetBigClassDataResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.topevery.www.GetBigClassDataResponseGetBigClassDataResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.topevery.www.GetBigClassDataResponseGetBigClassDataResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
