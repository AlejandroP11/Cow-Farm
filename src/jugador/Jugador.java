
package jugador;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro Pereiro G
 * @author David Braga
 */
public abstract class Jugador extends JPanel{
    private int veloX, veloY; //velocidad del coche tanto en x como en y
    private boolean sube,baja,izq,der; //para saber hacia que lado se mueve el coche

    public int getVeloX() {
        return veloX;
    }

    public void setVeloX(int veloX) {
        this.veloX = veloX;
    }

    public int getVeloY() {
        return veloY;
    }

    public void setVeloY(int veloY) {
        this.veloY = veloY;
    }

    public abstract void paint(Graphics g, int juX, int juY);
    public abstract int restringirX(int juX);
    public abstract int restringirY(int juY);

    
    //metodo que utiliza la entrada del ususario para mover el coche
    public void moverJugador(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){ //si el usuario clickea la A o la fecha izquierda
            izq = true;
            veloX = -1; //mueve el coche a la izquierda
        }
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){//si el usuario clickea la D o la fecha derecha
            der = true;
            veloX = 1; //mueve el coche a la derecha
        }
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){//si el usuario clickea la W o la fecha arriba
            sube = true;
            veloY = -1; //mueve el coche arriba
        }
        if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){//si el usuario clickea la S o la fecha abajo
            baja = true;
            veloY = 1; //mueve el coche abajo
        }
    }
    
    //metodo que utiliza la entrada del usuario para detener el coche
    public void stopJugador(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
            izq = false;
            veloX = 0; //ponemos la velocidad del coche en cero
        }
        else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            der = false;
            veloX = 0; //ponemos la velocidad del coche en cero
        }
        else if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
            sube = false;
            veloY = 0; //ponemos la velocidad del coche en cero
        }
        else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
            baja = false;
            veloY = 0; //ponemos la velocidad del coche en cero
        }
    }
}
