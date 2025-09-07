package com.example.video;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = legacySharpen;
    }

    public Frame sharpen(Frame frame, int strength) {
        String handle = frame.getHandle();
        String sharpenedHandle = legacySharpen.applySharpen(handle, strength);
        return new Frame(sharpenedHandle);
    }
}
