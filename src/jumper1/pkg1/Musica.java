/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumper1.pkg1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author TOSHIBA PC
 */
            
public class Musica extends Thread{
    Player music = null;
    public Musica(String string){
        super(string);
    }
    
    @Override
    public void run()
    {
        Core c = new Core(/*this*/);
        try {

            try {
                music = new Player(new BufferedInputStream(new FileInputStream("src/resources/Party.mp3") ));
            } catch (JavaLayerException | FileNotFoundException ex) {
                Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              music.play();  
            
            
        } catch (JavaLayerException ex) {
            Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(c.obs.val == 1)
        {
            parar();
        }
    }
    
    public void parar() 
    {
        music.close();
        /*try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        this.stop(null);
    }
}
