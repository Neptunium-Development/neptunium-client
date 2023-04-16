package me.corruptionhades.vapemenu.module.impl.closet;

import me.corruptionhades.vapemenu.event.EventTarget;
import me.corruptionhades.vapemenu.event.impl.EventUpdate;
import me.corruptionhades.vapemenu.module.Category;
import me.corruptionhades.vapemenu.module.Module;
import me.corruptionhades.vapemenu.setting.NumberSetting;
import me.corruptionhades.vapemenu.utils.time.TimerUtil;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;

public class CrystalBreak extends Module {

    private final TimerUtil timerUtil = new TimerUtil();

    private final NumberSetting cooldown = new NumberSetting("cooldown-ms", 0.0, 1000.0, 0.0, 0.01);

    public CrystalBreak() {
        super("CrystalPop", "Automatically pops end crystal when placed", Category.CLOSET);
        addSettings(cooldown);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        ClientTickEvents.END_CLIENT_TICK.register(client -> endCrystalTrigger());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {

    }
    private void endCrystalTrigger() {
        HitResult hit = mc.crosshairTarget;
        if (hit.getType() != HitResult.Type.ENTITY)
            return;
        Entity target = ((EntityHitResult) hit).getEntity();
        if (!(target instanceof EndCrystalEntity))
            return;
        if (timerUtil.hasReached((int) cooldown.getValue())) {
            mc.interactionManager.attackEntity(mc.player, target);
            mc.player.swingHand(Hand.MAIN_HAND);
            timerUtil.reset();
        }

    }
}