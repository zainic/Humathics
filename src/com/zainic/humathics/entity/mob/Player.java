package com.zainic.humathics.entity.mob;

import com.zainic.humathics.Game;
import com.zainic.humathics.graphics.Screen;
import com.zainic.humathics.graphics.Sprite;
import com.zainic.humathics.input.Keyboard;
import com.zainic.humathics.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	@Override
	public void update() {
		int xa = 0, ya = 0;
		anim = (anim + 1) % 1000;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		}
		else {
			walking = false;
		}
		
		updateShooting();

	}
	
	private void updateShooting() {
		if (Mouse.getB() == Mouse.LMB) {
			double dirX = (double) Mouse.getX() - (Game.getWindowWidth() >> 1);
			double dirY = (double) Mouse.getY() - (Game.getWindowHeight() >> 1);
			double dir = Math.atan2(dirY, dirX);
			shoot(x, y, dir);
		}
	}

	@Override
	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.playerUp;
			if (walking) {
				if (anim % 30 > 15) {
					sprite = Sprite.playerUp1;
				}
				else {
					sprite = Sprite.playerUp2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.playerDown;
			if (walking) {
				if (anim % 30 > 15) {
					sprite = Sprite.playerDown1;
				}
				else {
					sprite = Sprite.playerDown2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.playerLeft;
			if (walking) {
				if (anim % 30 > 15) {
					sprite = Sprite.playerLeft1;
				}
				else {
					sprite = Sprite.playerLeft2;
				}
			}
		}
		if (dir == 1) {
			sprite =  Sprite.playerRight;
			if (walking) {
				if (anim % 30 > 15) {
					sprite = Sprite.playerRight1;
				}
				else {
					sprite = Sprite.playerRight2;
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite);
	}

}
