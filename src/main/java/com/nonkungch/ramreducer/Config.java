package com.nonkungch.ramreducer;

import java.io.*;
import java.util.Properties;

public class Config {
    public static boolean showRamOverlay = true;
    public static boolean showRamWarning = true;
    public static double ramWarningThreshold = 0.9; // 90%
    
    public static boolean enableDeduplication = true;
    public static boolean enableAutoCleanup = true;

    private static final File CONFIG_FILE = new File("config/ram_reducer.properties");

    public static void load() {
        if (!CONFIG_FILE.exists()) {
            save();
            return;
        }
        try (InputStream input = new FileInputStream(CONFIG_FILE)) {
            Properties prop = new Properties();
            prop.load(input);
            showRamOverlay = Boolean.parseBoolean(prop.getProperty("showRamOverlay", "true"));
            showRamWarning = Boolean.parseBoolean(prop.getProperty("showRamWarning", "true"));
            ramWarningThreshold = Double.parseDouble(prop.getProperty("ramWarningThreshold", "0.9"));
            enableDeduplication = Boolean.parseBoolean(prop.getProperty("enableDeduplication", "true"));
            enableAutoCleanup = Boolean.parseBoolean(prop.getProperty("enableAutoCleanup", "true"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void save() {
        try {
            CONFIG_FILE.getParentFile().mkdirs();
            try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
                Properties prop = new Properties();
                prop.setProperty("showRamOverlay", String.valueOf(showRamOverlay));
                prop.setProperty("showRamWarning", String.valueOf(showRamWarning));
                prop.setProperty("ramWarningThreshold", String.valueOf(ramWarningThreshold));
                prop.setProperty("enableDeduplication", String.valueOf(enableDeduplication));
                prop.setProperty("enableAutoCleanup", String.valueOf(enableAutoCleanup));
                prop.store(output, "RAM Reducer Config");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
