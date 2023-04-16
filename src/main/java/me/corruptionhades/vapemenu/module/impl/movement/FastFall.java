package me.corruptionhades.vapemenu.module.impl.movement;

import me.corruptionhades.vapemenu.setting.ModeSetting;
import me.corruptionhades.vapemenu.module.Category;
import me.corruptionhades.vapemenu.module.Module;
public class FastFall extends Module {

    ModeSetting modeSetting = new ModeSetting("Mode", "Vanilla", "Vanilla", "Matrix");

    public FastFall() {
        super("FastFall", "Fall Faster", Category.MOVEMENT);
        addSettings(modeSetting);
    }

    @Override
    public void onTick() {
        if (mc.player.fallDistance > 0.4 && modeSetting.isMode("Vanilla")) {
            mc.player.setVelocity(mc.player.getVelocity().x, -1.6, mc.player.getVelocity().z);
        }
        if (mc.player.fallDistance > 0.8f && modeSetting.isMode("Matrix")) {
            mc.player.setVelocity(0, -0.54, 0);
        }
    }
}
