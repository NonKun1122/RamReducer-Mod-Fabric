package com.nonkungch.ramreducer;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RamReducer implements ModInitializer {
    public static final String MOD_ID = "ramreducer";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("RAM Reducer initialized. Optimizing memory...");
        MemoryMonitor.startMonitoring();
    }
}
