package jumper1.pkg1;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Images {

    private ImageIcon player, bg, obs, f1,f2,bf, e,m, castm,s, ene;
    public Image character, backgroundImage, obstacle, flecha1, flecha2,flecha3, fuego, ex, met,castdie, spartan, energia;
    
    public void loadImages() {
        player = new ImageIcon(getClass().getResource("/resources/anima_more_fast.gif"));
        character = player.getImage();
        bg = new ImageIcon(getClass().getResource("/resources/bg.png"));
        backgroundImage = bg.getImage();
     /*   obs = new ImageIcon(getClass().getResource("/resources/avatarghost.png"));
        obstacle = obs.getImage();*/
       f1 = new ImageIcon(getClass().getResource("/resources/flecha psico .gif"));
        f2 = new ImageIcon(getClass().getResource("/resources/flecha psico .gif"));
        flecha1 = f1.getImage();
       // flecha2 = f1.getImage();
        flecha3 = f2.getImage();
        bf = new ImageIcon(getClass().getResource("/resources/boladefuegoo.gif"));
        fuego = bf.getImage();
        e = new ImageIcon(getClass().getResource("/resources/explo2.gif"));
        ex = e.getImage();
        m = new ImageIcon(getClass().getResource("/resources/meteorito.png"));
        met = m.getImage();
        castm = new ImageIcon(getClass().getResource("/resources/castoedie.png"));
        castdie = castm.getImage();
        s = new ImageIcon(getClass().getResource("/resources/spartan.gif"));
        spartan = s.getImage();
        ene = new ImageIcon(getClass().getResource("/resources/pollafinal.gif"));
        energia = ene.getImage();
    }    
    
}