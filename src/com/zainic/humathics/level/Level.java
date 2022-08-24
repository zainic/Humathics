package com.zainic.humathics.level;

import com.zainic.humathics.graphics.Screen;
import com.zainic.humathics.level.tile.Tile;

public class Level {
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	public static Level spawn = new SpawnLevel("/levels/spawn.png");
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}
	
	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
		
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
				getTile(x, y).render(x, y, screen);
				
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		int coord = x + y * width;
		if (tiles[coord] == Tile.col_spawn_grass) return Tile.spawn_grass;
		if (tiles[coord] == Tile.col_spawn_hedge) return Tile.spawn_hedge;
		if (tiles[coord] == Tile.col_spawn_water) return Tile.spawn_water;
		if (tiles[coord] == Tile.col_spawn_wall1) return Tile.spawn_wall1;
		if (tiles[coord] == Tile.col_spawn_wall2) return Tile.spawn_wall2;
		if (tiles[coord] == Tile.col_spawn_floor) return Tile.spawn_floor;
		return Tile.voidTile;
	}
	
}
