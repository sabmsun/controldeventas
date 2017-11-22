
package modelo;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author S
 */
public class PersonaDAO {
        Conexion conexion;
public PersonaDAO(){
conexion = new Conexion();
}
public String insertar_persona(String cod_persona, String nombre_persona, String direccion, String telefono, String email, String contacto, String cel_contacto, String correo_contacto){
String rptaRegistro=null;
try {
        Connection accesoDB = conexion.getConexion();
        CallableStatement cs = accesoDB.prepareCall("{call insertar_persona(?,?,?,?,?,?,?,?)}");
    cs.setString(1, cod_persona);
    cs.setString(2, nombre_persona);
    cs.setString(3, direccion);
    cs.setString(4, telefono);
    cs.setString(5, email);
    cs.setString(6, contacto);
    cs.setString(7, cel_contacto);
    cs.setString(8, correo_contacto);
  int numFAfectas = cs.executeUpdate();
            
            if(numFAfectas>0){
                rptaRegistro="Registro persona exitoso.";
            }
        } catch (Exception e) {
    }
    
return rptaRegistro;

}
public ArrayList<Persona> listPersona(){
    ArrayList listaPersona = new ArrayList();
    Persona persona;
    try {
      Connection acceDB = conexion.getConexion();
            PreparedStatement ps = acceDB.prepareStatement("select * from persona");  
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
                persona = new Persona();
                persona.setCod_persona(rs.getString(1));
                persona.setNombre_persona(rs.getString(2));
                persona.setDireccion(rs.getString(3));
                persona.setTelefono(rs.getString(4));
                persona.setEmail(rs.getString(5));
                persona.setContacto(rs.getString(6));
                persona.setCel_contacto(rs.getString(7));
                persona.setCorreo_contacto(rs.getString(8));

    listaPersona.add(persona);
    }
    
    } catch (Exception e) {
    }
    
return listaPersona;
}
public int eliminar_persona(String cod_persona){
        int filAfectadas= 0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call eliminar_persona(?)}");
            cs.setString(1, cod_persona);
            filAfectadas = cs.executeUpdate();
        } catch (Exception e) {
        }
        
        return filAfectadas;
    }
public int editar_persona(String cod_persona, String nombre_persona, String direccion, String telefono, String email, String contacto, String cel_contacto, String correo_contacto){
        int filAfectadas=0;
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall("{call editar_persona(?,?,?,?,?,?,?,?)}");
        cs.setString(1, cod_persona);
        cs.setString(2, nombre_persona);
        cs.setString(3, direccion);
        cs.setString(4, telefono);
        cs.setString(5, email);
        cs.setString(6, contacto);
        cs.setString(7, cel_contacto);
        cs.setString(8, correo_contacto);
            filAfectadas = cs.executeUpdate();
        } catch (Exception e) {
        }
        return filAfectadas;  
    }
public ArrayList<Persona> buscaPersona(String cod_persona){
        ArrayList listaPersona = new ArrayList();
        Persona persona;
        try {
            Connection acceDB = conexion.getConexion();
            CallableStatement cs = acceDB.prepareCall("{call buscar_personaCod(?)}");
            cs.setString(1, cod_persona);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                persona = new Persona();
                persona.setCod_persona(rs.getString(1));
                persona.setNombre_persona(rs.getString(2));
                persona.setDireccion(rs.getString(3));
                persona.setTelefono(rs.getString(4));
                persona.setEmail(rs.getString(5));
                persona.setContacto(rs.getString(6));
                persona.setCel_contacto(rs.getString(7));
                persona.setCorreo_contacto(rs.getString(8));
                listaPersona.add(persona);
            }
        } catch (Exception e) {
        }
        return listaPersona;
    }
}

