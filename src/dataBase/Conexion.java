package dataBase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Conexion {

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

    public static Conexion getInstance(){
        //solo hago el new si es null
        if(instance == null)
            instance = new Conexion();
        //devuelvo siempre la única instancia
        return instance;
    }
    public void desconectar(){
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
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

    public int iniciarSesion(Usuarios us){
        String sql = "SELECT id FROM usuario WHERE usuario= '" + us.getUsuario() + "' AND contraseña='" + us.getContraseña() + "'";
        int resul = 0;
        try {
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Sesión iniciada");
                resul = rs.getInt("id");
            }
            else
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecto");
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return resul;
    }
    public boolean guardarPuntuacion(int id ,Puntuacion pu){
        String sql = "INSERT INTO puntuaciones (id, punt, nivel) VALUES(?,?,?)";
        try {
            PreparedStatement ps = stmt.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, pu.getPunt());
            ps.setInt(3, pu.getNivel());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario creado");
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la creacion del usuario" + e.getMessage());
            return false;
        }
    }
    public DefaultTableModel verPuntuaciones(){
        DefaultTableModel model = new DefaultTableModel();
        String sql = "SELECT usuario, nivel, punt FROM usuario, puntuaciones WHERE usaurio.id=puntuaciones.id ORDER BY puntuaciones.nivel, puntuaciones.punt";
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
        String sql = "INSERT INTO ima (id, jugador, enemigo) VALUES (?, ?, ?)";
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
        String sql = "SELECT jugador FROM ima WHERE id=" + id;
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
        String sql = "SELECT enemigo FROM ima WHERE id=" + id;
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


