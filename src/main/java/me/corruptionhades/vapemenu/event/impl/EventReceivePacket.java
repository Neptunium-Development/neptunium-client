package me.corruptionhades.vapemenu.event.impl;

import net.minecraft.network.Packet;
import me.corruptionhades.vapemenu.event.Event;

public class EventReceivePacket extends Event {

	private Packet<?> packet;
	
	public EventReceivePacket(Packet<?> packet) {
		this.packet = packet;
	}
	
	public Packet<?> getPacket() {
		return packet;
	}
}