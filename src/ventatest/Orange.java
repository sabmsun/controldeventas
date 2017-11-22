/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventatest;
import modelo.*;
import vista.*;
import controlador.*;
import javax.swing.JOptionPane;

/**
 *
 * @author S
 */
public class Orange {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int opcion = Integer.parseInt(JOptionPane.showInputDialog("ingrese jFrame a mostrar: \n "
                + "1.-jframe login  \n "
                + "2.- Frame de admin (agrega usuarios)\n"
                + "3 .-vendedor\n"
                + "4.-jframe agregar cliente"));
       switch(opcion){
           case 1:*/
               VistaLogin vista = new VistaLogin();
        ModeloLogin modelo = new ModeloLogin();
        ControladorLogin controlador = new ControladorLogin(vista, modelo);
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        /*break;
           case 2 :
                JFAdmin vistaAdmin = new JFAdmin();
        UsuarioDAO modeloC = new UsuarioDAO();
        ControladorCrud controlaC = new ControladorCrud(vistaAdmin, modeloC);
        
        vistaAdmin.setVisible(true);
        vistaAdmin.setLocationRelativeTo(null);
        break;
           case 3 :
               JFUsuarioVenta  vistaUsuarioVenta = new JFUsuarioVenta();
               vistaUsuarioVenta.setVisible(true);
               break;
           case 4:
       JFAgregarPersona vistaAgregarPersona = new JFAgregarPersona();
        PersonaDAO modeloAgregarPersona = new PersonaDAO();
        ControladorCrudPersona controlaAgregarPersona = new ControladorCrudPersona(vistaAgregarPersona, modeloAgregarPersona);
        
        vistaAgregarPersona.setVisible(true);
        vistaAgregarPersona.setLocationRelativeTo(null);
        break;
        
                        
       }
        
   
        /*JFAgregarPersona vistaC = new JFAgregarPersona();
        PersonaDAO modeloC = new PersonaDAO();
        ControladorCrudPersona controlaC = new ControladorCrudPersona(vistaC, modeloC);
        
        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);*/
       
          /*
      
        JFAdmin vistaC = new JFAdmin();
        UsuarioDAO modeloC = new UsuarioDAO();
        ControladorCrud controlaC = new ControladorCrud(vistaC, modeloC);
        
        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);
  */
    }
    
}
