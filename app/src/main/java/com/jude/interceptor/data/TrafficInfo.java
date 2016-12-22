package com.jude.interceptor.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrafficInfo {
    public static Map<String,Long> collectInfobyApps(Context context){
        Map<String,Long> info = new HashMap<>();
        List<ApplicationInfo> apps = context.getPackageManager()
                .getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (ApplicationInfo app:apps) {
            info.put(app.packageName, TrafficStats.getUidTxBytes(app.uid));
        }
        return info;
    }
}
