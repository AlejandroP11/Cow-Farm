package enemigo;

import java.awt.*;

public class Vaca extends Enemigo{
    @Override
    public void paint(Graphics g, int vX, int vY) {
        super.paint(g); //llamamos al metodo repaint
        Graphics2D obj = (Graphics2D) g; //creamos un objeto de la clase Graphics2D para dibujar
        obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //usamos la clase RenderingHints para renderizar
        try{
            obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\IdeaProjects\\EsquivandoVacas\\Imagenes\\vaca.png"), vX, vY,this);   //dibuja la vaca
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void paintS(Graphics g, int juX, int juY) {
        super.paint(g); //llamamos al metodo repaint
        Graphics2D obj = (Graphics2D) g; //creamos un objeto de la clase Graphics2D para dibujar
        obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //usamos la clase RenderingHints para renderizar
        try{
            obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\IdeaProjects\\EsquivandoVacas\\Imagenes\\vacaded.png"), juX - 30, juY - 20,this);   //dibuja la vaca
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
