/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.duanmau.view;

import com.mycompany.duanmau.entily.ChiTietSP;
import com.mycompany.duanmau.entily.DongSP;
import com.mycompany.duanmau.entily.MauSac;
import com.mycompany.duanmau.entily.NSX;
import com.mycompany.duanmau.entily.SanPham;
import com.mycompany.duanmau.request.ChiTietSPRequest;
import com.mycompany.duanmau.servicer.ChiTietSPService;
import com.mycompany.duanmau.servicer.DongSPService;
import com.mycompany.duanmau.servicer.MauService;
import com.mycompany.duanmau.servicer.NSXService;
import com.mycompany.duanmau.servicer.SanPhamService;
import com.mycompany.duanmau.servicer.impl.ChiTietSPServiceImpl;
import com.mycompany.duanmau.servicer.impl.DongServiceImpl;
import com.mycompany.duanmau.servicer.impl.MauServiceImpl;
import com.mycompany.duanmau.servicer.impl.NSXServiceImpl;
import com.mycompany.duanmau.servicer.impl.SanPhamServiceImpl;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vinhnv
 */
public class GDAddSanPham extends javax.swing.JFrame {

    /**
     * Creates new form GDAddSanPham
     */
    private DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
    private DongSPService qlDong = new DongServiceImpl();
    private MauService qlMau = new MauServiceImpl();
    private NSXService qlNSX = new NSXServiceImpl();
    private SanPhamService qlSanPham = new SanPhamServiceImpl();
    private ChiTietSPService qlChiTiet = new ChiTietSPServiceImpl();

    public GDAddSanPham() {
        initComponents();
        this.setLocationRelativeTo(null);
        comBoxTenSP();
        comBoxDong();
        comBoxMauSP();
        comBoxNSX();
    }

    private void comBoxTenSP() {
        boxModel = (DefaultComboBoxModel) cb_tensp.getModel();
        List<String> list = qlSanPham.getListNameSanPham();
        list.forEach(a -> boxModel.addElement(a));
    }

    private void comBoxDong() {
        boxModel = (DefaultComboBoxModel) cb_dong.getModel();
        List<String> list = qlDong.getListNameSanPham();
        list.forEach(a -> boxModel.addElement(a));
    }

    private void comBoxMauSP() {
        boxModel = (DefaultComboBoxModel) cb_mau.getModel();
        List<String> list = qlMau.getListNameSanPham();
        list.forEach(a -> boxModel.addElement(a));;
    }

    private void comBoxNSX() {
        boxModel = (DefaultComboBoxModel) cb_namSX.getModel();
        List<String> list = qlNSX.getListNameSanPham();
        list.forEach(a -> boxModel.addElement(a));
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
        cb_tensp = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_mau = new javax.swing.JComboBox<>();
        cb_dong = new javax.swing.JComboBox<>();
        cb_namSX = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_giaNhap = new javax.swing.JTextField();
        txt_giaban = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        btn_add = new javax.swing.JButton();
        txt_namBH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        btn_thoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Thêm Sản Phẩm");

        jLabel2.setText("Tên Sản Phẩm : ");

        jLabel3.setText("Dòng Sản Phẩm : ");

        jLabel4.setText("Màu Sản Phẩm : ");

        jLabel5.setText("Năm sản xuất  : ");

        jLabel6.setText("Năm bảo hành : ");

        jLabel7.setText("Giá nhập");

        jLabel8.setText("Giá bán");

        jLabel9.setText("Mô tả ");

        txt_mota.setColumns(20);
        txt_mota.setRows(5);
        jScrollPane1.setViewportView(txt_mota);

        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon("D:\\Hibernate\\DuAnMau\\img\\add-contact-icon.png")); // NOI18N
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel10.setText("Số lượng");

        btn_thoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_thoat.setText("EXIT");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cb_tensp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_mau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_dong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_namSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_giaNhap)
                                .addComponent(txt_giaban)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                .addComponent(txt_namBH, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_soLuong, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_mau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_dong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_namSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_namBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_thoat))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        try {
            int soLuong = Integer.parseInt(txt_soLuong.getText());
            int namBH = Integer.parseInt(txt_namBH.getText());
            ChiTietSPRequest request = new ChiTietSPRequest(cb_tensp.getSelectedItem().toString(),
                    cb_namSX.getSelectedItem().toString(),
                    cb_mau.getSelectedItem().toString(),
                    cb_dong.getSelectedItem().toString(),
                    namBH,
                    txt_mota.getText(),
                    soLuong,
                    new BigDecimal(txt_giaNhap.getText()),
                    new BigDecimal(txt_giaban.getText()));
            int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn muốn tiếp  tục ? ", "Insert", JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {
                String ktra = qlChiTiet.addChiTiet(request);
                JOptionPane.showMessageDialog(rootPane, ktra);
                new GDQuanLySanPham().setVisible(true);
                this.dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "số lượng và năm BH phải là số ");
        }

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        // TODO add your handling code here:
        new GDQuanLySanPham().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_thoatActionPerformed

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
            java.util.logging.Logger.getLogger(GDAddSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDAddSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDAddSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDAddSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDAddSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JComboBox<String> cb_dong;
    private javax.swing.JComboBox<String> cb_mau;
    private javax.swing.JComboBox<String> cb_namSX;
    private javax.swing.JComboBox<String> cb_tensp;
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
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_giaban;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JTextField txt_namBH;
    private javax.swing.JTextField txt_soLuong;
    // End of variables declaration//GEN-END:variables
}
