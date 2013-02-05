package minerMan.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class PacketJoin extends PacketBase {
	String playerName;
	public PacketJoin(String name) {
		this.playerName = name;
	}

	@Override
	public void writePacket(DataOutputStream out) {
		try {
			out.writeChars(playerName);
		} catch (IOException e) {
			System.err.println("Failed to write Packet");
			e.printStackTrace();
		}
	}

	@Override
	public void readPacket(DataInputStream in) {
		
		
	}

	@Override
	public void sendPacket(DataOutputStream out) {
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
