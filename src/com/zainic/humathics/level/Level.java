package com.zainic.humathics.level;

import com.zainic.humathics.graphics.Screen;
import com.zainic.humathics.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	protected void generateLevel() {
		
	}
	
	private void loadLevel(String path) {
		
	}
	
	private void time() {
		
	}
	
	public void update() {
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = (xScroll >> 4) - 1;
		int y0 = (yScroll >> 4) - 1;
		int x1 = ((xScroll + screen.width) >> 4) + 1;
		int y1 = ((yScroll + screen.height) >> 4) + 1;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);;
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		int coord = x + y * width;
		if (tiles[coord] == 0) return Tile.grass;
		return Tile.voidTile;
	}
	
}
