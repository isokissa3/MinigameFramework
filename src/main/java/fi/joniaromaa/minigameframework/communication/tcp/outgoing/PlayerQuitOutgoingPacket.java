package fi.joniaromaa.minigameframework.communication.tcp.outgoing;

import java.util.UUID;

import fi.joniaromaa.minigameframework.communication.tcp.TcpOutgoingPacket;
import fi.joniaromaa.minigameframework.utils.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class PlayerQuitOutgoingPacket implements TcpOutgoingPacket
{
	private static final int PACKET_ID = 3;
	
	private UUID uuid;
	
	public PlayerQuitOutgoingPacket(UUID uuid)
	{
		this.uuid = uuid;
	}
	
	@Override
	public ByteBuf getBytes()
	{
		ByteBuf buf = Unpooled.buffer();
		buf.writeShort(PlayerQuitOutgoingPacket.PACKET_ID);
		ByteBufUtils.writeUUID(buf, this.uuid);
		return buf;
	}
}
