/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.views;

import com.quan_ly_diem_sinh_vien.helper.DateHelp;
import com.quan_ly_diem_sinh_vien.models.BangDiem;
import com.quan_ly_diem_sinh_vien.models.BangDiemDAO;
import com.quan_ly_diem_sinh_vien.models.GiangVienDAO;
import com.quan_ly_diem_sinh_vien.models.HeDaoTao;
import com.quan_ly_diem_sinh_vien.models.HeDaoTaoDAO;
import com.quan_ly_diem_sinh_vien.models.Khoa;
import com.quan_ly_diem_sinh_vien.models.KhoaDAO;
import com.quan_ly_diem_sinh_vien.models.LopBienChe;
import com.quan_ly_diem_sinh_vien.models.LopBienCheDAO;
import com.quan_ly_diem_sinh_vien.models.Nganh;
import com.quan_ly_diem_sinh_vien.models.NganhDAO;
import com.quan_ly_diem_sinh_vien.models.NganhHocPhan;
import com.quan_ly_diem_sinh_vien.models.NganhHocPhanDAO;
import com.quan_ly_diem_sinh_vien.models.SinhVien;
import com.quan_ly_diem_sinh_vien.models.SinhVienDAO;
import static com.quan_ly_diem_sinh_vien.views.giangvienPanel.showMessageConfirm;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class sinhvienPanel extends javax.swing.JPanel {

    DefaultTableModel tableModel;

    public sinhvienPanel() {
        initComponents();
        refreshTable();

        // Set Ngành
        DefaultComboBoxModel nganhCbbModel = (DefaultComboBoxModel) nganhCombobox.getModel();
        nganhCbbModel.removeAllElements();
        ArrayList<Nganh> nganh_List = NganhDAO.list();
        for (Nganh n : nganh_List) {
            nganhCbbModel.addElement(n);
        }
        nganhCombobox.setModel(nganhCbbModel);

        // Set Lớp biên chế
        DefaultComboBoxModel lopBienCheCbbModel = (DefaultComboBoxModel) lopBienCheCombobox.getModel();
        lopBienCheCbbModel.removeAllElements();
        List<LopBienChe> listLopBienChe = LopBienCheDAO.list();
        Nganh nganhCurrent = nganh_List.get(0);
        var listLopBienCheThuocNganh = new ArrayList< LopBienChe>();
        for (var lbc : listLopBienChe) {
            if (lbc.getNganhId() == nganhCurrent.getId()) {
                listLopBienCheThuocNganh.add(lbc);
            }
        }
        for (LopBienChe h : listLopBienCheThuocNganh) {
            lopBienCheCbbModel.addElement(h);
        }
        lopBienCheCombobox.setModel(lopBienCheCbbModel);
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

    public void refreshTable() {
        tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        ArrayList<SinhVien> list = SinhVienDAO.list();
        for (SinhVien s : list) {
            tableModel.addRow(new Object[]{
                s.getId(),
                s.getName(),
                s.getBirthOfDate(),
                s.getSex(),
                s.getPhone(),
                s.getAddress(),
                s.getEmail(),
                s.getGpa(),
                LopBienCheDAO.find(s.getLopbiencheId()).getTenLop(),
                NganhDAO.find(s.getNganhId()).getTenNganh(),
                s.getStatus()
            });
        }
        table.setRowSelectionInterval(0, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ma_sinh_vien_text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ten_sinh_vien_text = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ngay_sinh_input = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        taobangdiemButton = new javax.swing.JButton();
        chitietsinhvienBtn = new javax.swing.JButton();
        gpaButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sexCombobox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        so_dien_thoai_text = new javax.swing.JTextField();
        email_text = new javax.swing.JTextField();
        dia_chi_text = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nganhCombobox = new javax.swing.JComboBox<>();
        gpa_text = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        statusCombobox = new javax.swing.JComboBox<>();
        lopBienCheCombobox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý sinh viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Mã sinh viên");

        ma_sinh_vien_text.setEditable(false);

        jLabel2.setText("Tên sinh viên");

        jLabel3.setText("Ngày sinh");

        ngay_sinh_input.setText("yyyy-mm-dd");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách chức năng")));

        addButton.setText("Thêm sinh viên mới");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa sinh viên cũ");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Cập nhật sinh viên");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        taobangdiemButton.setText("Tạo bảng điểm (Hoặc cập nhật)");
        taobangdiemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taobangdiemButtonActionPerformed(evt);
            }
        });

        chitietsinhvienBtn.setText("Chi tiết sinh viên");
        chitietsinhvienBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chitietsinhvienBtnActionPerformed(evt);
            }
        });

        gpaButton.setText("Update GPA");
        gpaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gpaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(18, 18, 18)
                .addComponent(taobangdiemButton)
                .addGap(18, 18, 18)
                .addComponent(chitietsinhvienBtn)
                .addGap(18, 18, 18)
                .addComponent(gpaButton)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(taobangdiemButton)
                    .addComponent(chitietsinhvienBtn)
                    .addComponent(gpaButton))
                .addGap(88, 88, 88))
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

        jLabel8.setText("GPA");

        jLabel10.setText("Ngành");

        nganhCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nganhCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nganhComboboxActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Msv", "Tên", "Ngày sinh", "Giới tính", "Số đt", "Địa chỉ", "Email", "GPA", "Lớp BC", "Ngành", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(table);

        jLabel11.setText("Tình trạng học");

        statusCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang học", "Bảo lưu", "Thôi học" }));
        statusCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboboxActionPerformed(evt);
            }
        });

        lopBienCheCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Lớp biên chế");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ngay_sinh_input, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ma_sinh_vien_text)
                                    .addComponent(ten_sinh_vien_text)
                                    .addComponent(so_dien_thoai_text, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sexCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dia_chi_text, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(email_text)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(gpa_text, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(statusCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lopBienCheCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nganhCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(jScrollPane2)
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
                    .addComponent(ma_sinh_vien_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ten_sinh_vien_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(ngay_sinh_input, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(so_dien_thoai_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dia_chi_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(gpa_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(statusCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nganhCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lopBienCheCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(311, 311, 311))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
            SinhVien item = new SinhVien();
            item.setName(ten_sinh_vien_text.getText());
            item.setBirthOfDate(DateHelp.convertDate(ngay_sinh_input.getText()));
            item.setSex(sexCombobox.getItemAt(sexCombobox.getSelectedIndex()));
            item.setPhone(so_dien_thoai_text.getText());
            item.setAddress(dia_chi_text.getText());
            item.setEmail(email_text.getText());
            item.setGpa(Float.parseFloat(gpa_text.getText()));

            LopBienChe l = (LopBienChe) lopBienCheCombobox.getModel().getSelectedItem();
            int lopBienChe_id = l.getId();
            item.setLopbiencheId(lopBienChe_id);
            System.out.println("Đã thêm" + lopBienChe_id);

            Nganh n = (Nganh) nganhCombobox.getModel().getSelectedItem();
            int nganh_id = n.getId();
            item.setNganhId(nganh_id);

            String status = (String) statusCombobox.getModel().getSelectedItem();
            item.setStatus(status);
            //Add
            int check = SinhVienDAO.create(item);
            if (check <= 0) {
                showMessage("Thêm dữ liệu không thành công");
            } else {
                showMessage("Thêm dữ liệu thành công");

            }
        } catch (Exception e) {
            showMessage("Thêm dữ liệu không thành công!, vui lòng kiểm tra lại các trường thông tin của bạn");
            e.printStackTrace();
        }
        //List lại table
        refreshTable();
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = table.getSelectedRow();
        int id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
        if (showMessageConfirm("Bạn có chắc chắn muốn xóa không") == 1) {
            BangDiemDAO.delete(id);
            int rs = SinhVienDAO.delete(id);
            if (rs == 0) {
                showMessage("Xóa không thành công! Vui lòng kiểm tra lại.");
            }
        }
        refreshTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            int id = Integer.parseInt(ma_sinh_vien_text.getText());
            SinhVien item = SinhVienDAO.find(id);
            item.setName(ten_sinh_vien_text.getText());
            item.setBirthOfDate(DateHelp.convertDate(ngay_sinh_input.getText()));
            item.setSex(sexCombobox.getItemAt(sexCombobox.getSelectedIndex()));
            item.setPhone(so_dien_thoai_text.getText());
            item.setAddress(dia_chi_text.getText());
            item.setEmail(email_text.getText());
            item.setGpa(Float.parseFloat(gpa_text.getText()));
            LopBienChe lbc = (LopBienChe) lopBienCheCombobox.getModel().getSelectedItem();
            int lop_bien_che_id = lbc.getId();
            item.setLopbiencheId(lop_bien_che_id);

            Nganh n = (Nganh) nganhCombobox.getModel().getSelectedItem();
            int nganh_id = n.getId();
            item.setNganhId(nganh_id);

            String status = (String) statusCombobox.getModel().getSelectedItem();
            item.setStatus(status);

            SinhVienDAO.update(item);
        } catch (Exception e) {
            showMessage("Cập nhật dữ liệu không thành công!\nVui lòng kiểm lại thông tin bạn nhập và chọn");
        }
        refreshTable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
        SinhVien sv = SinhVienDAO.find(id);
        ma_sinh_vien_text.setText(Integer.toString(sv.getId()));
        ten_sinh_vien_text.setText(sv.getName());
        ngay_sinh_input.setText(sv.getBirthOfDate().toString());
        sexCombobox.setSelectedItem(sv.getSex());
        so_dien_thoai_text.setText(sv.getPhone());
        dia_chi_text.setText(sv.getAddress());
        email_text.setText(sv.getEmail());
        gpa_text.setText(Float.toString(sv.getGpa()));
        lopBienCheCombobox.getModel().setSelectedItem(LopBienCheDAO.find(sv.getLopbiencheId()));
        nganhCombobox.getModel().setSelectedItem(NganhDAO.find(sv.getNganhId()));
        statusCombobox.getModel().setSelectedItem(sv.getStatus());
    }//GEN-LAST:event_editButtonActionPerformed

    private void sexComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexComboboxActionPerformed

    private void taobangdiemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taobangdiemButtonActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
        SinhVien sv = SinhVienDAO.find(id);

        ArrayList<NganhHocPhan> n_hp = NganhHocPhanDAO.findListNganhHocPhanVoiNganh(sv.getNganhId());
        for (var i : n_hp) {
            BangDiem bangdiem = new BangDiem();
            bangdiem.setDiemChuyenCan(-1);
            bangdiem.setDiemThi(-1);
            bangdiem.setNgayThi(null);
            bangdiem.setNganhHocphanId(i.getId());
            bangdiem.setSinhvienId(sv.getId());

            BangDiemDAO.createIfNotExist(bangdiem);
        }
    }//GEN-LAST:event_taobangdiemButtonActionPerformed

    private void chitietsinhvienBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chitietsinhvienBtnActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());
        SinhVien sv = SinhVienDAO.find(id);
        new BangDiemJFrameView(sv).setVisible(true);
    }//GEN-LAST:event_chitietsinhvienBtnActionPerformed

    private void nganhComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nganhComboboxActionPerformed
        Nganh n = (Nganh) nganhCombobox.getModel().getSelectedItem();
        if (n == null) {
            return;
        }
        int nganh_id = n.getId();

        // Set Lớp biên chế
        DefaultComboBoxModel lopBienCheCbbModel = (DefaultComboBoxModel) lopBienCheCombobox.getModel();
        lopBienCheCbbModel.removeAllElements();
        List<LopBienChe> listLopBienChe = LopBienCheDAO.list();
        var listLopBienCheThuocNganh = new ArrayList< LopBienChe>();
        for (var lbc : listLopBienChe) {
            if (lbc.getNganhId() == nganh_id) {
                listLopBienCheThuocNganh.add(lbc);
            }
        }
        for (LopBienChe h : listLopBienCheThuocNganh) {
            lopBienCheCbbModel.addElement(h);
        }
        lopBienCheCombobox.setModel(lopBienCheCbbModel);
    }//GEN-LAST:event_nganhComboboxActionPerformed

    private void gpaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gpaButtonActionPerformed
        var svlist = SinhVienDAO.list();
        for (var sv : svlist) {
            var bangdiemList = BangDiemDAO.listBangDiemThuocSinhVien(sv.getId());
            double gpa = 0;
            var so_mon_duoc_tinh = 0;
            for (var bd : bangdiemList) {
                if (bd.getDiemChuyenCan() > 0 && bd.getDiemThi() > 0) {
                    gpa += bd.getDiemChuyenCan() * 0.3 + bd.getDiemThi() * 0.7;
                    so_mon_duoc_tinh++;
                }
            }
            if (so_mon_duoc_tinh > 0) {
                sv.setGpa((float) ((gpa / so_mon_duoc_tinh) / 2.5));
            } else {
                sv.setGpa(0);
            }
            SinhVienDAO.update(sv);
        }
        refreshTable();
    }//GEN-LAST:event_gpaButtonActionPerformed

    private void statusComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton chitietsinhvienBtn;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField dia_chi_text;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField email_text;
    private javax.swing.JButton gpaButton;
    private javax.swing.JTextField gpa_text;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> lopBienCheCombobox;
    private javax.swing.JTextField ma_sinh_vien_text;
    private javax.swing.JComboBox<String> nganhCombobox;
    private javax.swing.JTextField ngay_sinh_input;
    private javax.swing.JComboBox<String> sexCombobox;
    private javax.swing.JTextField so_dien_thoai_text;
    private javax.swing.JComboBox<String> statusCombobox;
    private javax.swing.JTable table;
    private javax.swing.JButton taobangdiemButton;
    private javax.swing.JTextField ten_sinh_vien_text;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
