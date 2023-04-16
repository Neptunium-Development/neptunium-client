package me.corruptionhades.vapemenu.module.impl.movement;
import me.corruptionhades.vapemenu.module.Category;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ExplosionS2CPacket;
import net.minecraft.util.Formatting;
import me.corruptionhades.vapemenu.event.EventTarget;
import me.corruptionhades.vapemenu.event.impl.EventReceivePacket;
import me.corruptionhades.vapemenu.module.Module;
import me.corruptionhades.vapemenu.setting.NumberSetting;
import me.corruptionhades.vapemenu.utils.ReflectionHelper;

public class Velocity extends Module {

    public NumberSetting horizontal = new NumberSetting("Horizontal", -100, 200, 0, 1);
    public NumberSetting vertical = new NumberSetting("Vertical", 0, 200, 0, 1);

    public Velocity() {
        super("Velocity", "AntiKB", Category.COMBAT);
        addSettings(horizontal, vertical);
        get = this;
    }

     private static final Formatting Gray = Formatting.GRAY;

    @EventTarget
    public void onReceivePacket(EventReceivePacket event) {
        if(mc.world == null || mc.player == null) return;
        this.setDisplayName("Velocity " + Gray + "[" + "H:" + horizontal.getValue() + " V:" + vertical.getValue()+"]");
        if(event.getPacket() instanceof EntityVelocityUpdateS2CPacket) {
            EntityVelocityUpdateS2CPacket velocity = (EntityVelocityUpdateS2CPacket) event.getPacket();
            if(velocity.getId() == mc.player.getId() && !mc.player.isTouchingWater()) {
                ReflectionHelper.setPrivateValue(EntityVelocityUpdateS2CPacket.class, velocity, (int) (velocity.getVelocityX() * (horizontal.getValue() * 0.01)), "velocityX", "field_12561");
                ReflectionHelper.setPrivateValue(EntityVelocityUpdateS2CPacket.class, velocity, (int) (velocity.getVelocityY() * (vertical.getValue() * 0.01)), "velocityY", "field_12562");
                ReflectionHelper.setPrivateValue(EntityVelocityUpdateS2CPacket.class, velocity, (int) (velocity.getVelocityZ() * (horizontal.getValue() * 0.01)), "velocityZ", "field_12563");
            }
        } else if(event.getPacket() instanceof ExplosionS2CPacket) {
            ExplosionS2CPacket velocity = (ExplosionS2CPacket) event.getPacket();
            ReflectionHelper.setPrivateValue(ExplosionS2CPacket.class, velocity, (int) (velocity.getPlayerVelocityX() * (horizontal.getValue() * 0.01)), "playerVelocityX", "field_12176");
            ReflectionHelper.setPrivateValue(ExplosionS2CPacket.class, velocity, (int) (velocity.getPlayerVelocityY() * (vertical.getValue() * 0.01)), "playerVelocityY", "field_12183");
            ReflectionHelper.setPrivateValue(ExplosionS2CPacket.class, velocity, (int) (velocity.getPlayerVelocityZ() * (horizontal.getValue() * 0.01)), "playerVelocityZ", "field_12182");
        }
    }

    public static Velocity get;

    @Override
    public void onTick() {

    }
}