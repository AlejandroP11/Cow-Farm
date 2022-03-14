
package esquivandovacas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro Pereiro G
 * @author David Braga
 */
public class Coche extends JPanel{
    int veloX, veloY; //velocidad del coche tanto en x como en y
    boolean sube,baja,izq,der; //para saber hacia que lado se mueve el coche
    public void paint(Graphics g, int cocheX, int cocheY){
        super.paint(g); //llamamos al metodo repaint 
        Graphics2D obj = (Graphics2D) g; //creamos un objeto de la clase Graphics2D para dibujar
        obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //usamos la clase RenderingHints para renderizar
        try{
            obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\OneDrive\\Documentos\\NetBeansProjects\\EsquivandoVacas\\Imagenes\\tractor.png"),cocheX,cocheY,this);   //dibuja el coche en la vetana
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    //metodo que utiliza la entrada del ususario para mover el coche
    public void moverCoche(KeyEvent e){
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
    public void stopCoche(KeyEvent e){
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
