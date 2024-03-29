/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.quan_ly_diem_sinh_vien.views;

import com.quan_ly_diem_sinh_vien.models.BangDiemDAO;
import com.quan_ly_diem_sinh_vien.models.GiangVien;
import com.quan_ly_diem_sinh_vien.models.HocPhan;
import com.quan_ly_diem_sinh_vien.models.HocPhanDAO;
import com.quan_ly_diem_sinh_vien.models.Khoa;
import com.quan_ly_diem_sinh_vien.models.KhoaDAO;
import com.quan_ly_diem_sinh_vien.models.KhoaGiangVien;
import com.quan_ly_diem_sinh_vien.models.KhoaGiangVienDAO;
import com.quan_ly_diem_sinh_vien.models.LopBienChe;
import com.quan_ly_diem_sinh_vien.models.LopBienCheDAO;
import com.quan_ly_diem_sinh_vien.models.LopHocPhan;
import com.quan_ly_diem_sinh_vien.models.LopHocPhanSinhVien;
import com.quan_ly_diem_sinh_vien.models.LopHocPhanSinhVienDAO;
import com.quan_ly_diem_sinh_vien.models.Nganh;
import com.quan_ly_diem_sinh_vien.models.NganhDAO;
import com.quan_ly_diem_sinh_vien.models.NganhHocPhan;
import com.quan_ly_diem_sinh_vien.models.NganhHocPhanDAO;
import com.quan_ly_diem_sinh_vien.models.SinhVien;
import com.quan_ly_diem_sinh_vien.models.SinhVienDAO;
import static com.quan_ly_diem_sinh_vien.views.GiangvienJFrameView.showMessageConfirm;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lanta
 */
public class LophocphanJFrameView extends javax.swing.JFrame {

