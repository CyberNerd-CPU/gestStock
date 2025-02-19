import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Client extends javax.swing.JInternalFrame {
    
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs ;
        
        static String test;
    public Client() {
          con = Pont.Obtc();
          initComponents();
          ListeClient();
          
    }
    public void ListeClient(){
         try {
            ps = con.prepareStatement("select cni, nom, prenom,sexe, typedc as type  from Client");
            rs= ps.executeQuery();
            lst_clients.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.err.println(e);
        }
    
    }
    
    public void Ligne(){
            try {
                int column = 0;
                int row = lst_clients.getSelectedRow();
                Client.test =(lst_clients.getModel().getValueAt(row,column).toString());
                String requet ="select * from Client where cni ='"+test+"' ";
                ps = con.prepareStatement(requet);
                rs = ps.executeQuery();

            if(rs.next()){
                 String t1 =rs.getString("cni");
                cni.setText(t1);
                String t2 =rs.getString("nom");
                nom.setText(t2);
                String t3 =rs.getString("prenom");
                prenom.setText(t3);
                String t4 =rs.getString("sexe");
                sexe.setSelectedItem(t4);
                String t5 =rs.getString("typedc");
                type.setSelectedItem(t5);
        }  
        } catch (SQLException e) {
            System.err.println(e);
        }
            
            
            
            
            
            
          
    }    
    public void Clear(){
        cni.setText("");
        nom.setText("");
        prenom.setText("");
        sexe.setSelectedItem("Masculin");
        type.setSelectedItem("Grossiste");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_clients = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        nom = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        cni = new javax.swing.JTextField();
        sexe = new javax.swing.JComboBox<>();
        type = new javax.swing.JComboBox<>();
        r_nom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FAMILY");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("NAME");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("sexe");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("CNI");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("type");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        lst_clients.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lst_clients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cni", "Nom", "Prenom", "Sexe", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lst_clients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lst_clientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lst_clients);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_plus_math_30px.png"))); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_trash_32px_1.png"))); // NOI18N
        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_pencil_30px.png"))); // NOI18N
        jButton3.setText("Modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        nom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        prenom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomActionPerformed(evt);
            }
        });

        cni.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        sexe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculin", "Feminin" }));
        sexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexeActionPerformed(evt);
            }
        });

        type.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grossiste", "Detaillant" }));

        r_nom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("FIND BY NAME");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_26px.png"))); // NOI18N

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("mathiasabor@gmail.com");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cni, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(r_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(r_nom))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        
    }//GEN-LAST:event_prenomActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            try {
                ps = con.prepareStatement("insert into Client (cni ,nom ,prenom ,sexe, typedc ) values(?,?,?,?,?)");
                ps.setString(1,cni.getText());
                ps.setString(2,nom.getText());
                ps.setString(3,prenom.getText());
                String sex = sexe.getSelectedItem().toString();
                ps.setString(4,sex);    
                String typ = type.getSelectedItem().toString();
                ps.setString(5,typ);
                ps.execute();
                JOptionPane.showMessageDialog(null,"Enregistré avec succes.");
                    
                Ligne();
                ListeClient();
                Clear();
                ps.close();
                } catch (SQLException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void r_nomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_r_nomKeyReleased
              try {  
                ps = con.prepareStatement("select * from client where nom like ?");        
                ps.setString(1,"%" +r_nom.getText() + "%");
                rs=ps.executeQuery();               
                lst_clients.setModel(DbUtils.resultSetToTableModel(rs));                   
            } catch (SQLException ex) {
           System.err.print(ex.getMessage());
            }  
    }//GEN-LAST:event_r_nomKeyReleased

    private void lst_clientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lst_clientsMouseClicked
        Ligne();
    }//GEN-LAST:event_lst_clientsMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      try {
            if(JOptionPane.showConfirmDialog(null, "Vous ete sur le point de supprimer un client","Suppression",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
            if(cni.getText().length()!=0){
                ps = con.prepareStatement("delete * from Client where cni = ?");
                ps.setString(1, cni.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Client supprimé avec succes");
                ListeClient();
             Clear();
             Ligne();
            }else{
                JOptionPane.showMessageDialog(null, "selectionner un client");}}     
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     try {
            if(JOptionPane.showConfirmDialog(null, "Vous etes sur le point de modifier les informations du client","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
            if(cni.getText().length()!=0){ 
                String t0 = cni.getText();
            String t1 = nom.getText();
            String t2 = prenom.getText();
            String t3 = sexe.getSelectedItem().toString();
            String t4 = type.getSelectedItem().toString();
                    ps = con.prepareStatement("update Client set nom ='"+t1+"', prenom='"+t2+"' ,sexe='"+t3+"',typedc='"+t4+"' where cni='"+t0+"'");
            ps.executeUpdate();
            lst_clients.getSelectedRow();
             ListeClient();
             Clear();
             ps.close();
            }else{
                JOptionPane.showMessageDialog(null, "selectionner un Client");}}     
        } catch (HeadlessException | SQLException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexeActionPerformed
        
    }//GEN-LAST:event_sexeActionPerformed

    private void r_nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_nomActionPerformed
        
    }//GEN-LAST:event_r_nomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cni;
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
    private javax.swing.JTable lst_clients;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField prenom;
    private javax.swing.JTextField r_nom;
    private javax.swing.JComboBox<String> sexe;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
