package minerMan.network.packages;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import minerMan.network.connection.NetHandler;

public class PacketMsg extends PacketBase{
	String data;

	@Override
	public void writePacket(NetHandler net, DataOutputStream out) {
		try {
			
			out.writeChars(this.data);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void readPacket(NetHandler net, DataInputStream in) {
		try {
			
			this.data = in.readUTF();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void sendPacket(NetHandler net, DataOutputStream out) {
		// TODO Auto-generated method stub
		
	}

}
