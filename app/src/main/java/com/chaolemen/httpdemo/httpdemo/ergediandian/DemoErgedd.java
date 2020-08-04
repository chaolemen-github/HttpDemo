package com.chaolemen.httpdemo.httpdemo.ergediandian;

public class DemoErgedd {
    /**
     * upgrade : false
     * upgrade_version : 0
     * upgrade_url :
     */

    private boolean upgrade;
    private int upgrade_version;
    private String upgrade_url;

    public boolean isUpgrade() {
        return upgrade;
    }

    public void setUpgrade(boolean upgrade) {
        this.upgrade = upgrade;
    }

    public int getUpgrade_version() {
        return upgrade_version;
    }

    public void setUpgrade_version(int upgrade_version) {
        this.upgrade_version = upgrade_version;
    }

    public String getUpgrade_url() {
        return upgrade_url;
    }

    public void setUpgrade_url(String upgrade_url) {
        this.upgrade_url = upgrade_url;
    }
}
