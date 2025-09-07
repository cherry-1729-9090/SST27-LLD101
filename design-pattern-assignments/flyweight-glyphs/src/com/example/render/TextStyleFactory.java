package com.example.render;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {
    private static final Map<String, TextStyle> cache = new HashMap<>();

    public static TextStyle getTextStyle(String font, int size, boolean bold) {
        String key = font + "|" + size + "|" + (bold ? "B" : "");
        
        if (!cache.containsKey(key)) {
            cache.put(key, new TextStyle(font, size, bold));
        }
        
        return cache.get(key);
    }
}
