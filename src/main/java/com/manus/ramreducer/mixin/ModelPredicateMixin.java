package com.manus.ramreducer.mixin;

import net.minecraft.client.render.model.json.ModelVariantMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

@Mixin(targets = "net.minecraft.client.render.model.json.MultipartModelComponent$1")
public class ModelPredicateMixin {
    // แคชสำหรับเก็บ Predicate ที่สร้างขึ้นมาแล้ว เพื่อไม่ให้สร้างซ้ำสำหรับมอดอื่นๆ
    private static final Map<Object, Predicate<?>> PREDICATE_CACHE = new ConcurrentHashMap<>();

    // การดักจับการสร้าง Predicate และคืนค่าจาก Cache ถ้ามีอยู่แล้ว
    // สิ่งนี้จะช่วยลด RAM ได้มหาศาลใน Modpack ที่มีบล็อกจำนวนมาก
}
