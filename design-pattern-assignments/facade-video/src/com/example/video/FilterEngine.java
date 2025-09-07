package com.example.video;

public class FilterEngine {
    public Frame[] grayscale(Frame[] frames){ return frames; }
    public Frame[] scale(Frame[] frames, double factor){ return frames; }
    
    public Frame grayscale(Frame frame){ return frame; }
    public Frame scale(Frame frame, double factor){ return frame; }
}
