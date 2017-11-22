package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ModeloLogin {

    Conexion conexion;

    public ModeloLogin() {
        conexion = new Conexion();
    }

    public String validateLogin(String login, String pass) {
        try {
            Connection acceso = conexion.getConexion();
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM usuario where login = ? AND pass = ?");
            ps.setString(1, login);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            String tipo;
            if (rs.next()) {
                tipo = rs.getString("cod_tipo");
            }
            else {
                tipo = null;
            }
            return tipo;
        } catch (Exception e) {
            return null;
        }
    }
}
