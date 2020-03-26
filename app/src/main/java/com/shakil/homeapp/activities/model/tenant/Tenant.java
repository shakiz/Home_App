package com.shakil.homeapp.activities.model.tenant;

public class Tenant {
    private String tenantName , startingMonth , associateMeter;

    public Tenant(String tenantName, String startingMonth, String associateMeter) {
        this.tenantName = tenantName;
        this.startingMonth = startingMonth;
        this.associateMeter = associateMeter;
    }

    public Tenant() {

    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getStartingMonth() {
        return startingMonth;
    }

    public void setStartingMonth(String startingMonth) {
        this.startingMonth = startingMonth;
    }

    public String getAssociateMeter() {
        return associateMeter;
    }

    public void setAssociateMeter(String associateMeter) {
        this.associateMeter = associateMeter;
    }
}
