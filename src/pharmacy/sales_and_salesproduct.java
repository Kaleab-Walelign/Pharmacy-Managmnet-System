/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rog
 */
public class sales_and_salesproduct extends javax.swing.JFrame {

    /**
     * Creates new form sales_and_salesproduct
     */
    public sales_and_salesproduct() {
        initComponents();
        Connect();
    }
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
    DefaultTableModel df;
    
    public void Connect(){
        
                
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(addtostore.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy", "root","");
        } catch (SQLException ex) {
            Logger.getLogger(addtostore.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnsales = new javax.swing.JButton();
        btnsales_product = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnback_to_pharmacy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sub total", "pay", "bal"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnsales.setText("Sales");
        btnsales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalesActionPerformed(evt);
            }
        });

        btnsales_product.setText("Sales Product");
        btnsales_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsales_productActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sales_ID", "Drug name", "Price", "qty", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        btnback_to_pharmacy.setText("back to pharmacy");
        btnback_to_pharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnback_to_pharmacyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsales, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnsales_product, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btnback_to_pharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsales, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsales_product, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addComponent(btnback_to_pharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalesActionPerformed
        try {
            // TODO add your handling code here:
                pst = con.prepareStatement("select * from sales");
                
                rs = pst.executeQuery();
            
            jTable1.setModel(new DefaultTableModel(null,new String []{"id","subtotal","pay","bal"}));
                
            while (rs.next()){
                String id = rs.getString("id");
                String subtotal = rs.getString("subtotal");
                String pay = rs.getString("pay");
                String bal = rs.getString("bal");
                
                String tbData[] = {id,subtotal,pay,bal};
                DefaultTableModel tblMode = (DefaultTableModel)jTable1.getModel();
                
                tblMode.addRow(tbData);
                        
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(addtostore.class.getName()).log(Level.SEVERE, null, ex);
        }
                                            
    }//GEN-LAST:event_btnsalesActionPerformed

    private void btnsales_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsales_productActionPerformed
        
         try {
            // TODO add your handling code here:
                pst = con.prepareStatement("select * from sales_product");
                
                rs = pst.executeQuery();
            
            jTable2.setModel(new DefaultTableModel(null,new String []{"id","sales_id","drugname","price","qty","total"}));
                
            while (rs.next()){
                String id = rs.getString("id");
                String sales_id = rs.getString("sales_id");
                String drugname = rs.getString("drugname");
                String price = rs.getString("price");
                String qty = rs.getString("qty");
                String total = rs.getString("total");
                
                String tbData[] = {id,sales_id,drugname,price,qty,total};
                DefaultTableModel tblMode = (DefaultTableModel)jTable2.getModel();
                
                tblMode.addRow(tbData);
                        
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(addtostore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsales_productActionPerformed

    private void btnback_to_pharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnback_to_pharmacyActionPerformed
        // TODO add your handling code here:
        pharmacy jfrm2 = new pharmacy();
       // jfrm2.setSize(500,500);
        jfrm2.setVisible(true);
        this.setVisible(false);
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnback_to_pharmacyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sales_and_salesproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales_and_salesproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales_and_salesproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales_and_salesproduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sales_and_salesproduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback_to_pharmacy;
    private javax.swing.JButton btnsales;
    private javax.swing.JButton btnsales_product;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
