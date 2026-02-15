package com.nonkungch.ramreducer.mixin;

import net.minecraft.resource.ResourceReloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.client.resource.ResourceReloadLogger")
public class ResourceLoadingMixin {
    @Inject(method = "finish", at = @At("HEAD"))
    private void onReloadFinish(CallbackInfo ci) {
        // เคลียร์หน่วยความจำส่วนเกินหลังจากโหลด Resource เสร็จสิ้น
        System.gc(); 
    }
}
