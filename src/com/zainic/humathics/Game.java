package com.zainic.humathics;

import java.awt.*;
import java.awt.image.*;

import javax.swing.*;

import com.zainic.humathics.graphics.Screen;
import com.zainic.humathics.input.Keyboard;
import com.zainic.humathics.level.Level;
import com.zainic.humathics.level.RandomLevel;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	public static String title = "Humathics";
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private Screen screen;
	private Keyboard key;
	private Level level;
	
	public Game() {
		Dimension size = new Dimension(width*scale, height*scale);
		this.setPreferredSize(size);
		
		frame = new JFrame();
		screen = new Screen(width, height);
		key = new Keyboard();
		level = new RandomLevel(64,64);
		
		this.addKeyListener(key);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		this.requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta > 1) {
				tick();
				ticks++;
				delta--;
			}
			render();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(title + " | " + ticks + "ups, " + frames + "fps");
				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	int x=0, y=0;
	public void tick() {
		key.update();
		if (key.up) y--;
		if (key.down) y++;
		if (key.left) x--;
		if (key.right) x++;
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3); //triple buffering strategy
			return;
		}
		
		screen.clear();
		level.render(x, y, screen);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics(); //link between graphics and buffer
		g.setColor(new Color(255,99,33));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
		g.dispose(); //remove the graphics after not used
		bs.show(); //show the buffer that being calculated
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}

}
