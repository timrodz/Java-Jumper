/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jumper1.pkg1;


import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;


/**
 *
 * @author TOSHIBA PC
 */
public class Jumper11 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws javazoom.jl.decoder.JavaLayerException
     */
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException  {
        // TODO code application logic here
        Menu menu = new Menu();
        /*BufferedInputStream file = new BufferedInputStream(new FileInputStream("src/Party.mp3"));
        Player musica = new Player(file);
        m.recibe(musica,menu);*/
        //new Thread(new CargaMusica()).start();
         
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
//        menu.setUndecorated(true);
        menu.setVisible(true);
        
        
    }
    

    
}
