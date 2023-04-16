package me.corruptionhades.vapemenu.module.impl.combat;

import me.corruptionhades.vapemenu.module.Category;
import me.corruptionhades.vapemenu.module.Module;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class AutoTotem extends Module {

	// Set the position of the off-hand slot on the screen
	static int offHandSlotX = 1500;
	static int offHandSlotY = 800;

	// Set the amount of time to wait before checking the inventory again (in milliseconds)
	static int waitTime = 100;

	public AutoTotem() {
		super("AutoTotem", "Totem oFf", Category.COMBAT);
	}


	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		String utilityItemName = "totem";
		while (true) {
			// Check if the "V" key is pressed
			if (robot.isKeyDown(KeyEvent.VK_V)) {
				equipUtilityItem(robot, utilityItemName);
				// Wait for a short amount of time before checking again
				Thread.sleep(waitTime);
			}
		}
	}

	public static void equipUtilityItem(Robot robot, String itemName) {
		// Set the position of the utility item in the inventory on the screen
		int itemX = 0;
		int itemY = 0;
		if (itemName.equals("totem")) {
			itemX = 600;
			itemY = 500;
		}
		// Check if the player has the utility item in their off-hand slot
		Color offHandSlotColor = robot.getPixelColor(offHandSlotX, offHandSlotY);
		if (offHandSlotColor.equals(Color.WHITE)) {
			// The off-hand slot is empty, so check if the player has the utility item in their inventory
			Color itemColor = robot.getPixelColor(itemX, itemY);
			if (!itemColor.equals(Color.WHITE)) {
				// The player has the utility item in their inventory, so equip it in the off-hand slot
				robot.mouseMove(itemX, itemY);
				robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				robot.delay(50);
				robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
				robot.delay(50);
				robot.mouseMove(offHandSlotX, offHandSlotY);
				robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				robot.delay(50);
				robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
				robot.delay(50);
			}
		}
	}

	@Override
	public void onTick() {

	}
}