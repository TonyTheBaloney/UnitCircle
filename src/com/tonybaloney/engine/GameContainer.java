package com.tonybaloney.engine;

public class GameContainer implements Runnable{
	private Thread thread;
	private boolean running = false;
	private final double UPDATE_CAP = 1.0/60.0;
	private int width = 960, height = 540;
	private float scale = 1f;
	private String title = "Tony's Unit Circle Project";
	private Window window;
	private Renderer renderer;
	private Input input;
	private AbstractGame game;
	
	public static enum units{
		RADIANS,
		DEGREES,
		POSITIONS;
	}
	
	public units currentUnit = units.DEGREES;
	
	public GameContainer (AbstractGame game) {
		this.game = game;
	}
	
	public synchronized void start() {
		window = new Window(this);
		renderer = new Renderer(this);
		input = new Input(this);
		thread = new Thread(this);
		thread.run();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Stop does nothing but i needed it to clear
	}
	
	public void run() {
		running = true;
		boolean render = false;
		double firstTime;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime;
		double unprocessedTime = 0;
		double frameTime = 0;
		int frames = 0;
		@SuppressWarnings("unused")
		int fps = 0;
		while(running) {
			render = false;
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			unprocessedTime += passedTime;
			frameTime += passedTime;
			while(unprocessedTime >= UPDATE_CAP) {
				unprocessedTime -= UPDATE_CAP;
				render = true;
				//TODO Update game
				
				game.update(this, (float)UPDATE_CAP);
				
		    	if(input.isButtonDown(1) && currentUnit == units.DEGREES) {
		    		currentUnit = units.RADIANS;
		    	}else if(input.isButtonDown(1) && currentUnit == units.RADIANS) {
		    		currentUnit = units.POSITIONS;
		    	}else if(input.isButtonDown(1) && currentUnit == units.POSITIONS) {
		    		currentUnit = units.DEGREES;
		    	}
		    	
		    	input.update();
				if(frameTime >= 1.0) {
					frameTime = 0;
					fps = frames;
					frames = 0;
				}
			}
			
			if(render) {
				renderer.clear();
				//whiet background
				renderer.drawFillRect(0, 0, width, height, 0xffffffff);
				//TODO render game
				game.render(this, renderer);
				//renderer.drawText("Mouse X "+input.getMouseX(), 0, 30, 0xff000000,Font.STANDARD);
				//renderer.drawText("Mouse Y "+input.getMouseY(), 0, 60, 0xff000000,Font.STANDARD);
				
				//renderer.drawText("FPS:" +  fps, 0, 0, 0xff00ffff,Font.STANDARD);
				window.update();
				frames++;
			}
			else {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) { e.printStackTrace(); }
			}
			
			
		}
		dispose();
	}
	
	private void dispose() {
		
	}

	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
	public float getScale() {return scale;}
	public void setScale(float scale) {this.scale = scale;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public Window getWindow() {return window;}
	public Input getInput() { return input; }
	public units getCurrentUnit() {return currentUnit;}
	public void setCurrentUnit(units currentUnit) {this.currentUnit = currentUnit;}
}