    /**
     * Creates new form LophocphanJFrameView
     */
    DefaultTableModel tableModel;
    private LopHocPhan lophocphan;
    private NganhHocPhan n_hp;
    private Nganh nganh;
    private HocPhan hocphan;

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
        List<SinhVien> list = LopHocPhanSinhVienDAO.findListSinhVienThuocLopHocPhan(lophocphan.getId());
        tableModel.setNumRows(0);
        for (SinhVien item : list) {
            var bd = BangDiemDAO.findListVoiNganhHocPhanVaSinhVien(lophocphan.getNganhHocPhanId(), item.getId()).get(0);
            var diemchuyencan = bd.getDiemChuyenCan() == -1 ? "Chua co" : bd.getDiemChuyenCan();
            var diemthi = bd.getDiemThi() == -1 ? "Chua thi" : bd.getDiemThi();
            tableModel.addRow(new Object[]{
                item.getId(),
                item.getName(),
                diemchuyencan,
                diemthi
            });
        }
        if (list.size() == 0) {
            return;
        }
        table.setRowSelectionInterval(0, 0);
    }

    public LophocphanJFrameView(LopHocPhan _lophocphan) {
        initComponents();

        lophocphan = _lophocphan;
        n_hp = NganhHocPhanDAO.find(lophocphan.getNganhHocPhanId());
        nganh = NganhDAO.find(n_hp.getNganhId());
        hocphan = HocPhanDAO.find(n_hp.getHocPhanId());

        malopText.setText(lophocphan.getId() + "");
        tenlophocphanText.setText(lophocphan.getTenHocPhan());
        nganhText.setText(nganh.getTenNganh());
        hocphanText.setText(hocphan.getTenHocPhan());

        refreshTable();

        // Set cho combobox hiển thị tên 
        DefaultComboBoxModel sinhvienComboboxModel = (DefaultComboBoxModel) sinhvienCombobox.getModel();
        sinhvienComboboxModel.removeAllElements();
        List<SinhVien> svList = new ArrayList<>();
        for (SinhVien sv : SinhVienDAO.list()) {
            if (sv.getNganhId() == nganh.getId()) {
                svList.add(sv);
            }
        }
        for (SinhVien sv : svList) {
            sinhvienComboboxModel.addElement(sv);
        }
        sinhvienCombobox.setModel(sinhvienComboboxModel);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        malopText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tenlophocphanText = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        sinhvienCombobox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        sinhvien_text = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        diemchuyencan_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        diemthi_text = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nganhText = new javax.swing.JTextField();
        hocphanText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết lớp học phần", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel3.setText("Tên lớp học phần");

        malopText.setEditable(false);
        malopText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malopTextActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã lớp");

        tenlophocphanText.setEditable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sinh viên trong lớp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Điểm chuyên cần", "Điểm thi"
            }
        ));
        jScrollPane2.setViewportView(table);

        editBtn.setText("Chọn");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Xóa");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        sinhvienCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Thêm sinh viên");

        add.setText("Thêm");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel6.setText("Mã - Tên - Lớp BC");

        sinhvien_text.setEditable(false);

        updateBtn.setText("Cập nhật");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Điểm chuyên cần");

        jLabel2.setText("Điểm thi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sinhvienCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(add))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(sinhvien_text, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(diemthi_text, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(diemchuyencan_text))
                                .addGap(18, 18, 18)
                                .addComponent(updateBtn)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sinhvienCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sinhvien_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(diemchuyencan_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(diemthi_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setText("Ngành");

        nganhText.setEditable(false);

        hocphanText.setEditable(false);

        jLabel8.setText("Học phần");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hocphanText)
                            .addComponent(nganhText)
                            .addComponent(tenlophocphanText)
                            .addComponent(malopText))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(malopText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tenlophocphanText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nganhText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(hocphanText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void malopTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malopTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_malopTextActionPerformed

    private SinhVien sinhvienCurrent;
    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int index = table.getSelectedRow();
        Integer id = Integer.parseInt(tableModel.getValueAt(index, 0).toString());

        SinhVien item = SinhVienDAO.find(id);
        sinhvien_text.setText(item.getId() + " - " + item.getName() + " - " + LopBienCheDAO.find(item.getLopbiencheId()).getTenLop());
        var bd = BangDiemDAO.findListVoiNganhHocPhanVaSinhVien(lophocphan.getNganhHocPhanId(), item.getId()).get(0);
        var diemchuyencan = bd.getDiemChuyenCan() == -1 ? "Chua co" : bd.getDiemChuyenCan();
        var diemthi = bd.getDiemThi() == -1 ? "Chua thi" : bd.getDiemThi();
        diemchuyencan_text.setText(diemchuyencan + "");
        diemthi_text.setText(diemthi + "");
        sinhvienCurrent = item;
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = table.getSelectedRow();
        int id = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
        if (showMessageConfirm("Bạn có chắc chắn muốn xóa không") == 1) {
            int rs = LopHocPhanSinhVienDAO.deleteSinhVienThuocLopHocPhan(lophocphan.getId(), id);
            if (rs == 0) {
                showMessage("Xóa không thành công! Vui lòng kiểm tra lại.");
            }
        }
        refreshTable();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            LopHocPhanSinhVien item = new LopHocPhanSinhVien();
            item.setLopHocPhanId(lophocphan.getId());

            SinhVien sv = (SinhVien) sinhvienCombobox.getModel().getSelectedItem();
            item.setSinhVienId(sv.getId());

            //Add
            int check = LopHocPhanSinhVienDAO.create(item);
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
    }//GEN-LAST:event_addActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        var bd = BangDiemDAO.findListVoiNganhHocPhanVaSinhVien(lophocphan.getNganhHocPhanId(), sinhvienCurrent.getId()).get(0);
        float diemchuyencan = Float.parseFloat(diemchuyencan_text.getText());
        float diemthi = Float.parseFloat(diemthi_text.getText());
        Date ngaythi = null;
        if (diemthi > 0) {
            ngaythi = lophocphan.getNgayThi();
        }
        bd.setDiemChuyenCan(diemchuyencan);
        bd.setDiemThi(diemthi);
        bd.setNgayThi(ngaythi);

        BangDiemDAO.update(bd);
        refreshTable();
    }//GEN-LAST:event_updateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LophocphanJFrameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LophocphanJFrameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LophocphanJFrameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LophocphanJFrameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField diemchuyencan_text;
    private javax.swing.JTextField diemthi_text;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField hocphanText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField malopText;
    private javax.swing.JTextField nganhText;
    private javax.swing.JComboBox<String> sinhvienCombobox;
    private javax.swing.JTextField sinhvien_text;
    private javax.swing.JTable table;
    private javax.swing.JTextField tenlophocphanText;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
