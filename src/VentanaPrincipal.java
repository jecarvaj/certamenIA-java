
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */
public class VentanaPrincipal {
    //public JLabel label;
    public VentanaPrincipal(){
        Lienzo lienzo;
             Panel panel=new Panel();
             // lienzo=new Lienzo();
              
//                lienzo.label=new JLabel();
//                lienzo.label.setBounds(1,10, 200, 300);
//                label.setText("holaaaAAAA");
//                lienzo.label.setVisible(true);
              
             panel.setVisible(true);
             panel.setSize(panel.lienzo.laberinto.largo,64 );
//             panel.setFocusable(true);
//             panel.requestFocus();
             //panel.add(lienzo.label);
            
//               panel.lienzo.setFocusable(true);
//                  panel.lienzo.requestFocus();
       
            panel.lienzo.setSize(panel.lienzo.laberinto.ancho, panel.lienzo.laberinto.largo);
            JFrame ventana=new JFrame();
            ventana.setSize(panel.lienzo.laberinto.ancho, panel.lienzo.laberinto.largo+64);
               ventana.setFocusable(true);
            ventana.requestFocus();
            ventana.setVisible(true);
            
            ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
            ventana.setLayout(new BorderLayout());
            ventana.getContentPane().add(panel.lienzo, BorderLayout.CENTER);
            ventana.getContentPane().add(panel, BorderLayout.SOUTH);
            //ventana.setS
    
    }
}
