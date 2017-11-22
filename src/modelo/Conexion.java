package modelo;

import java.sql.*;
/**
 *
 * @author S
 */
public class Conexion {

    public Conexion() {
    }

    public Connection getConexion(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_controldeventas","root","admin");
            //con = DriverManager.getConnection("jdbc:mysql://10.10.100.152:3306","ib","123456");
            System.out.println("Se ha establecido la conexion");
        } catch (Exception e) {
            System.out.println(" La conexion ha fallado");
        }
        
        return con;
    }
    public static void main(String[] args) {
       Conexion conn = new Conexion();
       conn.getConexion();
    }
  
}