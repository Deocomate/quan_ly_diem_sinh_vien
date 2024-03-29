/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.views;

import com.quan_ly_diem_sinh_vien.helper.DateHelp;
import com.quan_ly_diem_sinh_vien.models.GiangVien;
import com.quan_ly_diem_sinh_vien.models.GiangVienDAO;
import com.quan_ly_diem_sinh_vien.models.HocPhan;
import com.quan_ly_diem_sinh_vien.models.HocPhanDAO;
import com.quan_ly_diem_sinh_vien.models.LopHocPhan;
import com.quan_ly_diem_sinh_vien.models.LopHocPhanDAO;
import com.quan_ly_diem_sinh_vien.models.Nganh;
import com.quan_ly_diem_sinh_vien.models.NganhDAO;
import com.quan_ly_diem_sinh_vien.models.NganhHocPhan;
import com.quan_ly_diem_sinh_vien.models.NganhHocPhanDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class lophocphanPanel extends javax.swing.JPanel {

    DefaultTableModel tableModel;

    public void showMessage(String mess) {
        JOptionPane.showMessageDialog(null, mess);
    }

    public static int showMessageConfirm(String message) {
        // Sử dụng JOptionPane để hiển thị hộp thoại xác nhận với lựa chọn là Yes hoặc No
        int result = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);

        // Kiểm tra kết quả và trả về 1 nếu người dùng chọn Yes và 0 nếu người dùng chọn No
        if (result == JOptionPane.YES_OPTION) {
            return 1;
        } else {
            return 0;
        }

    }

    public void refreshTable() {
        tableModel = (DefaultTableModel) table.getModel();
        List<LopHocPhan> list = LopHocPhanDAO.list();
        tableModel.setNumRows(0);

        for (LopHocPhan item : list) {
            NganhHocPhan n = NganhHocPhanDAO.find(item.getNganhHocPhanId());
            Nganh nganhhoc = NganhDAO.find(n.getNganhId());
            HocPhan hocphan = HocPhanDAO.find(n.getHocPhanId());
            tableModel.addRow(new Object[]{
                item.getId(),
                item.getTenHocPhan(),
                nganhhoc.getTenNganh(),
                hocphan.getTenHocPhan(),
                GiangVienDAO.find(item.getGiangVien_id()).getName(),
                item.getNgayBatDau(),
                item.getNgayKetThuc(),
                item.getNgayThi()
            });
        }
        table.setRowSelectionInterval(0, 0);
    }

    public lophocphanPanel() {
        initComponents();
        refreshTable();
        // Set cho combobox hiển thị tên 
        DefaultComboBoxModel nganhCbbModel = (DefaultComboBoxModel) nganhCombobox.getModel();
        nganhCbbModel.removeAllElements();
        List<Nganh> listNganh = NganhDAO.list();
        for (Nganh h : listNganh) {
            nganhCbbModel.addElement(h);
        }
        nganhCombobox.setModel(nganhCbbModel);
        // End

        // Set cho combobox hiển thị tên 
        DefaultComboBoxModel giangvienCbbModel = (DefaultComboBoxModel) giangvienCombobox.getModel();
        giangvienCbbModel.removeAllElements();
        List<GiangVien> listGiangVien = GiangVienDAO.list();
        for (GiangVien k : listGiangVien) {
            giangvienCbbModel.addElement(k);
        }
        giangvienCombobox.setModel(giangvienCbbModel);
        // End
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ma_lop_hoc_phan_text = new javax.swing.JTextField();
        ten_lop_hoc_phan_text = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        chitietlophocphanBtn = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        nganhCombobox = new javax.swing.JComboBox<>();
        giangvienCombobox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ngay_bat_dau_text = new javax.swing.JTextField();
        ngay_ket_thuc_text = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ngay_thi_text = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        hocphanCombobox = new javax.swing.JComboBox<>();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý lớp học phần", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Mã lớp học phần");

        jLabel2.setText("Tên lớp học phần");

        jLabel3.setText("Ngành");

        ma_lop_hoc_phan_text.setEditable(false);

        ten_lop_hoc_phan_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ten_lop_hoc_phan_textActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách chức năng"));

        addButton.setText("Thêm lớp học phần");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Cập nhật lớp học phần");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa lớp học phần");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        chitietlophocphanBtn.setText("Chi tiết lớp học phần");
        chitietlophocphanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chitietlophocphanBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addGap(30, 30, 30)
                .addComponent(deleteButton)
                .addGap(30, 30, 30)
                .addComponent(updateButton)
                .addGap(18, 18, 18)
                .addComponent(chitietlophocphanBtn)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton)
                    .addComponent(chitietlophocphanBtn))
                .addGap(80, 80, 80))
        );

        editButton.setText("Chọn");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã lớp học phần", "Tên lớp học phần", "Ngành", "Tên học phần", "Giảng Viên", "Ngày bắt đầu", "Ngày kết thúc", "Ngày thi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel4.setText("Giảng Viên");

        nganhCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nganhCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nganhComboboxActionPerformed(evt);
            }
        });

        giangvienCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Ngày bắt đầu");

        jLabel6.setText("Ngày kết thúc");

        ngay_bat_dau_text.setText("yyyy-mm-dd");

        ngay_ket_thuc_text.setText("yyyy-mm-dd");

        jLabel7.setText("Ngày thi");

        ngay_thi_text.setText("yyyy-mm-dd");
        ngay_thi_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngay_thi_textActionPerformed(evt);
            }
        });

        jLabel8.setText("Tên học phần");

        hocphanCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(editButton)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngay_thi_text)
                            .addComponent(ngay_ket_thuc_text)
                            .addComponent(ngay_bat_dau_text)
                            .addComponent(giangvienCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hocphanCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ma_lop_hoc_phan_text)
                            .addComponent(nganhCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ten_lop_hoc_phan_text))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ma_lop_hoc_phan_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ten_lop_hoc_phan_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nganhCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hocphanCombobox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(giangvienCombobox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ngay_bat_dau_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ngay_ket_thuc_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ngay_thi_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ten_lop_hoc_phan_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ten_lop_hoc_phan_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ten_lop_hoc_phan_textActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            LopHocPhan item = new LopHocPhan();
            item.setTenHocPhan(ten_lop_hoc_phan_text.getText());

            //
            Nganh n = (Nganh) nganhCombobox.getModel().getSelectedItem();
            int nganh_id = n.getId();
            HocPhan hp = (HocPhan) hocphanCombobox.getModel().getSelectedItem();
            int hocphan_id = hp.getId();
            NganhHocPhan n_hp = NganhHocPhanDAO.findNganhHocPhan(nganh_id, hocphan_id);
            item.setNganhHocPhanId(n_hp.getId());
            //
            GiangVien k = (GiangVien) giangvienCombobox.getModel().getSelectedItem();
            int giangvien_id = k.getId();
            item.setGiangVien_id(giangvien_id);

            item.setNgayBatDau(DateHelp.convertDate(ngay_bat_dau_text.getText()));
            item.setNgayKetThuc(DateHelp.convertDate(ngay_ket_thuc_text.getText()));
            item.setNgayThi(DateHelp.convertDate(ngay_thi_text.getText()));

            //Add
            int check = LopHocPhanDAO.create(item);
            if (check <= 0) {
                showMessage("Thêm dữ liệu không thành công");
            } else {
                showMessage("Thêm dữ liệu thành công");
            }
        } catch (Exception e) {
            showMessage("Thêm dữ liệu không thành công!, vui lòng kiểm tra lại các trường thông tin của bạn");
        }
        //List lại table
        refreshTable();
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            int id = Integer.parseInt(ma_lop_hoc_phan_text.getText());
            LopHocPhan item = LopHocPhanDAO.find(id);

            item.setTenHocPhan(ten_lop_hoc_phan_text.getText());

            //
            Nganh n = (Nganh) nganhCombobox.getModel().getSelectedItem();
            int nganh_id = n.getId();
            HocPhan hp = (HocPhan) hocphanCombobox.getModel().getSelectedItem();
            int hocphan_id = hp.getId();
            NganhHocPhan n_hp = NganhHocPhanDAO.findNganhHocPhan(nganh_id, hocphan_id);
            item.setNganhHocPhanId(n_hp.getId());
            //

            GiangVien k = (GiangVien) giangvienCombobox.getModel().getSelectedItem();
            int giangvien_id = k.getId();
            item.setGiangVien_id(giangvien_id);

            item.setNgayBatDau(DateHelp.convertDate(ngay_bat_dau_text.getText()));
            item.setNgayKetThuc(DateHelp.convertDate(ngay_ket_thuc_text.getText()));
            item.setNgayThi(DateHelp.convertDate(ngay_thi_text.getText()));
            LopHocPhanDAO.update(item);
        } catch (Exception e) {
            showMessage("Cập nhật dữ liệu không thành công!\nVui lòng kiểm lại thông tin bạn nhập và chọn");
        }
        refreshTable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = table.getSelectedRow();
        int id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
        if (showMessageConfirm("Bạn có chắc chắn muốn xóa không") == 1) {
            int rs = LopHocPhanDAO.delete(id);
            if (rs == 0) {
                showMessage("Xóa không thành công! Vui lòng kiểm tra lại.");
            }
        }
        refreshTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
        LopHocPhan item = LopHocPhanDAO.find(id);

        ma_lop_hoc_phan_text.setText(item.getId() + "");
        ten_lop_hoc_phan_text.setText(item.getTenHocPhan());
        //
        NganhHocPhan n = NganhHocPhanDAO.find(item.getNganhHocPhanId());
        Nganh nganhhoc = NganhDAO.find(n.getNganhId());
        HocPhan hocphan = HocPhanDAO.find(n.getHocPhanId());
        nganhCombobox.getModel().setSelectedItem(nganhhoc);
        hocphanCombobox.getModel().setSelectedItem(hocphan);
        //
        giangvienCombobox.getModel().setSelectedItem(GiangVienDAO.find(item.getGiangVien_id()));
        ngay_bat_dau_text.setText(item.getNgayBatDau() + "");
        ngay_ket_thuc_text.setText(item.getNgayKetThuc() + "");
        ngay_thi_text.setText(item.getNgayThi() + "");

    }//GEN-LAST:event_editButtonActionPerformed

    private void ngay_thi_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngay_thi_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngay_thi_textActionPerformed

    private void nganhComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nganhComboboxActionPerformed
        Nganh h = (Nganh) nganhCombobox.getModel().getSelectedItem();
        if (h == null) {
            return;
        }
        // Set cho combobox hiển thị tên 
        DefaultComboBoxModel hocphanComboboxModel = (DefaultComboBoxModel) hocphanCombobox.getModel();
        hocphanComboboxModel.removeAllElements();
        List<HocPhan> listHp = NganhHocPhanDAO.findListHocPhanThuocNganh(h.getId());
        for (HocPhan hp : listHp) {
            hocphanComboboxModel.addElement(hp);
        }
        hocphanCombobox.setModel(hocphanComboboxModel);
        // End
    }//GEN-LAST:event_nganhComboboxActionPerformed

    private void chitietlophocphanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chitietlophocphanBtnActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
        LopHocPhan item = LopHocPhanDAO.find(id);
        new LophocphanJFrameView(item).setVisible(true);
    }//GEN-LAST:event_chitietlophocphanBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton chitietlophocphanBtn;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JComboBox<String> giangvienCombobox;
    private javax.swing.JComboBox<String> hocphanCombobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ma_lop_hoc_phan_text;
    private javax.swing.JComboBox<String> nganhCombobox;
    private javax.swing.JTextField ngay_bat_dau_text;
    private javax.swing.JTextField ngay_ket_thuc_text;
    private javax.swing.JTextField ngay_thi_text;
    private javax.swing.JTable table;
    private javax.swing.JTextField ten_lop_hoc_phan_text;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
