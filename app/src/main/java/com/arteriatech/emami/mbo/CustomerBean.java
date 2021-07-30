package com.arteriatech.emami.mbo;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class CustomerBean implements Parcelable {
    private String customerId;
    private String customerName;
    private String street;
    private String city = "";
    private String country;
    private String website;
    private String editResourceURL;
    private String MobileNumber = "";
    private String MailId = "";
    private double latVal = 0.0;
    private double longVal = 0.0;
    private String Etag = "";
    private String SetResourcePath = "";
    private String gstin = "";
    private String CustomerNo = "";

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }

    public boolean isDealer() {
        return isDealer;
    }

    public void setDealer(boolean dealer) {
        isDealer = dealer;
    }

    private boolean isDealer = false;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email = "";

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getSeqNo() {
        return SeqNo;
    }

    public void setSeqNo(String seqNo) {
        SeqNo = seqNo;
    }

    private String SeqNo = "";

    public String getTimeTaken() {
        return TimeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        TimeTaken = timeTaken;
    }

    private String TimeTaken = "";

    public String getRschGuid() {
        return RschGuid;
    }

    public void setRschGuid(String rschGuid) {
        RschGuid = rschGuid;
    }

    private String RschGuid = "";
    private String RschGuid32 = "";

    public String getRschGuid32() {
        return RschGuid32;
    }

    public void setRschGuid32(String rschGuid32) {
        RschGuid32 = rschGuid32;
    }


    public String getRoutSchScope() {
        return RoutSchScope;
    }

    public void setRoutSchScope(String routSchScope) {
        RoutSchScope = routSchScope;
    }

    private String RoutSchScope = "";
    public static int SELECTED__SPINNER_INDEX = 0;

    public String getRouteGuid32() {
        return RouteGuid32;
    }

    public void setRouteGuid32(String routeGuid32) {
        RouteGuid32 = routeGuid32;
    }

    public String getRouteGuid36() {
        return RouteGuid36;
    }

    public void setRouteGuid36(String routeGuid36) {
        RouteGuid36 = routeGuid36;
    }

    private String RouteGuid32 = "";
    private String RouteGuid36 = "";

    private String DayOfWeek = "";
    private String DayOfMonth = "";

    public String getDayOfMonth() {
        return DayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        DayOfMonth = dayOfMonth;
    }

    public String getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }


    private String VisitType = "";

    public String getVisitType() {
        return VisitType;
    }

    public void setVisitType(String visitType) {
        VisitType = visitType;
    }

    public String getMtdValue() {
        return MtdValue;
    }

    public void setMtdValue(String mtdValue) {
        MtdValue = mtdValue;
    }

    private String MtdValue = "";

    //new 28112016
    private String CPTypeDesc = "";
    String RetailerCatDesc = "";
    private String UID = "";

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getCPTypeDesc() {
        return CPTypeDesc;
    }

    public void setCPTypeDesc(String CPTypeDesc) {
        this.CPTypeDesc = CPTypeDesc;
    }

    public String getRetailerCatDesc() {
        return RetailerCatDesc;
    }

    public void setRetailerCatDesc(String retailerCatDesc) {
        RetailerCatDesc = retailerCatDesc;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    private String landMark = "";

    public boolean isAddressEnabled() {
        return isAddressEnabled;
    }

    public void setIsAddressEnabled(boolean isAddressEnabled) {
        this.isAddressEnabled = isAddressEnabled;
    }

    private boolean isAddressEnabled = false;

    public String getSetResourcePath() {
        return SetResourcePath;
    }

    public void setSetResourcePath(String setResourcePath) {
        SetResourcePath = setResourcePath;
    }

    public String getEtag() {
        return Etag;
    }

    public void setEtag(String etag) {
        Etag = etag;
    }


    public double getLongVal() {
        return longVal;
    }

    public void setLongVal(double longVal) {
        this.longVal = longVal;
    }

    public double getLatVal() {
        return latVal;
    }

    public void setLatVal(double latVal) {
        this.latVal = latVal;
    }


    public String getRoutePlanKey() {
        return RoutePlanKey;
    }

    public void setRoutePlanKey(String routePlanKey) {
        RoutePlanKey = routePlanKey;
    }

    private String RoutePlanKey = "";


    public String getRouteID() {
        return RouteID;
    }

    public void setRouteID(String routeID) {
        RouteID = routeID;
    }

    public String getRouteDesc() {
        return RouteDesc;
    }

    public void setRouteDesc(String routeDesc) {
        RouteDesc = routeDesc;
    }

    private String RouteID = "";
    private String RouteDesc = "";


    public String getRouteHeading() {
        return RouteHeading;
    }

    public void setRouteHeading(String routeHeading) {
        RouteHeading = routeHeading;
    }

    private String RouteHeading = "";


    private String CustDOB = "";
    private String Anniversary = "";
    private String SpouseDOB = "";
    private String Child1DOB = "";
    private String Child2DOB = "";
    private String Child3DOB = "";
    private String Child1Name = "";
    private String Child2Name = "";
    private String Child3Name = "";

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    private String OwnerName = "";

    public String getCpGuidStringFormat() {
        return CpGuidStringFormat;
    }

    public void setCpGuidStringFormat(String cpGuidStringFormat) {
        CpGuidStringFormat = cpGuidStringFormat;
    }

    private String CpGuidStringFormat = "";

    public String getCPNo() {
        return CPNo;
    }

    public void setCPNo(String CPNo) {
        this.CPNo = CPNo;
    }

    public String getRetailerName() {
        return RetailerName;
    }

    public void setRetailerName(String retailerName) {
        RetailerName = retailerName;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getAddress3() {
        return Address3;
    }

    public void setAddress3(String address3) {
        Address3 = address3;
    }

    public String getAddress4() {
        return Address4;
    }

    public void setAddress4(String address4) {
        Address4 = address4;
    }

    public String getTownDesc() {
        return TownDesc;
    }

    public void setTownDesc(String townDesc) {
        TownDesc = townDesc;
    }

    public String getParentID() {
        return ParentID;
    }

    public void setParentID(String parentID) {
        ParentID = parentID;
    }

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String parentName) {
        ParentName = parentName;
    }

    private String CPNo = "";
    private String RetailerName = "";

    public String getCPGUID() {
        return CPGUID;
    }

    public void setCPGUID(String CPGUID) {
        this.CPGUID = CPGUID;
    }

    private String CPGUID = "";


    private String Address1 = "";
    private String Address2 = "";
    private String Address3 = "";
    private String Address4 = "";
    private String TownDesc = "";
    private String ParentID = "";
    private String ParentName = "";


    public String getDistrictDesc() {
        return DistrictDesc;
    }

    public void setDistrictDesc(String districtDesc) {
        DistrictDesc = districtDesc;
    }

    private String DistrictDesc = "";


    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String postalCode = "";

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getMailId() {
        return MailId;
    }

    public void setMailId(String mailId) {
        MailId = mailId;
    }

    public String getCustDOB() {
        return CustDOB;
    }

    public void setCustDOB(String custDOB) {
        CustDOB = custDOB;
    }

    public String getAnniversary() {
        return Anniversary;
    }

    public void setAnniversary(String anniversary) {
        Anniversary = anniversary;
    }

    public String getSpouseDOB() {
        return SpouseDOB;
    }

    public void setSpouseDOB(String spouseDOB) {
        SpouseDOB = spouseDOB;
    }

    public String getChild1DOB() {
        return Child1DOB;
    }

    public void setChild1DOB(String child1dob) {
        Child1DOB = child1dob;
    }

    public String getChild2DOB() {
        return Child2DOB;
    }

    public void setChild2DOB(String child2dob) {
        Child2DOB = child2dob;
    }

    public String getChild3DOB() {
        return Child3DOB;
    }

    public void setChild3DOB(String child3dob) {
        Child3DOB = child3dob;
    }

    public String getChild1Name() {
        return Child1Name;
    }

    public void setChild1Name(String child1Name) {
        Child1Name = child1Name;
    }

    public String getChild2Name() {
        return Child2Name;
    }

    public void setChild2Name(String child2Name) {
        Child2Name = child2Name;
    }

    public String getChild3Name() {
        return Child3Name;
    }

    public void setChild3Name(String child3Name) {
        Child3Name = child3Name;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public CustomerBean(String agencyId) {
        super();
        this.customerId = agencyId;
    }

    public CustomerBean(Parcel in) {
        readFromParcel(in);
    }

    public boolean isInitialized() {
        return (!TextUtils.isEmpty(this.customerId));
    }

    public String getAgencyId() {
        return customerId;
    }

    public void setAgencyId(String agencyId) {
        this.customerId = agencyId;
    }

    public String getAgencyName() {
        return customerName;
    }

    public void setAgencyName(String agencyName) {
        this.customerName = agencyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEditResourceURL() {
        return editResourceURL;
    }

    public void setEditResourceURL(String editResourceURL) {
        this.editResourceURL = editResourceURL;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.customerId);
        dest.writeString(this.customerName);
        dest.writeString(this.street);
        dest.writeString(this.city);
        dest.writeString(this.country);
        dest.writeString(this.website);
        dest.writeString(this.editResourceURL);

    }

    public void readFromParcel(Parcel in) {
        this.customerId = in.readString();
        this.customerName = in.readString();
        this.street = in.readString();
        this.city = in.readString();
        this.country = in.readString();
        this.website = in.readString();
        this.editResourceURL = in.readString();

    }

    public static final Creator<CustomerBean> CREATOR = new Creator<CustomerBean>() {
        @Override
        public CustomerBean createFromParcel(Parcel in) {
            return new CustomerBean(in);
        }

        @Override
        public CustomerBean[] newArray(int size) {
            return new CustomerBean[size];
        }
    };
}
