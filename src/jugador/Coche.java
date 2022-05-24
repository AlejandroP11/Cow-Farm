package jugador;

import java.awt.*;

public class Coche extends Jugador{

    @Override
    public void paint(Graphics g, int juX, int juY) {
        super.paint(g); //llamamos al metodo repaint
        Graphics2D obj = (Graphics2D) g; //creamos un objeto de la clase Graphics2D para dibujar
        obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //usamos la clase RenderingHints para renderizar
        try{
            obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\OneDrive\\Documentos\\NetBeansProjects\\EsquivandoVacas\\Imagenes\\coche.png"), juX, juY,this);   //dibuja el coche en la vetana
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public int restringirX(int juX) {
        return 0;
    }

    @Override
    public int restringirY(int juY) {
        return 0;
    }
}
