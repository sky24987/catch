/**
 * SZCGEvent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.topevery.www;

public class SZCGEvent  implements java.io.Serializable {
    private java.lang.String eventId;

    private java.lang.String activityInstanceId;

    private java.lang.String title;

    private java.lang.String typeName;

    private java.lang.String bigClassName;

    private java.lang.String smallClassName;

    private java.lang.String districtName;

    private java.lang.String streetName;

    private java.lang.String communityName;

    private java.lang.String address;

    private java.lang.String desc;

    private java.lang.String srcName;

    private java.lang.String taskDate;

    private int taskDurationMinutes;

    private java.lang.String taskOpinion;

    private com.topevery.www.SZCGEventFile[] files;

    private java.lang.String absX;

    private java.lang.String absY;

    private java.lang.String partCode;

    private java.lang.String typeId;

    private java.lang.String bigClassId;

    private java.lang.String smallClassId;

    private java.lang.String districtId;

    private java.lang.String streetId;

    private java.lang.String communityId;

    private java.lang.String reporter;

    private java.lang.String replyWay;

    private java.lang.String obName;

    private java.lang.String obPhone;

    public SZCGEvent() {
    }

    public SZCGEvent(
           java.lang.String eventId,
           java.lang.String activityInstanceId,
           java.lang.String title,
           java.lang.String typeName,
           java.lang.String bigClassName,
           java.lang.String smallClassName,
           java.lang.String districtName,
           java.lang.String streetName,
           java.lang.String communityName,
           java.lang.String address,
           java.lang.String desc,
           java.lang.String srcName,
           java.lang.String taskDate,
           int taskDurationMinutes,
           java.lang.String taskOpinion,
           com.topevery.www.SZCGEventFile[] files,
           java.lang.String absX,
           java.lang.String absY,
           java.lang.String partCode,
           java.lang.String typeId,
           java.lang.String bigClassId,
           java.lang.String smallClassId,
           java.lang.String districtId,
           java.lang.String streetId,
           java.lang.String communityId,
           java.lang.String reporter,
           java.lang.String replyWay,
           java.lang.String obName,
           java.lang.String obPhone) {
           this.eventId = eventId;
           this.activityInstanceId = activityInstanceId;
           this.title = title;
           this.typeName = typeName;
           this.bigClassName = bigClassName;
           this.smallClassName = smallClassName;
           this.districtName = districtName;
           this.streetName = streetName;
           this.communityName = communityName;
           this.address = address;
           this.desc = desc;
           this.srcName = srcName;
           this.taskDate = taskDate;
           this.taskDurationMinutes = taskDurationMinutes;
           this.taskOpinion = taskOpinion;
           this.files = files;
           this.absX = absX;
           this.absY = absY;
           this.partCode = partCode;
           this.typeId = typeId;
           this.bigClassId = bigClassId;
           this.smallClassId = smallClassId;
           this.districtId = districtId;
           this.streetId = streetId;
           this.communityId = communityId;
           this.reporter = reporter;
           this.replyWay = replyWay;
           this.obName = obName;
           this.obPhone = obPhone;
    }


    /**
     * Gets the eventId value for this SZCGEvent.
     * 
     * @return eventId
     */
    public java.lang.String getEventId() {
        return eventId;
    }


    /**
     * Sets the eventId value for this SZCGEvent.
     * 
     * @param eventId
     */
    public void setEventId(java.lang.String eventId) {
        this.eventId = eventId;
    }


    /**
     * Gets the activityInstanceId value for this SZCGEvent.
     * 
     * @return activityInstanceId
     */
    public java.lang.String getActivityInstanceId() {
        return activityInstanceId;
    }


    /**
     * Sets the activityInstanceId value for this SZCGEvent.
     * 
     * @param activityInstanceId
     */
    public void setActivityInstanceId(java.lang.String activityInstanceId) {
        this.activityInstanceId = activityInstanceId;
    }


    /**
     * Gets the title value for this SZCGEvent.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return title;
    }


    /**
     * Sets the title value for this SZCGEvent.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }


    /**
     * Gets the typeName value for this SZCGEvent.
     * 
     * @return typeName
     */
    public java.lang.String getTypeName() {
        return typeName;
    }


    /**
     * Sets the typeName value for this SZCGEvent.
     * 
     * @param typeName
     */
    public void setTypeName(java.lang.String typeName) {
        this.typeName = typeName;
    }


    /**
     * Gets the bigClassName value for this SZCGEvent.
     * 
     * @return bigClassName
     */
    public java.lang.String getBigClassName() {
        return bigClassName;
    }


    /**
     * Sets the bigClassName value for this SZCGEvent.
     * 
     * @param bigClassName
     */
    public void setBigClassName(java.lang.String bigClassName) {
        this.bigClassName = bigClassName;
    }


    /**
     * Gets the smallClassName value for this SZCGEvent.
     * 
     * @return smallClassName
     */
    public java.lang.String getSmallClassName() {
        return smallClassName;
    }


    /**
     * Sets the smallClassName value for this SZCGEvent.
     * 
     * @param smallClassName
     */
    public void setSmallClassName(java.lang.String smallClassName) {
        this.smallClassName = smallClassName;
    }


    /**
     * Gets the districtName value for this SZCGEvent.
     * 
     * @return districtName
     */
    public java.lang.String getDistrictName() {
        return districtName;
    }


    /**
     * Sets the districtName value for this SZCGEvent.
     * 
     * @param districtName
     */
    public void setDistrictName(java.lang.String districtName) {
        this.districtName = districtName;
    }


    /**
     * Gets the streetName value for this SZCGEvent.
     * 
     * @return streetName
     */
    public java.lang.String getStreetName() {
        return streetName;
    }


    /**
     * Sets the streetName value for this SZCGEvent.
     * 
     * @param streetName
     */
    public void setStreetName(java.lang.String streetName) {
        this.streetName = streetName;
    }


    /**
     * Gets the communityName value for this SZCGEvent.
     * 
     * @return communityName
     */
    public java.lang.String getCommunityName() {
        return communityName;
    }


    /**
     * Sets the communityName value for this SZCGEvent.
     * 
     * @param communityName
     */
    public void setCommunityName(java.lang.String communityName) {
        this.communityName = communityName;
    }


    /**
     * Gets the address value for this SZCGEvent.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this SZCGEvent.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the desc value for this SZCGEvent.
     * 
     * @return desc
     */
    public java.lang.String getDesc() {
        return desc;
    }


    /**
     * Sets the desc value for this SZCGEvent.
     * 
     * @param desc
     */
    public void setDesc(java.lang.String desc) {
        this.desc = desc;
    }


    /**
     * Gets the srcName value for this SZCGEvent.
     * 
     * @return srcName
     */
    public java.lang.String getSrcName() {
        return srcName;
    }


    /**
     * Sets the srcName value for this SZCGEvent.
     * 
     * @param srcName
     */
    public void setSrcName(java.lang.String srcName) {
        this.srcName = srcName;
    }


    /**
     * Gets the taskDate value for this SZCGEvent.
     * 
     * @return taskDate
     */
    public java.lang.String getTaskDate() {
        return taskDate;
    }


    /**
     * Sets the taskDate value for this SZCGEvent.
     * 
     * @param taskDate
     */
    public void setTaskDate(java.lang.String taskDate) {
        this.taskDate = taskDate;
    }


    /**
     * Gets the taskDurationMinutes value for this SZCGEvent.
     * 
     * @return taskDurationMinutes
     */
    public int getTaskDurationMinutes() {
        return taskDurationMinutes;
    }


    /**
     * Sets the taskDurationMinutes value for this SZCGEvent.
     * 
     * @param taskDurationMinutes
     */
    public void setTaskDurationMinutes(int taskDurationMinutes) {
        this.taskDurationMinutes = taskDurationMinutes;
    }


    /**
     * Gets the taskOpinion value for this SZCGEvent.
     * 
     * @return taskOpinion
     */
    public java.lang.String getTaskOpinion() {
        return taskOpinion;
    }


    /**
     * Sets the taskOpinion value for this SZCGEvent.
     * 
     * @param taskOpinion
     */
    public void setTaskOpinion(java.lang.String taskOpinion) {
        this.taskOpinion = taskOpinion;
    }


    /**
     * Gets the files value for this SZCGEvent.
     * 
     * @return files
     */
    public com.topevery.www.SZCGEventFile[] getFiles() {
        return files;
    }


    /**
     * Sets the files value for this SZCGEvent.
     * 
     * @param files
     */
    public void setFiles(com.topevery.www.SZCGEventFile[] files) {
        this.files = files;
    }


    /**
     * Gets the absX value for this SZCGEvent.
     * 
     * @return absX
     */
    public java.lang.String getAbsX() {
        return absX;
    }


    /**
     * Sets the absX value for this SZCGEvent.
     * 
     * @param absX
     */
    public void setAbsX(java.lang.String absX) {
        this.absX = absX;
    }


    /**
     * Gets the absY value for this SZCGEvent.
     * 
     * @return absY
     */
    public java.lang.String getAbsY() {
        return absY;
    }


    /**
     * Sets the absY value for this SZCGEvent.
     * 
     * @param absY
     */
    public void setAbsY(java.lang.String absY) {
        this.absY = absY;
    }


    /**
     * Gets the partCode value for this SZCGEvent.
     * 
     * @return partCode
     */
    public java.lang.String getPartCode() {
        return partCode;
    }


    /**
     * Sets the partCode value for this SZCGEvent.
     * 
     * @param partCode
     */
    public void setPartCode(java.lang.String partCode) {
        this.partCode = partCode;
    }


    /**
     * Gets the typeId value for this SZCGEvent.
     * 
     * @return typeId
     */
    public java.lang.String getTypeId() {
        return typeId;
    }


    /**
     * Sets the typeId value for this SZCGEvent.
     * 
     * @param typeId
     */
    public void setTypeId(java.lang.String typeId) {
        this.typeId = typeId;
    }


    /**
     * Gets the bigClassId value for this SZCGEvent.
     * 
     * @return bigClassId
     */
    public java.lang.String getBigClassId() {
        return bigClassId;
    }


    /**
     * Sets the bigClassId value for this SZCGEvent.
     * 
     * @param bigClassId
     */
    public void setBigClassId(java.lang.String bigClassId) {
        this.bigClassId = bigClassId;
    }


    /**
     * Gets the smallClassId value for this SZCGEvent.
     * 
     * @return smallClassId
     */
    public java.lang.String getSmallClassId() {
        return smallClassId;
    }


    /**
     * Sets the smallClassId value for this SZCGEvent.
     * 
     * @param smallClassId
     */
    public void setSmallClassId(java.lang.String smallClassId) {
        this.smallClassId = smallClassId;
    }


    /**
     * Gets the districtId value for this SZCGEvent.
     * 
     * @return districtId
     */
    public java.lang.String getDistrictId() {
        return districtId;
    }


    /**
     * Sets the districtId value for this SZCGEvent.
     * 
     * @param districtId
     */
    public void setDistrictId(java.lang.String districtId) {
        this.districtId = districtId;
    }


    /**
     * Gets the streetId value for this SZCGEvent.
     * 
     * @return streetId
     */
    public java.lang.String getStreetId() {
        return streetId;
    }


    /**
     * Sets the streetId value for this SZCGEvent.
     * 
     * @param streetId
     */
    public void setStreetId(java.lang.String streetId) {
        this.streetId = streetId;
    }


    /**
     * Gets the communityId value for this SZCGEvent.
     * 
     * @return communityId
     */
    public java.lang.String getCommunityId() {
        return communityId;
    }


    /**
     * Sets the communityId value for this SZCGEvent.
     * 
     * @param communityId
     */
    public void setCommunityId(java.lang.String communityId) {
        this.communityId = communityId;
    }


    /**
     * Gets the reporter value for this SZCGEvent.
     * 
     * @return reporter
     */
    public java.lang.String getReporter() {
        return reporter;
    }


    /**
     * Sets the reporter value for this SZCGEvent.
     * 
     * @param reporter
     */
    public void setReporter(java.lang.String reporter) {
        this.reporter = reporter;
    }


    /**
     * Gets the replyWay value for this SZCGEvent.
     * 
     * @return replyWay
     */
    public java.lang.String getReplyWay() {
        return replyWay;
    }


    /**
     * Sets the replyWay value for this SZCGEvent.
     * 
     * @param replyWay
     */
    public void setReplyWay(java.lang.String replyWay) {
        this.replyWay = replyWay;
    }


    /**
     * Gets the obName value for this SZCGEvent.
     * 
     * @return obName
     */
    public java.lang.String getObName() {
        return obName;
    }


    /**
     * Sets the obName value for this SZCGEvent.
     * 
     * @param obName
     */
    public void setObName(java.lang.String obName) {
        this.obName = obName;
    }


    /**
     * Gets the obPhone value for this SZCGEvent.
     * 
     * @return obPhone
     */
    public java.lang.String getObPhone() {
        return obPhone;
    }


    /**
     * Sets the obPhone value for this SZCGEvent.
     * 
     * @param obPhone
     */
    public void setObPhone(java.lang.String obPhone) {
        this.obPhone = obPhone;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SZCGEvent)) return false;
        SZCGEvent other = (SZCGEvent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.eventId==null && other.getEventId()==null) || 
             (this.eventId!=null &&
              this.eventId.equals(other.getEventId()))) &&
            ((this.activityInstanceId==null && other.getActivityInstanceId()==null) || 
             (this.activityInstanceId!=null &&
              this.activityInstanceId.equals(other.getActivityInstanceId()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle()))) &&
            ((this.typeName==null && other.getTypeName()==null) || 
             (this.typeName!=null &&
              this.typeName.equals(other.getTypeName()))) &&
            ((this.bigClassName==null && other.getBigClassName()==null) || 
             (this.bigClassName!=null &&
              this.bigClassName.equals(other.getBigClassName()))) &&
            ((this.smallClassName==null && other.getSmallClassName()==null) || 
             (this.smallClassName!=null &&
              this.smallClassName.equals(other.getSmallClassName()))) &&
            ((this.districtName==null && other.getDistrictName()==null) || 
             (this.districtName!=null &&
              this.districtName.equals(other.getDistrictName()))) &&
            ((this.streetName==null && other.getStreetName()==null) || 
             (this.streetName!=null &&
              this.streetName.equals(other.getStreetName()))) &&
            ((this.communityName==null && other.getCommunityName()==null) || 
             (this.communityName!=null &&
              this.communityName.equals(other.getCommunityName()))) &&
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.desc==null && other.getDesc()==null) || 
             (this.desc!=null &&
              this.desc.equals(other.getDesc()))) &&
            ((this.srcName==null && other.getSrcName()==null) || 
             (this.srcName!=null &&
              this.srcName.equals(other.getSrcName()))) &&
            ((this.taskDate==null && other.getTaskDate()==null) || 
             (this.taskDate!=null &&
              this.taskDate.equals(other.getTaskDate()))) &&
            this.taskDurationMinutes == other.getTaskDurationMinutes() &&
            ((this.taskOpinion==null && other.getTaskOpinion()==null) || 
             (this.taskOpinion!=null &&
              this.taskOpinion.equals(other.getTaskOpinion()))) &&
            ((this.files==null && other.getFiles()==null) || 
             (this.files!=null &&
              java.util.Arrays.equals(this.files, other.getFiles()))) &&
            ((this.absX==null && other.getAbsX()==null) || 
             (this.absX!=null &&
              this.absX.equals(other.getAbsX()))) &&
            ((this.absY==null && other.getAbsY()==null) || 
             (this.absY!=null &&
              this.absY.equals(other.getAbsY()))) &&
            ((this.partCode==null && other.getPartCode()==null) || 
             (this.partCode!=null &&
              this.partCode.equals(other.getPartCode()))) &&
            ((this.typeId==null && other.getTypeId()==null) || 
             (this.typeId!=null &&
              this.typeId.equals(other.getTypeId()))) &&
            ((this.bigClassId==null && other.getBigClassId()==null) || 
             (this.bigClassId!=null &&
              this.bigClassId.equals(other.getBigClassId()))) &&
            ((this.smallClassId==null && other.getSmallClassId()==null) || 
             (this.smallClassId!=null &&
              this.smallClassId.equals(other.getSmallClassId()))) &&
            ((this.districtId==null && other.getDistrictId()==null) || 
             (this.districtId!=null &&
              this.districtId.equals(other.getDistrictId()))) &&
            ((this.streetId==null && other.getStreetId()==null) || 
             (this.streetId!=null &&
              this.streetId.equals(other.getStreetId()))) &&
            ((this.communityId==null && other.getCommunityId()==null) || 
             (this.communityId!=null &&
              this.communityId.equals(other.getCommunityId()))) &&
            ((this.reporter==null && other.getReporter()==null) || 
             (this.reporter!=null &&
              this.reporter.equals(other.getReporter()))) &&
            ((this.replyWay==null && other.getReplyWay()==null) || 
             (this.replyWay!=null &&
              this.replyWay.equals(other.getReplyWay()))) &&
            ((this.obName==null && other.getObName()==null) || 
             (this.obName!=null &&
              this.obName.equals(other.getObName()))) &&
            ((this.obPhone==null && other.getObPhone()==null) || 
             (this.obPhone!=null &&
              this.obPhone.equals(other.getObPhone())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getEventId() != null) {
            _hashCode += getEventId().hashCode();
        }
        if (getActivityInstanceId() != null) {
            _hashCode += getActivityInstanceId().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        if (getTypeName() != null) {
            _hashCode += getTypeName().hashCode();
        }
        if (getBigClassName() != null) {
            _hashCode += getBigClassName().hashCode();
        }
        if (getSmallClassName() != null) {
            _hashCode += getSmallClassName().hashCode();
        }
        if (getDistrictName() != null) {
            _hashCode += getDistrictName().hashCode();
        }
        if (getStreetName() != null) {
            _hashCode += getStreetName().hashCode();
        }
        if (getCommunityName() != null) {
            _hashCode += getCommunityName().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getDesc() != null) {
            _hashCode += getDesc().hashCode();
        }
        if (getSrcName() != null) {
            _hashCode += getSrcName().hashCode();
        }
        if (getTaskDate() != null) {
            _hashCode += getTaskDate().hashCode();
        }
        _hashCode += getTaskDurationMinutes();
        if (getTaskOpinion() != null) {
            _hashCode += getTaskOpinion().hashCode();
        }
        if (getFiles() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFiles());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFiles(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getAbsX() != null) {
            _hashCode += getAbsX().hashCode();
        }
        if (getAbsY() != null) {
            _hashCode += getAbsY().hashCode();
        }
        if (getPartCode() != null) {
            _hashCode += getPartCode().hashCode();
        }
        if (getTypeId() != null) {
            _hashCode += getTypeId().hashCode();
        }
        if (getBigClassId() != null) {
            _hashCode += getBigClassId().hashCode();
        }
        if (getSmallClassId() != null) {
            _hashCode += getSmallClassId().hashCode();
        }
        if (getDistrictId() != null) {
            _hashCode += getDistrictId().hashCode();
        }
        if (getStreetId() != null) {
            _hashCode += getStreetId().hashCode();
        }
        if (getCommunityId() != null) {
            _hashCode += getCommunityId().hashCode();
        }
        if (getReporter() != null) {
            _hashCode += getReporter().hashCode();
        }
        if (getReplyWay() != null) {
            _hashCode += getReplyWay().hashCode();
        }
        if (getObName() != null) {
            _hashCode += getObName().hashCode();
        }
        if (getObPhone() != null) {
            _hashCode += getObPhone().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SZCGEvent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEvent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eventId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "EventId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("activityInstanceId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "ActivityInstanceId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "Title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "TypeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bigClassName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "BigClassName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smallClassName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "SmallClassName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("districtName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "DistrictName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("streetName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "StreetName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("communityName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "CommunityName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desc");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "Desc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("srcName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "SrcName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "TaskDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskDurationMinutes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "TaskDurationMinutes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskOpinion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "TaskOpinion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("files");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "Files"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEventFile"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.topevery.com/", "SZCGEventFile"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("absX");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "AbsX"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("absY");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "AbsY"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "PartCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typeId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "TypeId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bigClassId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "BigClassId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smallClassId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "SmallClassId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("districtId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "DistrictId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("streetId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "StreetId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("communityId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "CommunityId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reporter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "Reporter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("replyWay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "ReplyWay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "ObName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.topevery.com/", "ObPhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
