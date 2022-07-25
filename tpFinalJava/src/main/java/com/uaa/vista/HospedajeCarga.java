/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.uaa.vista;

import com.uaa.controlador.MemData;
import com.uaa.modelo.Funcionario;
import com.uaa.modelo.Habitacion;
import com.uaa.modelo.Hospedaje;
import com.uaa.modelo.Hotel;
import com.uaa.modelo.Lavanderia;
import com.uaa.modelo.Pasajero;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel
 */
public class HospedajeCarga extends javax.swing.JInternalFrame {
    /**
     * Creates new form Hospedaje
     */
    public HospedajeCarga() {
        initComponents();
        initPantalla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comFuncionario = new javax.swing.JComboBox<>();
        comPasajero = new javax.swing.JComboBox<>();
        comHabitacion = new javax.swing.JComboBox<>();
        comHotel = new javax.swing.JComboBox<>();
        comLavanderia = new javax.swing.JComboBox<>();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        spinnerId = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnGrabar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        txtFieldFuncionario = new javax.swing.JTextField();
        txtFieldPasajero = new javax.swing.JTextField();
        txtFieldHotel = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(153, 0, 153));

        jLabel1.setText("HOSPEDAJE");

        comFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comFuncionarioActionPerformed(evt);
            }
        });

        comPasajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comPasajeroActionPerformed(evt);
            }
        });

        comHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comHotelActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");

        jLabel3.setText("Funcionario:");

        jLabel4.setText("Pasajero:");

        jLabel5.setText("Habitación:");

        jLabel6.setText("Hotel:");

        jLabel7.setText("Lavandería:");

        jLabel8.setText("Fecha Inicio:");

        jLabel9.setText("Fecha Fin:");

        btnGrabar.setText("GRABAR");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comHabitacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comLavanderia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaInicio)
                            .addComponent(txtFechaFin)
                            .addComponent(spinnerId)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comPasajero, javax.swing.GroupLayout.Alignment.LEADING, 0, 120, Short.MAX_VALUE)
                                    .addComponent(comFuncionario, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldFuncionario)
                                    .addComponent(txtFieldPasajero)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(comHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(txtFieldHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGrabar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCerrar)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFieldFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtFieldPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtFieldHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comLavanderia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnCerrar))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        Hospedaje h = new Hospedaje();
        Funcionario fun = new Funcionario();
        Pasajero pas = new Pasajero();
        Habitacion hab = new Habitacion();
        Hotel hot = new Hotel();
        Lavanderia lav = new Lavanderia();
        
        for (Funcionario f : fun.getFuncionarios()) {
            if (f.getIdFuncionario()==Integer.parseInt(comFuncionario.getSelectedItem().toString())) {
                h.setFuncionario(f);
            }
        }
        for (Pasajero p : pas.getPasajeros()) {
            if (p.getIdPasajero()==Integer.parseInt(comPasajero.getSelectedItem().toString())) {
                h.setPasajero(p);
            }
        }
        for (Habitacion ha : hab.getHabitaciones()) {
            if (ha.getNroHabitacion()==Integer.parseInt(comHabitacion.getSelectedItem().toString())) {
                h.setHabitacion(ha);
            }
        }
        for (Hotel ho : hot.getHoteles()) {
            if (ho.getIdHotel()==Integer.parseInt(comHotel.getSelectedItem().toString())) {
                h.setHotel(ho);
            }
        }
        if (comLavanderia.getSelectedItem()!=null) {
            for (Lavanderia l : lav.getServicios()) {
               if (l.getNroServicio()==Integer.parseInt(comLavanderia.getSelectedItem().toString())) {
                   h.setLavanderia(l);
               }
            }           
        }


        
        h.setNroHospedaje((Integer) spinnerId.getValue());
        h.setFechaInicio(txtFechaInicio.getText());
        h.setFechaFin(txtFechaFin.getText());
        
        h.grabar();
        
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void comFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comFuncionarioActionPerformed
        Funcionario fun = new Funcionario();
        for (Funcionario f : fun.getFuncionarios()) {
            if (String.valueOf(f.getIdFuncionario()).equals(comFuncionario.getSelectedItem().toString())) {
                txtFieldFuncionario.setText(f.getNombre() + " " + f.getApellido());
            }
        }         
    }//GEN-LAST:event_comFuncionarioActionPerformed

    private void comPasajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comPasajeroActionPerformed
        Pasajero pas = new Pasajero();
        for (Pasajero p : pas.getPasajeros()) {
            if (String.valueOf(p.getIdPasajero()).equals(comPasajero.getSelectedItem().toString())) {
                txtFieldPasajero.setText(p.getNombre() + " " + p.getApellido());
            }
        }     
    }//GEN-LAST:event_comPasajeroActionPerformed

    private void comHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comHotelActionPerformed
        Hotel hot = new Hotel();
        for (Hotel h : hot.getHoteles()) {
            if (String.valueOf(h.getIdHotel()).equals(comHotel.getSelectedItem().toString())){ 
                txtFieldHotel.setText(h.getNombre());
            }
        }       
    }//GEN-LAST:event_comHotelActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> comFuncionario;
    private javax.swing.JComboBox<String> comHabitacion;
    private javax.swing.JComboBox<String> comHotel;
    private javax.swing.JComboBox<String> comLavanderia;
    private javax.swing.JComboBox<String> comPasajero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spinnerId;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtFieldFuncionario;
    private javax.swing.JTextField txtFieldHotel;
    private javax.swing.JTextField txtFieldPasajero;
    // End of variables declaration//GEN-END:variables

    private void initPantalla() {
        txtFieldFuncionario.setEditable(false);
        txtFieldPasajero.setEditable(false);
        txtFieldHotel.setEditable(false);

        
        Funcionario fun = new Funcionario();
        for (Funcionario f : fun.getFuncionarios()) {
            comFuncionario.addItem(String.valueOf(f.getIdFuncionario()));
        }
        Pasajero pas = new Pasajero();
        for (Pasajero p : pas.getPasajeros()) {
            comPasajero.addItem(String.valueOf(p.getIdPasajero()));
        }
        Hotel hot = new Hotel();
        for (Hotel h : hot.getHoteles()) {
            comHotel.addItem(String.valueOf(h.getIdHotel()));
        }
        Habitacion hab = new Habitacion();
        for (Habitacion h : hab.getHabitaciones()) {
            comHabitacion.addItem(String.valueOf(h.getNroHabitacion()));
        }
        Lavanderia lav = new Lavanderia();
        for (Lavanderia l : lav.getServicios()) { 
            comLavanderia.addItem(String.valueOf(l.getNroServicio()));   
        }
        comLavanderia.setSelectedIndex(-1);

        
        
    }

    private void calcularPrecio() {
       
    }
}
