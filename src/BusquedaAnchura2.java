
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */
public class BusquedaAnchura2 extends TimerTask implements Constantes {
        public Laberinto laberinto;
    public Jugador oponente;
    public ArrayList<Estado> colaEstados;
    public ArrayList<Estado> historial;
    public ArrayList<Character> pasos;
    public int index_pasos, cont_letra, cont_numero;
    public Estado inicial;
    public Estado objetivo;
    public Estado temp;
    public boolean exito;
    long tiempo_inicio, tiempo_final;//, tiempo_total;
    float tiempo_actual, tiempo_total=0;
    

      public static boolean parar=false, cazado=false, objAlcanzado=false,
            numero=true, letra=false;
    public BusquedaAnchura2(Laberinto laberinto)
    {   
        this.oponente=laberinto.jugador;
        this.laberinto=laberinto;
        this.colaEstados=new ArrayList<>();
        this.historial=new ArrayList<>();
        this.pasos=new ArrayList<>();
        cont_letra=0;
        cont_numero=0;
        //this.ventana=
   //     index_pasos=0;
        
//        x= laberinto.jugador.i_jugador;
//        y=laberinto.jugador.j_jugador;
        //x=34;
        //y=6;
//        x_malo=laberinto.adversario1.i_jugador;
//       y_malo=laberinto.adversario1.j_jugador;
//        inicial=new Estado(x_malo,y_malo,'N', null); //estado inicial
//        
//        colaEstados.add(inicial);
//        historial.add(inicial);
//        
//         
//        
//        objetivo=new Estado(laberinto.jugador.i_jugador,laberinto.jugador.j_jugador, 'N', null);
//        exito=false;
    }
    
    public void buscar(Estado inicial,Estado objetivo) {
        index_pasos=0;
    
        colaEstados.add(inicial);
        historial.add(inicial);
        
        this.objetivo=objetivo;
        exito=false;
        //System.out.println("entra a buscarrr");
        if ( inicial.equals(objetivo)) exito=true;
        
        while ( !colaEstados.isEmpty() && !exito ) {
           // System.out.println("buscandooo");
            //System.out.println(colaEstados);
            temp=colaEstados.get(0);
            colaEstados.remove(0);
            moverArriba(temp);
            moverAbajo(temp);
            moverIzquierda(temp);
            moverDerecha(temp);
        }
        
        if ( exito ) {
           // System.out.println("Ruta calculada");
            this.calcularRuta();
        }else {
           // System.out.println("La ruta no pudo calcularse");
        }
        
    }
    
    private void moverArriba(Estado e)
    {   
        int contiene=0;
        if(e.y>0){
            if(laberinto.casillas[e.x][e.y-1].camino!='N'){
                Estado arriba=new Estado(e.x, e.y-1, 'U', e);
                for (int i = 0; i < historial.size(); i++) {
                    if(historial.get(i).x==arriba.x
                     && historial.get(i).y==arriba.y){
                        contiene++;
                        break;
                    }
                    
                }
                
                if(contiene==0){
                    colaEstados.add(arriba);
                    historial.add(arriba);
                   // laberinto.casillas[e.x][e.y-1].tipo='x';
                    
                    if(arriba.equals(objetivo)){
                      //  laberinto.casillas[e.x][e.y-1].tipo='J';
                        objetivo=arriba;
                        exito=true;
                    }
                
            }}
                
        }
    }
    
     private void moverAbajo(Estado e)
    {
         int contiene=0;
        if(e.y<altoGameWorld-1){
            if(laberinto.casillas[e.x][e.y+1].camino!='N'){
                Estado abajo=new Estado(e.x, e.y+1, 'D', e);
                 for (int i = 0; i < historial.size(); i++) {
                    if(historial.get(i).x==abajo.x
                     && historial.get(i).y==abajo.y){
                        contiene++;
                         break;
                    }
                    
                }
                 if(contiene==0){
                    colaEstados.add(abajo);
                    historial.add(abajo);
                   // laberinto.casillas[e.x][e.y+1].tipo='x';
                    if(abajo.equals(objetivo)){
                       // laberinto.casillas[e.x][e.y+1].tipo='J';
                        objetivo=abajo;
                        exito=true;
                    }}
                
            }
                
        }
    }
     
      private void moverIzquierda(Estado e)
    {   
        int contiene=0;
        if(e.x>0){
            if(laberinto.casillas[e.x-1][e.y].camino!='N'){
                Estado izquierda=new Estado(e.x-1, e.y, 'L', e);
                 for (int i = 0; i < historial.size(); i++) {
                    if(historial.get(i).x==izquierda.x
                     && historial.get(i).y==izquierda.y){
                        contiene++;
                         break;
                    }
                    
                }
                 
                 if(contiene==0){
                    colaEstados.add(izquierda);
                    historial.add(izquierda);
                    //laberinto.casillas[e.x-1][e.y].tipo='x';
                    if(izquierda.equals(objetivo)){
                        //laberinto.casillas[e.x-1][e.y].tipo='J';
                        objetivo=izquierda;
                        exito=true;
                    }}
                
            }
                
        }
    }
      
