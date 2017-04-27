package com.company;

import java.io.File;

/**
 * Created by hackeru on 3/29/2017.
 */
public class UploadedFile extends File {
    private byte[] fileNameBytes;
    private int version;
    private boolean lock;

    public UploadedFile(String pathname) {
        super(pathname);
        this.version=0;

    }

    public byte[] getFileNameBytes() {
        return fileNameBytes;
    }

    public void setFileNameBytes(byte[] fileNameBytes) {
        this.fileNameBytes = fileNameBytes;
    }

    public void increaseVersion(){
        version++;
    }

    public void lock(){
        lock =true;
    }

    public void unlock(){
        lock =false;
    }
    public boolean isLocked(){
        return lock;

    }
}
