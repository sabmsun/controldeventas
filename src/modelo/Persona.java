
package modelo;

/**
 *
 * @author S
 */
public class Persona {
    String cod_persona;
    String nombre_persona;
    String direccion;
    String telefono;
    String email;
    String contacto;
    String cel_contacto;
    String correo_contacto;
      public Persona(){
        
     cod_persona="";
     nombre_persona="";
     direccion="";
     telefono="";
     email="";
     contacto="";
     cel_contacto="";
     correo_contacto="";
        }

    public String getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(String cod_persona) {
        this.cod_persona = cod_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCel_contacto() {
        return cel_contacto;
    }

    public void setCel_contacto(String cel_contacto) {
        this.cel_contacto = cel_contacto;
    }

    public String getCorreo_contacto() {
        return correo_contacto;
    }

    public void setCorreo_contacto(String correo_contacto) {
        this.correo_contacto = correo_contacto;
    }

 
      
      
}
