package minerMan.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import minerMan.server.MinerManServer;


public abstract class PacketBase {
	public MinerManServer server = MinerManServer.instance;

	public abstract void writePacket(DataOutputStream out);
	
	public abstract void readPacket(DataInputStream in);
	
	public abstract void sendPacket(DataOutputStream out);
}
