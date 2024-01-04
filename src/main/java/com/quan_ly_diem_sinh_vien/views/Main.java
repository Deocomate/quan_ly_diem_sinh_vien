
package com.quan_ly_diem_sinh_vien.views;

import java.awt.BorderLayout;
import javax.swing.JPanel;


public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    public void setView(JPanel panelSet) {
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panelSet);
        mainPanel.validate();
        mainPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        hedaotaoMenu = new javax.swing.JMenu();
        hedaotaoMI = new javax.swing.JMenuItem();
        khoaMenu = new javax.swing.JMenuItem();
        nganhMenu = new javax.swing.JMenuItem();
        giangvienMenu = new javax.swing.JMenuItem();
        hocphanMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        sinhvienMenu = new javax.swing.JMenuItem();
        lopbiencheMenu = new javax.swing.JMenuItem();
        lophocphanMenu = new javax.swing.JMenuItem();
        bangdiemMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );

        jMenu1.setText("Trang chủ");

        jMenuItem1.setText("Trang chủ");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        hedaotaoMenu.setText("Quản lý chung");

        hedaotaoMI.setText("Quản lý hệ đào tạo");
        hedaotaoMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hedaotaoMIActionPerformed(evt);
            }
        });
        hedaotaoMenu.add(hedaotaoMI);

        khoaMenu.setText("Quản lý khoa");
        khoaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khoaMenuActionPerformed(evt);
            }
        });
        hedaotaoMenu.add(khoaMenu);

        nganhMenu.setText("Quản lý ngành đào tạo");
        nganhMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nganhMenuActionPerformed(evt);
            }
        });
        hedaotaoMenu.add(nganhMenu);

        giangvienMenu.setText("Quản lý giảng viên");
        giangvienMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giangvienMenuActionPerformed(evt);
            }
        });
        hedaotaoMenu.add(giangvienMenu);

        hocphanMenu.setText("Quản lý học phần");
        hocphanMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hocphanMenuActionPerformed(evt);
            }
        });
        hedaotaoMenu.add(hocphanMenu);

        jMenuBar1.add(hedaotaoMenu);

        jMenu3.setText("Quản lý sinh viên");

        sinhvienMenu.setText("Quản lý sinh viên");
        sinhvienMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinhvienMenuActionPerformed(evt);
            }
        });
        jMenu3.add(sinhvienMenu);

        lopbiencheMenu.setText("Quản lý lớp biên chế");
        lopbiencheMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lopbiencheMenuActionPerformed(evt);
            }
        });
        jMenu3.add(lopbiencheMenu);

        lophocphanMenu.setText("Quản lý lớp học phần");
        lophocphanMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lophocphanMenuActionPerformed(evt);
            }
        });
        jMenu3.add(lophocphanMenu);

        bangdiemMenu.setText("Quản lý bảng điểm sinh viên");
        bangdiemMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bangdiemMenuActionPerformed(evt);
            }
        });
        jMenu3.add(bangdiemMenu);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nganhMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nganhMenuActionPerformed
        setView(new nganhPanel());
    }//GEN-LAST:event_nganhMenuActionPerformed

    private void hedaotaoMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hedaotaoMIActionPerformed
        setView(new hedaotaoPanel());
    }//GEN-LAST:event_hedaotaoMIActionPerformed

    private void khoaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khoaMenuActionPerformed
        setView(new khoaPanel());
    }//GEN-LAST:event_khoaMenuActionPerformed

    private void giangvienMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giangvienMenuActionPerformed
        setView(new giangvienPanel());
    }//GEN-LAST:event_giangvienMenuActionPerformed

    private void hocphanMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hocphanMenuActionPerformed
        setView(new hocphanPanel());
    }//GEN-LAST:event_hocphanMenuActionPerformed

    private void sinhvienMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinhvienMenuActionPerformed
        setView(new sinhvienPanel());
    }//GEN-LAST:event_sinhvienMenuActionPerformed

    private void lopbiencheMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lopbiencheMenuActionPerformed
        setView(new lopbienchePanel());
    }//GEN-LAST:event_lopbiencheMenuActionPerformed

    private void lophocphanMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lophocphanMenuActionPerformed
        setView(new lophocphanPanel());
    }//GEN-LAST:event_lophocphanMenuActionPerformed

    private void bangdiemMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bangdiemMenuActionPerformed
        setView(new bangdiemPanel());
    }//GEN-LAST:event_bangdiemMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bangdiemMenu;
    private javax.swing.JMenuItem giangvienMenu;
    private javax.swing.JMenuItem hedaotaoMI;
    private javax.swing.JMenu hedaotaoMenu;
    private javax.swing.JMenuItem hocphanMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem khoaMenu;
    private javax.swing.JMenuItem lopbiencheMenu;
    private javax.swing.JMenuItem lophocphanMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem nganhMenu;
    private javax.swing.JMenuItem sinhvienMenu;
    // End of variables declaration//GEN-END:variables
}
