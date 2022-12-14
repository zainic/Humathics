package com.zainic.humathics.level.tile;

import com.zainic.humathics.graphics.Screen;
import com.zainic.humathics.graphics.Sprite;

public class RockTile extends Tile{

	public RockTile(Sprite sprite) {
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
