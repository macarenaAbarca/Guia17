package cl.accenture.programatufuturo.dao;

public class TransacionDAO {
    private Conexion conexion;

    public TransacionDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }


}
