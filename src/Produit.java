import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/*import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;*/



public class Produit extends javax.swing.JInternalFrame {

        Connection con = null;
        PreparedStatement ps;
        ResultSet rs ;
        static String test;
    
    
    public Produit() {
        con = Pont.Obtc();
        initComponents();
        ListeProduit();
        
        
        
    }
public void ListeProduit(){
         try {
            ps = con.prepareStatement("select nom as Nom_Produit, prixu as Prix_unitaire,qtStock as quantite, dateEntre as Date_arrivée from  produit join stock on produit.id=stock.id ");
            rs= ps.executeQuery();
            lst_produit.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.err.println(e);
        }
}
    
public void Ligne(){
            try {
                int column = 0;
                int row = lst_produit.getSelectedRow();
                this.test =(lst_produit.getModel().getValueAt(row,column).toString());
                String requet ="select nom ,prix, qtStock, dateEntree from produit join stock on produit.id=stock.id  where id='"+test+"'";
                ps = con.prepareStatement(requet);
                rs = ps.executeQuery();
                

            if(rs.next()){
                String t1 =rs.getString("nom");
                nom.setText(t1);
                String t2 =rs.getString("pu");
                pu.setText(t2);
                String t3 = rs.getString("quantite")        ;
                quantite.setText(t3);
                Date t4 =rs.getDate("date");
                date.setDate(t4);
                        }  
        } catch (Exception e) {
            System.err.println(e);
        }
            
    }
public void Clear(){
    nom.setText("");
    pu.setText("");
    quantite.setText("");
    date.setDate(null);
    
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_produit = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        r_nom = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quantite = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 204, 0));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Date d'entrée");

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        lst_produit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Libellé", "Nom", "Prix unitaire", "Quantite", "Date d'entrée", "Date_Perm"
            }
        ));
        lst_produit.setColumnSelectionAllowed(true);
        lst_produit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lst_produitMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lst_produit);
        lst_produit.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        r_nom.setBackground(new java.awt.Color(204, 204, 204));
        r_nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_nomActionPerformed(evt);
            }
        });
        r_nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                r_nomKeyReleased(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("MODIFY");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("FIND");

        nom.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("NAME");

        pu.setBackground(new java.awt.Color(204, 204, 204));
        pu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("PRICE_UNIT");

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("QTE");

        quantite.setBackground(new java.awt.Color(204, 204, 204));
        quantite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantiteActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("PRINT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_26px.png"))); // NOI18N

        date.setDateFormatString("yyyy-MM-dd");

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("id");

        id.setEditable(false);
        id.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(quantite))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nom))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pu)))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(r_nom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(r_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantite, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quantiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantiteActionPerformed

    private void puActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if(JOptionPane.showConfirmDialog(null, "Vous etes sur le point de modifier les informations du produit","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
            if(nom.getText().length()!=0){ 
                ps = con.prepareStatement("update produit inner join stock on produit.id=stock.id set nom = ?,prixu =?, qtStock=?, dateEntre=? where produit.id =?");
                ps.setString(1,nom.getText());
                ps.setString(2,pu.getText());
                ps.setString(3,quantite.getText());
                ps.setString(4,((JTextField) date.getDateEditor().getUiComponent()).getText());
                ps.execute();
                Ligne();
                ListeProduit();
                Clear();
                JOptionPane.showMessageDialog(null, "Informations du produit modifiées avec succès!");
            }else{
                JOptionPane.showMessageDialog(null, "selectionner un produit");}}     
        } catch (Exception e) {
            System.err.println(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void r_nomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_r_nomKeyReleased
        try {
            ps = con.prepareStatement("select nom, prixu, qtStock, dateEntre from Produit join stock on produit.id=stock.id where nom like");
            ps.setString(1,"%" +r_nom.getText() + "%");
            rs=ps.executeQuery();
            lst_produit.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
    }//GEN-LAST:event_r_nomKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if(JOptionPane.showConfirmDialog(null, "Vous etes sur le point de supprimer un produit","Suppression",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
            if(nom.getText().length()!=0){
                ps = con.prepareStatement("delete * from Produit, stock where produit.id = stock.id=?");
                ps.execute();
                JOptionPane.showMessageDialog(null,"Produit supprimé avec succes");
             ListeProduit();
             Clear();
             Ligne();
            }else{
                JOptionPane.showMessageDialog(null, "selectionner un produit");}}     
        } catch (Exception e) {
            System.err.println(e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
            DefaultTableModel tableModel = (DefaultTableModel) lst_produit.getModel();
            HashMap<String ,Object> para = new HashMap<>();
            para.put("tittle","");
          /*  JasperPrint jasperprint = null ;
            JasperCompileManager.compileReportToFile("C:\\Users\\julie\\OneDrive\\Bureau\\JavaApplication84\\src\\report1.jrxml");
            jasperprint = JasperFillManager.fillReport("C:\\Users\\julie\\OneDrive\\Bureau\\JavaApplication84\\src\\report1.jasper",para, new JRTableModelDataSource(tableModel));
            JasperViewer.viewReport(jasperprint,false);*/
        }catch(Exception ex){
            System.err.println(ex);

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
                ps = con.prepareStatement("insert into produit (nom ,prixu) values(?,?)");
                ps.setString(1,nom.getText());
                ps.setString(2,pu.getText());
                ps.execute();
                
                ps = con.prepareStatement("insert into stock (qtStock, dateEntre) values (?,?)");
                ps.setString(1, quantite.getText());
                ps.setString(2, ((JTextField) date.getDateEditor().getUiComponent()).getText());
                ps.execute();
                
               
                ps = con.prepareStatement("select id from produit where nom=?");
                
                int ide = Integer.parseInt(id.getText());
                ps.execute();
                
                
                ps= con.prepareStatement("update stock join  produit on produit.id=stock.id set id='"+ ide +"' where id = null ");
                ps.setString(1,"%" +id.getText() + "%");
                ps.execute();
                JOptionPane.showMessageDialog(null,"Enregistré avec succes.");
                ListeProduit();
                Ligne();
                Clear();
            } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lst_produitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lst_produitMouseClicked
        Ligne();
    }//GEN-LAST:event_lst_produitMouseClicked

    private void r_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_r_nomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lst_produit;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField pu;
    private javax.swing.JTextField quantite;
    private javax.swing.JTextField r_nom;
    // End of variables declaration//GEN-END:variables
}
