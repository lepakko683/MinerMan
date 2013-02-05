package minerMan.game;

import minerMan.network.connection.NetHandler;

public class MinerMan {
	
	public static final String GAME_TITLE = "Miner Man";
	
	public static final String GAME_VERSION = "Alpha 0.1";
	
	public static final String Version = "a0.1";
	
	public static final int SCREEN_WIDTH = 640;
	
	public static final int SCREEN_HEIGHT = 480;
	
	public static final int GAME_FRAMERATE = 1;
	
	Timer timer = new Timer();
	NetHandler network;
	
	public boolean running;
	
	
	private void render() {}
	
	private void update() {
		System.out.println("exec");
		network.onUpdate();
		
	}
	
	private void gameLoop() {
		while(running){
			update();
			render();
			timer.run();
		}
		
	}
	
	public MinerMan() {
		this.running = true;
		network = new NetHandler(7888, "127.0.0.1");
		gameLoop();
	}
	
	public static void main(String[] args){
		new MinerMan();
		
	}
}