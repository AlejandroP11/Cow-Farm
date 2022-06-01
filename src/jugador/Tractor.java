package jugador;

import java.awt.*;

public class Tractor extends Jugador{

    public void paint(Graphics g, int juX, int juY){
        super.paint(g); //llamamos al metodo repaint
        Graphics2D obj = (Graphics2D) g; //creamos un objeto de la clase Graphics2D para dibujar
        obj.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //usamos la clase RenderingHints para renderizar
        try{
            obj.drawImage(getToolkit().getImage("C:\\Users\\34653\\IdeaProjects\\EsquivandoVacas\\Imagenes\\tractor.png"), juX, juY,this);   //dibuja el coche en la vetana
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public int restringirX(int juX) {
        if(juX < 145) {  //si el coche ha llegado o ha pasado el borde izquierdo
            juX = 145;   //mantenerlo en el borde minimo de x
            return juX;
        }

        if(juX +135 > 500) { //si el coche ha llegado o ha pasado el borde derecho
            juX = 500 - 135; //mantenerlo en el borde maximo de x
            return juX;
        }
        return juX;
    }

    @Override
    public int restringirY(int juY) {
        //casos para restringir el moviento del coche para que no se salga de la carretera
        if(juY < 0) { //si el coche ha llegado o ha pasado el borde superior
            juY = 0;  //mantenerlo en 0 de y
            return juY;
        }

        if(juY +150 >= 600) { //si el coche ha llegado o ha pasado el borde inferior
            juY = 600 - 150;  //mantenerlo en el borde maximo de y
            return juY;
        }
        return juY;
    }

}
