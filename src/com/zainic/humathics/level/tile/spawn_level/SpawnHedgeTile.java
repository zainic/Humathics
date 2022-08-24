package com.zainic.humathics.level.tile.spawn_level;

import com.zainic.humathics.graphics.Screen;
import com.zainic.humathics.graphics.Sprite;
import com.zainic.humathics.level.tile.Tile;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	@Override
	public boolean solid() {
		return true;
	}
	
	public boolean breakable() {
		return true;
	}

}
