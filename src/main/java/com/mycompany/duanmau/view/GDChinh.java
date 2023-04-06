/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.duanmau.view;

import com.mycompany.duanmau.viewModel.ChiTietSanPhamViewModel;
import com.mycompany.duanmau.viewModel.GioHangChiTietViewModel;
import com.mycompany.duanmau.viewModel.GioHangViewModel;
import com.mycompany.duanmau.viewModel.HoaDonViewModel;
import com.mycompany.duanmau.entily.ChiTietSP;
import com.mycompany.duanmau.entily.GioHangChiTiet;
import com.mycompany.duanmau.entily.HoaDon;
import com.mycompany.duanmau.entily.HoaDonChiTiet;
import com.mycompany.duanmau.repository.GioHangChiTietRepository;
import com.mycompany.duanmau.repository.HoaDonChiTietRepository;
import com.mycompany.duanmau.request.GioHangChiTietRequest;
import com.mycompany.duanmau.servicer.ChiTietSPService;
import com.mycompany.duanmau.servicer.GioHangChiTietService;
import com.mycompany.duanmau.servicer.HoaDonChiTietService;
import com.mycompany.duanmau.servicer.HoaDonService;
import com.mycompany.duanmau.servicer.impl.ChiTietSPServiceImpl;
import com.mycompany.duanmau.servicer.impl.GioHangChiTietServiceImpl;
import com.mycompany.duanmau.servicer.impl.HoaDonChiTietServiceImpl;
import com.mycompany.duanmau.servicer.impl.HoaDonServiceImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

;

/**
 *
 * @author vinhnv
 */
public class GDChinh extends javax.swing.JFrame {

    /**
     * Creates new form GDQuanLySanPhamChiTiet
     */
    private ButtonGroup buttonGroup = new ButtonGroup();
    private DefaultTableModel tableModel = new DefaultTableModel();
    private ChiTietSPService qlChiTiet = new ChiTietSPServiceImpl();
    private HoaDonService qlHoaDon = new HoaDonServiceImpl();
    private GioHangChiTietService qlGioHangChiTiet = new GioHangChiTietServiceImpl();
    private Map<UUID, ChiTietSanPhamViewModel> mapChiTiet = new HashMap<>();
    private Map<UUID, GioHangViewModel> mapGioHangChiTiet = new HashMap<>();
    private List<ChiTietSanPhamViewModel> listSanPham = new ArrayList<>();
    private HoaDonChiTietService qlHoaDonChiTiet = new HoaDonChiTietServiceImpl();

    public GDChinh() {
        initComponents();
        this.setLocationRelativeTo(null);
        getRadio();
        listSanPham = qlChiTiet.getAll();
        showDataSanPham(listSanPham);
        showDataHoaDon(qlHoaDon.getAll());
    }

