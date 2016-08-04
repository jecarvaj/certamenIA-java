/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;


public class Jugador implements Constantes{
    
    public Laberinto laberinto;
    public int i_jugador,j_jugador;
    int contDerecha=0, contIzquierda=0, contArriba=0, contAbajo=0;
    int comidaCapturada=0;
    public BusquedaAnchura2 busqueda;
    
    public char numero;
    public Jugador(Laberinto l) {
        
        laberinto=l;
        i_jugador=13;
        j_jugador=6;
        laberinto.casillas[i_jugador][j_jugador].tipo='J';
       
        //tarea=new BusquedaAnchura(laberinto);
//        tarea.run();
    }
     public void mover_arriba(){
          char index='p';
             contIzquierda=contDerecha=contAbajo=0;
          contArriba++;
     switch(laberinto.jugador.busqueda.cont_numero){
             //case 0: numero='1';break;
                       case 1: numero='1';break;
                       case 2: numero='2';break;
                        case 3: numero='3';break;
                       case 4: numero='4';break;
        
        }
        if (j_jugador < altoGameWorld-1 ) {
            for (int k = 0; k < 8; k++) {
           
               switch (k){
                   case 0: index='1';break;
                       case 1: index='2';break;
                           case 2: index='3';break;
                               case 3: index='4';break;
                                   case 4: index='5';break;
                                case 5: index='6';break;
                                case 6: index='7';break;
                                case 7: index='8';break;
               }
           
            
            if ( laberinto.casillas[i_jugador][j_jugador-1].tipo==index) {
                
                System.out.println("entro al ifffff");
               laberinto.casillas[i_jugador][j_jugador].tipo='C';
               j_jugador-=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador][j_jugador-1].tipo=index;
              //laberinto.casillas[i_jugador][j_jugador].tipo=tipo;
               System.out.println("Jugador paso a :"+i_jugador+" ,"+j_jugador);
             
            
        break;
        } 
        }
             if ( laberinto.casillas[i_jugador][j_jugador-1].tipo=='C' &&
                    laberinto.jugador.busqueda.objAlcanzado)
                    {
                   if(contArriba==1){
                   //laberinto.casillas[i_jugador][j_jugador].tipo='C';
               // laberinto.casillas[i_jugador][j_jugador+1].tipo='K';
                laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
                 laberinto.casillas[i_jugador][j_jugador-1].tipo=numero;
                   
                   }else{     
                laberinto.casillas[i_jugador][j_jugador].tipo='C';
               // laberinto.casillas[i_jugador][j_jugador+1].tipo='K';
                laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
                //laberinto.casillas[i_jugador][j_jugador-1].tipo='K';
                
                
                
               j_jugador-=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador][j_jugador-1].tipo=numero;}}
             
