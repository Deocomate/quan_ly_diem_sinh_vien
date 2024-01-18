/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.views;

import com.quan_ly_diem_sinh_vien.helper.DateHelp;
import com.quan_ly_diem_sinh_vien.models.GiangVien;
import com.quan_ly_diem_sinh_vien.models.GiangVienDAO;
import com.quan_ly_diem_sinh_vien.models.Khoa;
import com.quan_ly_diem_sinh_vien.models.KhoaDAO;
import static com.quan_ly_diem_sinh_vien.views.khoaPanel.showMessageConfirm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class giangvienPanel extends javax.swing.JPanel {

    DefaultTableModel tableModel;

    public giangvienPanel() {
        initComponents();
        refreshTable();
    }

    public void refreshTable() {
        tableModel = (DefaultTableModel) table.getModel();
        ArrayList<GiangVien> list = GiangVienDAO.list();
        tableModel.setRowCount(0);
        for (GiangVien g : list) {
            tableModel.addRow(new Object[]{
                g.getId(),
                g.getName(),
                g.getBirthOfDate(),
                g.getSex(), g.getPhone(),
                g.getAddress(),
                g.getEmail()});
        }

        table.setRowSelectionInterval(0, 0);

    }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ma_giang_vien_input = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ten_giang_vien_input = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ngay_sinh_input = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        giangvienchitietBtn = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sexCombobox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        so_dien_thoai_input = new javax.swing.JTextField();
        email_input = new javax.swing.JTextField();
        dia_chi_input = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý giảng viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã giảng viên", "Tên giảng viên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Email"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Mã giảng viên");

        ma_giang_vien_input.setEditable(false);

        jLabel2.setText("Tên Giảng Viên");

        jLabel3.setText("Ngày sinh");

        ngay_sinh_input.setText("yyyy-mm-dd");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách chức năng")));

        addButton.setText("Thêm giảng viên mới");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa giảng viên cũ");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Cập nhật giảng viên");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        giangvienchitietBtn.setText("Chi tiết giảng viên");
        giangvienchitietBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giangvienchitietBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteButton)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton)
                            .addComponent(updateButton))
                        .addGap(18, 18, 18)
                        .addComponent(giangvienchitietBtn)))
                .addContainerGap(425, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(giangvienchitietBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addGap(18, 18, 18))
        );

        editButton.setText("Chọn");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Giới tính");

        sexCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        sexCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexComboboxActionPerformed(evt);
            }
        });

        jLabel5.setText("Số điện thoại");

        jLabel6.setText("Email");

        jLabel7.setText("Địa chỉ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngay_sinh_input, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ma_giang_vien_input)
                            .addComponent(ten_giang_vien_input)
                            .addComponent(so_dien_thoai_input, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sexCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(email_input, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dia_chi_input, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ma_giang_vien_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ten_giang_vien_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(ngay_sinh_input, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(so_dien_thoai_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dia_chi_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            GiangVien item = new GiangVien();
            item.setName(ten_giang_vien_input.getText());
            item.setBirthOfDate(DateHelp.convertDate(ngay_sinh_input.getText()));
            item.setSex(sexCombobox.getItemAt(sexCombobox.getSelectedIndex()));
            item.setPhone(so_dien_thoai_input.getText());
            item.setAddress(dia_chi_input.getText());
            item.setEmail(email_input.getText());

            //Add
            int check = GiangVienDAO.create(item);
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

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = table.getSelectedRow();
        int id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
        if (showMessageConfirm("Bạn có chắc chắn muốn xóa không") == 1) {
            int rs = GiangVienDAO.delete(id);
            if (rs == 0) {
                showMessage("Xóa không thành công! Vui lòng kiểm tra lại.");
            }
        }
        refreshTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            int id = Integer.parseInt(ma_giang_vien_input.getText());
            GiangVien item = GiangVienDAO.find(id);
            item.setName(ten_giang_vien_input.getText());
            item.setBirthOfDate(DateHelp.convertDate(ngay_sinh_input.getText()));
            item.setSex(sexCombobox.getItemAt(sexCombobox.getSelectedIndex()));
            item.setPhone(so_dien_thoai_input.getText());
            item.setAddress(dia_chi_input.getText());
            item.setEmail(email_input.getText());

            GiangVienDAO.update(item);
        } catch (Exception e) {
            showMessage("Cập nhật dữ liệu không thành công!\nVui lòng kiểm lại thông tin bạn nhập và chọn");
        }
        refreshTable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
        GiangVien item = GiangVienDAO.find(id);

        ma_giang_vien_input.setText(Integer.toString(item.getId()));
        ten_giang_vien_input.setText(item.getName());
        ngay_sinh_input.setText(item.getBirthOfDate().toString());
        sexCombobox.setSelectedItem(item.getSex());
        so_dien_thoai_input.setText(item.getPhone());
        dia_chi_input.setText(item.getPhone());
        email_input.setText(item.getEmail());


    }//GEN-LAST:event_editButtonActionPerformed

    private void sexComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexComboboxActionPerformed

    private void giangvienchitietBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giangvienchitietBtnActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
        GiangVien item = GiangVienDAO.find(id);
        new GiangvienJFrameView(item).setVisible(true);
    }//GEN-LAST:event_giangvienchitietBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField dia_chi_input;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField email_input;
    private javax.swing.JButton giangvienchitietBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ma_giang_vien_input;
    private javax.swing.JTextField ngay_sinh_input;
    private javax.swing.JComboBox<String> sexCombobox;
    private javax.swing.JTextField so_dien_thoai_input;
    private javax.swing.JTable table;
    private javax.swing.JTextField ten_giang_vien_input;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
