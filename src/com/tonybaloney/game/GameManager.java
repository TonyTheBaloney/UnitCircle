package com.tonybaloney.game;


import com.tonybaloney.engine.AbstractGame;
import com.tonybaloney.engine.GameContainer;
import com.tonybaloney.engine.Renderer;
import com.tonybaloney.engine.gfx.ImageTile;

public class GameManager extends AbstractGame{
    
	private ImageTile unit_Circle;
	
	public GameManager(){
    	unit_Circle = new ImageTile("/Unit_Circle.png", 360,360);    
    }
	
    @Override
    public void update(GameContainer gc, float dt){
    	
    }
    
    float temp = 0;

    @Override
    public void render(GameContainer gc, Renderer r){
    	r.drawText("Unprofesionally made by: Tony", gc.getWidth()-350, 0, 0xff000000, r.STANDARD2X);
    	r.drawImage(unit_Circle, (gc.getWidth()/2)-180, (gc.getHeight()/2)-180);

    	//r.drawFillRect(gc.getInput().getMouseX() -16, gc.getInput().getMouseY() -16, 32, 32, 0xff00ffff);
    	if(gc.getCurrentUnit() == GameContainer.units.DEGREES) {
    		r.drawFillRect(gc.getWidth()-200, gc.getHeight()-100, 200, 100, 0xff17B67A);
    		r.drawText("Degrees", gc.getWidth()-190, gc.getHeight()-90, 0xffffffff, r.STANDARD4X);
    		r.drawText("0", 665, 260, 0xffff00ff, r.STANDARD2X);
    		r.drawText("30", 640, 175, 0xffff00ff, r.STANDARD2X);
    		r.drawText("45", 610, 135, 0xffff00ff, r.STANDARD2X);
    		r.drawText("60", 575, 100, 0xffff00ff, r.STANDARD2X);
    		r.drawText("90", 465, 70, 0xffff00ff, r.STANDARD2X);    		
    		r.drawText("120", 370, 90, 0xffff00ff, r.STANDARD2X);
    		r.drawText("135", 305, 135, 0xffff00ff, r.STANDARD2X);
    		r.drawText("150", 280, 175, 0xffff00ff, r.STANDARD2X);
    		r.drawText("180", 255, 260, 0xffff00ff, r.STANDARD2X);
    		r.drawText("210", 275, 350, 0xffff00ff, r.STANDARD2X);
    		r.drawText("225", 305, 390, 0xffff00ff, r.STANDARD2X);
    		r.drawText("240", 370, 440, 0xffff00ff, r.STANDARD2X);
    		r.drawText("270", 460, 455, 0xffff00ff, r.STANDARD2X);
    		r.drawText("300", 555, 435, 0xffff00ff, r.STANDARD2X);
    		r.drawText("315", 605, 400, 0xffff00ff, r.STANDARD2X);
    		r.drawText("330", 640, 355, 0xffff00ff, r.STANDARD2X);
    		r.drawText("360", 685, 260, 0xffff00ff, r.STANDARD2X);
    	}else if(gc.getCurrentUnit() == GameContainer.units.RADIANS) {
    		r.drawFillRect(gc.getWidth()-200, gc.getHeight()-100, 200, 100, 0xffEE2020);
    		r.drawText("Radians", gc.getWidth()-190, gc.getHeight()-90, 0xffffffff, r.STANDARD4X);
    		r.drawText("0", 665, 260, 0xffff00ff, r.STANDARDPI);
    		r.drawText("%/6", 640, 175, 0xffff00ff, r.STANDARDPI);
    		r.drawText("%/4", 610, 135, 0xffff00ff, r.STANDARDPI);
    		r.drawText("%/3", 575, 100, 0xffff00ff, r.STANDARDPI);
    		r.drawText("%/2", 465, 70, 0xffff00ff, r.STANDARDPI);    		
    		r.drawText("2%/3", 365, 85, 0xffff00ff, r.STANDARDPI);
    		r.drawText("3%/4", 290, 135, 0xffff00ff, r.STANDARDPI);
    		r.drawText("5%/6", 260, 175, 0xffff00ff, r.STANDARDPI);
    		r.drawText("%", 270, 260, 0xffff00ff, r.STANDARDPI);
    		r.drawText("7%/6", 260, 350, 0xffff00ff, r.STANDARDPI);
    		r.drawText("5%/4", 290, 390, 0xffff00ff, r.STANDARDPI);
    		r.drawText("4%/3", 360, 440, 0xffff00ff, r.STANDARDPI);
    		r.drawText("3%/2", 460, 455, 0xffff00ff, r.STANDARDPI);
    		r.drawText("5%/3", 555, 435, 0xffff00ff, r.STANDARDPI);
    		r.drawText("7%/4", 605, 400, 0xffff00ff, r.STANDARDPI);
    		r.drawText("11%/6", 640, 355, 0xffff00ff, r.STANDARDPI);
    		r.drawText("2%", 685, 260, 0xffff00ff, r.STANDARDPI);
    	}else if(gc.getCurrentUnit() == GameContainer.units.POSITIONS) {
    		r.drawFillRect(gc.getWidth()-200, gc.getHeight()-100, 200, 100, 0xff20E8EE);
    		r.drawText("Units", gc.getWidth()-190, gc.getHeight()-90, 0xffffffff, r.STANDARD4X);
    		r.drawText("(1,0)", 665, 260, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(&3/2,1/2)", 640, 175, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(&2/2,&2/2)", 610, 135, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(1/2,&3/2)", 575, 100, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(0,1)", 465, 70, 0xffff00ff, r.STANDARDPI);    		
    		r.drawText("(-1/2,&3/2)", 290, 90, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(-&2/2,&2/2)", 200, 135, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(-&3/2,1/2)", 190, 175, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(-1,0)", 235, 260, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(-&3/2,-1/2)", 180, 350, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(-&2/2,-&2/2)", 190, 390, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(-1/2,-&3/2)", 280, 440, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(0,-1)", 460, 455, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(1/2,-&3/2)", 555, 435, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(&2/2,-&2/2)", 605, 400, 0xffff00ff, r.STANDARDPI);
    		r.drawText("(&3/2,-1/2)", 640, 355, 0xffff00ff, r.STANDARDPI);
    	}else {
    		r.drawText("Towy dwoes nwot nwow how two code", 0, gc.getHeight()/2, 0xff00ff00, r.STANDARD4X);
    	}
    }


	public static void main(String args[]) {
        GameContainer gc = new GameContainer(new GameManager());
        //gc.setWidth(320);
        //gc.setHeight(240);
        gc.start();
	}
	
}
