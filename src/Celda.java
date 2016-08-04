
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


/**
 *
 * @author ian
 */

public class Celda extends JComponent implements Constantes {
    public int x,y;
    public char tipo, camino;
    public Boolean mover;
    public int indexSprite, indexSpriteMalos;
    public BufferedImage jugador,uno, dos, tres, cuatro, aaa, bbb, ccc,ok, ddd;
    public BufferedImage soldier[],secuenciaImg, malos[], secuencia2;

    
    public Celda(int x,int y,char tipo, char camino) {
        this.x=x; 
        this.y=y;
        this.tipo=tipo;
        this.camino=camino;
        indexSprite=0;
        indexSpriteMalos=0;
        
        try {
         jugador=ImageIO.read(new File("images/orange.png"));
           uno = ImageIO.read(new File("images/1.png"));
           dos = ImageIO.read(new File("images/2.png"));
            tres = ImageIO.read(new File("images/3.png"));
             cuatro = ImageIO.read(new File("images/4.png"));
              aaa = ImageIO.read(new File("images/a.png"));
               bbb = ImageIO.read(new File("images/b.png"));
                ccc = ImageIO.read(new File("images/c.png"));
                 ddd = ImageIO.read(new File("images/d.png"));
                // ok = ImageIO.read(new File("images/ok.png"));
           //cargamos imagenes sprites
         
           
//           secuenciaImg = ImageIO.read(new File("images/malos.png"));  
//           malos = new BufferedImage[3 * 4];
//           for(int i = 0; i < 3; i++) {
//              for(int j = 0; j < 4; j++) {
//                 malos[(i * 4) + j] = 
//                         secuenciaImg.getSubimage(i * sizeJugador, j * sizeJugador, sizeJugador, sizeJugador);
//              }
//           }
        
        } catch (IOException e) {
           System.out.println(e.toString()); 
        }  
        
    }
    
    @Override
    public void update(Graphics g) {
       switch(tipo) { 
           case 'J': g.drawImage(jugador,x,y, this); break;
               case '1': g.drawImage(uno,x,y, this); break;
                   case '2': g.drawImage(dos,x,y, this); break;
                       case '3': g.drawImage(tres,x,y, this); break;
                           case '4': g.drawImage(cuatro,x,y, this); break;
                               case '5': g.drawImage(aaa,x,y, this); break;
                                   case '6': g.drawImage(bbb,x,y, this); break;
                                       case '7': g.drawImage(ccc,x,y, this); break;
                                           case '8': g.drawImage(ddd,x,y, this); break;
                                           case 'K': g.drawImage(ok, x, y, this);break;
          // case 'O':  break; //OBSTACULO, NO PUEDE PASAR
          // case 'P': g.drawImage(comida,x,y, this); break;
           case 'C': break; //CAMINO
           //case 'A': g.drawImage(malos[indexSpriteMalos],x,y, this); break;
          // case 'M':  g.drawImage(muerto,x,y, this); break;
       }  
       
    }
    
    @Override
    public void paintComponent(Graphics g) {
        update(g);
    }
    
    
    public boolean dentro_area(int xp,int yp) {
       Rectangle r=new Rectangle(x,y,sizeCell,sizeCell);
       return r.contains(new Point(xp,yp)); 
   }
    

    
    
    
}