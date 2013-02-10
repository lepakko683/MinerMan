package minerMan.network.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import minerMan.network.packet.PacketBase;

public class ClientConnection {
	DataOutputStream outs;
	DataInputStream ins;
	Socket client;
	public boolean isDisconnected(){
		return false;
	}
	protected ClientConnection(Socket client){
		this.client = client;
		
		try {
			
			outs = new DataOutputStream(client.getOutputStream());
			ins = new DataInputStream(client.getInputStream());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onUpdate() {
		
	}

	public void sendPacket(PacketBase pack) {
		pack.writePacket(outs);
	}

}
