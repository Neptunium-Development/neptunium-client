package me.corruptionhades.vapemenu.module.impl.movement;

import me.corruptionhades.vapemenu.event.EventTarget;
import me.corruptionhades.vapemenu.event.impl.EventUpdate;
import me.corruptionhades.vapemenu.module.Category;
import me.corruptionhades.vapemenu.module.Module;

import static me.corruptionhades.vapemenu.utils.PacketHelper.mc;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", "Keeps Sprint", Category.MOVEMENT);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        mc.player.setSprinting(true);
    }

    @Override
    public void onTick() {

    }
}
