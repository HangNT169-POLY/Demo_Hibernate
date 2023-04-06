/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.duanmau.view;

import com.mycompany.duanmau.viewModel.ChiTietSanPhamViewModel;
import com.mycompany.duanmau.entily.ChiTietSP;
import com.mycompany.duanmau.entily.GioHangChiTiet;
import com.mycompany.duanmau.entily.HoaDonChiTiet;
import com.mycompany.duanmau.servicer.ChiTietSPService;
import com.mycompany.duanmau.servicer.DongSPService;
import com.mycompany.duanmau.servicer.GioHangChiTietService;
import com.mycompany.duanmau.servicer.HoaDonChiTietService;
import com.mycompany.duanmau.servicer.MauService;
import com.mycompany.duanmau.servicer.NSXService;
import com.mycompany.duanmau.servicer.SanPhamService;
import com.mycompany.duanmau.servicer.impl.ChiTietSPServiceImpl;
import com.mycompany.duanmau.servicer.impl.DongServiceImpl;
import com.mycompany.duanmau.servicer.impl.GioHangChiTietServiceImpl;
import com.mycompany.duanmau.servicer.impl.HoaDonChiTietServiceImpl;
import com.mycompany.duanmau.servicer.impl.MauServiceImpl;
import com.mycompany.duanmau.servicer.impl.NSXServiceImpl;
import com.mycompany.duanmau.servicer.impl.SanPhamServiceImpl;

import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinhnv
 */
public class GDQuanLySanPham extends javax.swing.JFrame {

    /**
     * Creates new form GDQuanLySanPham
     */
    private DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
    private DongSPService qlDong = new DongServiceImpl();
    private MauService qlMau = new MauServiceImpl();
    private NSXService qlNSX = new NSXServiceImpl();
    private SanPhamService qlSanPham = new SanPhamServiceImpl();
    private ChiTietSPService qlChiTiet = new ChiTietSPServiceImpl();
    private HoaDonChiTietService qlHoaDonChiTiet = new HoaDonChiTietServiceImpl();
    private GioHangChiTietService qlGioHangChiTiet = new GioHangChiTietServiceImpl();
    private DefaultTableModel tableModel = new DefaultTableModel();

    public GDQuanLySanPham() {
        initComponents();
        this.setLocationRelativeTo(null);
        showDataSanPham(qlChiTiet.getAll());
    }

    private void showDataSanPham(List<ChiTietSanPhamViewModel> list) {
        int index = 1;
        tableModel = (DefaultTableModel) tb_sanPham.getModel();
        tableModel.setRowCount(0);
        for (ChiTietSanPhamViewModel ct : list) {
            tableModel.addRow(new Object[]{
                index++, ct.getMaSanPham(), ct.getTenSanPham(), ct.getNamBaoHanh(), ct.getMoTa(),
                ct.getSoLuongSanPham(), ct.getGiaNhap(), ct.getGiaBan()
            });
        }
    }
    
    private void deleteHoaDonChiTiet (List<HoaDonChiTiet> list){
        for (HoaDonChiTiet hoaDonChiTiet : list) {
            qlHoaDonChiTiet.delete(hoaDonChiTiet);
        }
    }
    private void deleteGioHangChiTiet (List<GioHangChiTiet> list){
        for (GioHangChiTiet gioHangChiTiet : list) {
            qlGioHangChiTiet.delete(gioHangChiTiet);
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

        jPanel1 = new javax.swing.JPanel();
        btn_gioHang = new javax.swing.JButton();
        btn_quanLy = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_sanPham = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        btn_gioHang.setBackground(new java.awt.Color(204, 204, 0));
        btn_gioHang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_gioHang.setText("Giỏ hàng");
        btn_gioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gioHangActionPerformed(evt);
            }
        });

        btn_quanLy.setBackground(new java.awt.Color(204, 204, 0));
        btn_quanLy.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_quanLy.setText("Quản lý");
        btn_quanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quanLyActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 255, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("D:\\Hibernate\\DuAnMau\\img\\tải xuống (1).jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_gioHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_quanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_gioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_quanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jPanel6.setForeground(new java.awt.Color(153, 204, 255));

        tb_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Năm bảo hành", "Mô tả", "SL SP", "Giá nhập", "Giá bán"
            }
        ));
        tb_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_sanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_sanPham);

        btn_search.setIcon(new javax.swing.ImageIcon("D:\\Hibernate\\DuAnMau\\img\\Search-icon (1).png")); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btn_search)
                        .addGap(0, 218, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btn_them.setIcon(new javax.swing.ImageIcon("D:\\Hibernate\\DuAnMau\\img\\add-contact-icon.png")); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon("D:\\Hibernate\\DuAnMau\\img\\contact-editor-icon.png")); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon("D:\\Hibernate\\DuAnMau\\img\\delete-icon.png")); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(291, 291, 291))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_gioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gioHangActionPerformed
        // TODO add your handling code here:
        new GDChinh().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_gioHangActionPerformed

    private void btn_quanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quanLyActionPerformed
        // TODO add your handling code here:
        new GDQuanLySanPham().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_quanLyActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        String tenSanPham = txt_search.getText().trim();
        if (tenSanPham.length() <= 0) {
            showDataSanPham(qlChiTiet.getAll());
        } else {
            showDataSanPham(qlChiTiet.searchByNameSanPham(tenSanPham));
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        new GDAddSanPham().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_themActionPerformed

    private void tb_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanPhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_sanPhamMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        int row = tb_sanPham.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sản phẩm cần Update");
            return;
        }
        ChiTietSanPhamViewModel custum = qlChiTiet.getAll().get(row);
        new GDUpdate(custum).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        int row = tb_sanPham.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sản phẩm cần Delete");
            return;
        }
        UUID idChiTiet = qlChiTiet.getAll().get(row).getIdChiTiet();
        ChiTietSP chiTiet = qlChiTiet.getOne(idChiTiet);
        List<GioHangChiTiet> listGioHangChiTiet = qlGioHangChiTiet.getOne(chiTiet.getChiTietSanPhamId());
        List<HoaDonChiTiet> listHoaDonChiTiet = qlHoaDonChiTiet.getOne(chiTiet.getChiTietSanPhamId());
        int chon = JOptionPane.showConfirmDialog(rootPane, "Bạn muốn tiếp  tục ? ", "Insert", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            deleteGioHangChiTiet(listGioHangChiTiet);
            deleteHoaDonChiTiet(listHoaDonChiTiet);
            String ktra = qlChiTiet.delete(chiTiet);
            JOptionPane.showMessageDialog(rootPane, ktra);
            showDataSanPham(qlChiTiet.getAll());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(GDQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDQuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDQuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_gioHang;
    private javax.swing.JButton btn_quanLy;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tb_sanPham;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
