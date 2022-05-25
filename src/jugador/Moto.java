package jugador;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Moto extends Jugador{
    @Override
    public void paint(Graphics g, int juX, int juY) {
        super.paint(g); //llamamos al metodo repaint
        Graphics2D obj = (Graphics2D) g; //creamos un objeto de la clase Graphics2D para dibujar
        obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //usamos la clase RenderingHints para renderizar
        try{
            obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\OneDrive\\Documentos\\NetBeansProjects\\EsquivandoVacas\\Imagenes\\moto.png"), juX, juY,this);   //dibuja el coche en la vetana
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public int restringirX(int juX) {
        if(juX < 145) {  //si el coche ha llegado o ha pasado el borde izquierdo
            juX = 145;   //mantenerlo en el borde minimo de x
            this.setVeloX(1);
            return juX;
        }

        if(juX +135 > 500) { //si el coche ha llegado o ha pasado el borde derecho
            juX = 500 - 135; //mantenerlo en el borde maximo de x
            this.setVeloX(-1);
            return juX;
        }
        return juX;
    }

    @Override
    public int restringirY(int juY) {
        //casos para restringir el moviento del coche para que no se salga de la carretera
        if(juY < 0) { //si el coche ha llegado o ha pasado el borde superior
            juY = 0;  //mantenerlo en 0 de y
            this.setVeloY(1);
            return juY;
        }

        if(juY +115 >= 600) { //si el coche ha llegado o ha pasado el borde inferior
            juY = 600 - 115;  //mantenerlo en el borde maximo de y
            this.setVeloY(-1);
            return juY;
        }
        return juY;
    }

    @Override
    public void moverJugador(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){ //si el usuario clickea la A o la fecha izquierda
            this.setIzq(true);
            this.setVeloX(2);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.setDer(true);
            this.setVeloX(-2);
        }
        else if(e.getKeyCode() == KeyEvent.VK_W ||e.getKeyCode() == KeyEvent.VK_UP){
            this.setSube(true);
            this.setVeloY(2);
        }
        else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
            this.setBaja(true);
            this.setVeloY(-2);
        }
    }

    @Override
    public void stopJugador(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){ //si el usuario clickea la A o la fecha izquierda
            this.setIzq(false);
            this.setVeloX(2);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            this.setDer(false);
            this.setVeloX(-2);
        }
        else if(e.getKeyCode() == KeyEvent.VK_W ||e.getKeyCode() == KeyEvent.VK_UP){
            this.setSube(false);
            this.setVeloY(2);
        }
        else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
            this.setBaja(false);
            this.setVeloY(-2);
        }
    }

}
