package minerMan.game;

public class Timer extends Thread {
	private boolean wait;
	
	public Timer(){
		wait = true;
	}

	private long limitTo(){
		
		long waitTime = 1000 / MinerMan.GAME_FRAMERATE;
		
		return waitTime;
	}

	@Override
	public void run() {
		if(wait){
			try {
				Timer.sleep(limitTo());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//wait = false;
		
	}
}
