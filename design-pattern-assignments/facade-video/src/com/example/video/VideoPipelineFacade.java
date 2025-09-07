package com.example.video;

import java.nio.file.Path;

public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final Encoder encoder;
    private final SharpenAdapter sharpenAdapter;

    public VideoPipelineFacade() {
        this.decoder = new Decoder();
        this.filterEngine = new FilterEngine();
        this.encoder = new Encoder();
        this.sharpenAdapter = new SharpenAdapter(new LegacySharpen());
    }

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Frame[] frames = decoder.decode(src);
        
        if (gray) {
            frames = filterEngine.grayscale(frames);
        }
        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }
        if (sharpenStrength != null && sharpenStrength > 0) {
            for (int i = 0; i < frames.length; i++) {
                frames[i] = sharpenAdapter.sharpen(frames[i], sharpenStrength);
            }
        }
        
        encoder.encode(frames, out);
        return out;
    }
}
