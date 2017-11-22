package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class ControladorLogin implements ActionListener {

    VistaLogin vista = new VistaLogin();
    ModeloLogin modelo = new ModeloLogin();

    public ControladorLogin(VistaLogin vista, ModeloLogin modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnLogin.addActionListener(this);
        this.vista.btnCancel.addActionListener(this);
        this.vista.jTextField1.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if(vista.jTextField1.getText().length() == 0) {
                    vista.jTextField1.setForeground(Color.gray);
                    vista.jTextField1.setText("Nombre de usuario");
                }
            }
            
            @Override
            public void focusGained(FocusEvent e) {
                vista.jTextField1.setForeground(Color.black);
                vista.jTextField1.setText("");
            }
        });
        this.vista.jPasswordField1.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if(vista.jPasswordField1.getPassword().length == 0) {
                    vista.jPasswordField1.setForeground(Color.gray);
                    vista.jPasswordField1.setText("********");
                }
            }
            
            @Override
            public void focusGained(FocusEvent e) {
                vista.jPasswordField1.setForeground(Color.black);
                vista.jPasswordField1.setText("");
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnLogin) {
            //modelo.validarLogin();
            if (vista.jTextField1.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos.");
            } else if (vista.jPasswordField1.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos.");
            } else {
                String login = vista.jTextField1.getText();
                String pass = String.valueOf(vista.jPasswordField1.getPassword());
                switch (modelo.validateLogin(login, pass)) {
                    case "Administrador":
                        
                        vista.dispose();
                        JFAdmin vistaAdmin = new JFAdmin();
                        UsuarioDAO modeloC = new UsuarioDAO();
                        ControladorCrud controlaC = new ControladorCrud(vistaAdmin, modeloC);
        
                        vistaAdmin.setVisible(true);
                        vistaAdmin.setLocationRelativeTo(null);
                        break;
                    case "Supervisor":
                        vista.dispose();
                        JFSupervisor vistaSupervisor = new JFSupervisor();
                        vistaSupervisor.setLocationRelativeTo(null);
                        vistaSupervisor.setVisible(true);
                        break;
                        
                    case "Vendedor":
                        
                        vista.dispose();
                       JFUsuarioVenta  vistaUsuarioVenta = new JFUsuarioVenta();
                        vistaUsuarioVenta.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Error.");
                }
            }
        } else if (e.getSource() == vista.btnCancel) {
            System.exit(0);
        }
    }

}
