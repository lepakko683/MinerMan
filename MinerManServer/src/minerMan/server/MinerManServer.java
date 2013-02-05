package minerMan.server;

import minerMan.network.connection.NetHandler;
import minerMan.network.connection.PacketHandler;
import minerMan.network.packet.PacketMsg;

public class MinerManServer {
	public static MinerManServer instance = new MinerManServer();
	public static final int UPDFRATE = 1;
	
	public NetHandler network;
	public PacketHandler packHandler;
	public boolean running;
	public String message;
	
	public MinerManServer(){
		network = new NetHandler();
		packHandler = new PacketHandler();
		message = packHandler.message;
		while(running){
			PacketMsg mesg = new PacketMsg(Long.toString((System.currentTimeMillis())));
			network.sendPacket(mesg);
			System.out.println(message);
		}
	}
	
	public static void main(String[] args){
		//new MinerManServer();
		
		//DateEvent de0 = new DateEvent("", "", "");
		DateEvents dES = new DateEvents();
		//System.out.println(de0.isActive());
	}

}
