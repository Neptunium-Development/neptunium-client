package me.corruptionhades.vapemenu.module.impl.combat;
import java.util.List;

import me.corruptionhades.vapemenu.module.Category;
import me.corruptionhades.vapemenu.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.item.Items;
import me.corruptionhades.vapemenu.utils.player.FindItemResult;
import me.corruptionhades.vapemenu.utils.player.InventoryUtils;

public class AutoTotem extends Module {

	List<Entity> entities;

	
	public AutoTotem() {
		super("Offhand", "Puts the shit in your offhand", Category.COMBAT);
	}
	@Override
	public void onTick() {
		if (mc.player.getOffHandStack().getItem() != Items.TOTEM_OF_UNDYING) {
            FindItemResult iTotem = InventoryUtils.find(itemStack -> itemStack.getItem() == Items.TOTEM_OF_UNDYING, 0, 35);
            if (iTotem.found()) {
            	InventoryUtils.move().from(iTotem.getSlot()).toOffhand();
            } else return;
		}
	}
}