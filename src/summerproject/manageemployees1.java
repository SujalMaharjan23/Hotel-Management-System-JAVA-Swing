/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package summerproject;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author SUJAL
 */
public class manageemployees1 extends javax.swing.JFrame {

    /**
     * Creates new form manageemployees
     */
    DefaultTableModel model;
    public manageemployees1() {
        initComponents();
        setRecordsToTable();
    }

    public void setRecordsToTable()
    {
        JTableHeader header = tbl.getTableHeader();
        Font font = new Font("Times New Roman",Font.BOLD,15);
        header.setFont(font);
        tbl.setRowHeight(30);

        try
        {
            C c = new C();
            String sql="SELECT * FROM employeedatabase";
            ResultSet rs = c.state.executeQuery(sql);
            while(rs.next())
            {
                int eid = rs.getInt("eid");
                String name = rs.getString("name").toLowerCase();
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String permanent_address = rs.getString("permanent_address");
                String temporary_address = rs.getString("temporary_address");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                String job = rs.getString("job");
                int salary = rs.getInt("salary");
                
                byte[] img = rs.getBytes("photo");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
                ImageIcon photo = new ImageIcon(myimg);
                
                Object[] obj = {eid,name,age,gender,permanent_address,temporary_address,email,contact,job,salary,photo};
                model = (DefaultTableModel) tbl.getModel();
                model.addRow(obj);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
    }
    
    public void update(int aeid, String aname, int aage, String apermanent_address, String atemporary_address, String aemail, String acontact, String ajob, int asalary)
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem","root","");
            PreparedStatement pst = con.prepareStatement("update employeedatabase set name = ?,age = ?,permanent_address = ?,temporary_address = ?,email = ?,contact = ?,job = ?,salary = ? where eid = ?");
            pst.setString(1,aname);
            pst.setInt(2,aage);
            pst.setString(3,apermanent_address);
            pst.setString(4,atemporary_address);
            pst.setString(5,aemail);
            pst.setString(6,acontact);
            pst.setString(7,ajob);
            pst.setInt(8,asalary);
            pst.setInt(9,aeid);
            
            int rowCount = pst.executeUpdate();
            if(rowCount == 1)
            {
                JOptionPane.showMessageDialog(null,"Data updated successfully!");
                clearTable();
                setRecordsToTable();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Data Update Failed!");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Data Update Failed!");
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Data Update Failed!");
            ex.printStackTrace();
        }
    }
    
    public void delete(int adeid)
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem","root","");
            PreparedStatement pst1 = con1.prepareStatement("delete from employeedatabase where eid = ?");
            pst1.setInt(1,adeid);
            
            int rowCount = pst1.executeUpdate();
            if(rowCount == 1)
            {
                JOptionPane.showMessageDialog(null,"Data deleted successfully!");
                clearTable();
                setRecordsToTable();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Data deletion Failed!");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Data deletion Failed!");
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Data deletion Failed!");
            ex.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        searchtext = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtpaddress = new javax.swing.JTextField();
        txttaddress = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtsalary = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcontact = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtjob = new javax.swing.JComboBox<>();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txteid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("employees");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Search BY Name :");

        tbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EID", "Name", "Age", "Gender", "Permanent Address", "Temporary Address", "Email", "Contact", "Job", "Salary", "Photo"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setMinWidth(40);
            tbl.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbl.getColumnModel().getColumn(0).setMaxWidth(40);
            tbl.getColumnModel().getColumn(2).setMinWidth(40);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbl.getColumnModel().getColumn(2).setMaxWidth(40);
            tbl.getColumnModel().getColumn(3).setMinWidth(60);
            tbl.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbl.getColumnModel().getColumn(3).setMaxWidth(60);
            tbl.getColumnModel().getColumn(7).setMinWidth(100);
            tbl.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(7).setMaxWidth(100);
            tbl.getColumnModel().getColumn(8).setMinWidth(80);
            tbl.getColumnModel().getColumn(8).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(8).setMaxWidth(80);
            tbl.getColumnModel().getColumn(9).setMinWidth(80);
            tbl.getColumnModel().getColumn(9).setPreferredWidth(80);
            tbl.getColumnModel().getColumn(9).setMaxWidth(80);
        }

        searchtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchtextActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 0, 0));
        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel4.setText("Name:");

        jLabel5.setText("Age:");

        jLabel6.setText("Permanent Address:");

        jLabel7.setText("Temporary Address:");

        txtage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtageActionPerformed(evt);
            }
        });

        jLabel9.setText("Salary:");

        jLabel10.setText("Job:");

        jLabel11.setText("Contact:");

        jLabel12.setText("Email:");

        txtjob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Front Desk", "Housekeeping", "Chef", "Guard", "Waiter/Waitress", " " }));
        txtjob.setSelectedIndex(5);

        update.setBackground(new java.awt.Color(0, 0, 0));
        update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        update.setText("Update");
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(0, 0, 0));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        delete.setText("Delete");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel14.setText("Employee ID:");

        txteid.setText("ID No.");
        txteid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtpaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(27, 27, 27)
                            .addComponent(txttaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(332, 332, 332)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsalary)
                            .addComponent(txtcontact)
                            .addComponent(txtemail)
                            .addComponent(txtjob, 0, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(157, 157, 157))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(547, 547, 547))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 990, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jLabel14)
                .addGap(31, 31, 31)
                .addComponent(txteid, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(searchtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txteid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update)
                        .addGap(8, 8, 8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(txtpaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtjob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete)
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtsalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(53, 53, 53)
                .addComponent(back)
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new admin();
    }//GEN-LAST:event_backActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        // TODO add your handling code here:
        int rowNO = tbl.getSelectedRow();
        TableModel model = tbl.getModel();
        txteid.setText(model.getValueAt(rowNO, 0).toString());
        txteid.setEditable(false);
        txtname.setText(model.getValueAt(rowNO, 1).toString());
        txtage.setText(model.getValueAt(rowNO, 2).toString());
        txtpaddress.setText(model.getValueAt(rowNO, 4).toString());
        txttaddress.setText(model.getValueAt(rowNO, 5).toString());
        txtemail.setText(model.getValueAt(rowNO, 6).toString());
        txtcontact.setText(model.getValueAt(rowNO, 7).toString());
        txtjob.setSelectedItem(model.getValueAt(rowNO, 8));
        txtsalary.setText(model.getValueAt(rowNO, 9).toString());
    }//GEN-LAST:event_tblMouseClicked

    private void txtageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtageActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        int rid = Integer.parseInt(txteid.getText());
        String rname = txtname.getText();
        int rage = Integer.parseInt(txtage.getText());
        String rpaddress = txtpaddress.getText();
        String rtaddress = txttaddress.getText();
        String remail = txtemail.getText();
        String rcontact = txtcontact.getText();
        String rjob = (String) txtjob.getSelectedItem();
        int rsalary = Integer.parseInt(txtsalary.getText());
        
        update(rid,rname,rage,rpaddress,rtaddress,remail,rcontact,rjob,rsalary);
    }//GEN-LAST:event_updateActionPerformed

    private void txteidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteidActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txteidActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int rdid = Integer.parseInt(txteid.getText());
        delete(rdid);
    }//GEN-LAST:event_deleteActionPerformed

    public void search(String str)
    {
        model = (DefaultTableModel) tbl.getModel();
        
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tbl.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
        
    }
    
    private void searchtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchtextActionPerformed
        // TODO add your handling code here:
        String searchString = searchtext.getText();
        search(searchString);
    }//GEN-LAST:event_searchtextActionPerformed

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
            java.util.logging.Logger.getLogger(manageemployees1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageemployees1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageemployees1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageemployees1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageemployees1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchtext;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JTextField txteid;
    private javax.swing.JTextField txtemail;
    private javax.swing.JComboBox<String> txtjob;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpaddress;
    private javax.swing.JTextField txtsalary;
    private javax.swing.JTextField txttaddress;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
