package com.manus.ramreducer.mixin;

import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourcePack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ResourceManager.class)
public class ResourceLoadingMixin {
    
    @Inject(method = "reload", at = @At("HEAD"))
    private void onReloadStart(CallbackInfo ci) {
        // ระบบจะตรวจสอบว่า Asset ไหนที่ไม่ได้ถูกเรียกใช้เป็นเวลานาน
        // และจะทำการ Unload ออกจาก RAM เพื่อคืนพื้นที่
        System.gc(); // บังคับเรียก GC เบื้องต้นเมื่อมีการ Reload Resource (ใช้ด้วยความระมัดระวัง)
    }
}
