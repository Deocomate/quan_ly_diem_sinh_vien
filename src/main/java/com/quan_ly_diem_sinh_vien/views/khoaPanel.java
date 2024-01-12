/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.views;

import com.quan_ly_diem_sinh_vien.helper.DateHelp;
import com.quan_ly_diem_sinh_vien.models.Khoa;
import com.quan_ly_diem_sinh_vien.models.KhoaDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class khoaPanel extends javax.swing.JPanel {

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
        List<Khoa> list = KhoaDAO.list();
        tableModel.setNumRows(0);
        for (Khoa item : list) {
            tableModel.addRow(new Object[]{
                item.getId(),
                item.getTenKhoa(),
                item.getNgayThanhLap().toString()
            });
        }
        table.setRowSelectionInterval(0, 0);
    }

    /**
     * Creates new form hocphanPanel
     */
    public khoaPanel() {
        initComponents();
        refreshTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ma_khoa_input = new javax.swing.JTextField();
        ten_khoa_input = new javax.swing.JTextField();
        ngay_thanh_lap_input = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        quan_ly_chuyen_sau_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        editButton = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý khoa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Mã khoa");

        jLabel2.setText("Tên khoa");

        jLabel3.setText("Ngày thành lập");

        ma_khoa_input.setEditable(false);

        ngay_thanh_lap_input.setText("yyyy-mm-dd");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách chức năng"));

        addButton.setText("Thêm khoa mới");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Cập nhật tt khoa");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa khoa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        quan_ly_chuyen_sau_btn.setText("Quản lý chuyên sâu");
        quan_ly_chuyen_sau_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quan_ly_chuyen_sau_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(quan_ly_chuyen_sau_btn))
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addContainerGap(246, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(quan_ly_chuyen_sau_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã khoa", "Tên khoa", "Ngày thành lập"
            }
        ));
        jScrollPane1.setViewportView(table);

        editButton.setText("Chọn");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ma_khoa_input, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ngay_thanh_lap_input, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                    .addComponent(ten_khoa_input)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ma_khoa_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ten_khoa_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ngay_thanh_lap_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            Khoa item = new Khoa();
            item.setTenKhoa(ten_khoa_input.getText());
            item.setNgayThanhLap(DateHelp.convertDate(ngay_thanh_lap_input.getText()));

            //Add
            int check = KhoaDAO.create(item);
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
            int rs = KhoaDAO.delete(id);
            if (rs == 0) {
                showMessage("Xóa không thành công! Vui lòng kiểm tra lại.");
            }
        }
        refreshTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            int id = Integer.parseInt(ma_khoa_input.getText());
            Khoa item = KhoaDAO.find(id);
            item.setTenKhoa(ten_khoa_input.getText());
            item.setNgayThanhLap(DateHelp.convertDate(ngay_thanh_lap_input.getText()));
            KhoaDAO.update(item);
        } catch (Exception e) {
            showMessage("Cập nhật dữ liệu không thành công!\nVui lòng kiểm lại thông tin bạn nhập và chọn");
        }
        refreshTable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());

        Khoa item = KhoaDAO.find(id);
        ma_khoa_input.setText(item.getId() + "");
        ten_khoa_input.setText(item.getTenKhoa());
        ngay_thanh_lap_input.setText(item.getNgayThanhLap().toString() + " ");
    }//GEN-LAST:event_editButtonActionPerformed

    private void quan_ly_chuyen_sau_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quan_ly_chuyen_sau_btnActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
        Khoa item = KhoaDAO.find(id);
        
    }//GEN-LAST:event_quan_ly_chuyen_sau_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ma_khoa_input;
    private javax.swing.JTextField ngay_thanh_lap_input;
    private javax.swing.JButton quan_ly_chuyen_sau_btn;
    private javax.swing.JTable table;
    private javax.swing.JTextField ten_khoa_input;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
