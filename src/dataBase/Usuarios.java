package dataBase;
//declaracion de variables para la creacion de usuarios
public class Usuarios {
    private int id;
    private String usuario;
    private String contraseña;
//contructor
    public Usuarios(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
//getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
