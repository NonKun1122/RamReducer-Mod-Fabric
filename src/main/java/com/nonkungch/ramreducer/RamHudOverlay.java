package com.nonkungch.ramreducer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class RamHudOverlay implements HudRenderCallback {
    private static long lastWarningTime = 0;
    private static final long WARNING_DURATION = 5000; // แสดงคำเตือน 5 วินาที

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        if (!Config.showRamOverlay) return;

        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.options.hudHidden) return;

        TextRenderer renderer = client.textRenderer;
        int width = client.getWindow().getScaledWidth();
        int height = client.getWindow().getScaledHeight();

        // 1. แสดง RAM มุมขวาบน
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
        long maxMemory = runtime.maxMemory() / (1024 * 1024);
        String ramText = "RAM: " + usedMemory + "MB / " + maxMemory + "MB";
        
        int textWidth = renderer.getWidth(ramText);
        drawContext.drawTextWithShadow(renderer, ramText, width - textWidth - 5, 5, 0xFFFFFF);

        // 2. แสดงการแจ้งเตือนมุมขวาล่าง
        double usageRatio = (double) usedMemory / maxMemory;
        if (Config.showRamWarning && usageRatio > Config.ramWarningThreshold) {
            lastWarningTime = System.currentTimeMillis();
        }

        if (System.currentTimeMillis() - lastWarningTime < WARNING_DURATION) {
            String warningText = "⚠️ WARNING: High RAM Usage (" + (int)(usageRatio * 100) + "%)";
            int warnWidth = renderer.getWidth(warningText);
            drawContext.drawTextWithShadow(renderer, Text.literal(warningText).formatted(Formatting.RED, Formatting.BOLD), 
                width - warnWidth - 5, height - 15, 0xFF5555);
        }
    }
}
