package com.jude.interceptor.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.support.v4.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrafficInfo {

    public static Map<String, Pair<Long, Long>> collectBytesByApps(Context context) {
        Map<String, Pair<Long, Long>> info = new HashMap<>();
        List<ApplicationInfo> apps = context.getPackageManager()
                .getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (ApplicationInfo app : apps) {
            long tx = TrafficStats.getUidTxBytes(app.uid);
            long rx = TrafficStats.getUidRxBytes(app.uid);
            if (tx != 0 || rx != 0)
                info.put(app.packageName, Pair.create(tx, rx));
        }
        return info;
    }

    public static Map<String, Long> collectTxPackets(Context context) {
        Map<String, Long> info = new HashMap<>();
        List<ApplicationInfo> apps = context.getPackageManager()
                .getInstalledApplications(PackageManager.GET_UNINSTALLED_PACKAGES);
        for (ApplicationInfo app : apps) {
            long tx = TrafficStats.getUidUdpRxPackets(app.uid);
            if (tx != 0)
                info.put(app.packageName, tx);
        }
        return info;
    }


}
