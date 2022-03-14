
package esquivandovacas;

import javax.swing.JFrame;

/**
 *
 * @author Alejandro Pereiro G
 * @author David Braga
 */
public class Main{

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventanaJ = new JFrame("Esquivando Vacas"); //creamos una ventana JFrame para ver el juego
        Juego juego = new Juego(); //instanciamos un objeto juego
        ventanaJ.setVisible(true); //permitimos que el JFrame se vea en panatalla
        ventanaJ.add(juego); //añadimos el objeto juego al JFrame
        ventanaJ.setSize(600, 600); //le damos tamaño al JFrame
        ventanaJ.setLocation(450, 100); //le damos una localizacion al JFrame
        ventanaJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cerramos el juego cuando se cierre la ventana 
        int c = 1, contador = 1; //declaramos dos variables
        while(true){ //creamos un bucle infinito
            juego.moverCarretera(contador); //movemos la carretera
            while(c <= 1){ //mientras c sea menor o igual a uno
                juego.repaint(); //repintamos el juego con las nuevas localizaciones
                try {
                    Thread.sleep(5); //detenemos la ejecucion por cinco milisengundos para que parezca que se mueve la carretera continuamente
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
                c++; //aumentamos el valor de c
            }
            c = 1; //devolvemos el valor de c a uno
            contador++; //aumentamos el valor del contador 
            if(juego.numV < 4 && contador % 200 == 0){ //si hay menos de cuatro vacas y el contador llega a 200
                juego.vY[juego.numV] = 0; //le damos posiciones iniciales a las vacas
                int p = (int)(Math.random()*100)%4; //creamos un numero random entre cero y cien y lo divimos entre cuatro 
                if(p == 0) //si p es igaul a cero
                    p = 135; //ponemos a la vaca en la primera posicion
                else if(p == 1) //si p es igual a uno
                    p = 190; //ponemos a la vaca en la segunda posicion
                else if(p == 2) //si p es igual a dos
                    p = 275; //ponemos a la vaca en la tercera posicion
                else //si es cualquier otro numero
                    p = 340; //ponemos a la vaca en la cuarta posicion
                juego.vX[juego.numV] = p; //asiganmos la posicion a una vaca
                if(juego.nivel < 5) //si el nivel es menor que cinco
                    juego.velV[juego.numV] = 2; //la velocidad de las vacas es dos
                else if(juego.nivel >= 5 && juego.nivel < 10) //si el nivel es mayor o igual a cinco y menor de diez
                    juego.velV[juego.numV] = 3; //la velocidad de las vacas es tres
                else if(juego.nivel >= 10) //si el nivel es mayor o igual a diez 
                    juego.velV[juego.numV] = 4; //la velocidad de las vacas es cuatro
                juego.numV++; //aumentamos el numero de vacas
            }
        }   
    }
}
