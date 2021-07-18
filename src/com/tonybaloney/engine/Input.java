package com.tonybaloney.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener{
	private GameContainer gc;
	private static final int NUM_KEYS = 256;
	private static final int NUM_BUTTONS = 5;
	
	
	private final boolean[] keys = new boolean[NUM_KEYS];
	private final boolean[] keysLast = new boolean[NUM_KEYS];
	
	private final boolean[] buttons = new boolean[NUM_BUTTONS];
	private final boolean[] buttonsLast = new boolean[NUM_BUTTONS];
	
	private int mouseX, mouseY;
	private int scroll;
	
	
	public Input(GameContainer gc) {
		this.gc = gc;
		mouseX = 0;
		mouseY = 0;
		scroll = 0;
		
		gc.getWindow().getCanvas().addKeyListener(this);
		gc.getWindow().getCanvas().addMouseMotionListener(this);
		gc.getWindow().getCanvas().addMouseListener(this);
		gc.getWindow().getCanvas().addMouseWheelListener(this);
	}

	public void update() {
		scroll = 0;
		for(int i = 0; i < NUM_KEYS; i++) {
			keysLast[i] = keys[i];
		}
		
		for(int i = 0; i < NUM_BUTTONS; i++) {
			buttonsLast[i] = buttons[i];
		}
	}
	
	public boolean isKey(int keycode) {
		return keys[keycode];
	}
	public boolean isKeyUp(int keycode) {
		return !keys[keycode] && keysLast[keycode];
	}
	public boolean isKeyDown(int keycode) {
		return keys[keycode] && !keysLast[keycode];
	}
	
	public boolean isButton(int button) {
		return buttons[button];
	}

	public boolean isButtonDown(int button) {
		return buttons[button] && !buttonsLast[button];
	}


	public boolean isButtonUp(int button) {
		return !buttons[button] && buttonsLast[button];
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll = e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = (int) (e.getX()/ gc.getScale());
		mouseY = (int) (e.getY()/ gc.getScale());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = (int) (e.getX()/ gc.getScale());
		mouseY = (int) (e.getY()/ gc.getScale());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() < NUM_BUTTONS) {
			buttons[e.getButton()] = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() < NUM_BUTTONS) {
			buttons[e.getButton()] = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < NUM_KEYS) {
			keys[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < NUM_KEYS) {
			keys[e.getKeyCode()] = false;
		}
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public int getScroll() {
		return scroll;
	}
}
