/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumper1.pkg1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javazoom.jl.decoder.JavaLayerException;


/**
 *
 * @author TOSHIBA PC
 */
public class Core extends JPanel implements Runnable, KeyListener {

  
    Menu m;
    
   // Player musica;
      JFrame frame ;
    // Creando objetos
    Runner runner = new Runner(this);
    // Crea un fondo en (0, 0)
    static Background bg1 = new Background(0, 0);
    // Crea un fondo en (2000, 0) para que se repitan como 1, 2, 1, 2, etc.
    static Background bg2 = new Background(2000, 0);
    Obstacle obs = new Obstacle(this);
    // Crea el objeto para cargar las imagenes
    Images img = new Images();
    Timer timer;
    int DELAY = 30;
    int muerte=0;
    Thread musica;
    // Dimensiones por escala (300*3 = 900, 200 * 3 = 600)
    static final int ancho = 300, alto = 200, escala = 3;
    // Imagenes por segundo deseadas y se convierten a miliseg.
    private int FPS = 60;
    // Transformamos 60 segundos a milisegundos:
    private long tiempoDeseado = 1000 / FPS;
    // hilo que correra en run()
    Thread thread;
    
     public Core(/*Thread mus*/)  {
        super();
        setPreferredSize(new Dimension(ancho * escala, alto * escala));
        setFocusable(true);
        requestFocus();
       // musica = mus;
//        mus.start();
        //this.run();
    }
    @Override
    public void run() {
             while (true) {
            // métodos a repetir aquí
            update();
            repaint();
//            mus.start();
//            init();
            
            // Estrategia de bufer
            long inicio, tiempoTranscurrido, espera;
            
            inicio = System.nanoTime();
            
            tiempoTranscurrido = System.nanoTime() - inicio;
            
            espera = tiempoDeseado - tiempoTranscurrido / 1000000;
            
            if (espera < 0) espera = 5;
            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // Fin del bucle infinito
    }
    
    public void addNotify() {
        super.addNotify();
        if(thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }
    
      public void paint(Graphics g) {
        super.paint(g);
        // Para utilizar metodos mas avanzados de pintura:
//        Graphics2D g2d = (Graphics2D) g;
        // Contenido a dibujar
        img.loadImages();
        
        // Crea las 2 imagenes de fondo con las posiciones que les dimos cuando creamos el objeto
        g.drawImage(img.backgroundImage, bg1.getBgX(), bg1.getBgY(), this);
        g.drawImage(img.backgroundImage, bg2.getBgX(), bg2.getBgY(), this);
        g.drawString("PUNTAJE: "+ obs.av, 0, 50);
        if(obs.bol == 0)
        {
            g.drawImage(img.spartan, 780,460 ,32*3,34*3, this);
        }
        
        if(obs.val == 0)
        {
           g.drawImage(img.character, runner.getX(), runner.getY(), 49,66, this); 
        }
        else
        {
            g.drawImage(img.castdie, runner.getX(), runner.getY(), 49,66, this);
        }
        
       //g.fillRect(runner.getX(), runner.getY(), 49,66);
        obs.update();
        obs.draw(g);
    }
      
      public void update() {
        // Controla movimiento
        runner.update();
        bg1.update();
        bg2.update();
        //el siguiente if nos funciona para evitar de que mande el joption de que perdiste
        if(muerte<=0){
        if (runner.collision()) {
          // obs.c = 1;
          //obs.draw(null);
            if(obs.av < obs.gc)
              colision();
         
          
        } 
        
       
        
        
        if (runner.collisionf1()) {
           if(obs.av < obs.gc)
              colision();
        } 
        if (runner.collisionf2()) {
           if(obs.av < obs.gc)
              colision();
        } 
        if (runner.collisionf3()) {
           if(obs.av < obs.gc)
              colision();
        } 
        if (runner.collisionm()) {
           if(obs.av < obs.gc)
              colision();
        } 
        if (runner.collisionm2()) {
           if(obs.av < obs.gc)
              colision();
        } 
        
        
        }
        
        
        
        
    
    }
      
       void gano()
    {
        //menu perdio = new menu();
          JOptionPane.showMessageDialog(this, "En hora buena ¡HAS GANADO!, Tu puntaje fue de "+obs.av, "GAME OVER", JOptionPane.OK_OPTION);
        // perdio.setVisible(true);
        
           //el dispose cierra el frame cuando halla colision
         frame.dispose();
         Menu m=new Menu();
         m.setLocationRelativeTo(null);
         m.setResizable(false);
         m.setVisible(true);
         muerte++;
         
        thread.stop();
            
        
         //finalize ciuerra todos los procesos de esta clase
            try {
                this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    void colision()
    {
        muerte++;
         obs.val = 1;
        
         //paint(null);
        //menu perdio = new menu();
          JOptionPane.showMessageDialog(this, "Has perdido, Tu puntaje fue de "+obs.av, "GAME OVER", JOptionPane.OK_OPTION);
        // perdio.setVisible(true);
         m.musica.stop();
           //el dispose cierra el frame cuando halla colision
          
         Menu m=new Menu();
         m.setLocationRelativeTo(null);
         m.setResizable(false);
         m.setVisible(true);
         
         frame.dispose();
         
         
        thread.stop();
        
        
         //finalize ciuerra todos los procesos de esta clase
            try {
                this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    void cerrar()
    {
             Menu m=new Menu();
         m.setLocationRelativeTo(null);
         m.setResizable(false);
         m.setVisible(true);
         frame.dispose();
         muerte++;
         
        thread.stop();
        Musica mus = new Musica("HiloMusica");//HiloMusica es el nombre del proceso
                mus.parar();    
        
         //finalize ciuerra todos los procesos de esta clase
            try {
                this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void keyTyped(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
      {
          cerrar();
      }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        runner.KeyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       runner.KeyReleased(e);
    }
    
    public static Background getBg1() {
        return bg1;
    }

    public static Background getBg2() {
        return bg2;
    }
    
    public void recibe(JFrame kk) throws JavaLayerException, FileNotFoundException {
    frame=kk;
     
    }
     
}