       private void moverDerecha(Estado e)
    {   
        int contiene=0;
        if(e.x<anchoGameWorld-2){
            if(laberinto.casillas[e.x+1][e.y].camino!='N'){
                Estado derecha=new Estado(e.x+1, e.y, 'R', e);
                for (int i = 0; i < historial.size(); i++) {
                    if(historial.get(i).x==derecha.x
                     && historial.get(i).y==derecha.y){
                        contiene++;
                         break;
                    }
                    
                }
                
                if(contiene==0){
                    colaEstados.add(derecha);
                    historial.add(derecha);
                    // laberinto.casillas[e.x+1][e.y].tipo='x';
                    if(derecha.equals(objetivo)){
                        //laberinto.casillas[e.x+1][e.y].tipo='J';
                        objetivo=derecha;
                        exito=true;
                    }}
                
            }
                
        }
    }
//    
//    private void moverArriba(Estado e)
//    {   
//        int contiene=0;
//        if(e.y>0){
//            if(laberinto.casillas[e.x][e.y-1].tipo!='O'
//                    && laberinto.casillas[e.x][e.y-1].tipo!='P'){
//                Estado arriba=new Estado(e.x, e.y-1, 'U', e);
//                for (int i = 0; i < historial.size(); i++) {
//                    if(historial.get(i).x==arriba.x
//                     && historial.get(i).y==arriba.y){
//                        contiene++;
//                        break;
//                    }
//                    
//                }
//                
//                if(contiene==0){
//                     if (oponente.tipo=='m') {
//                       colaEstados.add(0,arriba);
//                     } else {
//                       colaEstados.add(arriba); 
//                        historial.add(arriba);}
//                    
//                    //laberinto.casillas[e.x][e.y-1].tipo='x';
//                    
//                    if(arriba.equals(objetivo)){
//                        //laberinto.casillas[e.x][e.y-1].tipo='J';
//                        objetivo=arriba;
//                        exito=true;
//                    }
//                
//            }}
//                
//        }
//    }
//    
//     private void moverAbajo(Estado e)
//    {
//         int contiene=0;
//        if(e.y<altoGameWorld-1){
//            if(laberinto.casillas[e.x][e.y+1].tipo!='O'
//              && laberinto.casillas[e.x][e.y+1].tipo!='P'){
//                Estado abajo=new Estado(e.x, e.y+1, 'D', e);
//                 for (int i = 0; i < historial.size(); i++) {
//                    if(historial.get(i).x==abajo.x
//                     && historial.get(i).y==abajo.y){
//                        contiene++;
//                         break;
//                    }
//                    
//                }
//                 if(contiene==0){
//                  if (oponente.tipo=='m') {
//                       colaEstados.add(abajo);
//                     } else {
//                       colaEstados.add(abajo); 
//                    historial.add(abajo);}
//                   // laberinto.casillas[e.x][e.y+1].tipo='x';
//                    if(abajo.equals(objetivo)){
//                        //laberinto.casillas[e.x][e.y+1].tipo='J';
//                        objetivo=abajo;
//                        exito=true;
//                    }}
//                
//            }
//                
//        }
//    }
//     
//      private void moverIzquierda(Estado e)
//    {   
//        int contiene=0;
//        if(e.x>0){
//            if(laberinto.casillas[e.x-1][e.y].tipo!='O'
//                    && laberinto.casillas[e.x-1][e.y].tipo!='P'){
//                Estado izquierda=new Estado(e.x-1, e.y, 'L', e);
//                 for (int i = 0; i < historial.size(); i++) {
//                    if(historial.get(i).x==izquierda.x
//                     && historial.get(i).y==izquierda.y){
//                        contiene++;
//                         break;
//                    }
//                    
//                }
//                 
//                 if(contiene==0){
//                      if (oponente.tipo=='m') {
//                       colaEstados.add(izquierda);
//                     } else {
//                       colaEstados.add(izquierda); 
//                    historial.add(izquierda);}
//                    //laberinto.casillas[e.x-1][e.y].tipo='x';
//                    if(izquierda.equals(objetivo)){
//                        laberinto.casillas[e.x-1][e.y].tipo='J';
//                        objetivo=izquierda;
//                        exito=true;
//                    }}
//                
//            }
//                
//        }
//    }
//      
//       private void moverDerecha(Estado e)
//    {   
//        int contiene=0;
//        if(e.x<anchoGameWorld-2){
//            if(laberinto.casillas[e.x+1][e.y].tipo!='O'
//                    && laberinto.casillas[e.x+1][e.y].tipo!='P'){
//                Estado derecha=new Estado(e.x+1, e.y, 'R', e);
//                for (int i = 0; i < historial.size(); i++) {
//                    if(historial.get(i).x==derecha.x
//                     && historial.get(i).y==derecha.y){
//                        contiene++;
//                         break;
//                    }
//                    
//                }
//                
//                if(contiene==0){
//                    if (oponente.tipo=='m') {
//                       colaEstados.add(0,derecha);
//                     } else {
//                       colaEstados.add(derecha); 
//                    historial.add(derecha);}
//                    // laberinto.casillas[e.x+1][e.y].tipo='x';
//                    if(derecha.equals(objetivo)){
//                        //laberinto.casillas[e.x+1][e.y].tipo='J';
//                        objetivo=derecha;
//                        exito=true;
//                    }}
//                
//            }
//                
//        }
//    }
//    
    public void calcularRuta()
    {
        
        //index_pasos=0;
       //// System.out.println("entra a calcular ruta");
        Estado predecesor=objetivo;
        do{
            pasos.add(0,predecesor.oper);
            predecesor=predecesor.predecesor;
        }while(predecesor!=null);
        //index_pasos=pasos.size()-1;
    }
    
    
    @Override
    public synchronized void run() {
        ////System.out.println("entra al rub de anchura");
        
       if ( ! parar ) {
          // System.out.println("distinto de parar");
          colaEstados.clear();
          historial.clear();
          pasos.clear(); 
      
          
           if(numero){ 
               laberinto.casillas[laberinto.crear.numeros.get(cont_numero).x][laberinto.crear.numeros.get(cont_numero).y].camino='S';
             this.buscar(new Estado(oponente.i_jugador,oponente.j_jugador,'N',null),
                      new Estado(laberinto.crear.numeros.get(cont_numero).x,
                              laberinto.crear.numeros.get(cont_numero).y,'N',null));
            tiempo_inicio = System.currentTimeMillis();
          }
          else if(letra){
              tiempo_final = System.currentTimeMillis();
               laberinto.casillas[laberinto.crear.letras.get(cont_letra).x][laberinto.crear.letras.get(cont_letra).y].camino='S';
                 this.buscar(new Estado(oponente.i_jugador,oponente.j_jugador,'N',null),
                      new Estado(laberinto.crear.letras.get(cont_letra).x,laberinto.crear.letras.get(cont_letra).y,'N',null));
               pasos.remove(pasos.size()-1);
            } 
           
         
          if ( pasos.size() > 1 ) {
             
              System.out.println("pasos seze "+pasos.size());
             switch(pasos.get(1)) {
                case 'D': oponente.mover_abajo();break;
                case 'U': oponente.mover_arriba(); break;
                case 'R': oponente.mover_derecha();break;
                case 'L': oponente.mover_izquierda();break;
             }
          
         //si es que se encuentran
             
                laberinto.lienzo.repaint();  
             
       }else{
              ;

            

                if(letra){
           numero=true;
                //JOptionPane.showMessageDialog(null,"the task has taken "+ ( time_end - time_start )/1000.0 +" milliseconds");
                    //laberinto.lienzo.label.setDoubleBuffered(true); 
           String labelLetra="hola";
           switch(cont_numero){
               case 1: labelLetra="Tiempo  1...A : ";break;
               case 2: labelLetra="Tiempo  2...B : ";break;
               case 3: labelLetra="Tiempo  3...C : ";break;
               case 4: labelLetra="Tiempo  4-D : ";break;
           }
            tiempo_actual=(float) (( tiempo_final - tiempo_inicio )/1000.0);
            tiempo_total=(float) (tiempo_total+tiempo_actual);
                    laberinto.lienzo.label.setText(labelLetra+ tiempo_actual +" segundos.               Acumulado: "+tiempo_total+" segundos");
                
                cont_letra++;
                laberinto.casillas[laberinto.crear.letras.get(cont_numero-1).x][laberinto.crear.letras.get(cont_numero-1).y].tipo='C';
                     letra=false;
                     objAlcanzado=false;
                if(cont_letra==4){
                    
                    JOptionPane.showMessageDialog(null,"Completado!   Tiempo Total : "+tiempo_total+" segundos");
            
                     
                         parar=true;
                       
                       // pararOponentes();
                       this.cancel();
                }}
           else if(numero){
              cont_numero++;
                 objAlcanzado=true;
                letra=true;
               numero=false;
           } 
       }
      }
       
    }   
    
}
