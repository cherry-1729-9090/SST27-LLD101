package com.example.video;

public class Frame {
    public final int w, h;
    private final String handle;
    
    public Frame(int w, int h) { 
        this.w = w; 
        this.h = h; 
        this.handle = "FRAME:" + w + "x" + h;
    }
    
    public Frame(String handle) {
        this.w = 1920;
        this.h = 1080;
        this.handle = handle;
    }
    
    public String getHandle() {
        return handle;
    }
}
