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
import ventatest.*;

/**
 *
 * @author S
 */
public class ControladorCrud implements ActionListener,KeyListener{
JFAdmin vistaCRUD= new JFAdmin();
        UsuarioDAO modeloCRUD= new UsuarioDAO();

        public ControladorCrud(JFAdmin vistaCRUD, UsuarioDAO modeloCRUD){
        this.modeloCRUD=modeloCRUD;
        this.vistaCRUD=vistaCRUD;
        this.vistaCRUD.btnRegistrar.addActionListener(this);
        this.vistaCRUD.btnListar.addActionListener(this);
        this.vistaCRUD.btnEditar.addActionListener(this);
        this.vistaCRUD.btnEliminar.addActionListener(this);
        this.vistaCRUD.btnGEdit.addActionListener(this);
                this.vistaCRUD.txtBusqueda.addKeyListener(this);
this.vistaCRUD.MIcerrarSesion.addActionListener(this);
        this.vistaCRUD.txtCod_usuario.addKeyListener(this);
        this.vistaCRUD.txtRut.addKeyListener(this);
        this.vistaCRUD.txtLogin.addKeyListener(this);
        this.vistaCRUD.txtPassword1.addKeyListener(this);
        this.vistaCRUD.txtPassword2.addKeyListener(this);
        this.vistaCRUD.txtEstado.addKeyListener(this);
        this.vistaCRUD.txtAcceso.addKeyListener(this);
                }
          public void InicializarCrud(){
        
    }
          
          public void LLenarTabla(JTable tablaD){
              DefaultTableModel  modeloT = new DefaultTableModel();
              tablaD.setModel(modeloT);
              
        modeloT.addColumn("COD_USUARIO");
        modeloT.addColumn("RUT_USUARIO");
        modeloT.addColumn("LOGIN");
        modeloT.addColumn("PASS");
        modeloT.addColumn("ESTADO");
        modeloT.addColumn("ACCESO");
        modeloT.addColumn("COD_TIPO");
        
                Object[] columna = new Object[7];
                int numRegistros = modeloCRUD.listUsuario().size();
 for (int i = 0; i < numRegistros; i++) {
            columna[0] = modeloCRUD.listUsuario().get(i).getCod_usuario();
            columna[1] = modeloCRUD.listUsuario().get(i).getRut_usuario();
            columna[2] = modeloCRUD.listUsuario().get(i).getLogin();
            columna[3] = modeloCRUD.listUsuario().get(i).getPassword();
            columna[4] = modeloCRUD.listUsuario().get(i).getEstado();
            columna[5] = modeloCRUD.listUsuario().get(i).getAcceso();
            columna[6] = modeloCRUD.listUsuario().get(i).getCod_tipo();
            modeloT.addRow(columna);
        }


          }
          public void LimpiarCampos(){
        vistaCRUD.txtCod_usuario.setText("");
        vistaCRUD.txtRut.setEditable(true);
        vistaCRUD.txtLogin.setText("");
        vistaCRUD.txtPassword1.setText("");
        vistaCRUD.txtPassword2.setText("");
        vistaCRUD.txtEstado.setText("");
        vistaCRUD.txtAcceso.setText("");
        vistaCRUD.txtCod_tipo.setSelectedIndex(1);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == vistaCRUD.btnRegistrar ){
            String cod_usuario = vistaCRUD.txtCod_usuario.getText();
            String rut_usuario = vistaCRUD.txtRut.getText();
            String login = vistaCRUD.txtLogin.getText();
            String password = vistaCRUD.txtPassword1.getText();
            String estado = vistaCRUD.txtEstado.getText();
            String acceso = vistaCRUD.txtAcceso.getText();
           String cod_tipo = String.valueOf(vistaCRUD.txtCod_tipo.getSelectedItem());
            
         String rptaRegistro = modeloCRUD.insertar_usuario(cod_usuario, rut_usuario, login, password, estado, acceso,cod_tipo);
         if(rptaRegistro!=null){
         JOptionPane.showMessageDialog(null, rptaRegistro);
                LimpiarCampos();
                LLenarTabla(vistaCRUD.jtDatos);
         }else{
                JOptionPane.showMessageDialog(null, "Registro Erroneo.");
         }
    }
         if(e.getSource() == vistaCRUD.btnListar){
             LLenarTabla(vistaCRUD.jtDatos);
            JOptionPane.showMessageDialog(null, "Lista de registros.");
        }
         
        if(e.getSource() == vistaCRUD.btnEditar){
            int filaEditar = vistaCRUD.jtDatos.getSelectedRow();
            int numfilas = vistaCRUD.jtDatos.getSelectedRowCount();
            
            if(filaEditar>=0 && numfilas==1){
                vistaCRUD.txtCod_usuario.setText(String.valueOf(vistaCRUD.jtDatos.getValueAt(filaEditar,0)));
                vistaCRUD.txtCod_usuario.setEditable(false);
                vistaCRUD.btnGEdit.setEnabled(true);
                vistaCRUD.btnEditar.setEnabled(false);
                vistaCRUD.btnEliminar.setEnabled(false);
                vistaCRUD.btnRegistrar.setEnabled(false);
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
            String cod_tipo = String.valueOf(vistaCRUD.txtCod_tipo.getSelectedItem());
                               
            int rptEdit = modeloCRUD.editar_usuario(cod_usuario, rut_usuario, login, password, estado, acceso,cod_tipo);
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
            vistaCRUD.btnRegistrar.setEnabled(true);
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
        }
          if(e.getSource() == vistaCRUD.MIcerrarSesion){
            vistaCRUD.dispose();
            vistaCRUD.setVisible(false);
             VistaLogin vista = new VistaLogin();
        ModeloLogin modelo = new ModeloLogin();
        ControladorLogin controlador = new ControladorLogin(vista, modelo);
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);  
          }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
if(e.getSource() == vistaCRUD.txtCod_usuario || e.getSource() == vistaCRUD.txtRut ){
            char c = e.getKeyChar();
            if(c<'0' || c>'9'){
                e.consume();            }    
}
if(e.getSource() == vistaCRUD.txtLogin || e.getSource() == vistaCRUD.txtPassword1 || e.getSource() == vistaCRUD.txtPassword2 || e.getSource() == vistaCRUD.txtEstado || e.getSource() == vistaCRUD.txtAcceso   ){
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
            modeloT.addColumn("CODIGO TIPO");
            
            Object[] columna = new Object[7];

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
    }
    
}
