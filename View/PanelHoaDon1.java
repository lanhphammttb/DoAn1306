/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CChiTietHoaDon;
import static Controller.CChiTietHoaDon.LayDuLieuChiTietHoaDon;
import Main.MainClass;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Controller.CHoaDon;
import static Controller.CHoaDon.LayDuLieuHoaDon;
import Controller.CKhachHang;
import Controller.CNhanVien;
import static Controller.CSanPham.GetGiaSanPham;
import Controller.KiemTraDuLieu_Controller;
import Controller.UserInfo;
import Database.CalendarAdapter;
import Database.ConnectDB;
import Database.PrintPDF;
import Model.ChiTietHoaDon;
import Model.HoaDon;
import Model.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.TableModel;

public class PanelHoaDon1 extends javax.swing.JPanel {
    DefaultTableModel tblDanhSach;
    DefaultTableModel tblDanhSach2;
    java.util.List<HoaDon> arr = new ArrayList<>();
    java.util.List<ChiTietHoaDon> arr2 = new ArrayList<>();
    String MaHoaDon, MaKhachHang, MaNhanVien, NgayLapHoaDon, TongTien, GhiChu, sMaHoaDonTim;
    String MaCTHD, MaSanPham, SoLuong, sMaCTHDTim;
    
    boolean ktThem;
    String macu;
    SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy");
    Date date;
	public PanelHoaDon1() {
		initComponents();
        tblDanhSach = (DefaultTableModel) tblHoaDon_HoaDon.getModel();
        tblDanhSach2 = (DefaultTableModel) tblCTHoaDon_ChiTietHoaDon.getModel();
//        DesginTable();
        KhoaMo(true);
        sMaHoaDonTim = "";
        LayNguonHD();
        KhoaMo2(true);
        sMaCTHDTim = "";
        LayNguonCTHD();
	}
    public void KhoaMo(boolean b){
        btnThem_HoaDon.setEnabled(b);
        btnSua_HoaDon.setEnabled(b);
        btnXoa_HoaDon.setEnabled(b);

        btGhi_HoaDon.setEnabled(!b);
        btKhong_HoaDon.setEnabled(!b);       
        
        txtMaPhieuMua_HoaDon.setEditable(!b);
        cbbKhachHang_HoaDon.setEditable(!b);
        cbbNhanVien_HoaDon.setEditable(!b);
        dtNgayLapHoaDon.setEnabled(!b);
        txtTongTien_HoaDon.setEnabled(!b);
        txtGhiChu_HoaDon.setEditable(!b);
               
        tblHoaDon_HoaDon.setEnabled(b);
    }
    public void KhoaMo2(boolean b){       
        btnThem_ChiTietHoaDon.setEnabled(b);
        btnSua_ChiTietHoaDon.setEnabled(b);
        btnXoa_ChiTietHoaDon.setEnabled(b);
        
        btGhi_ChiTietHoaDon.setEnabled(!b);
        btKhong_ChiTietHoaDon.setEnabled(!b);
                
        txtMaCTHD_ChiTietHoaDon.setEditable(!b);       
        txtMaHoaDon_ChiTietHoaDon.setEditable(!b);
        cbbSanPham_ChiTietHoaDon.setEnabled(!b);
        txtSoLuong_ChiTietHoaDon.setEditable(!b);
        txtTongTien_ChiTietHoaDon.setEnabled(!b);

        tblCTHoaDon_ChiTietHoaDon.setEnabled(b);
    }    
    public void XoaTrang(){
        txtMaPhieuMua_HoaDon.setText("");
        cbbKhachHang_HoaDon.setSelectedIndex(0);
        cbbNhanVien_HoaDon.setSelectedIndex(0);
        sDF.format(dtNgayLapHoaDon.getDate());
        txtTongTien_HoaDon.setText("");       
        txtGhiChu_HoaDon.setText("");
    }
    public void XoaTrang2(){
        txtMaCTHD_ChiTietHoaDon.setText("");
        txtMaHoaDon_ChiTietHoaDon.setText("");
        txtSoLuong_ChiTietHoaDon.setText("");
        txtTongTien_ChiTietHoaDon.setText("");
        txtGhiChu_ChiTietHoaDon.setText("");
        cbbSanPham_ChiTietHoaDon.setSelectedIndex(0);
    }    
    public void  LayNguonHD(){
        arr = CHoaDon.LayNguonHD(sMaHoaDonTim);
        tblDanhSach.setRowCount(0); // xóa trắng danh sách
        arr.forEach(p->{
            tblDanhSach.addRow(new Object[]{
                p.getMaHoaDon(), p.getMaKhachHang(),p.getMaNhanVien(),p.getNgayLapHoaDon(),p.getTongTien(),p.getGhiChu()
            });
        });
    }  
    