    private void getRadio() {
        buttonGroup.add(rd_daTT);
        buttonGroup.add(rd_choTT);
        buttonGroup.add(rd_daHuy);
        buttonGroup.add(rd_tatCa);
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

    private void showDataGioHang(Map<UUID, ChiTietSanPhamViewModel> mapChiTiet) {
        int index = 1;
        tableModel = (DefaultTableModel) tb_gioHang.getModel();
        tableModel.setRowCount(0);
        for (Map.Entry<UUID, ChiTietSanPhamViewModel> entry : mapChiTiet.entrySet()) {
            Object key = entry.getKey();
            ChiTietSanPhamViewModel val = entry.getValue();
            tableModel.addRow(new Object[]{
                index++, val.getMaSanPham(), val.getTenSanPham(),
                val.getSoLuongSanPham(), val.getGiaBan(), getThanhTien(val.getSoLuongSanPham(), val.getGiaBan())
            });
        }
    }

    private void showDataHoaDon(List<HoaDonViewModel> list) {
        int index = 1;
        tableModel = (DefaultTableModel) tb_hoaDon.getModel();
        tableModel.setRowCount(0);
        for (HoaDonViewModel hd : list) {
            tableModel.addRow(new Object[]{
                index++, hd.getMaHoaDon(), hd.getNgayTao(), hd.getTenNhanVien(),
                hd.getTinhTrang() == 1 ? "Chờ thanh toán" : "Đã thanh tóa"
            });
        }

    }

    private void showDataGioHang(List<GioHangViewModel> list) {
        int index = 1;
        tableModel = (DefaultTableModel) tb_gioHang.getModel();
        tableModel.setRowCount(0);
        for (GioHangViewModel gioHangCustom : list) {
            tableModel.addRow(new Object[]{
                index++, gioHangCustom.getMaSP(), gioHangCustom.getTenSP(),
                gioHangCustom.getSoLuong(), gioHangCustom.getDonGia(), getThanhTien(gioHangCustom.getSoLuong(), gioHangCustom.getDonGia())
            });
        }
    }

    private double getThanhTien(int soLuong, BigDecimal giaTien) {
        return giaTien.doubleValue() * soLuong;
    }

    private double getSum() {
        double sum = 0;
        for (Map.Entry<UUID, ChiTietSanPhamViewModel> entry : mapChiTiet.entrySet()) {
            Object key = entry.getKey();
            ChiTietSanPhamViewModel val = entry.getValue();
            sum += getThanhTien(val.getSoLuongSanPham(), val.getGiaBan());
        }
        return sum;
    }

    private double tienDu(double tongTien, double tienDua) {
        return tienDua - tongTien;
    }

    private List<GioHangChiTietRequest> convert(Map<UUID, ChiTietSanPhamViewModel> mapChiTiet) {
        List<GioHangChiTietRequest> listCovert = new ArrayList<>();
        for (Map.Entry<UUID, ChiTietSanPhamViewModel> entry : mapChiTiet.entrySet()) {
            Object key = entry.getKey();
            ChiTietSanPhamViewModel val = entry.getValue();
            GioHangChiTietRequest request = new GioHangChiTietRequest(val.getGiaBan(), val.getGiaBan(), val.getSoLuongSanPham(), val.getIdChiTiet(), null);
            listCovert.add(request);
        }
        return listCovert;
    }

    private void clean() {
        tableModel = (DefaultTableModel) tb_gioHang.getModel();
        tableModel.setRowCount(0);
        txt_maHD.setText("");
        txt_ngayTao.setText("");
        txt_tenNV.setText("");
        txt_tienKhachDua.setText("");
        txt_tienThua.setText("");
        txt_tongTien.setText("");
        //
        txt_maHD.setEditable(false);
        txt_ngayTao.setEditable(false);
        txt_tenNV.setEditable(false);
        txt_tienThua.setEditable(false);
        txt_tienKhachDua.setEditable(false);
        txt_tongTien.setEditable(false);
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
        btn_exitr = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rd_tatCa = new javax.swing.JRadioButton();
        rd_daHuy = new javax.swing.JRadioButton();
        rd_daTT = new javax.swing.JRadioButton();
        btn_taoHD = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_thanhToan = new javax.swing.JButton();
        txt_maHD = new javax.swing.JTextField();
        txt_tenNV = new javax.swing.JTextField();
        txt_tongTien = new javax.swing.JTextField();
        txt_ngayTao = new javax.swing.JTextField();
        txt_tienKhachDua = new javax.swing.JTextField();
        txt_tienThua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rd_choTT = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_sanPham = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_hoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_gioHang = new javax.swing.JTable();

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

        btn_exitr.setBackground(new java.awt.Color(204, 204, 0));
        btn_exitr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_exitr.setText("Exit");
        btn_exitr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_gioHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_quanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
            .addComponent(btn_exitr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_gioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_quanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exitr, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        rd_tatCa.setText("Tất cả");

        rd_daHuy.setText("Đã Hủy");

        rd_daTT.setText("Đã thanh toán");

        btn_taoHD.setText("Tạo Hóa Đơn");
        btn_taoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taoHDActionPerformed(evt);
            }
        });

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        jLabel3.setText("MãHD");

        jLabel4.setText("Ngày Tạo");

        jLabel5.setText("Tên NV");

