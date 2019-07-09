package com.zzc.datasalesprovider.Model;

public class CompanyDataCompanyWithBLOBs extends CompanyDataCompany {
    private String address;

    private String productions;

    private String businessScope;

    private String businessLicenseNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getProductions() {
        return productions;
    }

    public void setProductions(String productions) {
        this.productions = productions == null ? null : productions.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber == null ? null : businessLicenseNumber.trim();
    }
}