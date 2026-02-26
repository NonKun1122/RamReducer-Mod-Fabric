package com.nonkungch.ramreducer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class RamReducerClient implements ClientModInitializer {
    private static KeyBinding configKeyBinding;

    @Override
    public void onInitializeClient() {
        // ลงทะเบียนปุ่มลัด (ค่าเริ่มต้นคือตัว R)
        configKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.ramreducer.config", 
                InputUtil.Type.KEYSYM, 
                GLFW.GLFW_KEY_R, 
                "category.ramreducer"
        ));

        // ตรวจสอบการกดปุ่มในแต่ละ Tick
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (configKeyBinding.wasPressed()) {
                client.setScreen(new RamReducerConfigScreen(client.currentScreen));
            }
        });
    }
}
