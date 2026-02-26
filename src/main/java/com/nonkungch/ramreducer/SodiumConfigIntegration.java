package com.nonkungch.ramreducer;

import net.minecraft.text.Text;

/**
 * คลาสสำหรับการเชื่อมต่อกับ Sodium Options API สำหรับ RAM Reducer
 */
public class SodiumConfigIntegration {
    /*
    ตัวอย่างการเพิ่ม Option ใน Sodium:
    
    public static void registerOptions(OptionGroup.Builder groups) {
        // ตัวเลือกเปิด/ปิด RAM Overlay
        groups.add(OptionImpl.createBuilder(Boolean.class, storage)
                .setName(Text.literal("Show RAM Overlay"))
                .setTooltip(Text.literal("Display RAM usage in the top-right corner"))
                .setControl(TickBoxControl::new)
                .setBinding((options, value) -> { Config.showRamOverlay = value; Config.save(); },
                            options -> Config.showRamOverlay)
                .build());

        // ตัวเลือกเปิด/ปิด การแจ้งเตือนแรมเต็ม
        groups.add(OptionImpl.createBuilder(Boolean.class, storage)
                .setName(Text.literal("Show RAM Warning"))
                .setTooltip(Text.literal("Show warning notification in the bottom-right when RAM is high"))
                .setControl(TickBoxControl::new)
                .setBinding((options, value) -> { Config.showRamWarning = value; Config.save(); },
                            options -> Config.showRamWarning)
                .build());
    }
    */
}