        jLabel6.setText("Tổng tiền");

        jLabel7.setText("Tiền khách đưa");

        jLabel8.setText("Tiền thừa");

        btn_thanhToan.setText("THANH TOÁN");
        btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhToanActionPerformed(evt);
            }
        });

        txt_tienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienKhachDuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btn_thanhToan)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btn_thanhToan)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Sản phẩm");

        rd_choTT.setText("Chờ thanh toán");

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
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tb_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Ngày Tạo", "Tên NV", "Tình trạng"
            }
        ));
        tb_hoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_hoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_hoaDon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Giỏ Hàng");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Hóa đơn");

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));

        tb_gioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tb_gioHang);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(184, 184, 184)
                                        .addComponent(rd_choTT)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rd_tatCa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rd_daHuy)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rd_daTT))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(btn_taoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(142, 142, 142)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 53, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_choTT)
                    .addComponent(rd_tatCa)
                    .addComponent(rd_daHuy)
                    .addComponent(rd_daTT))
                .addGap(15, 15, 15)
                .addComponent(btn_taoHD)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_sanPhamMouseClicked
        // TODO add your handling code here:

        String maHD = txt_maHD.getText();
        if (maHD.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng tạo hóa đơn !");
            return;
        } else {
            int row = tb_sanPham.getSelectedRow();
            double sum = 0;
            ChiTietSanPhamViewModel custum = listSanPham.get(row);
            String txtSoluong = JOptionPane.showInputDialog(this, "Mời nhập số lượng : ", "0");
            try {
                int soLuong = Integer.valueOf(txtSoluong);
                if (soLuong < 0) {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số lượng => 0  !");
                    return;
                }
                if(custum.getSoLuongSanPham() <= 0 ){
                    JOptionPane.showMessageDialog(rootPane, " Hang da het ! \n" + " Vui lòng chọn sản phẩm khác !!" );
                    return;
                }
                custum.setSoLuongSanPham(soLuong);
                mapChiTiet.put(custum.getIdChiTiet(), custum);
                showDataGioHang(mapChiTiet);
                txt_tongTien.setText(String.valueOf(getSum()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số lượng bằng số !");
            }
        }


    }//GEN-LAST:event_tb_sanPhamMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        String tenSanPham = txt_search.getText().trim();
        if (tenSanPham.length() <= 0) {
            showDataSanPham(qlChiTiet.getAll());
        } else {
            showDataSanPham(qlChiTiet.searchByNameSanPham(tenSanPham));
        }
    }//GEN-LAST:event_btn_searchActionPerformed

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

    private void btn_taoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoHDActionPerformed
        // TODO add your handling code here:
        new GDHoaDon().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_taoHDActionPerformed

    private void tb_hoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_hoaDonMouseClicked
        // TODO add your handling code here:
        int row = tb_hoaDon.getSelectedRow();
        HoaDonViewModel hoaDonCustum = qlHoaDon.getAll().get(row);
        txt_maHD.setText(hoaDonCustum.getMaHoaDon());
        txt_ngayTao.setText(String.valueOf(hoaDonCustum.getNgayTao()));
        txt_tenNV.setText(hoaDonCustum.getTenNhanVien());
        txt_maHD.setEditable(false);
        txt_ngayTao.setEditable(false);
        txt_tenNV.setEditable(false);
        txt_tienThua.setEditable(false);
        //
        txt_tienThua.setEditable(true);
        txt_tienKhachDua.setEditable(true);
        txt_tongTien.setEditable(true);
        List<GioHangViewModel> list = new HoaDonChiTietRepository().getHoaDonChiTietCustom(hoaDonCustum.getIdHoaDon());
        showDataGioHang(list);
        if (hoaDonCustum.getTinhTrang() == 0) {
            btn_thanhToan.setEnabled(false);
        } else {
            btn_thanhToan.setEnabled(true);
        }
        double sum = 0;
        for (GioHangViewModel x : list) {
            double soLuong = x.getSoLuong();
            double donGia = Double.parseDouble(x.getDonGia().toString());
            sum += getThanhTien(x.getSoLuong(), x.getDonGia());
        }
        txt_tongTien.setText(String.valueOf(sum));


    }//GEN-LAST:event_tb_hoaDonMouseClicked

    private void txt_tienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaActionPerformed
        // TODO add your handling code here:
        if (!txt_tienKhachDua.getText().equals("")) {
            try {
                double tienDua = Double.parseDouble(txt_tienKhachDua.getText());
                double tongTien = Double.parseDouble(txt_tongTien.getText());
                if (tienDua < tongTien) {
                    JOptionPane.showMessageDialog(this, "Tiền thanh toán phải lớn hơn tổng tiền");
                    return;
                }
                txt_tienThua.setText(String.valueOf(tienDua - tongTien));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Tiền đưa cần nhập số ");
            }
        }
    }//GEN-LAST:event_txt_tienKhachDuaActionPerformed

    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
        // TODO add your handling code here:
        Date dateHienTai = new Date();
        List<GioHangChiTietRequest> list = convert(mapChiTiet);
        List<ChiTietSP> listChiTietSP = new ArrayList<>();
        List<ChiTietSP> listChiTietSPAll = qlChiTiet.getAllList();
        List<GioHangChiTiet> listGioHangChiTiet = new ArrayList<>();
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        String maHoaDon = txt_maHD.getText().trim();
        HoaDon hoaDon = qlHoaDon.getOne(maHoaDon);
        hoaDon.setTinhTrang(0);
        hoaDon.setNgayThanhToan(dateHienTai);
        qlHoaDon.update(hoaDon);
        for (GioHangChiTietRequest gioHangChiTietRequest : list) {
            listGioHangChiTiet.add(qlGioHangChiTiet.getConvert(gioHangChiTietRequest));
            listHoaDonChiTiet.add(qlHoaDonChiTiet.getConvert(gioHangChiTietRequest, maHoaDon));
        }
        list.stream().forEach(a -> listChiTietSP.add(qlChiTiet.getOne(a.getIdChiTiet())));
        List<GioHangChiTiet> listSaveGioHangChiTiet = qlGioHangChiTiet.saveAll(listGioHangChiTiet);
        List<HoaDonChiTiet> listSaveHoaDonChiTiet = qlHoaDonChiTiet.saveAll(listHoaDonChiTiet);

        for (ChiTietSP chiTietSP : listChiTietSPAll) {
            for (GioHangChiTiet gioHangChiTiet : listSaveGioHangChiTiet) {
                if (chiTietSP.getChiTietSanPhamId().equals(gioHangChiTiet.getChiTietSP().getChiTietSanPhamId())) {
                    System.out.println(gioHangChiTiet.getSoLuong());
                    chiTietSP.setSoLuongTon(chiTietSP.getSoLuongTon() - gioHangChiTiet.getSoLuong());
                    listChiTietSP.add(chiTietSP);
                }
            }
        }
        
        List<ChiTietSP> listUpdateChiTietSP = qlChiTiet.updateAll(listChiTietSP);
        listChiTietSP.forEach(a -> System.out.println(a.getSoLuongTon()));
        showDataHoaDon(qlHoaDon.getAll());
        showDataSanPham(qlChiTiet.getAll());
        clean();
    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void btn_exitrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitrActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_exitrActionPerformed

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
            java.util.logging.Logger.getLogger(GDChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exitr;
    private javax.swing.JButton btn_gioHang;
    private javax.swing.JButton btn_quanLy;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_taoHD;
    private javax.swing.JButton btn_thanhToan;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rd_choTT;
    private javax.swing.JRadioButton rd_daHuy;
    private javax.swing.JRadioButton rd_daTT;
    private javax.swing.JRadioButton rd_tatCa;
    private javax.swing.JTable tb_gioHang;
    private javax.swing.JTable tb_hoaDon;
    private javax.swing.JTable tb_sanPham;
    private javax.swing.JTextField txt_maHD;
    private javax.swing.JTextField txt_ngayTao;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tenNV;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_tongTien;
    // End of variables declaration//GEN-END:variables
}
