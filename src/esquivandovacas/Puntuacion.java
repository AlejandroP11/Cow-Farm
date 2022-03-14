
package esquivandovacas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Alejandro Pereiro G
 * @author David Braga
 */
public class Puntuacion implements Comparable<Puntuacion>{
    private String nombre; //nombre del jugador
    private int punt; //cantidad de puntos obtenidos por nivel
    private  int nivel; //niveles superados
    
    //constructor vacio
    public Puntuacion() {
    }
    
    //constructor con todos los atributos
    public Puntuacion(String nombre, int nivel, int punt) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.punt = punt;
    }
    
    //geters y seters de todos los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPunt() {
        return punt;
    }

    public void setPunt(int punt) {
        this.punt = punt;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    //metodo que se utiliza para comparar y ordenar las puntuaciones dentro de las ArraysList
        @Override
    public int compareTo(Puntuacion o) {
        if(nivel > o.nivel || nivel == o.nivel && punt > o.punt) { //si el nivel es mayor o si el nivel es igual y tiene mas puntos
            return -1; //devuelve -1
        }
        if(nivel == o.nivel && punt == o.punt){ //si el nivel y los puntos son iguales
            return 0; //devuelve 0
        }else{ //de otra manera 
        return 1;} //devuelve 1
    } 
    
    //metodo toString para escribir las puntuaciones
    @Override
    public String toString() {
        return "nombre: "+ getNombre() + "----> nivel: " + getNivel();
    }
    
    Scanner sc;     //declaramos un scanner
    FileWriter fi;  //declaramos un FileWriter
    PrintWriter es; //declaramos un PrintWriter
    
    //metodo que utilizamos para leer el archivo de puntuaciones
    public ArrayList<Puntuacion> leerPuntuacion(String fic, String deli){
        File f = new File(fic); //creamos un objeto de tipo File
        ArrayList<Puntuacion>lista = new ArrayList<Puntuacion>(); //instanciamos un ArrayList de puntuacion
        Puntuacion pu; //instanciamos un objeto de puntuacion
        String ca; //instanciamos un String
        try {
            sc = new Scanner(f); //usamos el scanner en el objeto File
            while(sc.hasNextLine()){ //si tiene mas lineas
                ca = sc.nextLine();  //metemos dentro del objeto String la siguiente linea
                String[]li = ca.split(deli); //separamos ca por un delimitador y lo introducimos en un Array
                pu = new Puntuacion(li[0], Integer.parseInt(li[1]), Integer.parseInt(li[2])); //construimos el objeto Puntuacion
                lista.add(pu); //agregamos el objeto al ArrayList
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error de lectura "+ex.getMessage());
        } finally{
            sc.close(); //cerramos el scanner
        }
        return lista;  //devolvemos el ArrayList
    }
    
    //metodo para comparar la puntuacion conseguida con la mejor puntuacion que esta archivada
    public void laMejorPuntuacion(String fic, String deli, Puntuacion p){
        ArrayList<Puntuacion>lista = new ArrayList<Puntuacion>(); //instanciamos un ArrayList de puntuacion
        lista = leerPuntuacion(fic, deli); //llamamos al metodo leerPuntuacion
        if(p.compareTo(lista.get(0)) == -1 || p.compareTo(lista.get(0)) == 0) //si la puntuacion que pasamos con parametro es mayor que la mejor puntuacion anotada
            JOptionPane.showMessageDialog(null, "FELICIDADES!!!!!!\nHAS HECHO LA MEJOR PUNTUACION"); //sacamos por pantalla 
    }
    
    //metodo para ver las mejores puntuaciones
    public void verMejoresPuntuacion(String fic, String deli){
        ArrayList<Puntuacion>lista = new ArrayList<Puntuacion>(); //instanciamos un ArrayList de puntuacion
        lista = leerPuntuacion(fic, deli); //llamamos al metodo leerPuntuacion
        System.out.println("Mejores puntuaciones"); //sacamos por pantalla
        for(Puntuacion x : lista){ //usamos un for each para los elementos del ArrayList
            System.out.println(x.toString()); //sacamos por pantalla
        }
    }
    
    //metodo para escribir en el archivo las mejores puntuaciones
    public void escribirPuntuacion(String fic, String deli, Puntuacion p){
        File fich = new File(fic); //creamos un objeto de tipo File
        ArrayList<Puntuacion>lista = new ArrayList<Puntuacion>(); //instanciamos un ArrayList de puntuacion
        if(fich.exists()){ //si el objeto File existe
            lista = leerPuntuacion(fic,deli); //llamamos al metodo leerPuntuacion
            try {
                fi=new FileWriter(fic); //usamos el objeto FileWriter 
                es=new PrintWriter(fi); //usamos el objeto PrintWriter
                lista.add(p); //agregamos al ArryList la Puntuacion que pasamos por parametro
                Collections.sort(lista); //ordenamos el ArrayList
                for(int i = 0; i < lista.size() && i < 5; i++){ //mientras sea menor que el tamaño de la lista o menor que cinco
                    es.print(lista.get(i).getNombre()+", "); //escribimos el nombre y una ,
                    es.print(lista.get(i).getNivel()+", "); //escribimos el nivel y una ,
                    es.println(lista.get(i).getPunt()); //escribimos los puntos y saltamos de linea
                }
            } catch (IOException ex) {
                System.out.println("Error de escritura "+ex.getMessage());
            } finally {
                try {
                    es.close(); //cerramos el PrinWriter
                    fi.close(); //cerramos el FileWriter
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el fichero "+ex.getMessage());
                }
            }
        } else{ //de no existir el objeto File
            try {
                fi=new FileWriter(fic); //usamos el objeto FileWriter 
                es=new PrintWriter(fi); //usamos el objeto PrintWriter
                lista.add(p); //agregamos al ArryList la Puntuacion que pasamos por parametro
                for(int i = 0; i < lista.size(); i++){ //mientras sea menor que el tamaño de la lista
                    es.print(lista.get(i).getNombre()+", "); //escribimos el nombre y una ,
                    es.print(lista.get(i).getNivel()+", "); //escribimos el nivel y una ,
                    es.println(lista.get(i).getPunt()); //escribimos los puntos y saltamos de linea
                }
            } catch (IOException ex) {
                System.out.println("Error de escritura "+ex.getMessage());
            } finally {
                try {
                    es.close(); //cerramos el PrinWriter
                    fi.close(); //cerramos el FileWriter
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el fichero "+ex.getMessage());
                }
            }
        }
    }
}

