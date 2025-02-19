import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/*import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;*/


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julien
 */
public class Facture extends javax.swing.JInternalFrame {

     Connection con = null;
        PreparedStatement ps;
        ResultSet rs ;
        static String test;
    public Facture() {
        con = Pont.Obtc();
        initComponents();
        ListeFacture();
    }
    
    public void Ligne(){
            try {
                lst_factures.getSelectedRow();
                String requet ="select * from commande where id ='"+test+"' ";
                ps = con.prepareStatement(requet);
                rs = ps.executeQuery();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void ListeFacture(){
         try {
            ps = con.prepareStatement("select id, nom as Nom_client, prenom as Prénom_Client,nomp as Nom_Produit, qtc as quantite,prixu as Prix_Unitaire,prixt as Prix_total, datecommande as Date_commande  from  commande");
            rs= ps.executeQuery();
            lst_factures.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lst_factures = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        r_nomp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 0));

        lst_factures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(lst_factures);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FIND BY NAME");

        r_nomp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_nompActionPerformed(evt);
            }
        });
        r_nomp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                r_nompKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_26px.png"))); // NOI18N

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("futurinov809@gmail.com");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(r_nomp, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_nomp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            DefaultTableModel tableModel = (DefaultTableModel) lst_factures.getModel();
            HashMap<String ,Object> para = new HashMap<>();
            para.put("tittle","");
           /* JasperPrint jasperprint = null ;
            JasperCompileManager.compileReportToFile("C:\\Users\\mathi\\Desktop\\matin\\projetapoo\\projetapoo\\JavaApplication84\\src\\facture.jrxml");
            jasperprint = JasperFillManager.fillReport("C:\\Users\\julie\\OneDrive\\Bureau\\JavaApplication84\\src\\facture.jasper",para, new JRTableModelDataSource(tableModel));
            JasperViewer.viewReport(jasperprint,false);*/
        }catch(Exception ex){
            System.err.println(ex);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void r_nompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_nompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_nompActionPerformed

    private void r_nompKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_r_nompKeyReleased
            try {  
                ps = con.prepareStatement("select * from commande where id like ?");        
                ps.setString(1,"%" +r_nomp.getText() + "%");
                rs=ps.executeQuery();               
                lst_factures.setModel(DbUtils.resultSetToTableModel(rs));                   
            } catch (SQLException ex) {
           System.err.print(ex.getMessage());
            }  
    }//GEN-LAST:event_r_nompKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lst_factures;
    private javax.swing.JTextField r_nomp;
    // End of variables declaration//GEN-END:variables

}