    public void  LayNguonCTHD(){
        arr2 = CChiTietHoaDon.LayNguonCTHD(sMaCTHDTim);
        tblDanhSach2.setRowCount(0); // xóa trắng danh sách
        arr2.forEach(p->{
            tblDanhSach2.addRow(new Object[]{
                p.getMaCTHD(), p.getMaHoaDon(),p.getMaSanPham(),p.getSoLuong(),p.getTongTien(),p.getGhiChu()
            });
        });
    }
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTabbedPaneHoaDon = new javax.swing.JTabbedPane();
        jPanelHoaDon = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblHoaDon_HoaDon = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblCTHoaDon_ChiTietHoaDon = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lblMaHoaDon_HoaDon = new javax.swing.JLabel();
        lblTongTien_HoaDon = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtTongTien_HoaDon = new javax.swing.JTextField();
        cbbKhachHang_HoaDon = new javax.swing.JComboBox<>();
        cbbNhanVien_HoaDon = new javax.swing.JComboBox<>();
        txtMaPhieuMua_HoaDon = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtGhiChu_HoaDon = new javax.swing.JTextArea();
        btnThem_HoaDon = new javax.swing.JButton();
        btnSua_HoaDon = new javax.swing.JButton();
        lblNgayLap = new javax.swing.JLabel();
        btnXoa_HoaDon = new javax.swing.JButton();
        btGhi_HoaDon = new javax.swing.JButton();
        btKhong_HoaDon = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        lblMaCTPM = new javax.swing.JLabel();
        lblSoLuong_CTPM = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtTongTien_ChiTietHoaDon = new javax.swing.JTextField();
        cbbSanPham_ChiTietHoaDon = new javax.swing.JComboBox<>();
        txtMaCTHD_ChiTietHoaDon = new javax.swing.JTextField();
        jScrollPane17 = new javax.swing.JScrollPane();
        txtGhiChu_ChiTietHoaDon = new javax.swing.JTextArea();
        txtMaHoaDon_ChiTietHoaDon = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtSoLuong_ChiTietHoaDon = new javax.swing.JTextField();
        dtNgayLapHoaDon = new com.toedter.calendar.JDateChooser();
        btnThem_ChiTietHoaDon = new javax.swing.JButton();
        btnSua_ChiTietHoaDon = new javax.swing.JButton();
        btnXoa_ChiTietHoaDon = new javax.swing.JButton();
        btGhi_ChiTietHoaDon = new javax.swing.JButton();
        btKhong_ChiTietHoaDon = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1220, 640));

        jPanelHoaDon.setBackground(new java.awt.Color(204, 204, 255));
        jPanelHoaDon.setPreferredSize(new java.awt.Dimension(1176, 581));
        jPanelHoaDon.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelHoaDonComponentShown(evt);
            }
        });

        tblHoaDon_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Khách Hàng", "Nhân Viên", "Ngày Lập HĐ", "Tổng Tiền", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDon_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblHoaDon_HoaDon);

        tblCTHoaDon_ChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã CTHD", "Mã Hóa Đơn", "Sản Phẩm", "Số Lượng", "Tổng Tiền", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCTHoaDon_ChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHoaDon_ChiTietHoaDonMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblCTHoaDon_ChiTietHoaDon);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 102, 255));
        jLabel34.setText("Bảng Chi Tiết Hóa Đơn");

        jPanel14.setBackground(new java.awt.Color(204, 204, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(400, 227));

        jLabel33.setText("Ghi Chú");

        lblMaHoaDon_HoaDon.setText("Mã Hóa Đơn");

        lblTongTien_HoaDon.setText("Tổng Tiền");

        jLabel31.setText("Nhân Viên");

        jLabel30.setText("Khách Hàng");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        txtTongTien_HoaDon.setEditable(false);
        txtTongTien_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTien_HoaDonActionPerformed(evt);
            }
        });

        cbbKhachHang_HoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhachHang_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhachHang_HoaDonActionPerformed(evt);
            }
        });

        cbbNhanVien_HoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNhanVien_HoaDon.setActionCommand("");
        cbbNhanVien_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhanVien_HoaDonActionPerformed(evt);
            }
        });

        txtMaPhieuMua_HoaDon.setEditable(false);

        txtGhiChu_HoaDon.setColumns(20);
        txtGhiChu_HoaDon.setRows(5);
        jScrollPane16.setViewportView(txtGhiChu_HoaDon);

        btnThem_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file_blank_paper_document_page_icon_196467.png"))); // NOI18N
        btnThem_HoaDon.setText("Thêm ");
        btnThem_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_HoaDonActionPerformed(evt);
            }
        });

        btnSua_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings_options_configuration_setting_system_icon_196481.png"))); // NOI18N
        btnSua_HoaDon.setText("Sửa");
        btnSua_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_HoaDonActionPerformed(evt);
            }
        });

        lblNgayLap.setText("Ngày Lập");
        lblNgayLap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNgayLapMouseClicked(evt);
            }
        });

        btnXoa_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bin_trash_rubbish_dustbin_remove_icon_196490.png"))); // NOI18N
        btnXoa_HoaDon.setText("Xóa");
        btnXoa_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_HoaDonActionPerformed(evt);
            }
        });

        btGhi_HoaDon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btGhi_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seo-social-web-network-internet_273_icon-icons.com_61489.png"))); // NOI18N
        btGhi_HoaDon.setText("Ghi");
        btGhi_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGhi_HoaDonActionPerformed(evt);
            }
        });

        btKhong_HoaDon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btKhong_HoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/no_icon_128419.png"))); // NOI18N
        btKhong_HoaDon.setText("Không");
        btKhong_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhong_HoaDonActionPerformed(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(204, 204, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(400, 230));

        jLabel36.setText("Ghi Chú");

        lblMaCTPM.setText("Mã CTHD");

        lblSoLuong_CTPM.setText("Số Lượng");

        lblMaHoaDon.setText("Mã Hóa Đơn");

        jLabel40.setText("Sản Phẩm");

        txtTongTien_ChiTietHoaDon.setEditable(false);
        txtTongTien_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTien_ChiTietHoaDonActionPerformed(evt);
            }
        });

        cbbSanPham_ChiTietHoaDon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSanPham_ChiTietHoaDonItemStateChanged(evt);
            }
        });

        txtMaCTHD_ChiTietHoaDon.setEditable(false);

        txtGhiChu_ChiTietHoaDon.setColumns(20);
        txtGhiChu_ChiTietHoaDon.setRows(5);
        jScrollPane17.setViewportView(txtGhiChu_ChiTietHoaDon);

        txtMaHoaDon_ChiTietHoaDon.setEditable(false);

        jLabel57.setText("Thành Tiền");

        txtSoLuong_ChiTietHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoLuong_ChiTietHoaDonKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuong_ChiTietHoaDonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSoLuong_CTPM)
                            .addComponent(jLabel57)
                            .addComponent(lblMaCTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMaCTHD_ChiTietHoaDon)
                    .addComponent(txtMaHoaDon_ChiTietHoaDon)
                    .addComponent(cbbSanPham_ChiTietHoaDon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTongTien_ChiTietHoaDon, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong_ChiTietHoaDon, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addGap(190, 190, 190))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaCTHD_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaCTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHoaDon_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSanPham_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuong_CTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(txtTongTien_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18))
        );

        dtNgayLapHoaDon.setDateFormatString("dd/MM/yyyy");

        btnThem_ChiTietHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file_blank_paper_document_page_icon_196467.png"))); // NOI18N
        btnThem_ChiTietHoaDon.setText("Thêm");
        btnThem_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_ChiTietHoaDonActionPerformed(evt);
            }
        });

        btnSua_ChiTietHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings_options_configuration_setting_system_icon_196481.png"))); // NOI18N
        btnSua_ChiTietHoaDon.setText("Sửa");
        btnSua_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_ChiTietHoaDonActionPerformed(evt);
            }
        });

        btnXoa_ChiTietHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bin_trash_rubbish_dustbin_remove_icon_196490.png"))); // NOI18N
        btnXoa_ChiTietHoaDon.setText("Xóa");
        btnXoa_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_ChiTietHoaDonActionPerformed(evt);
            }
        });

        btGhi_ChiTietHoaDon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btGhi_ChiTietHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seo-social-web-network-internet_273_icon-icons.com_61489.png"))); // NOI18N
        btGhi_ChiTietHoaDon.setText("Ghi");
        btGhi_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGhi_ChiTietHoaDonActionPerformed(evt);
            }
        });

        btKhong_ChiTietHoaDon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btKhong_ChiTietHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/no_icon_128419.png"))); // NOI18N
        btKhong_ChiTietHoaDon.setText("Không");
        btKhong_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhong_ChiTietHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaHoaDon_HoaDon)
                            .addComponent(lblTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayLap)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTongTien_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(cbbNhanVien_HoaDon, 0, 208, Short.MAX_VALUE)
                                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addComponent(cbbKhachHang_HoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dtNgayLapHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaPhieuMua_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btGhi_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btKhong_HoaDon)
                        .addComponent(btnThem_ChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addComponent(btnSua_ChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoa_ChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btGhi_ChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btKhong_ChiTietHoaDon))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaHoaDon_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaPhieuMua_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbKhachHang_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNhanVien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnThem_HoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua_HoaDon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgayLap)
                            .addComponent(dtNgayLapHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnXoa_HoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGhi_HoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btKhong_HoaDon)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnThem_ChiTietHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua_ChiTietHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa_ChiTietHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGhi_ChiTietHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btKhong_ChiTietHoaDon)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 102, 255));
        jLabel35.setText("Bảng Hóa Đơn");

        javax.swing.GroupLayout jPanelHoaDonLayout = new javax.swing.GroupLayout(jPanelHoaDon);
        jPanelHoaDon.setLayout(jPanelHoaDonLayout);
        jPanelHoaDonLayout.setHorizontalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel34))
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHoaDonLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );
        jPanelHoaDonLayout.setVerticalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        jTabbedPaneHoaDon.addTab("Phiếu Mua Hàng", jPanelHoaDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelHoaDonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelHoaDonComponentShown
        LayDuLieuHoaDon();
        cbbNhanVien_HoaDon.setModel(LayDuLieucbb("NhanVien", "TenNhanVien", "MaNhanVien"));
        cbbKhachHang_HoaDon.setModel(LayDuLieucbb("KhachHang", "TenKhachHang", "MaKhachHang"));
        cbbSanPham_ChiTietHoaDon.setModel(LayDuLieucbb("SanPham", "TenSanPham", "MaSanPham"));
        try {
            date = sDF.parse(NgayLapHoaDon);
            dtNgayLapHoaDon.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_jPanelHoaDonComponentShown

    private void txtSoLuong_ChiTietHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuong_ChiTietHoaDonKeyReleased
        int SoLuong = 0;
        double Tien = 0;
        try {
            SoLuong = Integer.valueOf(txtSoLuong_ChiTietHoaDon.getText());
        } catch (Exception e) {
        }
        int Gia = GetGiaSanPham(GetCbbSelected(cbbSanPham_ChiTietHoaDon));
        Tien = (double) Gia * SoLuong;
        txtTongTien_ChiTietHoaDon.setText(String.valueOf(Tien));
    }//GEN-LAST:event_txtSoLuong_ChiTietHoaDonKeyReleased

    private void txtSoLuong_ChiTietHoaDonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuong_ChiTietHoaDonKeyPressed

    }//GEN-LAST:event_txtSoLuong_ChiTietHoaDonKeyPressed

    private void btnSua_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_ChiTietHoaDonActionPerformed
        if(txtMaCTHD_ChiTietHoaDon.getText().length()<=0)
        return;
        macu = txtMaCTHD_ChiTietHoaDon.getText();
        ktThem = false;
        KhoaMo(false);
        txtMaCTHD_ChiTietHoaDon.requestFocus(); 
    }//GEN-LAST:event_btnSua_ChiTietHoaDonActionPerformed

    private void btnXoa_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_ChiTietHoaDonActionPerformed
        if(txtMaCTHD_ChiTietHoaDon.getText().length()<=0)
        return;
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa [" + txtMaCTHD_ChiTietHoaDon.getText() + "] không ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.YES_OPTION) {
            macu = txtMaCTHD_ChiTietHoaDon.getText();
            CKhachHang.XoaBo(macu);
            LayNguonCTHD();
            XoaTrang2();
        }  
    }//GEN-LAST:event_btnXoa_ChiTietHoaDonActionPerformed

    private void btnThem_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_ChiTietHoaDonActionPerformed
        XoaTrang2();
        KhoaMo2(false);
        ktThem = true;
        txtMaCTHD_ChiTietHoaDon.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem_ChiTietHoaDonActionPerformed

    private void cbbSanPham_ChiTietHoaDonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSanPham_ChiTietHoaDonItemStateChanged
        int SoLuong = 0;
        double Tien = 0;
        try {
            SoLuong = Integer.valueOf(txtSoLuong_ChiTietHoaDon.getText());
        } catch (Exception e) {
        }
        int Gia = GetGiaSanPham(GetCbbSelected(cbbSanPham_ChiTietHoaDon));
        Tien = (double) Gia * SoLuong;
        txtTongTien_ChiTietHoaDon.setText(String.valueOf(Tien));
    }//GEN-LAST:event_cbbSanPham_ChiTietHoaDonItemStateChanged

    private void txtTongTien_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien_ChiTietHoaDonActionPerformed

    }//GEN-LAST:event_txtTongTien_ChiTietHoaDonActionPerformed

    private void lblNgayLapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNgayLapMouseClicked

    }//GEN-LAST:event_lblNgayLapMouseClicked

    private void btnSua_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_HoaDonActionPerformed
        if(txtMaPhieuMua_HoaDon.getText().length()<=0)
        return;
        macu = txtMaPhieuMua_HoaDon.getText();
        ktThem = false;
        KhoaMo(false);
        txtMaPhieuMua_HoaDon.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSua_HoaDonActionPerformed

    private void btnXoa_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_HoaDonActionPerformed
        if(txtMaPhieuMua_HoaDon.getText().length()<=0)
        return;
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa [" + txtMaPhieuMua_HoaDon.getText() + "] không ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.YES_OPTION) {
            macu = txtMaPhieuMua_HoaDon.getText();
            CKhachHang.XoaBo(macu);
            LayNguonHD();
            XoaTrang();
        }
    }//GEN-LAST:event_btnXoa_HoaDonActionPerformed

    private void btnThem_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_HoaDonActionPerformed
        XoaTrang();
        KhoaMo(false);
        ktThem = true;
        txtMaPhieuMua_HoaDon.requestFocus();       
    }//GEN-LAST:event_btnThem_HoaDonActionPerformed

    private void txtTongTien_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien_HoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTien_HoaDonActionPerformed

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        //        frmKhachHang frmk=new frmKhachHang();
        //        frmk.show();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void tblCTHoaDon_ChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHoaDon_ChiTietHoaDonMouseClicked
        int viTriDongVuaBam = tblCTHoaDon_ChiTietHoaDon.getSelectedRow();
        txtMaCTHD_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 1).toString());
        txtMaHoaDon_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 2).toString());
        txtSoLuong_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 4).toString());
        txtTongTien_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 5).toString());
        txtGhiChu_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 6).toString());
        setSelectedCombobox(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 3).toString(), cbbSanPham_ChiTietHoaDon);
        LayDuLieuChiTietHoaDon(txtMaPhieuMua_HoaDon.getText());
    }//GEN-LAST:event_tblCTHoaDon_ChiTietHoaDonMouseClicked

    private void tblHoaDon_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon_HoaDonMouseClicked
        int index = tblHoaDon_HoaDon.getSelectedRow();
        TableModel model = tblHoaDon_HoaDon.getModel();
        MaHoaDon = model.getValueAt(index, 0).toString();
        MaKhachHang = model.getValueAt(index, 1).toString();
        MaNhanVien = model.getValueAt(index, 2).toString();
        NgayLapHoaDon = model.getValueAt(index, 3).toString();
        TongTien = model.getValueAt(index, 4).toString();
        GhiChu = model.getValueAt(index, 5).toString();

        txtMaPhieuMua_HoaDon.setText(MaHoaDon);
        cbbKhachHang_HoaDon.setSelectedItem(MaKhachHang);
        cbbNhanVien_HoaDon.setSelectedItem(MaNhanVien);
        try {
            date = sDF.parse(NgayLapHoaDon);
            dtNgayLapHoaDon.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
        }        
        txtTongTien_HoaDon.setText(TongTien);
        txtGhiChu_HoaDon.setText(GhiChu);
        LayDuLieuChiTietHoaDon(txtMaPhieuMua_HoaDon.getText());
        if (tblCTHoaDon_ChiTietHoaDon.getRowCount() > 0) {
            cbbSanPham_ChiTietHoaDon.setModel(LayDuLieucbb("SanPham", "TenSanPham", "MaSanPham"));
            txtMaCTHD_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 1).toString());
            txtMaHoaDon_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 2).toString());
            txtSoLuong_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 4).toString());
            txtTongTien_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 5).toString());
            txtGhiChu_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 6).toString());
            setSelectedCombobox(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 3).toString(), cbbSanPham_ChiTietHoaDon);
        } else {
            XoaTrang2();
            txtMaHoaDon_ChiTietHoaDon.setText(txtMaPhieuMua_HoaDon.getText());
        }
    }//GEN-LAST:event_tblHoaDon_HoaDonMouseClicked

    private void cbbNhanVien_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhanVien_HoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhanVien_HoaDonActionPerformed

    private void cbbKhachHang_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhachHang_HoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHang_HoaDonActionPerformed

    private void btGhi_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGhi_HoaDonActionPerformed
        //kiểm tra dữ liệu rỗng
        if(txtMaPhieuMua_HoaDon.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã hóa đơn","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtMaPhieuMua_HoaDon.requestFocus();
            return;
        }
        if(cbbKhachHang_HoaDon.getSelectedItem().toString().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập khách hàng","Thông Báo",JOptionPane.WARNING_MESSAGE);
            cbbKhachHang_HoaDon.requestFocus();
            return;
        }
        if(cbbNhanVien_HoaDon.getSelectedItem().toString().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập nhân viên","Thông Báo",JOptionPane.WARNING_MESSAGE);
            cbbNhanVien_HoaDon.requestFocus();
            return;
        }
        if(sDF.format(dtNgayLapHoaDon.getDate()).length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ","Thông Báo",JOptionPane.WARNING_MESSAGE);
            dtNgayLapHoaDon.requestFocus();
            return;
        }

        //kiểm tra tính hợp lệ của dữ liệu
        //kiểm tra trùng mã (trùng khóa chính - xây dựng hàm kiểm tra trong controlle)
        if(KiemTraDuLieu_Controller.KiemTraTrungMa("HoaDon", "MaHoaDon", txtMaPhieuMua_HoaDon.getText(), ktThem, macu)==true){
            JOptionPane.showMessageDialog(this, "Bạn nhập trùng mã lớp","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtMaPhieuMua_HoaDon.requestFocus();
            return;
        }
        //thực hiện ghi

        MaNhanVien  = txtMaPhieuMua_HoaDon.getText();
        MaKhachHang = cbbKhachHang_HoaDon.getSelectedItem().toString();
        MaNhanVien  = cbbNhanVien_HoaDon.getSelectedItem().toString();
        NgayLapHoaDon = sDF.format(dtNgayLapHoaDon.getDate());
        TongTien    = txtTongTien_HoaDon.getText();
        GhiChu      =txtGhiChu_HoaDon.getText();
        
        HoaDon hd = new HoaDon(MaHoaDon, MaKhachHang, MaNhanVien, NgayLapHoaDon, TongTien, GhiChu);
        if(ktThem==true){
            CHoaDon.ThemMoi(hd);
        }
        else{
            CHoaDon.CapNhat(hd, macu);
        }
        //lấy nguồn dữ liệu mới
        LayNguonHD();
        KhoaMo(true);
    }//GEN-LAST:event_btGhi_HoaDonActionPerformed

    private void btKhong_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhong_HoaDonActionPerformed
        XoaTrang();
        KhoaMo(true);
    }//GEN-LAST:event_btKhong_HoaDonActionPerformed

    private void btGhi_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGhi_ChiTietHoaDonActionPerformed
        //kiểm tra dữ liệu rỗng
        if(txtMaCTHD_ChiTietHoaDon.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã chi tiết hóa đơn","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtMaCTHD_ChiTietHoaDon.requestFocus();
            return;
        }
        if(txtMaHoaDon_ChiTietHoaDon.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã hóa đơn","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtMaHoaDon_ChiTietHoaDon.requestFocus();
            return;
        }
        if(cbbSanPham_ChiTietHoaDon.getSelectedItem().toString().length()<=0){
            JOptionPane.showMessageDialog(this, "sản phẩm","Thông Báo",JOptionPane.WARNING_MESSAGE);
            cbbSanPham_ChiTietHoaDon.requestFocus();
            return;
        }
        if(txtSoLuong_ChiTietHoaDon.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng sản phẩm","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtSoLuong_ChiTietHoaDon.requestFocus();
            return;
        }

        //kiểm tra tính hợp lệ của dữ liệu
        //kiểm tra trùng mã (trùng khóa chính - xây dựng hàm kiểm tra trong controlle)
        if(KiemTraDuLieu_Controller.KiemTraTrungMa("ChiTietHoaDon", "MaCTHD", txtMaCTHD_ChiTietHoaDon.getText(), ktThem, macu)==true){
                    JOptionPane.showMessageDialog(this, "Bạn nhập trùng mã khách hàng","Thông báo",JOptionPane.ERROR_MESSAGE);
                    txtMaCTHD_ChiTietHoaDon.requestFocus();
                    return;
                } 
        //thực hiện ghi
        MaCTHD  = txtMaCTHD_ChiTietHoaDon.getText();
        MaHoaDon= txtMaHoaDon_ChiTietHoaDon.getText();
        MaSanPham = cbbSanPham_ChiTietHoaDon.getSelectedItem().toString();
        SoLuong = txtSoLuong_ChiTietHoaDon.getText();
        TongTien = txtTongTien_ChiTietHoaDon.getText();
        GhiChu = txtGhiChu_ChiTietHoaDon.getText();

        ChiTietHoaDon cthd = new ChiTietHoaDon(MaCTHD, MaHoaDon, MaSanPham, SoLuong, TongTien, GhiChu);
        if(ktThem==true){
            CChiTietHoaDon.ThemMoi(cthd);
        }
        else{
            CChiTietHoaDon.CapNhat(cthd, macu);
        }
        //lấy nguồn dữ liệu mới
        LayNguonCTHD();
        KhoaMo2(true);        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btGhi_ChiTietHoaDonActionPerformed

    private void btKhong_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhong_ChiTietHoaDonActionPerformed
        XoaTrang2();
        KhoaMo2(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btKhong_ChiTietHoaDonActionPerformed
//    public void LayDuLieuHoaDon() {
//        String cautruyvan = "";
//        cautruyvan = "select MaHoaDon,KhachHang.TenKhachHang as TenKhachHang,NhanVien.TenNhanVien,TongTien,NgayLapHoaDon,HoaDon.GhiChu from HoaDon,KhachHang,NhanVien where HoaDon.MaKhachHang =KhachHang.MaKhachHang "
//                + "and HoaDon.MaNhanVien=NhanVien.MaNhanVien ";
//        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
//        Object[] obj = new Object[]{"STT", "Mã hóa đơn", "Khách Hàng ", "Nhân viên", "Ngày lập hóa dơn", "tổng tiền", "Chú Thích"};
//        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
//        tblHoaDon_HoaDon.setModel(tableModel);
//        int c = 0;
//        try {
//            while (rs.next()) {
//                Object[] item = new Object[7];
//                c++;
//                item[0] = c;
//                item[1] = rs.getInt("MaHoaDon");
//                item[2] = rs.getString("TenKhachHang");
//                item[3] = rs.getString("TenNhanVien");
//                item[4] = rs.getString("NgayLapHoaDon");
//                item[5] = rs.getInt("TongTien");
//                item[6] = rs.getString("GhiChu");
//                tableModel.addRow(item);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//    }
    public void setSelectedCombobox(String cbbselected, JComboBox cbb) {
        for (int i = 0; i < cbb.getItemCount(); i++) {
            Object obj = cbb.getItemAt(i);
            if (obj != null) {
                displayvalueModel m = (displayvalueModel) obj;
                if (cbbselected.trim().equals(m.displayMember)) {
                    cbb.setSelectedItem(m);
                }
            }
        }
    }
//    public int GetGiaSanPham(String MaSP) {
//        int Gia = 0;
//        String cautruyvan = "select * from SanPham where MaSanPham=" + MaSP;
//        ResultSet rs = Main.MainClass.connection.ExcuteQueryGetTable(cautruyvan);
//        try {
//            if (rs.next()) {
//                Gia = rs.getInt("Giaban");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//        return Gia;
//    }
////    public void LayDuLieuChiTietHoaDon(String MaHoaDon) {
////        String cautruyvan = "";
////        cautruyvan = "select MaCTHD,MaHoaDon,SanPham.TenSanPham,SoLuong,TongTien,ChiTietHoaDon.GhiChu "
////                + " from ChiTietHoaDon,SanPham where ChiTietHoaDon.MaSanPham=SanPham.MaSanPham  and MaHoaDon=" + MaHoaDon;
////        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
////        Object[] obj = new Object[]{"STT", "Mã CTHD", "Mã Hóa Đơn", "Sản Phẩm", "Số Lượng", "tổng tiền", "Chú Thích"};
////        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
////        tblCTHoaDon_ChiTietHoaDon.setModel(tableModel);
////        int c = 0;
////        try {
////            while (rs.next()) {
////                c++;
////                Object[] item = new Object[7];
////                item[0] = c;
////                item[1] = rs.getInt("MaCTHD");
////                item[2] = rs.getString("MaHoaDon");
////                item[3] = rs.getString("TenSanPham");
////                item[4] = rs.getString("SoLuong");
////                item[5] = rs.getDouble("TongTien");
////                item[6] = rs.getString("GhiChu");
////                tableModel.addRow(item);
////            }
////        } catch (SQLException ex) {
////            System.out.println(ex.toString());
////        }
////    }
    public DefaultComboBoxModel LayDuLieucbb(String bang, String Ten, String Ma) {
        String cautruyvan = "select *from " + bang;
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        try {
            while (rs.next()) {
                displayvalueModel valueModel = new displayvalueModel(rs.getString(Ten), rs.getString(Ma));
                cbbmodel.addElement(valueModel);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cbbmodel;
    }
//    public void reset_chitiethoadon() {
//        txtMaCTHD_ChiTietHoaDon.setText("");
//        txtMaHoaDon_ChiTietHoaDon.setText("");
//        txtSoLuong_ChiTietHoaDon.setText("");
//        txtTongTien_ChiTietHoaDon.setText("");
//        txtGhiChu_ChiTietHoaDon.setText("");
//        cbbSanPham_ChiTietHoaDon.setSelectedIndex(0);
//    }
//     public boolean KiemTraNhapHoaDon(int ts) {
//        String MaHoaDon, MaNhanVien, KhachHang, NgayLap, TongTien,ThongBao="";
//        boolean kiemtra = false;
//        MaHoaDon = txtMaPhieuMua_HoaDon.getText();
//        MaNhanVien = GetCbbSelected(cbbNhanVien_HoaDon);
//        
//        KhachHang =  GetCbbSelected(cbbKhachHang_HoaDon);
//        NgayLapHoaDon = sDF.format(dtNgayLapHoaDon.getDate());
//          TongTien = txtTongTien_HoaDon.getText();
//        if (MaHoaDon.equals("") && ts == 1) {
//            ThongBao += "bạn chưa chọn Hóa Đơn để lấy  Mã Hóa Dơn\n";
//            lblMaHoaDon_HoaDon.setForeground(Color.red);
//        }
//        if (MaNhanVien.equals("")) {
//            ThongBao += "bạn chưa Chọn Nhân Viên\n";
//        }
//        if (MaKhachHang.equals("")) {
//            ThongBao += "bạn chưa Chọn Khách Hàng\n";
//        }
//        if (NgayLapHoaDon.equals("")) {
//            lblNgayLap.setForeground(Color.red);
//            ThongBao += "bạn chưa Nhập Ngày Lập\n";
//        }
//          if (TongTien.equals("")) {
//           txtTongTien_HoaDon.setText("0");
//        }
//        if (ThongBao.equals("")) {
//            kiemtra = true;
////            lblDiaChi_KhachHang.setForeground(Color.black);
//            lblNgayLap.setForeground(Color.black);
//            lblTongTien_HoaDon.setForeground(Color.black);
//        } else {
//            kiemtra = false;
//            ThongBao(ThongBao, "lỗi nhập liệu", 2);
//        }
//        return kiemtra;
//    }
//    public void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
//        JOptionPane.showMessageDialog(new JFrame(), noiDungThongBao,
//                tieuDeThongBao, icon);
//    }
    public String GetCbbSelected(JComboBox cbb) {
        Object[] obj = cbb.getSelectedObjects();
        displayvalueModel item = (displayvalueModel) obj[0];
        return item.displayvalue.toString();

    }
//       public boolean KiemTraNhapChiTietHoaDon(int ts) {
//        String MaHoaDon, MaChiTietHoaDon, SanPham, SoLuong,ThongBao="";
//        boolean kiemtra = false;
//        MaHoaDon = txtMaPhieuMua_HoaDon.getText();
//        MaChiTietHoaDon = txtMaCTHD_ChiTietHoaDon.getText();
//        SanPham =  GetCbbSelected(cbbSanPham_ChiTietHoaDon);
//          SoLuong = txtSoLuong_ChiTietHoaDon.getText();
//        if (MaChiTietHoaDon.equals("") && ts == 1) {
//            ThongBao += "bạn chưa chọn Hóa Đơn để lấy  Mã Hóa Dơn\n";
//            lblMaCTPM.setForeground(Color.red);
//        }
//        if (MaHoaDon.equals("")) {
//            ThongBao += "bạn chưa chon trong hóa đơn nào cả\n";
//            lblMaHoaDon.setForeground(Color.red);
//        }
//        if (SoLuong.equals("")) {
//            ThongBao += "bạn chưa Nhập Số Lượng"
//                    + "\n";
//             lblSoLuong_CTPM.setForeground(Color.red);
//        }
//            try {
//                int bien=Integer.valueOf(SoLuong);
//            } catch (Exception e) {
//                 ThongBao += "Số lượng phải nhập Bằng số"
//                    + "\n";
//                
//            }
//      
//        if (ThongBao.equals("")) {
//            kiemtra = true;
//            lblSoLuong_CTPM.setForeground(Color.black);
//            lblMaHoaDon.setForeground(Color.black);
//            lblMaCTPM.setForeground(Color.black);
//        } else {
//            kiemtra = false;
//            ThongBao(ThongBao, "lỗi nhập liệu", 2);
//        }
//        return kiemtra;
//    }
//    public void SetTongTien(String MaHoaDon) {
//        String cautruyvan = "select sum(ChiTietHoaDon.TongTien) as TongTienHienTai,HoaDon.MaHoaDon from HoaDon,ChiTietHoaDon "
//                + "where HoaDon.MaHoaDon=ChiTietHoaDon.MaHoaDon"
//                + " and HoaDon.MaHoaDon=" + MaHoaDon + "group by HoaDon.MaHoaDon";
//        ResultSet rs = Main.MainClass.connection.ExcuteQueryGetTable(cautruyvan);
//        String ttht = "";
//
//        try {
//            if (rs.next()) {
//                ttht = rs.getString("TongTienHienTai");
//                txtTongTien_HoaDon.setText(ttht);
//                String ctv = "update HoaDon set TongTien= " + ttht + "where MaHoaDon=" + MaHoaDon;
//                System.out.println(ctv);
//                MainClass.connection.ExcuteQueryUpdateDB(ctv);
//                LayDuLieuHoaDon();
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGhi_ChiTietHoaDon;
    private javax.swing.JButton btGhi_HoaDon;
    private javax.swing.JButton btKhong_ChiTietHoaDon;
    private javax.swing.JButton btKhong_HoaDon;
    private javax.swing.JButton btnSua_ChiTietHoaDon;
    private javax.swing.JButton btnSua_HoaDon;
    private javax.swing.JButton btnThem_ChiTietHoaDon;
    private javax.swing.JButton btnThem_HoaDon;
    private javax.swing.JButton btnXoa_ChiTietHoaDon;
    private javax.swing.JButton btnXoa_HoaDon;
    private javax.swing.JComboBox<String> cbbKhachHang_HoaDon;
    private javax.swing.JComboBox<String> cbbNhanVien_HoaDon;
    private javax.swing.JComboBox<String> cbbSanPham_ChiTietHoaDon;
    private com.toedter.calendar.JDateChooser dtNgayLapHoaDon;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanelHoaDon;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JTabbedPane jTabbedPaneHoaDon;
    private javax.swing.JLabel lblMaCTPM;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaHoaDon_HoaDon;
    public javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblSoLuong_CTPM;
    private javax.swing.JLabel lblTongTien_HoaDon;
    private javax.swing.JTable tblCTHoaDon_ChiTietHoaDon;
    private javax.swing.JTable tblHoaDon_HoaDon;
    private javax.swing.JTextArea txtGhiChu_ChiTietHoaDon;
    private javax.swing.JTextArea txtGhiChu_HoaDon;
    private javax.swing.JTextField txtMaCTHD_ChiTietHoaDon;
    private javax.swing.JTextField txtMaHoaDon_ChiTietHoaDon;
    private javax.swing.JTextField txtMaPhieuMua_HoaDon;
    private javax.swing.JTextField txtSoLuong_ChiTietHoaDon;
    private javax.swing.JTextField txtTongTien_ChiTietHoaDon;
    private javax.swing.JTextField txtTongTien_HoaDon;
    // End of variables declaration//GEN-END:variables
}
