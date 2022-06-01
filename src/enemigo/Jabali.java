package enemigo;

import java.awt.*;

public class Jabali extends Enemigo{
    @Override
    public void paint(Graphics g, int vX, int vY) {
        super.paint(g); //llamamos al metodo repaint
        Graphics2D obj = (Graphics2D) g; //creamos un objeto de la clase Graphics2D para dibujar
        obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //usamos la clase RenderingHints para renderizar
        try{
            obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\IdeaProjects\\EsquivandoVacas\\Imagenes\\jabali.png"), vX, vY,this); //dibuja al jabali
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
            obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\IdeaProjects\\EsquivandoVacas\\Imagenes\\jabaliPontente.png"), juX - 30, juY - 20,this); //dibuja al jabali
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
