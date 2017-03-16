package com.transit;

import java.util.Map;

/**
 * Created by maprangsuwanbubpa on 17-03-16.
 */
public class Alert {
    Map<String, ServiceAlerts> service_alerts;

    public Map<String, ServiceAlerts> getAlert() {
        return this.service_alerts;
    }

    public void setAlert(Map<String, ServiceAlerts> alert) {
        this.service_alerts = alert;

    }

}
