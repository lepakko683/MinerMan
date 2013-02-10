package minerMan.server;

import minerMan.network.connection.NetHandler;
import minerMan.network.connection.PacketHandler;
import minerMan.network.packet.PacketMsg;
import minerMan.server.gui.ServerGuiMain;
import minerMan.tile.WorldTile;

public class MinerManServer {
	public static MinerManServer instance = new MinerManServer();
	public static final int UPDFRATE = 1;
	public static int connections = 0;
	
	public NetHandler network;
	public PacketHandler packHandler;
	public boolean running;
	public String message;
	private Timer timer;
	
	public MinerManServer(){
		ServerGuiMain gui0 = new ServerGuiMain(400,400);
		gui0.setTitle("Hello, minerMan!");
		running = true;
		network = new NetHandler();
		packHandler = new PacketHandler();
		timer = new Timer();
		WorldTile tiles = new WorldTile();
		while(running){
			
			network.onUpdate();
			System.out.println("exec");
			gui0.onUpdate(Integer.toString(network.getConnections()));
			timer.run();
			
		}
	}
	
	public static void main(String[] args){
		new MinerManServer();
	}

}
