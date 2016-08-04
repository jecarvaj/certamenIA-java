
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
public class Panel extends JPanel implements ActionListener {
     BufferedImage fondo; 
     public Lienzo lienzo;
     public JButton reiniciar, salir;
    public Panel(){
        
        lienzo=new Lienzo();
        
                 lienzo.label=new JLabel();
                lienzo.label.setBounds(0,100, 200, 300);
                //label.setText("holaaaAAAA");
                lienzo.label.setFont(new java.awt.Font("JFRockSolid", 0, 15));
                lienzo.label.setForeground(Color.GREEN);
                lienzo.label.setVisible(true);
                
                reiniciar=new JButton("Again");
                salir = new JButton("Exit");
                salir.addActionListener(this);
                reiniciar.addActionListener(this);
                this.setBackground(Color.BLACK);
                this.add(lienzo.label);
                //this.add(reiniciar);
                this.add(salir);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==salir){
            System.exit(0);
        }
    }
}
    
//     @Override
//    public void paintComponent(Graphics g){
//        Dimension d = getSize();
//             
//        
//        try {
//            fondo = ImageIO.read(new File("images/panel.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
//        g.drawImage(fondo,0,0,200, 800, null);        
//        setOpaque(false);
//        
//    }
//}
