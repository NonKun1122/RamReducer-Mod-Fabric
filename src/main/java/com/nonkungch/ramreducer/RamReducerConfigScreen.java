package com.nonkungch.ramreducer;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.text.Text;

public class RamReducerConfigScreen extends Screen {
    private final Screen parent;

    public RamReducerConfigScreen(Screen parent) {
        super(Text.literal("RAM Reducer Settings"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int y = this.height / 4;

        // 1. ปุ่มเปิด/ปิด RAM Overlay
        this.addDrawableChild(CyclingButtonWidget.onOffBuilder(Config.showRamOverlay)
                .build(this.width / 2 - 100, y, 200, 20, Text.literal("Show RAM Overlay"), (button, value) -> {
                    Config.showRamOverlay = value;
                    Config.save();
                }));

        // 2. ปุ่มเปิด/ปิด RAM Warning
        this.addDrawableChild(CyclingButtonWidget.onOffBuilder(Config.showRamWarning)
                .build(this.width / 2 - 100, y + 30, 200, 20, Text.literal("Show RAM Warning"), (button, value) -> {
                    Config.showRamWarning = value;
                    Config.save();
                }));

        // 3. ปุ่มเปิด/ปิด Auto Cleanup
        this.addDrawableChild(CyclingButtonWidget.onOffBuilder(Config.enableAutoCleanup)
                .build(this.width / 2 - 100, y + 60, 200, 20, Text.literal("Auto RAM Cleanup"), (button, value) -> {
                    Config.enableAutoCleanup = value;
                    Config.save();
                }));

        // ปุ่ม Done
        this.addDrawableChild(ButtonWidget.builder(Text.translatable("gui.done"), (button) -> {
            this.client.setScreen(this.parent);
        }).dimensions(this.width / 2 - 100, this.height - 40, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void close() {
        this.client.setScreen(this.parent);
    }
}
