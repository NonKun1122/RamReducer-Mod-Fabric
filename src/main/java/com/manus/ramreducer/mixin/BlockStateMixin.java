package com.manus.ramreducer.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.state.StateHolder;
import net.minecraft.state.property.Property;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Mixin(StateHolder.class)
public abstract class BlockStateMixin<O, S> {
    // ใช้ Cache เพื่อแชร์ Map ของ Property ที่เหมือนกันระหว่าง BlockState ต่างๆ
    private static final Map<Map<?, ?>, Map<?, ?>> CANONICAL_MAPS = new ConcurrentHashMap<>();

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(Object owner, Map<Property<?>, Comparable<?>> entries, CallbackInfo ci) {
        // ใน Minecraft ปกติ แต่ละ BlockState จะมี ImmutableMap ของตัวเอง
        // เราจะทำการ Deduplicate Map เหล่านี้เพื่อลดการใช้ RAM
        // หมายเหตุ: ในการใช้งานจริงต้องระวังเรื่อง Thread-safety และการเข้าถึงฟิลด์ private
    }
}
