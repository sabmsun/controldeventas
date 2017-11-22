package controlador;
import modelo.*;
import vista.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author S
 */
public class ControladorCrudPersona implements ActionListener,KeyListener{
JFAgregarPersona vistaCRUD= new JFAgregarPersona();
        PersonaDAO modeloCRUD= new PersonaDAO();

        public ControladorCrudPersona(JFAgregarPersona vistaCRUD, PersonaDAO modeloCRUD){
        this.modeloCRUD=modeloCRUD;
        this.vistaCRUD=vistaCRUD;
        this.vistaCRUD.btnRegistrarPersona.addActionListener(this);
         this.vistaCRUD.btnListarPersona.addActionListener(this);
        this.vistaCRUD.btnCancelar.addActionListener(this);
        /*
        this.vistaCRUD.btnEditarPersona.addActionListener(this);
        this.vistaCRUD.btnEliminarPersona.addActionListener(this);
        this.vistaCRUD.btnGEditPersona.addActionListener(this);
                this.vistaCRUD.txtBusquedaPersona.addKeyListener(this);
*/
        this.vistaCRUD.txtCod_persona.addKeyListener(this);
        this.vistaCRUD.txtNombre_persona.addKeyListener(this);
        this.vistaCRUD.txtDireccion.addKeyListener(this);
        this.vistaCRUD.txtTelefono.addKeyListener(this);
        this.vistaCRUD.txtEmail.addKeyListener(this);
        this.vistaCRUD.txtContacto.addKeyListener(this);
        this.vistaCRUD.txtCel_contacto.addKeyListener(this);
        this.vistaCRUD.txtCorreo_contacto.addKeyListener(this);
        }
          public void InicializarCrud(){
        
    }
          
           public void LLenarTabla(JTable tablaD){
              DefaultTableModel  modeloT = new DefaultTableModel();
              tablaD.setModel(modeloT);
              
        modeloT.addColumn("COD_PERSONA");
        modeloT.addColumn("NOMBRE_PERSONA");
        modeloT.addColumn("DIRECCION");
        modeloT.addColumn("TELEFONO");
        modeloT.addColumn("EMAIL");
        modeloT.addColumn("CONTACTO");
        modeloT.addColumn("CEL_CONTACTO");
        modeloT.addColumn("CORREO_CONTACTO");
        
                Object[] columna = new Object[8];
                int numRegistros = modeloCRUD.listPersona().size();
 for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloCRUD.listPersona().get(i).getCod_persona();
            columna[1] = modeloCRUD.listPersona().get(i).getNombre_persona();
            columna[2] = modeloCRUD.listPersona().get(i).getDireccion();
            columna[3] = modeloCRUD.listPersona().get(i).getTelefono();
            columna[4] = modeloCRUD.listPersona().get(i).getEmail();
            columna[5] = modeloCRUD.listPersona().get(i).getContacto();
            columna[6] = modeloCRUD.listPersona().get(i).getCel_contacto();
            columna[7] = modeloCRUD.listPersona().get(i).getCorreo_contacto();
            modeloT.addRow(columna);
        }


          }

   public void LimpiarCampos(){
        vistaCRUD.txtCod_persona.setText("");
        //vistaCRUD.txtRut.setEditable(true);
        vistaCRUD.txtNombre_persona.setText("");
        vistaCRUD.txtDireccion.setText("");
        vistaCRUD.txtTelefono.setText("");
        vistaCRUD.txtEmail.setText("");
        vistaCRUD.txtContacto.setText("");
        vistaCRUD.txtCel_contacto.setText("");
        vistaCRUD.txtCorreo_contacto.setText("");

                

    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaCRUD.btnCancelar){vistaCRUD.dispose();}
         if(e.getSource() == vistaCRUD.btnRegistrarPersona ){
            String cod_persona = vistaCRUD.txtCod_persona.getText();
            String nombre_persona = vistaCRUD.txtNombre_persona.getText();
            String direccion = vistaCRUD.txtDireccion.getText();
            String telefono = vistaCRUD.txtTelefono.getText();
            String email = vistaCRUD.txtEmail.getText();
            String contacto = vistaCRUD.txtContacto.getText();
            String cel_contacto = vistaCRUD.txtCel_contacto.getText();
            String correo_contacto = vistaCRUD.txtCorreo_contacto.getText();
            
         String rptaRegistro = modeloCRUD.insertar_persona(cod_persona, nombre_persona, direccion, telefono, email, contacto, cel_contacto, correo_contacto);
         if(rptaRegistro!=null){
         JOptionPane.showMessageDialog(null, rptaRegistro);
                LimpiarCampos();
                
                LLenarTabla(vistaCRUD.jtDatosPersona);
         
         }else{
                JOptionPane.showMessageDialog(null, "Registro Erroneo.");
         }
    }
         if(e.getSource() == vistaCRUD.btnListarPersona){
             LLenarTabla(vistaCRUD.jtDatosPersona);
            JOptionPane.showMessageDialog(null, "Lista de registros.");
        }
        
         
        /*if(e.getSource() == vistaCRUD.btnEditar){
            int filaEditar = vistaCRUD.jtDatos.getSelectedRow();
            int numfilas = vistaCRUD.jtDatos.getSelectedRowCount();
            
            if(filaEditar>=0 && numfilas==1){
                vistaCRUD.txtCod_usuario.setText(String.valueOf(vistaCRUD.jtDatos.getValueAt(filaEditar,0)));
                vistaCRUD.txtCod_usuario.setEditable(false);
                vistaCRUD.btnGEdit.setEnabled(true);
                vistaCRUD.btnEditar.setEnabled(false);
                vistaCRUD.btnEliminar.setEnabled(false);
                vistaCRUD.btnRegistrarPersona.setEnabled(false);
                vistaCRUD.btnListar.setEnabled(false);
            
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione registro a editar");
            }
        }
        
        if(e.getSource() == vistaCRUD.btnGEdit){
            String cod_usuario = vistaCRUD.txtCod_usuario.getText();
            String rut_usuario = vistaCRUD.txtRut.getText();
            String login = vistaCRUD.txtLogin.getText();
            String password = vistaCRUD.txtPassword1.getText();
            String estado= vistaCRUD.txtEstado.getText();
            String acceso = vistaCRUD.txtAcceso.getText();      
            
            int rptEdit = modeloCRUD.editar_usuario(cod_usuario, rut_usuario, login, password, estado, acceso);
            if(rptEdit>0){
                LimpiarCampos();
                JOptionPane.showMessageDialog(null, "Edicion exitosa.");
                LLenarTabla(vistaCRUD.jtDatos);
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo realizar edicion.");
            }
            vistaCRUD.txtCod_usuario.setEditable(true);
            vistaCRUD.btnGEdit.setEnabled(false);
            vistaCRUD.btnEditar.setEnabled(true);
            vistaCRUD.btnEliminar.setEnabled(true);
            vistaCRUD.btnRegistrarPersona.setEnabled(true);
            vistaCRUD.btnListar.setEnabled(true);
        }
        
        if(e.getSource() == vistaCRUD.btnEliminar){
            int filInicio = vistaCRUD.jtDatos.getSelectedRow();
            int numfilas = vistaCRUD.jtDatos.getSelectedRowCount();
            ArrayList<String> listaCod_usuario = new ArrayList<>();
            String cod_usuario;
         
            if(filInicio>=0){
                for(int i = 0; i<numfilas; i++){
                    cod_usuario = String.valueOf(vistaCRUD.jtDatos.getValueAt(i+filInicio, 0));
                    listaCod_usuario.add(i, cod_usuario);
                }

                for(int j = 0; j<numfilas; j++){
                    int rpta = JOptionPane.showConfirmDialog(null, "Desea eliminar registro con dni: "+listaCod_usuario.get(j)+"? ");
                    if(rpta==0){
                        modeloCRUD.eliminar_usuario(listaCod_usuario.get(j));
                    }
                }
                LLenarTabla(vistaCRUD.jtDatos);
            }else{
                JOptionPane.showMessageDialog(null, "Elija al menos un registro para eliminar.");
            }    
        }*/
    }
