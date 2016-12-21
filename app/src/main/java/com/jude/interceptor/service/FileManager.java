package com.jude.interceptor.service;

import android.os.Environment;

import com.jude.utils.JTimeTransform;

import java.io.File;

public class FileManager {
    private static final File Directory = new File(Environment.getExternalStorageDirectory(),"PacketCap");

    public static void initFileManager(){
        if (!Directory.isDirectory()){
            Directory.delete();
            Directory.mkdir();
        }
    }

    public static File createNewPacketFile() {
        return new File(Directory,createNewFileName());
    }

    public static File[] listPacketFiles(){
        return Directory.listFiles();
    }

    private static String createNewFileName(){
        return new JTimeTransform(System.currentTimeMillis()/1000).toString("yyyyMMdd_hhmmss")+".pcap";
    }
}
