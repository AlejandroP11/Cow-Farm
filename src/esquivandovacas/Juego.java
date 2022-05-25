
package esquivandovacas;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import jugador.*;
import LibreriaAlex.*;


/**
 *
 * @author Alejandro Pereiro G
 * @author David Braga
 */
public class Juego extends JPanel{

    int juY, juX; //localizacion del jugador
    int carX,carY; //localizacion de la carretera 
    Jugador coche = new Coche();
    int numV; //numero de vacas en la carretera
    int vX[], vY[]; //arrays que contienen las localizaciones de las vacas
    int velV[];

    Puntuacion puntuacion = new Puntuacion();
    int puntos, nivel; //numero de puntos y nivel en el que se encuentra
    boolean seAcabo; //para saber si se acabo la partida o no

    public Juego(){
        //Listener para obtener cuando una tecla es presionada y soltada
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {//cuando presionamos una tecla
                 coche.moverJugador(e);//mover el coche en la direccion indicada
            }

            @Override
            public void keyReleased(KeyEvent e) {//cuando soltamos la tecla
                coche.stopJugador(e);//dejar de mover el coche
            }
    });
        setFocusable(true);//indicamos que el JPanel es focuseable
        carX = carY = 999; //inicializamos la localizacion del cruce de carreteras a (-999,-999)
        juY = 300; //inicializamos los valores del jugador
        juX = 250;
        numV = 0; //inicializamos el numero de vacas
        vX = new int[20]; //inicializamos las posiciones de las vacas
        vY = new int[20];
        velV = new int[20]; //inicializamos la velocidad de las vacas
        puntos = 0; //inicializamos puntos
        nivel = 1; //inicializamos nivel
        seAcabo = false;//inicializamos se acabo en falso
    }
    //metodo para pintar todas las imagenes en la pantalla en posiciones especificas
    //la escena va a ser repintada cada vez que las posiciones cambian
    @Override
    public void paint(Graphics g){
        super.paint(g); //llamamos al metodo repaint 
        Graphics2D obj = (Graphics2D) g; //creamos un objeto de la clase Graphics2D para dibujar
        obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //usamos la clase RenderingHints para renderizar
        try{
            obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\OneDrive\\Documentos\\NetBeansProjects\\EsquivandoVacas\\Imagenes\\st_road2.png"), 0, 0 ,this);//dibujar la carretera principal
            if(carY <= 599 && carX <= 599) //si la localizacion del cruce de carretera es menor de 599 en x,y
                obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\OneDrive\\Documentos\\NetBeansProjects\\EsquivandoVacas\\Imagenes\\cross_road.png"),carX,carY,this);//dibujar el cruce de carreteras
            
            coche.paint(g, juX, juY);//dibujar al jugador

            if(seAcabo)//si se acabo es verdad
                obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\OneDrive\\Documentos\\NetBeansProjects\\EsquivandoVacas\\Imagenes\\vacaded.png"), juX -30, juY -30,this);//dibujar la imagen de choque

            if(this.numV > 0){//si el numero de vacas es mayor que cero
                for(int i = 0; i < this.numV; i++)//por cada vaca
                    obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\OneDrive\\Documentos\\NetBeansProjects\\EsquivandoVacas\\Imagenes\\capibara.png"),this.vX[i],this.vY[i],this);//dibujar vaca
                    }
            Font f = new Font("Times Roman", Font.BOLD + Font.ITALIC, 20);//inicializamos fuente
            g.setFont(f);//hacemos el set de la fuente 
            g.setColor(Color.red);//la ponemos de color rojo
            g.drawString("Nivel: "+nivel, 500, 50);//dibujamos la variable nivel
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    //metodo que mueve la carretera a traves de la ventana para que parezca que el coche avanza
    public void moverCarretera(int count){
        if(carY == 999 && carX == 999){ //si el cruce ha pasado
            if(count%10 == 0){  //despues de cierto tiempo
                carY = -599;    //mandar el cruce a -599
                carX = 0;
            }
        }
        else { //de no ser asi
            carY++; //seguir moviendo el cruce por la ventana
        }
        if(carY == 699 && carX == 0){ //si el cruce llega a 699
            carY = carX = 999; //llevarlo de nuevo al inicio
        }
 
        juX += coche.getVeloX(); //actualizar la posicion del coche
        juY += coche.getVeloY();
        
        juX = coche.restringirX(juX);
        juY = coche.restringirY(juY);
        
        for(int i = 0; i < this.numV; i++) //para todas las vacas
            this.vY[i] += velV[i]; //moverlas basandonos en la velocidad indicada
        
        int indice[] = new int[numV]; //creamos un Array de tipo int y le asignamos el tamaño del numero de vacas que tengamos
        for(int i = 0; i < numV; i++){ //por cada vaca que tengamos
            if(vY[i] <= 900) //si la posicion de la vaca enn y es menor o igual a 900
                indice[i] = 1; //ponemos en la posicion i del Array el valor uno
        }
        
        int c = 0; //creamos una variable de tipo int
        for(int i = 0; i < numV; i++){ //por cada vaca que tengamos
            if(indice[i] == 1){ //si el valor de la Array en la posicion i es igual a uno
                vX[c] = vX[i]; //le damos el valor de la poscion i a la poscion c 
                vY[c] = vY[i];
                velV[c] = velV[i];

                c++; //aumentamos c 
            }
        }
        
        puntos += numV - c; //los puntos se incrementan cada vez que pasa una vaca
        
        if(puntos==5){          //si tenemos cinco puntos
            int i = nivel + 1;  //declaramos acumulador y sumamos los niveles que tenemos mas uno
            nivel = i;          //nivel es igual al valor de i
            puntos = 0;         //volvemos a declarar puntos como cero
        }
        
        numV = c; 
        
        //Chequamos el choque
        int dif = 0; //la diferencia de posicion entre el coche y las vacas 
        for(int i = 0; i < numV; i++){ //por cada vaca
            dif = juX - vX[i]; //diferencia es la distancia entre el coche y las vacas
            if((vX[i] >= juX && vX[i] <= juX +65) || (vX[i]+65 >= juX && vX[i]+65 <= juX +65)){ //si se choca horizontalmente
                if(juY +50 >= vY[i] && !(juY >= vY[i]+50)){ //y si hay choque vertical
                    this.finaliza(); //se llama al metodo finaliza y se acaba el juego
                }
            }
        }
    }
        //metodo que se encarga de las funciones finales del juego
        public void finaliza(){
        seAcabo = true; //indicamos que el juego se ha acabado 
        String n = LeerDatos.leerString("Introduce tu nombre"); //le pedimos al jugador que introduzca su nombre
        Puntuacion pu = new Puntuacion(n, nivel, puntos); //creamos un objeto puntuacion con el nombre, nivel y puntos conseguidos
        pu.laMejorPuntuacion("puntuaciones.txt", "\\s*,\\s*", pu); //llamamos al metodo mejor puntuacion
        pu.escribirPuntuacion("puntuaciones.txt", "\\s*,\\s*", pu);//llamamos al metodo escribir puntuacion
        pu.verMejoresPuntuacion("puntuaciones.txt", "\\s*,\\s*");  //llamamos al metodo ver mejores puntuaciones
        String s=LeerDatos.leerString("Quieres volver a jugar? s/n"); //le preguntamos al jugador si quiere volver a jugar
        if(s.equalsIgnoreCase("s")){ //si el jugador responde que si 
            Main.main(null); //comenzamos el juego de nuevo
        }
        else //de no ser asi
            System.exit(0); //finalizamos el juego
    }
}
    