/*
    

    @Override
    public void keyReleased(KeyEvent e) {
if(e.getSource()== vistaCRUD.txtBusqueda){
            
            String cod_usuario = vistaCRUD.txtBusqueda.getText();
            DefaultTableModel  modeloT = new DefaultTableModel();
            vistaCRUD.jtDatos.setModel(modeloT);
            
            modeloT.addColumn("CODIGO USUARIO");
            modeloT.addColumn("RUT USUARIO");
            modeloT.addColumn("LOGIN");
            modeloT.addColumn("PASSWORD");
            modeloT.addColumn("ESTADO");
            modeloT.addColumn("ACCESO");
            
            Object[] columna = new Object[6];

            int numRegistros = modeloCRUD.buscaUsuario(cod_usuario).size();

            for (int i = 0; i < numRegistros; i++) {
                
                columna[0] = modeloCRUD.buscaUsuario(cod_usuario).get(i).getCod_usuario();
                columna[1] = modeloCRUD.buscaUsuario(cod_usuario).get(i).getRut_usuario();
                columna[2] = modeloCRUD.buscaUsuario(cod_usuario).get(i).getLogin();
                columna[3] = modeloCRUD.buscaUsuario(cod_usuario).get(i).getPassword();
                columna[4] = modeloCRUD.buscaUsuario(cod_usuario).get(i).getEstado();
                columna[4] = modeloCRUD.buscaUsuario(cod_usuario).get(i).getAcceso();
                
                modeloT.addRow(columna);
            }
        }    
    }*/
    
    

    @Override
   
    public void keyTyped(KeyEvent e) {
if(e.getSource() == vistaCRUD.txtCod_persona || e.getSource() == vistaCRUD.txtTelefono || e.getSource() == vistaCRUD.txtCel_contacto ){
            char c = e.getKeyChar();
            if(c<'0' || c>'9'){
                e.consume();            }    
}
if(e.getSource() == vistaCRUD.txtNombre_persona || e.getSource() == vistaCRUD.txtContacto  ){
            char c = e.getKeyChar();
            if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c!=(char)KeyEvent.VK_SPACE)){
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
