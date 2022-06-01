package enemigo;

import javax.swing.*;
import java.awt.*;

public abstract class Enemigo extends JPanel {
    public abstract void paint(Graphics g, int vX, int vY);
    public abstract void paintS(Graphics g, int juX, int juY);


}
