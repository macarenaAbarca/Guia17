package cl.accenture.programatufuturo.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cl.accenture.programatufuturo.model.CuentaBancaria;

public class CuentaBancariaDAO {
    private Conexion conexion;

    public CuentaBancariaDAO(Conexion conexion) {
        this.conexion = conexion;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public void guardarCuenta(CuentaBancaria cuenta)throws Exception{
        PreparedStatement psGuardar=getConexion().obtenerConexion().prepareStatement
                ("INSERT INTO cuentabancaria(idCuenta, saldoDisponible, tipoCuenta) VALUES(?,?,?)");
        psGuardar.setString(1,cuenta.getIdCuenta());
        psGuardar.setInt(2,cuenta.getSaldoDisponible());
        psGuardar.setString(3,cuenta.getTipoCuenta());
        int result=psGuardar.executeUpdate();
    }

    public void obtenerCuentas()throws Exception{
        PreparedStatement psObtener=getConexion().obtenerConexion().prepareStatement("SELECT idCuenta FROM cuentabancaria");
        ResultSet rs=psObtener.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("idCuenta"));
        }
    }
}
