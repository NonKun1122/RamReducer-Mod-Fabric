package com.manus.ramreducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MemoryMonitor {
    private static final Logger LOGGER = LoggerFactory.getLogger("RAM-Monitor");
    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public static void startMonitoring() {
        scheduler.scheduleAtFixedRate(() -> {
            Runtime runtime = Runtime.getRuntime();
            long usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
            long maxMemory = runtime.maxMemory() / (1024 * 1024);
            
            LOGGER.info("Current RAM Usage: {}MB / {}MB", usedMemory, maxMemory);
            
            // ถ้า RAM ใกล้เต็ม (เช่น เกิน 90%) จะทำการบังคับคืนหน่วยความจำเบื้องต้น
            if ((double) usedMemory / maxMemory > 0.9) {
                LOGGER.warn("High RAM usage detected! Attempting emergency cleanup...");
                System.gc();
            }
        }, 0, 1, TimeUnit.MINUTES);
    }
}
