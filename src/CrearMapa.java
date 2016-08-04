
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Ian
 */
public class CrearMapa implements Constantes {
    public static ArrayList<Celda> numeros;
    public static ArrayList<Celda> letras;
      public static ArrayList<Integer> posicionI, posicionJ, letraI, letraJ;
    
        public CrearMapa(Celda[][] casillas, int cantidad){
            
            
           // ponerObstaculos(casillas);
           ponerComida(casillas, cantidad);
            //crearGuarida(casillas);
            
        }
        
        
    static void ponerComida(Celda[][] casillas, int cantidad) {
            int i,j;
         numeros=new ArrayList<>();
         letras=new ArrayList<>();
         posicionI=new ArrayList<>();
         posicionJ=new ArrayList<>();
         letraI=new ArrayList<>();
         letraJ=new ArrayList<>();
         int numeroI, numeroJ;
         
            for (int n = 0; n< cantidad; n++) {
                numeroI=numeroAleatorio(3,anchoGameWorld-4);
                numeroJ=numeroAleatorio(3,altoGameWorld-4);
                if(!posicionI.contains(numeroI)&& !posicionJ.contains(numeroJ)){
                    posicionI.add(numeroI);
                     posicionJ.add(numeroJ);
                }else { n--;}
            }
            
           for (int k = 0; k < cantidad; k++) {
               char index='p';
               switch (k){
                   case 0: index='1';break;
                       case 1: index='2';break;
                           case 2: index='3';break;
                               case 3: index='4';break;
               }
               
             casillas[posicionI.get(k)][posicionJ.get(k)].tipo=index;
             casillas[posicionI.get(k)][posicionJ.get(k)].camino='N';
            numeros.add(new Celda(posicionI.get(k), posicionJ.get(k), index, 'N'));
            
        }
           
           for (int n = 0; n< cantidad; n++) {
               numeroI=numeroAleatorio(3,anchoGameWorld-4);
                numeroJ=numeroAleatorio(3,altoGameWorld-4);
                if(!letraI.contains(numeroI)&& !letraJ.contains(numeroJ)&&
                       !posicionI.contains(numeroI) && !posicionJ.contains(numeroJ) ){
                    letraI.add(numeroI);
                     letraJ.add(numeroJ);
                }else { n--;}
         }
           
           for (int k = 0; k < cantidad; k++) {
               char index='p';
               switch (k){
                   case 0: index='5';break;
                       case 1: index='6';break;
                           case 2: index='7';break;
                               case 3: index='8';break;
               }
               
             casillas[letraI.get(k)][letraJ.get(k)].tipo=index;
              casillas[letraI.get(k)][letraJ.get(k)].camino='N';
            letras.add(new Celda(letraI.get(k), letraJ.get(k), index, 'N'));
            
        }
//            casillas[posicionI.get(0)][posicionJ.get(0)].tipo='P';
//           // casillas[posicionI.get(0)][posicionJ.get(0)].es='1';
//            numeros.add(new Celda(posicionI.get(0), posicionJ.get(0), 'P'));
//            
//            casillas[posicionI.get(1)][posicionJ.get(1)].tipo='P';
//            //casillas[posicionI.get(1)][posicionJ.get(1)].es='2';
//            numeros.add(new Celda(posicionI.get(1), posicionJ.get(1), 'P'));
//            
//            casillas[posicionI.get(2)][posicionJ.get(2)].tipo='P';
//          //  casillas[posicionI.get(2)][posicionJ.get(2)].es='3';
//            numeros.add(new Celda(posicionI.get(2), posicionJ.get(2), 'P'));
//            
//            casillas[posicionI.get(3)][posicionJ.get(3)].tipo='P';
//            //casillas[posicionI.get(3)][posicionJ.get(3)].es='4';
//            numeros.add(new Celda(posicionI.get(3), posicionJ.get(3), 'P'));
            
    }
    
    
//    static void crearGuarida(Celda[][] casillas){
//        
//        for (int i = 12; i < 15; i++) {  //hierbas y parte de la base
//            
//                casillas[i][4]=new Celda(i+(i*sizeCell),
//                                    4+(4*sizeCell),'G');
//                   
//        }
//        
//    
//    }
//    static void ponerObstaculos(Celda[][] casillas) {
//        
//      //public void ponerObstaculos( Celda[][] casillas){
//    
//        for (int i = 0; i < 19; i++) {  //hierbas y parte de la base
//            for (int j = 0; j < 2; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//            }        
//        }
//        
//        for (int i = 10; i < 18; i++) {      //base jugador
//            for (int j = 2; j < 4; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//            }        
//        }
//        
//        
//            for (int j = 4; j < 8; j++) {  //piedras a la salida de la base
//                casillas[11][j]=new Celda(11+(11*sizeCell),
//                                    j+(j*sizeCell),'O');
//                casillas[15][j]=new Celda(15+(15*sizeCell),
//                                    j+(j*sizeCell),'O');
//            }        
//            
//        
//            for (int i = 0; i < 7; i++) {   
//            for (int j = 9; j < 16; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }        
//              }
//            
//            for (int i = 1; i < 6; i++) { //arbolito
//            
//                casillas[i][16]=new Celda(i+(i*sizeCell),
//                                    16+(16*sizeCell),'O');
//                        
//              }
//            
//            for (int j = 10; j < 15; j++) {
//            
//                casillas[7][j]=new Celda(7+(7*sizeCell),
//                                    j+(j*sizeCell),'O');
//                        
//              }
//            
//            for (int i = 4; i < 5; i++) {  //piedra chica
//            for (int j = 4; j < 6; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//            }}
//            
//            for (int i = 28; i <33; i++) {  //montania grande derecha/arriba
//                for (int j = 0; j <11; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//            casillas[32][10]=new Celda(32+(32*sizeCell),
//                                    10+(10*sizeCell),'C');
//            
//            for (int i = 25; i <29; i++) {  //montania grande derecha/arriba2
//                for (int j = 3; j <11; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//            
//            for (int i = 21; i <22; i++) {  //3 arboles juntos en columna al medio
//                for (int j = 6; j <13; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//            
//            for (int i = 16; i <20; i++) {  //3 arboles juntos en columna al medio
//                for (int j = 15; j <19; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//            casillas[16][15]=new Celda(16+(16*sizeCell),  //puntas de ese arbol
//                                    15+(15*sizeCell),'C');
//            casillas[19][15]=new Celda(19+(19*sizeCell),
//                                    15+(15*sizeCell),'C');
//            
//            for (int i = 13; i <15; i++) {  //floress
//                for (int j = 21; j <26; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//            
//            for (int i = 29; i <38; i++) {  //base de malos
//                for (int j = 21; j <30; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//            
//            for (int i = 18; i <25; i++) {  //montanita inferior
//                for (int j = 26; j <30; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//            casillas[18][26]=new Celda(18+(18*sizeCell),  //esquinas de esa montana
//                                    26+(26*sizeCell),'C');
//            casillas[24][26]=new Celda(24+(24*sizeCell),
//                                    26+(26*sizeCell),'C');
//            
//            for (int i = 32; i <38; i++) {  //montanita inferior
//                for (int j = 12; j <17; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//            
//            for (int i = 1; i <10; i++) {  //3 arboles juntos izquierda inferior
//                for (int j = 19; j <23; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//            
//             for (int i = 25; i <28; i++) {  //arbolito
//                for (int j = 15; j <18; j++) {
//                casillas[i][j]=new Celda(i+(i*sizeCell),
//                                    j+(j*sizeCell),'O');
//                }
//            }
//    
//    }
    
    
   
     
      static int numeroAleatorio(int minimo, int maximo) {
       Random random = new Random();
       int numero_aleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
       return numero_aleatorio;
    }

    
}

 
    
    
 

