
package dataBase;

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
//declaracion de variables de la clase puntuación
public class Puntuacion implements Comparable<Puntuacion>{
    private int punt; //cantidad de puntos obtenidos por nivel
    private  int nivel; //niveles superados
    
    //constructor vacio
    public Puntuacion() {
    }
    
    //constructor con todos los atributos
    public Puntuacion(int nivel, int punt) {
        this.nivel = nivel;
        this.punt = punt;
    }
    
    //geters y seters de todos los atributos
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
        return "----> nivel: " + getNivel();
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
                pu = new Puntuacion(Integer.parseInt(li[1]), Integer.parseInt(li[2])); //construimos el objeto Puntuacion
                lista.add(pu); //agregamos el objeto al ArrayList
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error de lectura "+ex.getMessage());
        } finally{
            sc.close(); //cerramos el scanner
        }
        return lista;  //devolvemos el ArrayList
    }

}

