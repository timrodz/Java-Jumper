package jumper1.pkg1;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Runner {
    
    final int hspeed = 5;
    final int vspeed = -20;
    
    private Core core;
    private Obstacle obs;
    private Background bg1 = Core.getBg1();
    private Background bg2 = Core.getBg2();
    
    private int x = 100;
    private int y = 510;
    private int dx = 0;
    private int dy = 0;
    private int width = 49, height = 66;
    boolean hasJumped = false;

    public Runner(Core core) {
//        Accedemos las propiedades del panel(ancho, alto, etc)
        this.core = core;
    }
	
    public void update() {
        // Hace que se siga moviendo pero se detenga a la mitad
        if (dx < 0) {
            x+=dx * (int) 1.2; 
        }
        if (dx == 0) {
            bg1.bgdx = 0;
            bg2.bgdx = 0;
        }
	if (x <= 400 && dx > 0) {
            x+=dx * (int) 1.2;
        }
        if (x + dx <= 0) { 
            x = 0;
        }
        
       // if (x > 400 && dx > 0) {
            bg1.bgdx = -hspeed;
            bg2.bgdx = -hspeed;
        //}
           
//      if (collision()) {
//            System.out.println("lol");
//        }
        
        y+=dy;
        if (hasJumped == true) {
            dy+=1;
            if (y+dy >= core.getHeight() - 85) {
                dy =0;
                hasJumped = false;
            }
        }
        
    }
    
    public boolean collision() {
        return core.obs.getBounds().intersects(getBounds());
    }
    public boolean collisionf1() {
        return core.obs.getBoundsf1().intersects(getBounds());
    }

      public boolean collisionf2() {
        return core.obs.getBoundsf2().intersects(getBounds());
    }
       public boolean collisionf3() {
        return core.obs.getBoundsf3().intersects(getBounds());
    }
        public boolean collisionm() {
        return core.obs.getBoundsm().intersects(getBounds());
    }
         public boolean collisionfm1() {
        return core.obs.getBoundsm1().intersects(getBounds());
    }
          public boolean collisionm2() {
        return core.obs.getBoundsm2().intersects(getBounds());
    }
     
    public Rectangle getBounds() {
        return new Rectangle(x, y, 40, 40);
    }
	
    public void KeyPressed(KeyEvent e) {
    	switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            dx = -hspeed;
                break;
            case KeyEvent.VK_RIGHT:
            dx = hspeed;
                break;
            case KeyEvent.VK_SPACE:
            jump();
                break;
    	}
    }
    
    public void jump() {
        if (hasJumped == false) {
            dy = vspeed;
            hasJumped = true;
        }
    }
    
    public void KeyReleased(KeyEvent e) {
        dx = 0;
    }	
	
  
    // Getters, Setters

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }
    
}