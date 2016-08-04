import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author ian
 */


public class Lienzo extends Canvas implements Constantes{
    
    public Laberinto laberinto;
   // public Adversario adversario,adversario2;
    public Timer lanzadorTareas;
    public Image imagenAuxiliar;
    public Graphics graficoAuxiliar;
    public Image fondo;
    public JLabel label;
     //BusquedaAnchura buscar;
    //public Adversario adversario1;
    
    public Lienzo(){
      
        laberinto=new Laberinto(this);
        //adversario=new Adversario(laberinto);
        //adversario2=new Adversario(laberinto);
        //buscar=new BusquedaAnchura(laberinto);
        label=new JLabel();
//                 label.setBounds(10,10, 200, 300);
//               // label.setText("holaaaAAAA");
//                label.setVisible(true);
       
        try {
           fondo = ImageIO.read(new File("images/map6.png"));
        } catch (IOException e) {
           System.out.println(e.toString()); 
        } 
        this.setSize(laberinto.ancho, laberinto.largo);
//      
//        System.out.println("empieza a buscar bucscar");
//         laberinto.jugador.tarea.buscar();
//         System.out.println("termina de buscarbuscar");
//        System.out.println("aqui empieza a calcular ruta");
//        laberinto.jugador.tarea.calcularRuta();
        //laberinto.jugador.tarea.run();
        //eventos de teclado
//        laberinto.adversario1.buscamalo.buscar();
  //      laberinto.adversario1.buscamalo.calcularRuta();
        
//        for (int i=0;i< anchoGameWorld; i++){
//            for (int j=0;j<altoGameWorld; j++){
//                if(laberinto.casillas[i][j].tipo=='x')laberinto.casillas[i][j].tipo='C';
//            }  
//        }
        
        addKeyListener(new java.awt.event.KeyAdapter() {
           @Override
           public void keyReleased(KeyEvent e) {
           //public void keyPressed(KeyEvent e) {
              laberinto.chequearTecla(e);
              repaint();
           }
        });
        
       //adversario1 = new Adversario(laberinto);
      //laberinto.jugador.tarea.buscar();
      //laberinto.jugador.tarea.calcularRuta();
       
        lanzadorTareas=new Timer();
        //lanzadorTareas.scheduleAtFixedRate(adversario,0,500);
        //lanzadorTareas.scheduleAtFixedRate(adversario2,0,500);
       // lanzadorTareas.scheduleAtFixedRate(laberinto.adversario1.buscamalo,0,1550);
       //lanzadorTareas.scheduleAtFixedRate(laberinto.adversario2.buscamalo,0,1550);
        //lanzadorTareas.scheduleAtFixedRate(laberinto.adversario3.buscamalo,0,900);
       // lanzadorTareas.scheduleAtFixedRate(laberinto.adversario4.buscamalo,0,900);
        lanzadorTareas.scheduleAtFixedRate(laberinto.jugador.busqueda,0,200);
      
       
    }
    
    //pintamos y evitamos el parpadeo
    @Override
    public void update(Graphics g) {
         if(graficoAuxiliar==null){
          imagenAuxiliar=createImage(this.getWidth(),this.getHeight());
          graficoAuxiliar=imagenAuxiliar.getGraphics();
       }
       graficoAuxiliar.setColor(getBackground());
       graficoAuxiliar.fillRect(0,0,this.getWidth(),this.getHeight());
       
       graficoAuxiliar.drawImage(fondo, 0, 0, null); 
       laberinto.update(graficoAuxiliar);      
       
       g.drawImage(imagenAuxiliar, 0, 0, null);  
       laberinto.update(g);
       
    }
    @Override
    public void paint(Graphics g) {
       
        update(g);
       
    }
    
  
  
}
