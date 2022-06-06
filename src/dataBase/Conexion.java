package dataBase;

import esquivandovacas.Juego;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Conexion {
    //creamos las variables para la conexion
    private static Conexion instance;
    private static Connection conn = null;
    private Statement stmt;
    private ResultSet rs;

    private Conexion(){
        String url = "jdbc:sqlite:CowFarm.sqlite";
        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //metodo de conexión
    public static Conexion getInstance(){
        //solo hago el new si es null
        if(instance == null)
            instance = new Conexion();
        //devuelvo siempre la única instancia
        return instance;
    }
    //metodo de desconexión
    public void desconectar(){
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    //Metodo el cual recoge los datos de registro y los guarda en la bd
    public boolean crearUsuario(Usuarios us){
        String sql = "INSERT INTO usuario (usuario, contraseña) VALUES(?,?)";
        try {
            PreparedStatement ps = stmt.getConnection().prepareStatement(sql);
            ps.setString(1, us.getUsuario());
            ps.setString(2, us.getContraseña());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario creado");
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la creacion del usuario" + e.getMessage());
            return false;
        }
    }
    //Método de incio de sesión el cual comprueba si los datos insertados son correctos y si no muestra el mensaje de error
    public boolean iniciarSesion(Usuarios us){
        String sql = "SELECT * FROM usuario WHERE usuario= '" + us.getUsuario() + "' AND contraseña='" + us.getContraseña() + "'";
        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Sesión iniciada");
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "Error en el usuario o la contraseñá");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
            return false;
        }
    }
    //método para obtener el valor de la id del usuario que inicia sesión
    public int valorID(Usuarios us) {
        String sql = "SELECT * FROM usuario WHERE usuario= '" + us.getUsuario() + "' AND contraseña='" + us.getContraseña() + "'";
        int res = 0;
        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                res = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return res;
    }
    //método que recoge la id del usuario, la puntuación y el nivel y los guarda en la bd
    public boolean guardarPuntuacion(int id ,Puntuacion pu){
        String sql = "INSERT INTO puntuaciones (id_punt, punt, nivel) VALUES(?,?,?)";
        try {
            PreparedStatement ps = stmt.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, pu.getPunt());
            ps.setInt(3, pu.getNivel());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la creacion del usuario" + e.getMessage());
            return false;
        }
    }
    //método de ver puntuaciones el cual muestra el usuario el nivel al que consiguió llegar y su puntuación en una tabla
    public DefaultTableModel verPuntuaciones(){
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT usuario, nivel, punt FROM usuario, puntuaciones WHERE id=id_punt ORDER BY puntuaciones.nivel DESC, puntuaciones.punt DESC";
        try {
            rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int canCol = rsmd.getColumnCount();
            for(int i = 1; i <= canCol; i++)
                model.addColumn(rsmd.getColumnLabel(i));
            while (rs.next()){
                Object[] fila = new Object[canCol];
                for(int i = 0; i < canCol; i++)
                    fila[i] = rs.getObject(i+1);
                model.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return model;
    }

    public void insertarSkins(int id, int ju, int en){
        String sql = "INSERT OR REPLACE INTO ima (id_ima, jugador, enemigo) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = stmt.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, ju);
            ps.setInt(3, en);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Skins cambiadas");
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public int selecJu(int id){
        String sql = "SELECT jugador FROM ima WHERE id_ima=" + id;
        int resul = 0;
        try {
            rs = stmt.executeQuery(sql);
            if(rs.next())
                resul = rs.getInt("jugador");
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return resul;
    }
    public int selecEn(int id){
        String sql = "SELECT enemigo FROM ima WHERE id_ima=" + id;
        int resul = 0;
        try {
            rs = stmt.executeQuery(sql);
            if(rs.next())
                resul = rs.getInt("enemigo");
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return resul;
    }
}


