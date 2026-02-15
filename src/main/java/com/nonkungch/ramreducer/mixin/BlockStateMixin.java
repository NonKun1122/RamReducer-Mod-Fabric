package com.nonkungch.ramreducer.mixin;

import net.minecraft.state.State;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import com.google.common.collect.ImmutableMap;

@Mixin(State.class)
public abstract class BlockStateMixin<O, S> {
    @Shadow
    private ImmutableMap<net.minecraft.state.property.Property<?>, Comparable<?>> entries;

    // ระบบจะช่วยลดการใช้ RAM ในการเก็บข้อมูลสถานะบล็อกที่ซ้ำซ้อน
}
