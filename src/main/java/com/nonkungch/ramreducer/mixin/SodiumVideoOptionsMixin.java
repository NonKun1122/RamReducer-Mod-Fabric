package com.nonkungch.ramreducer.mixin;

import com.nonkungch.ramreducer.Config;
import me.jellysquid.mods.sodium.client.gui.SodiumVideoOptionsScreen;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;
import me.jellysquid.mods.sodium.client.gui.options.storage.MinecraftOptionsStorage;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = SodiumVideoOptionsScreen.class, remap = false)
public class SodiumVideoOptionsMixin {
    @Shadow
    @Final
    private List<OptionPage> pages;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        // สร้างกลุ่มตัวเลือกสำหรับ RAM Reducer
        OptionGroup.Builder groupBuilder = OptionGroup.createBuilder();
        groupBuilder.setName(Text.literal("RAM Reducer Settings"));

        // 1. แสดง RAM Overlay (Checkbox)
        groupBuilder.add(OptionImpl.createBuilder(Boolean.class, new MinecraftOptionsStorage())
                .setName(Text.literal("Show RAM Overlay"))
                .setTooltip(Text.literal("Display RAM usage in the top-right corner."))
                .setControl(TickBoxControl::new)
                .setBinding((opt, value) -> { Config.showRamOverlay = value; Config.save(); },
                            opt -> Config.showRamOverlay)
                .build());

        // 2. แสดงการแจ้งเตือน RAM สูง (Checkbox)
        groupBuilder.add(OptionImpl.createBuilder(Boolean.class, new MinecraftOptionsStorage())
                .setName(Text.literal("Show RAM Warning"))
                .setTooltip(Text.literal("Show warning notification when RAM usage is critical."))
                .setControl(TickBoxControl::new)
                .setBinding((opt, value) -> { Config.showRamWarning = value; Config.save(); },
                            opt -> Config.showRamWarning)
                .build());

        // เพิ่มหน้าการตั้งค่าใหม่เข้าไปใน Sodium
        pages.add(new OptionPage(Text.literal("RAM Reducer"), List.of(groupBuilder.build())));
    }
}
