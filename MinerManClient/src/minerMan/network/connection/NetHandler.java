package minerMan.network.connection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NetHandler extends Thread {
	private int port;
	private String ip;
	
	private Socket socket;
	private OutputStream out;
	private BufferedWriter bw;
	
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
		if(this.socket == null){
			this.connect();
		}else{
			if(out == null){
				try{
				out = socket.getOutputStream();
				}catch(IOException iox){
					iox.printStackTrace();
				}
			}else{
				try {
					out.write(1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	@Override
	public void run(){
		//reconnect
	}
}
