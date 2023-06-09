package me.corruptionhades.vapemenu.mixin;

import me.corruptionhades.vapemenu.module.Module;
import me.corruptionhades.vapemenu.event.impl.EventUpdate;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "tick", at = @At("HEAD"))
    public void onUpdate(CallbackInfo ci) {
        new EventUpdate().call();
    }
    
    @Inject(at = @At("HEAD"), method = "tick")
    public void onTick(CallbackInfo ci) {
       if (mc.player != null) {
            for (Module module : ModuleManager.INSTANCE.getEnabledModules()) {
                module.onTick();
            }
        }
    }
}
