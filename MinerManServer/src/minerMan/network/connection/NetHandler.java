package minerMan.network.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import minerMan.network.packet.PacketBase;

public class NetHandler {
	List<ClientConnection> connects = new ArrayList<ClientConnection>();
	ServerSocket server;
	
	public void updateConnections(boolean sendPack, PacketBase pack){
		
		if(connects.size()>0){
			
			for(ClientConnection co : connects){
				if(sendPack){
					co.sendPacket(pack);
				}
					co.onUpdate();

				
			
			}
		}
	}
	
	public void addConnection(Socket client){
		connects.add(new ClientConnection(client));
	}
	
	public void onUpdate() throws IOException{
		Socket sock = server.accept();
		if(sock != null){
			this.addConnection(sock);
		}
		this.updateConnections(false, null);
	}
	
	public void startServerNet(int port) throws IOException{
		server = new ServerSocket(port);
		
	}
	
	public void sendPacket(PacketBase pack){
		updateConnections(true, pack);
	}
}
