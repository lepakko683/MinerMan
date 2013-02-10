package minerMan.tileFore;

import minerMan.item.tool.ToolType;

public enum TileForeMaterial {
	SOIL(1, 1f, new ToolType[]{ToolType.SHOVEL}),
	STONE(2, 3f, new ToolType[]{ToolType.PICKAXE});
	
	protected final int hardnessLevel;
	
	protected final float hardness;
	
	protected final ToolType[] harvestToolType;
	private TileForeMaterial(int hl, float h, ToolType[] tt){
		this.hardnessLevel = hl;
		this.hardness = h;
		this.harvestToolType = tt;
	}
	public int getHardnessLevel(){
		return this.hardnessLevel;
	}
	public float getHardness(){
		return this.hardness;
	}
	public ToolType[] getHarvestTools(){
		return this.harvestToolType;
	}
}