            else if(laberinto.casillas[i_jugador][j_jugador-1].tipo=='C'){
                 laberinto.casillas[i_jugador][j_jugador].tipo='C';
               j_jugador-=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
            
            }
        }
       else {
            System.out.println("Imposible subir");
        }
    }
     
      public void mover_abajo(){
            contIzquierda=contDerecha=contArriba=0;
            contAbajo++;
        switch(laberinto.jugador.busqueda.cont_numero){
             //case 0: numero='1';break;
                       case 1: numero='1';break;
                       case 2: numero='2';break;
                        case 3: numero='3';break;
                       case 4: numero='4';break;
        
        }
        if (j_jugador < altoGameWorld-1 ) {
            for (int k = 0; k < 8; k++) {
               char index='p';
               switch (k){
                   case 0: index='1';break;
                       case 1: index='2';break;
                           case 2: index='3';break;
                               case 3: index='4';break;
                                   case 4: index='5';break;
                                case 5: index='6';break;
                                case 6: index='7';break;
                                case 7: index='8';break;
               }
           
            
            if ( laberinto.casillas[i_jugador][j_jugador+1].tipo==index) {
                
                System.out.println("entro al ifffff");
               laberinto.casillas[i_jugador][j_jugador].tipo='C';
               j_jugador+=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador][j_jugador+1].tipo=index;
              //laberinto.casillas[i_jugador][j_jugador].tipo=tipo;
               System.out.println("Jugador paso a :"+i_jugador+" ,"+j_jugador);
                if(j_jugador==altoGameWorld-3){
           laberinto.casillas[i_jugador][j_jugador].tipo=index; 
                      j_jugador+=1;
                       laberinto.casillas[i_jugador][j_jugador].tipo='J'; 
            }
            
        break;
        } 
        }
             if ( laberinto.casillas[i_jugador][j_jugador+1].tipo=='C' &&
                    laberinto.jugador.busqueda.objAlcanzado)
                    {
                  if(contAbajo==1){
                   //laberinto.casillas[i_jugador][j_jugador].tipo='C';
               // laberinto.casillas[i_jugador][j_jugador+1].tipo='K';
                laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
                //laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
                 laberinto.casillas[i_jugador][j_jugador+1].tipo=numero;
                   
                   }else{     
                laberinto.casillas[i_jugador][j_jugador].tipo='C';
               // laberinto.casillas[i_jugador][j_jugador+1].tipo='K';
                laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
                //laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
                
                  
               j_jugador+=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador][j_jugador+1].tipo=numero;}}
            else if(laberinto.casillas[i_jugador][j_jugador+1].tipo=='C'){
                 laberinto.casillas[i_jugador][j_jugador].tipo='C';
               j_jugador+=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
            
            }
        }
       else {
            System.out.println("Imposible subir");
        }
    }
      
      
       public void mover_izquierda(){
              contArriba=contDerecha=contAbajo=0;
              contIzquierda++;
        switch(laberinto.jugador.busqueda.cont_numero){
             //case 0: numero='1';break;
                       case 1: numero='1';break;
                       case 2: numero='2';break;
                        case 3: numero='3';break;
                       case 4: numero='4';break;
        
        }
        if (i_jugador > 0 ) {
            for (int k = 0; k < 8; k++) {
               char index='p';
               switch (k){
                   case 0: index='1';break;
                       case 1: index='2';break;
                           case 2: index='3';break;
                               case 3: index='4';break;
                                case 4: index='5';break;
                                case 5: index='6';break;
                                case 6: index='7';break;
                                case 7: index='8';break;
               }
           
            
            if ( laberinto.casillas[i_jugador-1][j_jugador].tipo==index) {
                
                System.out.println("entro al ifffff");
               laberinto.casillas[i_jugador][j_jugador].tipo='C';
               i_jugador-=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador-1][j_jugador].tipo=index;
              //laberinto.casillas[i_jugador][j_jugador].tipo=tipo;
               System.out.println("Jugador paso a :"+i_jugador+" ,"+j_jugador);
                if(i_jugador==1){
            laberinto.casillas[i_jugador][j_jugador].tipo=index; 
                      i_jugador-=1;
                     laberinto.casillas[i_jugador][j_jugador].tipo='J'; 
            }
            break; 
        
        }
        }
             if ( laberinto.casillas[i_jugador-1][j_jugador].tipo=='C' &&
                    laberinto.jugador.busqueda.objAlcanzado)
                    {
                         if(contIzquierda==1){
                  // laberinto.casillas[i_jugador][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
                //laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
               // laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
                 laberinto.casillas[i_jugador-1][j_jugador].tipo=numero;
                   
                   }else{     
                laberinto.casillas[i_jugador][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
               // laberinto.casillas[i_jugador-1][j_jugador].tipo='K';
                //laberinto.casillas[i_jugador+1][j_jugador].tipo='K';
                laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
                
                 
                
               i_jugador-=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador-1][j_jugador].tipo=numero;}}
            else if(laberinto.casillas[i_jugador-1][j_jugador].tipo=='C'){
                 laberinto.casillas[i_jugador][j_jugador].tipo='C';
               i_jugador-=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
            
            }
        }
       else {
            System.out.println("Imposible subir");
        }
    }
       
       public void mover_derecha(){
          contIzquierda=contArriba=contAbajo=0;
          contDerecha++;
        switch(laberinto.jugador.busqueda.cont_numero){
             //case 0: numero='1';break;
                       case 1: numero='1';break;
                       case 2: numero='2';break;
                        case 3: numero='3';break;
                       case 4: numero='4';break;
        
        }
        if (i_jugador < anchoGameWorld-1 ) {
            for (int k = 0; k < 8; k++) {
               char index='p';
               switch (k){
                   case 0: index='1';break;
                       case 1: index='2';break;
                           case 2: index='3';break;
                               case 3: index='4';break;
                                   case 4: index='5';break;
                                case 5: index='6';break;
                                case 6: index='7';break;
                                case 7: index='8';break;
               }
           
            
            if ( laberinto.casillas[i_jugador+1][j_jugador].tipo==index) {
                
                System.out.println("entro al ifffff");
               laberinto.casillas[i_jugador][j_jugador].tipo='C';
               i_jugador+=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador+1][j_jugador].tipo=index;
              //laberinto.casillas[i_jugador][j_jugador].tipo=tipo;
               System.out.println("Jugador paso a :"+i_jugador+" ,"+j_jugador);
                if(i_jugador==anchoGameWorld-2){
                     laberinto.casillas[i_jugador][j_jugador].tipo=index; 
                      i_jugador+=1;
                       laberinto.casillas[i_jugador][j_jugador].tipo='J'; 
            }
            
         break;
        }
        }
             if ( laberinto.casillas[i_jugador+1][j_jugador].tipo=='C' &&
                    laberinto.jugador.busqueda.objAlcanzado)
                    {
                         if(contDerecha==1){
                  // laberinto.casillas[i_jugador][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
                //laberinto.casillas[i_jugador-1][j_jugador].tipo='C';
               // laberinto.casillas[i_jugador+1][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
                 laberinto.casillas[i_jugador+1][j_jugador].tipo=numero;
                   
                   }else{     
                laberinto.casillas[i_jugador][j_jugador].tipo='C';
                laberinto.casillas[i_jugador][j_jugador+1].tipo='C';
               // laberinto.casillas[i_jugador-1][j_jugador].tipo='K';
                //laberinto.casillas[i_jugador+1][j_jugador].tipo='K';
                laberinto.casillas[i_jugador][j_jugador-1].tipo='C';
 
               i_jugador+=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
               laberinto.casillas[i_jugador+1][j_jugador].tipo=numero;}}
            else if(laberinto.casillas[i_jugador+1][j_jugador].tipo=='C'){
                 laberinto.casillas[i_jugador][j_jugador].tipo='C';
               i_jugador+=1;
               laberinto.casillas[i_jugador][j_jugador].tipo='J';
            
            }
        }
       else {
            System.out.println("Imposible subir");
        }
    }
    

    
    
}


