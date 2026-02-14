package com.manus.ramreducer;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RamReducerPreLaunch implements PreLaunchEntrypoint {
    public static final Logger LOGGER = LoggerFactory.getLogger("ramreducer-prelaunch");

    @Override
    public void onPreLaunch() {
        LOGGER.info("RAM Reducer PreLaunch: Preparing memory optimizations before other mods load.");
        // ตั้งค่าระบบที่ต้องทำงานก่อนมอดอื่น เช่น การตั้งค่า Priority ของ Mixin หรือการเตรียม Cache
    }
}
