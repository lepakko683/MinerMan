package minerMan.tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import minerMan.tileFore.TileForeMaterial;
import minerMan.tileFore.WorldTileFore;

public class WorldTile {
	public enum TileType{
		FORE, BACK;
	}
	public static List<WorldTile> listTilesFore = new ArrayList<WorldTile>();
	private TileForeMaterial material;
	
	public WorldTile(int id, TileType type){
	}
	public void setMaterial(TileForeMaterial mat){
		this.material = mat;
	}
}
