package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class AppSettings implements Serializable {
    private static volatile AppSettings instance;
    private final Properties props = new Properties();
    private boolean loaded = false;

    private AppSettings() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method");
        }
    }

    public static AppSettings getInstance() {
        if (instance == null) {
            synchronized (AppSettings.class) {
                if (instance == null) {
                    instance = new AppSettings();
                }
            }
        }
        return instance;
    }

    public void loadFromFile(Path file) {
        if (!loaded) {
            synchronized (this) {
                if (!loaded) {
                    try (InputStream in = Files.newInputStream(file)) {
                        props.load(in);
                        loaded = true;
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                }
            }
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    private Object readResolve() {
        return getInstance();
    }
}
