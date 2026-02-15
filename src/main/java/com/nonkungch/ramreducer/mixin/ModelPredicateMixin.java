package com.nonkungch.ramreducer.mixin;

import net.minecraft.client.render.model.json.MultipartModelComponent;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MultipartModelComponent.class)
public class ModelPredicateMixin {
    // ปรับปรุงการแคชโมเดลเพื่อลดการสร้าง Object ใหม่ในหน่วยความจำ
}
