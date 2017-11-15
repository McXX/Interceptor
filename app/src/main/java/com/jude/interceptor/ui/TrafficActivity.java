package com.jude.interceptor.ui;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.widget.TextView;

import com.jude.interceptor.R;
import com.jude.interceptor.data.TrafficInfo;

import java.util.Map;

public class TrafficActivity extends Activity {

    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic_activity);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv1.setText("Bytes:\n");
        for (Map.Entry<String, Pair<Long, Long>> entry : TrafficInfo.collectBytesByApps(this).entrySet()) {
            tv1.append(entry.getKey() + " - " + entry.getValue().first + " tx " + entry.getValue().second + " rx\n");
        }
    }
}
