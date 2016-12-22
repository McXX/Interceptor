package com.jude.interceptor.service;


import android.annotation.TargetApi;
import android.os.Build;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalExecutor {
//    private static SparseArray<String> netstat = new SparseArray<>();

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static String netstat() {
        StringBuilder processOutput = new StringBuilder();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("netstat",
                    "-vat");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String readLine;
            while ((readLine = processOutputReader.readLine()) != null) {
                processOutput.append(readLine).append(System.lineSeparator());
            }
            process.waitFor();
        } catch (IOException | InterruptedException ignored) {}
        return processOutput.toString().trim();
    }

}
