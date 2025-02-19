import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.proteanit.sql.DbUtils;


public class Personnel extends javax.swing.JInternalFrame {
        Connection con = null;
        PreparedStatement ps;
        ResultSet rs ;
        String imche = null ;
     
    
        
        static String test;
    
    public Personnel() {
        con = Pont.Obtc();
        initComponents();
         ListePersonnel();
    }
    
    public void ListePersonnel(){
         try {
            ps = con.prepareStatement("select id, nom as Nom, prenom as Prenom, sexe as Sexe, type as Type, dateNaissance as Date_Naissance   from personnel");
            rs= ps.executeQuery();
            lst_personnel.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            System.err.println(e);
        }
    
    }
         public ImageIcon ResizeImage(String Imagepath , byte[] pic){
        ImageIcon MyImage = null ;
        if(Imagepath !=null){
            MyImage = new ImageIcon(Imagepath);
        }else{
                    MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
        Image newimg = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newimg);
        return image ;
        
    
        
       }
    
     public void Ligne(){
            try {
                int column = 0;
                int row = lst_personnel.getSelectedRow();
                this.test =(lst_personnel.getModel().getValueAt(row,column).toString());
                String requet ="select * from personnel where id ='"+test+"' ";
                ps = con.prepareStatement(requet);
                rs = ps.executeQuery();
            if(rs.next()){
                String t1 =rs.getString("id");
                id.setText(t1);
                String t2 =rs.getString("nom");
                nom.setText(t2);
                String t3 =rs.getString("prenom");
                prenom.setText(t3);
                String t4 =rs.getString("sexe");
                sexe.setSelectedItem(t4);
                String t5 =rs.getString("type");
                type.setSelectedItem(t5);
                String t6 = rs.getString("mdp");
                mdp.setText(t6);
                Date t7 =rs.getDate("dateNaissance");
                date.setDate(t7);
                image.setIcon(ResizeImage(null,rs.getBytes("image")));
                //image.setSize(164, 215);
                
               
        }  
        } catch (Exception e) {
            System.err.println(e);
        }
            
            
    }
    
    public void Clear(){
        id.setText("");
        nom.setText("");
        prenom.setText("");
        mdp.setText("");
        date.setDate(null);
        image.setIcon(null);
        
        
                }
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lst_personnel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        r_nomp = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        prenom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        id = new javax.swing.JTextField();
        sexe = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        mdp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 0));
        setIconifiable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1080, 729));

        lst_personnel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nom", "Prenom", "Sexe", "Type"
            }
        ));
        lst_personnel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lst_personnelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lst_personnel);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        r_nomp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        r_nomp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r_nompMouseClicked(evt);
            }
        });
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

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("MODIFY");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("FIND BY NAME");

        prenom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Type");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("BIRTH");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("NAME");

        type.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gérant", "Comptable" }));

        id.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        sexe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculin", "Féminin" }));
        sexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("GENDER");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Id");

        nom.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FAMILY");

        image.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("CHOOSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        date.setDateFormatString("yyyy-MM-dd");

        mdp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("PassWord");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_26px.png"))); // NOI18N

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setText("futurinov809@gmail.com");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PERSONNEL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mdp)))
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prenom)
                                    .addComponent(sexe, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addGap(43, 43, 43)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(r_nomp, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mdp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r_nomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lst_personnelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lst_personnelMouseClicked
        Ligne();        // TODO add your handling code here:
    }//GEN-LAST:event_lst_personnelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

  
        
         if(imche !=null){
            
            try {
            ps = con.prepareStatement("insert into Personnel (id ,nom ,prenom ,sexe, type,mdp, dateNaissance,image) values(?,?,?,?,?,?,?,?)");
            InputStream img = new FileInputStream(new File(imche));
            ps.setString(1,id.getText());
            ps.setString(2,nom.getText());
            ps.setString(3,prenom.getText());
            String sex = sexe.getSelectedItem().toString();
            ps.setString(4,sex);
            String typ = type.getSelectedItem().toString();
            ps.setString(5,typ);
            ps.setString(6,mdp.getText());
            ps.setString(7, ((JTextField) date.getDateEditor().getUiComponent()).getText());
            ps.setBlob(8, img);
            ps.execute();
            ListePersonnel();
            Clear();
            Ligne();
            ps.close(); 
            if(ps.executeUpdate()==1){
                    Ligne();
                    JOptionPane.showMessageDialog(null,"personnel enregistre avec succes");
                    imche=null;
            }else{
            JOptionPane.showMessageDialog(null,"Une erreur cest produite");
            }
            }catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }catch (FileNotFoundException ex) {
                Logger.getLogger(Personnel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null,"aucune image selectionner");
        }
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            if(JOptionPane.showConfirmDialog(null, "Vous ete sur le point de supprimer une personne","Suppression",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                if(id.getText().length()!=0){
                    ps = con.prepareStatement("delete from personnel where id = ?");
                    ps.setString(1, id.getText());
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Personne supprimée avec succes");
                    ListePersonnel();
                    Clear();
                    ps.close();
                }else{
                    JOptionPane.showMessageDialog(null, "selectionner une personne");}}
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void lst_personnelsMouseClicked(java.awt.event.MouseEvent evt) {                                         
        Ligne();        // TODO add your handling code here:
    }    
    private void r_nompKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_r_nompKeyReleased
        // TODO add your handling code here:
        try {
            ps = con.prepareStatement("select * from personnel where nom like ?");
            ps.setString(1,"%" +r_nomp.getText() + "%");
            rs=ps.executeQuery();
            lst_personnel.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
    }//GEN-LAST:event_r_nompKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if(JOptionPane.showConfirmDialog(null, "Vous ete sur le point de modifier les informations d'une personne","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                if(id.getText().length()!=0){
                
                    ps = con.prepareStatement("update personnel set nom = ?,prenom =?,sexe  = ?,type =?, mdp =?,image=? where id =?");    
                    ps.setString(1,id.getText());
                    ps.setString(2,nom.getText());
                    ps.setString(3,prenom.getText());
                    ps.setString(4,sexe.getSelectedItem().toString());
                    ps.setString(5,type.getSelectedItem().toString());
                    ps.setString(6,mdp.getText());
                    ps.setString(7,((JTextField) date.getDateEditor().getUiComponent()).getText());
                    InputStream img = new FileInputStream(new File(imche));
                    ps.setBlob(8, img);
                    
                    ps.executeUpdate();
                    ps.execute();
                    ListePersonnel();
                    Clear();
                }else{
                    JOptionPane.showMessageDialog(null, "selectionner une personne");}}
        } catch (Exception e) {
            System.err.println(e);
        }
        
      

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomActionPerformed

    private void r_nompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_nompActionPerformed
        // TODO add your handling code he
    }//GEN-LAST:event_r_nompActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          JFileChooser file = new  JFileChooser();
        file.setCurrentDirectory( new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filtre = new FileNameExtensionFilter("*.Image","jpg","png","jpeg");
        file.addChoosableFileFilter(filtre);
        
        int res = file.showSaveDialog(null);
        
        if(res == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String chemin = selectedFile.getAbsolutePath();
            image.setIcon(ResizeImage(chemin,null));
            imche=chemin;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void r_nompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r_nompMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_r_nompMouseClicked

    private void sexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField id;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable lst_personnel;
    private javax.swing.JTextField mdp;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField prenom;
    private javax.swing.JTextField r_nomp;
    private javax.swing.JComboBox<String> sexe;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
