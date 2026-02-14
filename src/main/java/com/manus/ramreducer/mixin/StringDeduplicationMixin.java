package com.manus.ramreducer.mixin;

import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Identifier.class)
public class StringDeduplicationMixin {
    
    @ModifyVariable(method = "<init>(Ljava/lang/String;Ljava/lang/String;)V", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private static String internNamespace(String namespace) {
        return namespace != null ? namespace.intern() : null;
    }

    @ModifyVariable(method = "<init>(Ljava/lang/String;Ljava/lang/String;)V", at = @At("HEAD"), argsOnly = true, ordinal = 1)
    private static String internPath(String path) {
        return path != null ? path.intern() : null;
    }
}
