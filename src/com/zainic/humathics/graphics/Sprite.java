package com.zainic.humathics.graphics;

public class Sprite {
	
	private int x, y;
	private SpriteSheet sheet;
	
	public final int SIZE;
	public int[] pixels;
	
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite grass1 = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite tree = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 4, 0, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 5, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x0000ff);
	
	// Spawn level sprites
	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_hedge = new Sprite(16, 1, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_wall1 = new Sprite(16, 0, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_wall2 = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
	public static Sprite spawn_floor = new Sprite(16, 1, 1, SpriteSheet.spawn_level);
	
	// Player sprites
	public static Sprite playerUp = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite playerDown = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite playerLeft = new Sprite(32, 3, 5, SpriteSheet.tiles);
	public static Sprite playerRight = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite playerUp1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite playerDown1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite playerLeft1 = new Sprite(32, 3, 6, SpriteSheet.tiles);
	public static Sprite playerRight1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite playerUp2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	public static Sprite playerDown2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	public static Sprite playerLeft2 = new Sprite(32, 3, 7, SpriteSheet.tiles);
	public static Sprite playerRight2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color) {
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	private void setColor(int color) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}
	}
	
	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
	
}
