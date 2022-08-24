package com.zainic.humathics.level.tile.spawn_level;

import com.zainic.humathics.graphics.Screen;
import com.zainic.humathics.graphics.Sprite;
import com.zainic.humathics.level.tile.Tile;

public class SpawnWallTile extends Tile {

	public SpawnWallTile(Sprite sprite) {
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

}
