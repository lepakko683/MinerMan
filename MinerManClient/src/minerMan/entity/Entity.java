package minerMan.entity;

public class Entity {
	protected int id;
	
	protected double x, y;
	
	protected double velocityMultipler;
	
	protected double dX, dY;
	
	protected boolean canMove;
	
	public boolean isMoving(){
		if(dX != 0 || dY != 0){
			return true;
		}
		return false;
	}
	
	public void onUpdate(){
		
	}
	
}
