package jumper1.pkg1;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Obstacle {

    public int x = 900, xf = 64 , av = 0, x1 = 0, x2 = 200, x3 = 400, tobx = 25, mpx = 550, mpx1 = 0, mpx2 , bolenex = 780, xene ;
    public int yf = 64, y1 = -60, y2 = -30, y3 = 0 , toby = 67,mpy = 0, val = 0, gc = 25, i, aum = 30, bol = 1, boleney = 460;
    Random rnd = new Random();
    private double dx =  4.5;
    private int y , r, cond = 10;
    private int width = 36, height = 64;
    private Core core;
    
    public Obstacle(Core core) {
        this.core = core;
    }
    
    public void update() //Actualiza las posiciones de todos los obstaculos
    { 
            updateFuegoYEnergia();
            updateFlechas();
            updateMeteoros();
           
           
            if(x < 0 | bolenex < 0)// esta condicion valida la posicion del fuego para que pueda aparecer
            {
                x = 900;//posiciona el fuego en 900
                bolenex = 780;//posiciona la bola de energia frente al spartan
                av++;//el puntaje incrementa
                    if(av == gc && val == 0)
                    {
                        core.gano();// si el puntaje es igual a 25 el jugador gana
                    }
              
                if(av%5 == 0) // esta condicion valida la velocidad del que tienen los obstaculos
                {
                    dx = dx + 1;
                   }
            }        
    }
    
    public void draw(Graphics g) {
        y = core.getHeight() -85;
        FuegoYEnergia(g);
        Flechas(g);
        Meteoros(g);      
    }
    
    
    void FuegoYEnergia(Graphics g)
    {
        if(bol == 1)
            g.drawImage(core.img.fuego, x, y, core);// pinta el fuego
        else
            g.drawImage(core.img.energia, bolenex, boleney, core);//pinta la bola de energia
    }
    
    void Flechas(Graphics g)
    {
        g.drawImage(core.img.flecha1, x1, y1, core);
            g.drawImage(core.img.flecha1, x2 , y2, core);//estas tres lineas pintan las flechas 
            g.drawImage(core.img.flecha3, x3, y3, core);
    }
    
    void Meteoros(Graphics g)
    {
        if( av > 4 ) //valida el pintado del primer meteoro
          g.drawImage(core.img.met, mpx, mpy, core); 
        if(av > 9 ) //valida el pintado del primer meteoro
        {
            mpx1 = mpx +300;
            g.drawImage(core.img.met, mpx1, mpy, core);    
        } 
        if( av > 14 ) //valida el pintado del primer meteoro
        {
            mpx2 = mpx + 600;
           g.drawImage(core.img.met, mpx2, mpy, core);     
        }
    }
    
    public Rectangle getBounds() 
    {
        if(bol == 1)
             return new Rectangle(x, y, xf, yf);
       else
             return new Rectangle(bolenex, boleney, xf, yf);
    }
    
     public Rectangle getBoundsf1() {
        return new Rectangle(x1 , y1, tobx, toby);
    }
     
      public Rectangle getBoundsf2() {
        return new Rectangle(x2 , y2, tobx, toby);
    }
       public Rectangle getBoundsf3() {
        return new Rectangle(x3 , y3, tobx, toby);
    }
    
    public Rectangle getBoundsm()
    {
        return new Rectangle(mpx, mpy, 20, 20);
    }
    
    public Rectangle getBoundsm1()
    {
        return new Rectangle(mpx1, mpy, 20, 20);
    }
    public Rectangle getBoundsm2()
    {
        return new Rectangle(mpx2, mpy, 20, 20);
    }
    
    public int getX() {
        return x;
    }

    
    void updateFuegoYEnergia()
    {
        if(bol == 1)
        {
            x-=dx;//la psicion en x del fuego decrementa 
            if(x < 0)
            bol = 0;//bol cambia a 0 dandole el turno a la bola de energia
        }
        else
        {
            bolenex-=dx;//la bola de energia decrementa
            if(bolenex < 0)
            bol = 1;//bol cambia a 1 dandole el turno al fuego
        }
    }
    
    void updateFlechas()
    {
         y1+=dx; y2+=dx;y3+=dx;   // incrementan las posiciones en y de las flechas
         if(y1 > 600)
            {
                y1 = -60;
               x1 = rnd.nextInt(400); //le da una posision random a la fleya en x cuando esta sale de la pantalla
            }
            
            if(y2 > 600)
            {
                y2 = -30; 
                x2 = rnd.nextInt(400);//le da una posision random a la fleya en x cuando esta sale de la pantalla
            }
            
            if(y3 > 600)
            {
               y3 = 0; 
               x3 = rnd.nextInt(400);//le da una posision random a la fleya en x cuando esta sale de la pantalla
            }
    }
    
    void updateMeteoros()
    {
        if( av > 4 )// esta condicion valida la aparicion del meteoro
            {
                mpx-=dx;mpy+=dx;//la posicion del meteoro en x decrementa igual que la de y formando un angulo de 45° 
               if(mpy > 600)//esta condiion valida la si el meteoro esta fuera de pantalla para que vuelva a aparecer arriba
                   {
                     //r = rnd.nextInt((500 -700)+500);
                     mpy = 0;
                     //mpx = r;
                     mpx = 550;
                   }
            }
    }
}