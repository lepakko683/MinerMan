package minerMan.network.connection;

import minerMan.network.packet.PacketBase;
import minerMan.network.packet.PacketMsg;

public class PacketHandler {
	public String message;
	public PacketHandler(){
		message = "";
	}
	
	public void receivePacket(PacketBase pack){
		if(pack instanceof PacketMsg){
			PacketMsg pac = (PacketMsg) pack;
			
			this.message = pac.data;
		}
	}
	public void sendPacket(){
		
	}
}
