package minerMan.network.connection;

import java.io.IOException;
import java.net.Socket;

public class NetHandler extends Thread {
	private int port;
	private String ip;
	
	private Socket socket;
	
	public NetHandler(int port, String ip){
		this.port = port;
		this.ip = ip;
	}
	
	public void connect(){
		
		try {
			socket = new Socket(ip, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void onUpdate(){
		this.connect();
		
	}
	
	@Override
	public void run(){
		//reconnect
	}
}
