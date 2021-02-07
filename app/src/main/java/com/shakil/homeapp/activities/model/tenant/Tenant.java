package com.shakil.homeapp.activities.model.tenant;

public class Tenant {
    private String TenantName;
    private String StartingMonth;
    private int StartingMonthId;
    private String  AssociateMeter;
    private int  AssociateMeterId;

    public String getTenantName() {
        return TenantName;
    }

    public void setTenantName(String tenantName) {
        TenantName = tenantName;
    }

    public String getStartingMonth() {
        return StartingMonth;
    }

    public void setStartingMonth(String startingMonth) {
        StartingMonth = startingMonth;
    }

    public int getStartingMonthId() {
        return StartingMonthId;
    }

    public void setStartingMonthId(int startingMonthId) {
        StartingMonthId = startingMonthId;
    }

    public String getAssociateMeter() {
        return AssociateMeter;
    }

    public void setAssociateMeter(String associateMeter) {
        AssociateMeter = associateMeter;
    }

    public int getAssociateMeterId() {
        return AssociateMeterId;
    }

    public void setAssociateMeterId(int associateMeterId) {
        AssociateMeterId = associateMeterId;
    }
}
