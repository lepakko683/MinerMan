package minerMan.network.packages;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import minerMan.network.connection.NetHandler;

public class PacketJoin extends PacketBase {
	String playerName;
	public PacketJoin(String name) {
		this.playerName = name;
	}

	@Override
	public void writePacket(NetHandler net, DataOutputStream out) {
		try {
			out.writeChars(playerName);
		} catch (IOException e) {
			System.err.println("Failed to write Packet");
			e.printStackTrace();
		}
	}

	@Override
	public void readPacket(NetHandler net, DataInputStream in) {
		
		
	}

	@Override
	public void sendPacket(NetHandler net, DataOutputStream out) {
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
