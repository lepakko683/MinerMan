package minerMan.network.packages;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import minerMan.network.connection.NetHandler;

public abstract class PacketBase {

	public abstract void writePacket(NetHandler net, DataOutputStream out);
	
	public abstract void readPacket(NetHandler net, DataInputStream in);
	
	public abstract void sendPacket(NetHandler net, DataOutputStream out);
}
