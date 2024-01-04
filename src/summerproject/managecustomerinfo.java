/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package summerproject;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class managecustomerinfo extends javax.swing.JFrame {

    /**
     * Creates new form searchcustomerinfo
     */
    
    DefaultTableModel model;
    public managecustomerinfo() {
        initComponents();
        setRecordsToTable();
    }

    public void setRecordsToTable()
    {
        try
        {
            C c = new C();
            String sql="SELECT * FROM customerdatabase";
            ResultSet rs = c.state.executeQuery(sql);
            while(rs.next())
            {
                int cid = rs.getInt("cid");
                String name = rs.getString("name").toLowerCase();
                String contact = rs.getString("contact");
                String gender = rs.getString("gender");
                String id = rs.getString("id");
                String arrival = rs.getString("arrival_from");
                String nationality = rs.getString("nationality");
                String postal = rs.getString("postal_address");
                String email = rs.getString("email");
                String room = rs.getString("room");
                String deposit = rs.getString("deposit");
                String time = rs.getString("time");
                Object[] obj = {cid,name,contact,gender,id,arrival,nationality,postal,email,room,deposit,time};
                model = (DefaultTableModel) tbl.getModel();
                JTableHeader header = tbl.getTableHeader();
                Font font = new Font("Times New Roman",Font.BOLD,16);
                header.setFont(font);
                tbl.setRowHeight(20);
                model.addRow(obj);
            }
//            tb.setModel(DbUtils.resultSetToTableModel(rs));
            
//            JTableHeader header = tb.getTableHeader();
//            header.setFont(new Font("TImes New Roman",Font.BOLD,20));
//            tb.getColumnModel().getColumn(0).setHeaderValue("Name");
//            tb.getColumnModel().getColumn(3).setPreferredWidth(20);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void search(String str)
    {
        model = (DefaultTableModel) tbl.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tbl.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
        
    }
    
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
    }
    
    public void update(int acid, String aname, String agender, String acontact, String aemail, String aarrival, String anationality, String apostal, String aroom)
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem","root","");
            PreparedStatement pst = con.prepareStatement("update customerdatabase set name = ?, gender = ?, contact = ?, email = ?, arrival_from = ?, nationality = ?, postal_address = ?, room = ? where cid = ?");
            pst.setString(1,aname);
            pst.setString(2,agender);
            pst.setString(3,acontact);
            pst.setString(4,aemail);
            pst.setString(5,aarrival);
            pst.setString(6,anationality);
            pst.setString(7,apostal);
            pst.setString(8,aroom);
            pst.setInt(9,acid);
            
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
            
            PreparedStatement pst1 = con.prepareStatement("update rooms set availability = 'occupied' where roomnumber = ?");
            pst1.setString(1, aroom);
            pst1.executeUpdate();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Data Update Failed!");
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Data Update Failed!");
            ex.printStackTrace();
        }
    }
    
    public void delete(int adcid, String adroom)
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem","root","");
            PreparedStatement pst2 = con1.prepareStatement("delete from customerdatabase where cid = ?");
            pst2.setInt(1,adcid);
            
            int rowCount = pst2.executeUpdate();
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
            
            PreparedStatement pst3 = con1.prepareStatement("update rooms set availability = 'occupied' where roomnumber = ?");
            pst3.setString(1, adroom);
            pst3.executeUpdate();
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
        txt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        backbutton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        txtContact = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtgender = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtarrival = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtRoom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcid = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtnationality = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtpostal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Search :");

        txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 94, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("customers");

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CID", "Name", "Contact", "Gender", "ID", "Arrival From", "Nationality", "Postal Address", "Email", "Room", "Deposit", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
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
            tbl.getColumnModel().getColumn(2).setMinWidth(100);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(2).setMaxWidth(100);
            tbl.getColumnModel().getColumn(3).setMinWidth(60);
            tbl.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbl.getColumnModel().getColumn(3).setMaxWidth(60);
            tbl.getColumnModel().getColumn(4).setMinWidth(100);
            tbl.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(4).setMaxWidth(100);
            tbl.getColumnModel().getColumn(5).setMinWidth(110);
            tbl.getColumnModel().getColumn(5).setPreferredWidth(110);
            tbl.getColumnModel().getColumn(5).setMaxWidth(110);
            tbl.getColumnModel().getColumn(6).setMinWidth(100);
            tbl.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbl.getColumnModel().getColumn(6).setMaxWidth(100);
            tbl.getColumnModel().getColumn(9).setMinWidth(50);
            tbl.getColumnModel().getColumn(9).setPreferredWidth(50);
            tbl.getColumnModel().getColumn(9).setMaxWidth(50);
            tbl.getColumnModel().getColumn(10).setMinWidth(70);
            tbl.getColumnModel().getColumn(10).setPreferredWidth(70);
            tbl.getColumnModel().getColumn(10).setMaxWidth(70);
            tbl.getColumnModel().getColumn(11).setMinWidth(125);
            tbl.getColumnModel().getColumn(11).setPreferredWidth(125);
            tbl.getColumnModel().getColumn(11).setMaxWidth(125);
        }

        backbutton.setBackground(new java.awt.Color(0, 0, 0));
        backbutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backbutton.setForeground(new java.awt.Color(255, 255, 255));
        backbutton.setText("Back");
        backbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });

        jLabel3.setText("Name:");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel4.setText("Contact:");

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

        jLabel5.setText("Gender:");

        jLabel6.setText("Arrival From:");

        jLabel9.setText("Email:");

        jLabel8.setText("Room:");

        jLabel7.setText("Customer ID:");

        jLabel10.setText("Nationality:");

        txtnationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnationalityActionPerformed(evt);
            }
        });

        jLabel11.setText("Postal Address:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(623, 623, 623)
                        .addComponent(backbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(63, 63, 63)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtgender, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(323, 323, 323)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtarrival, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnationality, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(txtpostal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(156, 156, 156))
            .addGroup(layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(backbutton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtcid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtarrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtpostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtActionPerformed

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyReleased
        // TODO add your handling code here:
        String searchString = txt.getText();
        search(searchString);
    }//GEN-LAST:event_txtKeyReleased

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new admin();
    }//GEN-LAST:event_backbuttonActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int rdid = Integer.parseInt(txtcid.getText());
        String rdroom = txtRoom.getText();
        delete(rdid,rdroom);
    }//GEN-LAST:event_deleteActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        // TODO add your handling code here:
        int rowNO = tbl.getSelectedRow();
        TableModel model = tbl.getModel();
        txtcid.setText(model.getValueAt(rowNO, 0).toString());
        txtname.setText(model.getValueAt(rowNO, 1).toString());
        txtgender.setText(model.getValueAt(rowNO, 3).toString());
        txtContact.setText(model.getValueAt(rowNO, 2).toString());
        txtEmail.setText(model.getValueAt(rowNO, 8).toString());
        txtarrival.setText(model.getValueAt(rowNO, 5).toString());
        txtnationality.setText(model.getValueAt(rowNO, 6).toString());
        txtpostal.setText(model.getValueAt(rowNO, 7).toString());
        txtRoom.setText(model.getValueAt(rowNO, 9).toString());
    }//GEN-LAST:event_tblMouseClicked

    private void txtnationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnationalityActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        int rcid = Integer.parseInt(txtcid.getText());
        String rname = txtname.getText();
        String rcontact = txtContact.getText();
        String rgender = txtgender.getText();
        String rarrival = txtarrival.getText();
        String rnationality = txtnationality.getText();
        String rpostal = txtpostal.getText();
        String remail = txtEmail.getText();
        String rroom = txtRoom.getText();
        
        update(rcid,rname,rgender,rcontact,remail,rarrival,rnationality,rpostal,rroom);
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(managecustomerinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managecustomerinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managecustomerinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managecustomerinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managecustomerinfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbutton;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txt;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtRoom;
    private javax.swing.JTextField txtarrival;
    private javax.swing.JLabel txtcid;
    private javax.swing.JTextField txtgender;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnationality;
    private javax.swing.JTextField txtpostal;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
