package me.corruptionhades.vapemenu.module.impl.combat;

import me.corruptionhades.vapemenu.event.EventTarget;
import me.corruptionhades.vapemenu.event.impl.EventUpdate;
import me.corruptionhades.vapemenu.event.impl.PacketSendEvent;
import me.corruptionhades.vapemenu.module.Category;
import me.corruptionhades.vapemenu.module.Module;
import me.corruptionhades.vapemenu.module.impl.movement.Timer;
import me.corruptionhades.vapemenu.utils.time.TimerUtil;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;

public class Criticals extends Module {

    private Packet<?> cached;
    private TimerUtil timer;

    public Criticals() {
        super("Criticals", "Auto Crits", Category.COMBAT);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        timer = new TimerUtil();
    }

    @EventTarget
    public void onPacket(PacketSendEvent e) {
        Packet<?> packet = e.getPacket();
        if(packet instanceof PlayerInteractEntityC2SPacket pie) {

        }
    }

}
