package minerMan.network.connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import minerMan.network.packet.PacketBase;

public class NetHandler extends Thread {
	List<ClientConnection> connects = new ArrayList<ClientConnection>();
	ServerSocket server;
	
	public NetHandler(){
		try{
			server = new ServerSocket(7888);
			this.start();
		}catch(IOException iox){
			
		}catch(IllegalThreadStateException illeg){
			System.out.println("ThreadState!!!");
		}
	}
	
	public int getConnections(){
		if(connects.size()>0){
			return this.connects.size();
		}else{
			return 0;
		}
	}
	
	public void updateConnections(boolean sendPack, PacketBase pack){
		
		if(connects.size()>0){
			
			for(ClientConnection co : connects){
				if(co.isDisconnected())
				if(sendPack){
					co.sendPacket(pack);
					try {
						System.out.println(co.ins.readInt());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
					co.onUpdate();

				
			
			}
		}
	}
	
	public void addConnection(Socket client){
		connects.add(new ClientConnection(client));
	}
	
	public void onUpdate(){
		this.updateConnections(false, null);
	}
	@Override
	public void run(){
		this.acceptConnect();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void acceptConnect() {
		try{
			Socket sock = server.accept();
			if(sock != null){
				System.out.println("CONNECTED!!!");
				this.addConnection(sock);
			}
			this.updateConnections(false, null);
		}catch(IOException iox){
			//iox.printStackTrace();
			System.out.println("failed");
		}
	}

	public void startServerNet(int port) throws IOException{
		server = new ServerSocket(port);
		
	}
	
	public void sendPacket(PacketBase pack){
		updateConnections(true, pack);
	}
}
