package com.zainic.humathics.level.tile;

import com.zainic.humathics.graphics.Screen;
import com.zainic.humathics.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
		
	}
	
	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	
}
