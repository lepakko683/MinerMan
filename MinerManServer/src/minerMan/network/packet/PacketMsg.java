package minerMan.network.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class PacketMsg extends PacketBase{
	public String data;
	public PacketMsg(String text){
		this.data = text;
	}

	@Override
	public void writePacket(DataOutputStream out) {
		try {
			
			out.writeChars(this.data);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void readPacket(DataInputStream in) {
		try {
			
			this.data = in.readUTF();
			server.packHandler.receivePacket(this);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void sendPacket(DataOutputStream out) {
		// TODO Auto-generated method stub
		
	}

}
