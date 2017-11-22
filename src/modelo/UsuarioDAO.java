package modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author S
 */
public class UsuarioDAO {

    Conexion conexion;

    public UsuarioDAO() {
        conexion = new Conexion();
    }

    public String insertar_usuario(String cod_usuario, String rut_usuario, String login, String password, String estado, String acceso, String cod_tipo) {
        String rptaRegistro = null;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call insertar_usuario(?,?,?,?,?,?,?)}");
            cs.setString(1, cod_usuario);
            cs.setString(2, rut_usuario);
            cs.setString(3, login);
            cs.setString(4, password);
            cs.setString(5, estado);
            cs.setString(6, acceso);
            cs.setString(7, cod_tipo);
            int numFAfectas = cs.executeUpdate();

            if (numFAfectas > 0) {
                rptaRegistro = "Registro usuario exitoso.";
            }
        } catch (Exception e) {
        }

        return rptaRegistro;
    }

    public ArrayList<Usuario> listUsuario() {
        ArrayList listaUsuario = new ArrayList();
        Usuario usuario;
        try {
            Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from usuario");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setCod_usuario(rs.getString(1));
                usuario.setRut_usuario(rs.getString(2));
                usuario.setLogin(rs.getString(3));
                usuario.setPassword(rs.getString(4));
                usuario.setEstado(rs.getString(5));
                usuario.setAcceso(rs.getString(6));
                usuario.setCod_tipo(rs.getString(7));
                listaUsuario.add(usuario);
            }

        } catch (Exception e) {
        }

        return listaUsuario;
    }

    public int eliminar_usuario(String cod_usuario) {
        int filAfectadas = 0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call eliminar_usuario(?)}");
            cs.setString(1, cod_usuario);
            filAfectadas = cs.executeUpdate();
        } catch (Exception e) {
        }

        return filAfectadas;
    }

    public int editar_usuario(String cod_usuario, String rut_usuario, String login, String password, String estado, String acceso, String cod_tipo) {
        int filAfectadas = 0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call editar_usuario(?,?,?,?,?,?,?)}");
            cs.setString(1, cod_usuario);
            cs.setString(2, rut_usuario);
            cs.setString(3, login);
            cs.setString(4, password);
            cs.setString(5, estado);
            cs.setString(6, acceso);
            cs.setString(7, cod_tipo);
            filAfectadas = cs.executeUpdate();
        } catch (Exception e) {
        }
        return filAfectadas;
    }

    public ArrayList<Usuario> buscaUsuario(String cod_usuario) {
        ArrayList listaUsuario = new ArrayList();
        Usuario usuario;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call buscar_usuarioCod(?)}");
            cs.setString(1, cod_usuario);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setCod_usuario(rs.getString(1));
                usuario.setRut_usuario(rs.getString(2));
                usuario.setLogin(rs.getString(3));
                usuario.setPassword(rs.getString(4));
                usuario.setEstado(rs.getString(5));
                usuario.setAcceso(rs.getString(6));
                usuario.setAcceso(rs.getString(7));
                listaUsuario.add(usuario);
            }
        } catch (Exception e) {
        }
        return listaUsuario;
    }

}
